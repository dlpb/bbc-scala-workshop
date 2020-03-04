package domain

trait Printable extends Any {
  def print = println(this)
}

case class Price(price: Double) extends AnyVal with Printable {
  override def toString = {
    val formatter = java.text.NumberFormat.getCurrencyInstance
    formatter.format(price)
  }
}


sealed trait Genre {
  def name: String
}
case object Technical extends Genre {
  def name = "Technical"
}

case object Fiction extends Genre {
  def name = "Fiction"
}

case object Historical extends Genre {
  def name = "Historical"
}


abstract class ShopProduct(val title: String, val price: Price, val genre: Genre) extends SaleableItem {

  override def toString = s"$title, $price $genre"
}
