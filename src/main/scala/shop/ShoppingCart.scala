package shop

import domain.{Price, ShopProduct}

import scala.collection.mutable.ListBuffer

class ShoppingCart {

  val contents = ListBuffer[ShopProduct]()

  def add(product: ShopProduct): Unit = {
    contents.addOne(product)
  }

  def remove(product: Product): Unit = {
    val index = contents.indexOf(product)
    if(index != -1) {
      contents.remove(index, 1)
    }
  }

  def isEmpty(): Boolean = contents.isEmpty

  def size(): Int = contents.size

  def total(): Price = {
    contents.foldLeft(Price(0.0)) { (total, p) => total + p.price}
  }
}
