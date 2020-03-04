package domain

trait Inventory{
  def shopProducts: List[ShopProduct]
}

case class BookInventory(books: List[Book]) extends Inventory {
  override def shopProducts: List[ShopProduct] = books

  def groupByGenre = books.groupBy(_.genre)

  def prettyFormat: String = {
    val inventory: Map[Genre, List[Book]] = groupByGenre

    val headerString =
      """Book Inventory""".stripMargin

    val prettyInventory: String = inventory.toSeq.map({
      data =>
        val (genre, books) = data
        val prettyBooks = books
          .map(_.prettyDetailedFormat)
          .mkString("\n\n")
        s"""
           |$genre
           |$prettyBooks
         """.stripMargin

    })
    .mkString("\n")

    headerString + prettyInventory
  }

  override def toString = prettyFormat
}
