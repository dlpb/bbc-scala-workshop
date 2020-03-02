package domain

object Bookshop {

  val name = "Scala Books of the World"
  val address = Address(26, "Main Street", "Bath", "Somerset", "BA1 3ZZ")

  val author = new Author("Pete Smith")
  val publisherAddress = new Address(10, "High Street", "Sailsbury", "Wiltshire", "SL10 3AD")
  val publisher = new Publisher("Tech Books Publishing Ltd.", publisherAddress)
  val book = new Book("Scala Unleashed", Price(15.95), author, publisher, Technical)

  val books: List[Book] = List(book)

  def printDetails(): Unit = {
    println(s"name: $name")
    println(s"address: $address")
    println(s"books: $books")

  }
}
