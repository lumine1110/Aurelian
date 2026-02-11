package aurelian

import aurelian.engine.tensor.*
import aurelian.engine.tensor.Shape.*
import java.nio.file.{Files, Paths}
import java.nio.charset.StandardCharsets
import scala.jdk.CollectionConverters.*

object Main:
  // 形状の型エイリアス定義 (例: 2x3行列)
  type Matrix2x3 = 2 #: 3 #: Scalar

  def main(args: Array[String]): Unit =
    println("Aurelian Tensor Engine: Initializing...")

    // データディレクトリのパス設定
    val inputDir = Paths.get("data", "input")
    val outputDir = Paths.get("data", "output")

    // ディレクトリの存在確認
    if (!Files.exists(inputDir)) {
      System.err.println(s"Error: Input directory not found at $inputDir")
      sys.exit(1)
    }
    if (!Files.exists(outputDir)) {
      System.err.println(s"Error: Output directory not found at $outputDir")
      sys.exit(1)
    }

    val inputPath = inputDir.resolve("input.txt")
    val outputPath = outputDir.resolve("output.txt")

    // 1. 入力ファイルの読み込み
    if (!Files.exists(inputPath)) {
      System.err.println(s"Error: Input file not found at $inputPath")
      sys.exit(1)
    }

    println(s"Reading from $inputPath...")
    val lines = Files.readAllLines(inputPath, StandardCharsets.UTF_8).asScala

    // パース処理: カンマ区切りの数値をフラットな配列にする
    val rawData = lines.flatMap { line =>
      line.split(",").map(_.trim.toDouble)
    }.toArray

    // 2. テンソル生成 (型安全なキャスト)
    // 本来はここでデータの個数が Shape.NumElements[Matrix2x3] と一致するか検証が必要
    val tensorA: Tensor[Matrix2x3] = Tensor.fromArray(rawData)

    println(s"Loaded Tensor A: $tensorA")

    // 別のテンソルBを作成 (演算用)
    // 全要素が 0.5 の同じ形状のテンソル
    val tensorB: Tensor[Matrix2x3] = Tensor.fromArray(Array.fill(6)(0.5))

    // 3. テンソル演算 (A + B) * 2.0
    // 型システムにより、形状が異なるテンソルとの演算はコンパイルエラーになる
    val resultTensor = (tensorA + tensorB).scale(2.0)

    println(s"Result Tensor: $resultTensor")

    // 4. 結果の書き出し
    val outputString = resultTensor.data.mkString(", ")
    Files.write(outputPath, outputString.getBytes(StandardCharsets.UTF_8))
    println(s"Written result to $outputPath")
