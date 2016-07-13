package io.github.delr3ves.pocs.katacaseclases

class LabelledPoint(_label: String, _x: Int, _y: Int) extends Serializable with Product {

  def label = _label

  def x = _x

  def y = _y

  override def toString: String = s"LabelledPoint($label,$x,$y)"

  override def equals(that: Any): Boolean =
    that match {
      case that: LabelledPoint => that.canEqual(this) && this.label == that.label && this.x == that.x && this.y == that.y
      case _ => false
    }

  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + label.hashCode;
    result = prime * result + x.hashCode()
    result = prime * result + y.hashCode()
    return result
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[LabelledPoint]

  override def productPrefix = getClass.getSimpleName

  override def productArity = elementsAsList.length

  override def productElement(i: Int) = elementsAsList(i)

  override def productIterator = elementsAsList.toIterator

  def copy(label: String = _label, x: Int = _x, y: Int = _y) = new LabelledPoint(label, x, y)

  private def elementsAsList = List(label, x, y)
}

object LabelledPoint {
  def apply(label: String, x: Int, y: Int) = new LabelledPoint(label, x, y)

  def unapply(arg: LabelledPoint): Option[(String, Int, Int)] = Some((arg.label, arg.x, arg.y))
}
