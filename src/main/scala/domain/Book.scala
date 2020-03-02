package domain

case class Author(name: String)

case class Publisher(name: String, address: Address)

case class Book(title: String, price: Price, author: Author, publisher: Publisher, genre: Genre) extends ShopProduct
