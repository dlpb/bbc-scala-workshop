package domain

case class Author(name: String) {
  override def toString = name
}

case class Publisher(name: String, address: Address) {
  override def toString = s"$name - $address"
}

case class Book(override val title: String, override val price: Price, author: Author, publisher: Publisher, override val genre: Genre) extends ShopProduct(title, price, genre) {
  def prettyDetailedFormat: String = {
    s"""  Title: $title
       |  Author: $author
       |  Price: $price
       |  Publisher: $publisher
       |  Genre: $genre""".stripMargin
  }

}
