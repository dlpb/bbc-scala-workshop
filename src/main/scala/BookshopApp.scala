import domain.{Address, Author, Book, Bookshop, Publisher}

object BookshopApp extends App {
  println("Welcome to the bookshop")

//  val author = new Author("Pete Smith")
//  val address = new Address(10, "High Street", "Sailsbury", "Wiltshire", "SL10 3AD")
//  val publisher = new Publisher("Tech Books Publishing Ltd.", address)
//  val book = new Book("Scala Unleashed", 15.95, author, publisher)
//
//  println(book)
//  println("Calculating the sales discount price")
//  book.setSaleDiscount(10.0)
//  println(s"Sale price of the book is : ${book.calculateSalePrice()}")

  Bookshop.printDetails
}