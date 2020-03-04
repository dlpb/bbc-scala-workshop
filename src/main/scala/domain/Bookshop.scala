package domain

object Bookshop {

  val name = "Scala Books of the World"
  val address = Address(26, "Main Street", "Bath", "Somerset", "BA1 3ZZ")

//  val author =  Author("Pete Smith")
//  val publisherAddress =  Address(10, "High Street", "Sailsbury", "Wiltshire", "SL10 3AD")
//  val publisher =  Publisher("Tech Books Publishing Ltd.", publisherAddress)
//  val book =  Book("Scala Unleashed", Price(15.95), author, publisher, Technical)

  val books = List(
    Book("Scala Unleashed", Price(15.95), Author("Pete Smith"), Publisher("Tech Books Publishing Ltd.", Address(10, "High Street", "Sailsbury", "Wiltshire", "SL10 3AD")), Technical),
    Book("Python in the Wild", Price(12.55), Author("Joe Jones"), Publisher("Tech Books Publishing Ltd.", Address(10, "High Street", "Sailsbury", "Wiltshire", "SL10 3AD")), Technical),
    Book("The Wars of the Roses Retold", Price(12.34), Author("Pete Andrews"), Publisher("Historical Books Are Us", Address(5, "The Estate", "Market Harborough", "Hampshire", "HA3 4RR")), Historical),
    Book("It was a Dark Night", Price(23.55), Author("Gryff Cooke"), Publisher("Adriana Books", Address(340, "Long Mile Road", "Swindon", "Wiltshire", "SN12 6ER")), Fiction),
  )

  val bookInventory = BookInventory(books)

  def printDetails(): Unit = {
    println(s"name: $name")
    println(s"address: $address")
    println(s"books: $bookInventory")

  }
}
