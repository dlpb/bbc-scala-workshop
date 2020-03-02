package domain

import scala.util.{Try, Success, Failure}

object Bookshop {

  val name = "Scala Books of the World"
  val address = Address(26, "Main Street", "Bath", "Somerset", "BA1 3ZZ")

//  val author =  Author("Pete Smith")
//  val publisherAddress =  Address(10, "High Street", "Sailsbury", "Wiltshire", "SL10 3AD")
//  val publisher =  Publisher("Tech Books Publishing Ltd.", publisherAddress)
//  val book =  Book("Scala Unleashed", Price(15.95), author, publisher, Technical)

  def makeBook(title: String, price: Price, author: Author, publisher: Publisher, genre: Genre) =
    Try {
      Book(title, price, author, publisher, genre)
    } recoverWith {
      case e: PriceException =>
        println(s"You cannot give away a book or pay people to take books - ${e.getMessage}")
        throw e
    } match {
      case Success(book) => Some(book)
      case Failure(_) => None
    }

  val books = List(
    makeBook("Scala Unleashed", Price(15.95), Author("Pete Smith"), Publisher("Tech Books Publishing Ltd.", Address(10, "High Street", "Sailsbury", "Wiltshire", "SL10 3AD")), Technical),
    makeBook("Python in the Wild", Price(12.55), Author("Joe Jones"), Publisher("Tech Books Publishing Ltd.", Address(10, "High Street", "Sailsbury", "Wiltshire", "SL10 3AD")), Technical),
    makeBook("The Wars of the Roses Retold", Price(12.34), Author("Pete Andrews"), Publisher("Historical Books Are Us", Address(5, "The Estate", "Market Harborough", "Hampshire", "HA3 4RR")), Historical),
    makeBook("It was a Dark Night", Price(23.55), Author("Gryff Cooke"), Publisher("Adriana Books", Address(340, "Long Mile Road", "Swindon", "Wiltshire", "SN12 6ER")), Fiction),
    makeBook("It was a Dark Night 2", Price(0.01), Author("Gryff Cooke"), Publisher("Adriana Books", Address(340, "Long Mile Road", "Swindon", "Wiltshire", "SN12 6ER")), Fiction),
    makeBook("It was a Dark Night 3", Price(0.00), Author("Gryff Cooke"), Publisher("Adriana Books", Address(340, "Long Mile Road", "Swindon", "Wiltshire", "SN12 6ER")), Fiction),
    makeBook("It was a Dark Night 4", Price(-0.01), Author("Gryff Cooke"), Publisher("Adriana Books", Address(340, "Long Mile Road", "Swindon", "Wiltshire", "SN12 6ER")), Fiction),
  ).flatten

  val bookInventory = BookInventory(books)



  def printDetails(): Unit = {
    println(s"name: $name")
    println(s"address: $address")
    println(s"books: $bookInventory")

    val prettyPrintBook: Book => Unit = (book: Book) => {
      val prettyString =
        s"""
           | ${book.title}
           |   by ${book.author.name}
           |     at a cost of ${book.price}
       """.stripMargin
      println(prettyString)
    }

    println("Technical books")

    books
      .filter(_.genre.equals(Technical))
      .foreach(prettyPrintBook)


    println("books under £15")
    books
      .filter(_.price < 15.00)
      .foreach(prettyPrintBook)

  }
}
