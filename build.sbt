ThisBuild / scalaVersion := "3.8.1"
ThisBuild / organization := "aurelian.engine"
ThisBuild / version      := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .settings(
    name := "aurelian",
    // 外部依存(libraryDependencies)はあえて空。
    // テスト用のライブラリのみ、後ほど必要に応じて追加。
    scalacOptions ++= Seq(
      "-Xcheck-macros",      // マクロのデバッグ用
      "-Yexplicit-nulls",    // Null安全性を極限まで高める
      "-language:experimental.into" // 最新の型変換機能を利用
    )
  )