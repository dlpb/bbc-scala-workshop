package domain

trait SaleableItem {

  def price: Price

  if(price < 0.01) throw new PriceException(s"""Price of "$this" must be more than 0.01""")

  private var saleDiscountPercentage: Double = 0.0

  def setSaleDiscount(percentage: Double) = {
    this.saleDiscountPercentage = percentage
  }

  def calculateSalePrice(): Double = {
    price.price - ((saleDiscountPercentage * price.price) / 100)
  }
}

class PriceException(message: String) extends IllegalArgumentException(message)

