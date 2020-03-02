package domain

case class Author(name: String)

case class Publisher(name: String, address: Address)

case class Price(price: Double)

case class Book(title: String, price: Price, author: Author, publisher: Publisher) {
  private var saleDiscountPercentage: Double = 0.0

  def setSaleDiscount(value: Double) = {
    this.saleDiscountPercentage = value
  }


  def calculateSalePrice(): Double = {
    price.price - ((saleDiscountPercentage * price.price) / 100)
  }


}
