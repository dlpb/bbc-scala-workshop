package domain

trait SaleableItem {

  def price: Price

  private var saleDiscountPercentage: Double = 0.0

  def setSaleDiscount(percentage: Double) = {
    this.saleDiscountPercentage = percentage
  }

  def calculateSalePrice(): Double = {
    price.price - ((saleDiscountPercentage * price.price) / 100)
  }
}
