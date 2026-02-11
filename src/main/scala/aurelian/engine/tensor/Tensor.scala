package aurelian.engine.tensor

/**
 * 型安全なテンソル。
 * S: Shape (形状を表す型)
 */
final case class Tensor[S <: Shape](data: Array[Double]):

  /**
   * 要素ごとの加算。
   * 同じ形状 S を持つテンソル同士でしか演算できないことが型システムで保証される。
   */
  def +(that: Tensor[S]): Tensor[S] =
    Tensor(this.data.zip(that.data).map(_ + _))

  /**
   * 要素ごとの減算。
   */
  def -(that: Tensor[S]): Tensor[S] =
    Tensor(this.data.zip(that.data).map(_ - _))

  /**
   * 要素ごとの積（アダマール積）。
   */
  def *(that: Tensor[S]): Tensor[S] =
    Tensor(this.data.zip(that.data).map(_ * _))

  /**
   * スカラー倍。
   */
  def scale(scalar: Double): Tensor[S] =
    Tensor(this.data.map(_ * scalar))

  /**
   * 全要素に関数を適用 (Map)。
   */
  def map(f: Double => Double): Tensor[S] =
    Tensor(this.data.map(f))

  override def toString: String =
    s"Tensor(size=${data.length}, data=[${data.mkString(", ")}])"

object Tensor:
  /**
   * 配列からテンソルを生成するファクトリ。
   * 本来は実行時にサイズの整合性チェックを行うべきだが、
   * ここでは「信頼できるソースからの生成」としてそのままラップする。
   */
  def fromArray[S <: Shape](data: Array[Double]): Tensor[S] =
    new Tensor[S](data)
