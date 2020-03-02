package domain

case class Price(price: Double)

sealed trait Genre {
  def name: String
}
case object Technical extends Genre {
  def name = "Technical"
}


trait ShopProduct {
  def price: Price
  def title: String
  def genre: Genre

  private var saleDiscountPercentage: Double = 0.0

  def setSaleDiscount(percentage: Double) = {
    this.saleDiscountPercentage = percentage
  }

  def calculateSalePrice(): Double = {
    price.price - ((saleDiscountPercentage * price.price) / 100)
  }
}
