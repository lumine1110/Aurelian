package aurelian.engine.tensor

import scala.compiletime.ops.int.*

/**
 * Aurelian Tensor Engine
 *
 * 形状（Shape）の型レベル定義。
 * 実行時ではなく、コンパイル時にテンソルの次元とサイズを確定させるための基盤。
 * これにより、「型が合えば、推論は常に正しい」という原則を保証する。
 */
sealed trait Shape

object Shape:
  /**
   * 0次元（スカラー）を表す終端型。
   */
  case object Scalar extends Shape
  type Scalar = Scalar.type

  /**
   * 次元を追加する型構築子。
   * H: その次元のサイズ（型レベル整数）
   * T: 残りの形状
   *
   * 使用例: 3 x 4 の行列 -> 3 #: 4 #: Scalar
   */
  case class #:[H <: Int & Singleton, T <: Shape](head: H, tail: T) extends Shape

  /**
   * 形状のランク（次元数）を計算する型レベル関数。
   */
  type Rank[S <: Shape] <: Int = S match
    case Scalar => 0
    case _ #: t => 1 + Rank[t]

  /**
   * 形状の全要素数を計算する型レベル関数。
   */
  type NumElements[S <: Shape] <: Int = S match
    case Scalar => 1
    case h #: t => h * NumElements[t]
