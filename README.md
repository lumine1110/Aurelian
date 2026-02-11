# Aurelian 🌌🧠

> **Restitutor Orbis** — *Restorer of the World* / *世界の修復者*

[![Scala 3](https://img.shields.io/badge/Scala-3.8.1-dc322f.svg?style=for-the-badge&logo=scala)](https://scala-lang.org)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg?style=for-the-badge)](LICENSE)
[![Status](https://img.shields.io/badge/Status-Experimental-orange.svg?style=for-the-badge)](https://github.com/yourusername/aurelian)

**Aurelian** is a **Type-Level Tensor Engine** built from scratch in Scala 3.
It rejects the chaos of the modern AI ecosystem 🐍💥 and establishes a new sanctuary of **Logic** and **Order** 🏛️✨.

**Aurelian** は、Scala 3 でゼロから構築された **型レベルテンソルエンジン** です。
現代のAIエコシステムに蔓延するカオス 🐍💥 を拒絶し、**論理** と **秩序** 🏛️✨ の聖域を再構築します。

---

## 🔮 Vision: The Great Disconnect / 大いなる断絶

We are building a universe where **Runtime Errors** are a myth.
By severing ties with external "Black Box" libraries (PyTorch, NumPy, TensorFlow), Aurelian reclaims control over every bit and operation.

> *"If it compiles, the inference is correct."* 🧘‍♂️

私たちは、**実行時エラー** が神話となる宇宙を創造しています。
外部の「ブラックボックス」ライブラリ（PyTorch, NumPy, TensorFlow）との関係を断ち切ることで、Aurelian はすべてのビットと演算に対する完全な支配権を取り戻します。

> *「コンパイルが通れば、推論は正しい」* 🧘‍♂️

---

## 🚀 Features / 特徴

### 🛡️ Type-Safe Tensors (Compile-Time Shape Checking)
No more `RuntimeError: size mismatch`. Aurelian uses Scala 3's powerful **Match Types** and **Singleton Types** to verify tensor shapes at compile time.

もう `RuntimeError: size mismatch` に怯える必要はありません。Aurelian は Scala 3 の強力な **Match Types** と **Singleton Types** を駆使し、コンパイル時にテンソルの形状を厳密に検証します。

```scala
// ❌ Compile Error! Dimension mismatch detected BEFORE execution.
// 実行前に次元の不一致を検出し、コンパイルエラーとなります。
val result = matrixA + matrixB 
```

### 🚫 Zero Dependencies / ゼロ依存
*   No Python 🐍
*   No NumPy 🔢
*   No Native Bindings (yet) 🔗
*   **Pure JVM / Future Panama API** ☕

### 💎 Pure Scala 3
Leveraging the bleeding edge of functional programming:
関数型プログラミングの最先端技術を活用：
*   `experimental.into`
*   `explicit-nulls`
*   Contextual Abstractions

---

## 📂 Project Structure / 構造

```
Aurelian/
├── 📂 data/              # The Data Sanctuary / データの聖域
│   ├── 📂 input/         # 📥 Raw Signals / 生の信号
│   └── 📂 output/        # 📤 Processed Intelligence / 処理された知性
├── 📂 src/
│   └── 📂 main/scala/
│       └── 📂 aurelian/
│           ├── 📂 engine/
│           │   └── 📂 tensor/  # 🧠 The Core Logic (Shape & Tensor) / 核となる論理
│           └── Main.scala      # 🎮 Entry Point / エントリーポイント
└── build.sbt             # 🏗️ The Blueprint / 設計図
```

---

## ⚡ Quick Start / クイックスタート

### 1. Prepare the Environment / 環境準備
Ensure you have **JDK 21+** and **sbt** installed.
**JDK 21以上** と **sbt** がインストールされていることを確認してください。

### 2. Inject Data / データの注入
Place your numerical essence into `data/input/input.txt`:
数値的エッセンスを `data/input/input.txt` に配置します：
```csv
1.0, 2.0, 3.0
4.0, 5.0, 6.0
```

### 3. Ignite the Engine / エンジン点火
```bash
sbt run
```

### 4. Witness the Result / 結果の観測
Check `data/output/output.txt` for the computed manifestation.
計算された顕現（結果）を `data/output/output.txt` で確認してください。

---

## 🧠 Roadmap / ロードマップ

- [x] **Phase 1: Genesis** - Basic Shape & Tensor definitions. (創世記：基本形状とテンソルの定義)
- [ ] **Phase 2: Expansion** - Matrix Multiplication (`MatMul`) & Dot Product. (拡張：行列積と内積)
- [ ] **Phase 3: Perception** - Algebraic Pose Estimation. (知覚：代数的姿勢推定)
- [ ] **Phase 4: Ascension** - GPU Acceleration via Project Panama. (昇華：Project PanamaによるGPU加速)

---

*Built with 🩸, 💦, and 𝜆 by the Aurelian Architects.*
