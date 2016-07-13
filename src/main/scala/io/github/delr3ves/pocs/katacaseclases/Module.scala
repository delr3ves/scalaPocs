package io.github.delr3ves.pocs.katacaseclases

object Module extends Serializable with Product {

  override def productPrefix: String = toString

  override def productElement(n: Int): Any = throw new IndexOutOfBoundsException

  override def productArity: Int = 0

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Module.type]

  override def toString = "Module"
}
