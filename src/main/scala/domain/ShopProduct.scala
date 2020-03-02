package domain

case class Price(price: Double)

trait ShopProduct {
  def price: Price
  def title: String

  private var saleDiscountPercentage: Double = 0.0

  def setSaleDiscount(percentage: Double) = {
    this.saleDiscountPercentage = percentage
  }

  def calculateSalePrice(): Double = {
    price.price - ((saleDiscountPercentage * price.price) / 100)
  }
}
