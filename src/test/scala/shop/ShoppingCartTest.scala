package shop

import domain._
import org.specs2.mutable.Specification

class ShoppingCartTest extends Specification {

  val book1 = Book("Scala Unleashed", Price(15.95), Author("Pete Smith"), Publisher("Tech Books Publishing Ltd.", Address(10, "High Street", "Sailsbury", "Wiltshire", "SL10 3AD")), Technical)
  val book2 = Book("Python in the Wild", Price(12.55), Author("Joe Jones"), Publisher("Tech Books Publishing Ltd.", Address(10, "High Street", "Sailsbury", "Wiltshire", "SL10 3AD")), Technical)
  val book3 = Book("The Wars of the Roses Retold", Price(12.34), Author("Pete Andrews"), Publisher("Historical Books Are Us", Address(5, "The Estate", "Market Harborough", "Hampshire", "HA3 4RR")), Historical)

  "shopping cart" should {
    "be empty when created" in {
      val cart = new ShoppingCart()
      cart.size must be equalTo 0
    }

    "be empty when created" in {
      val cart = new ShoppingCart()
      cart.isEmpty() must be equalTo true
    }

    "have length 1 when there is one product added" in {
      val cart = new ShoppingCart()
      cart.add(book1)
      cart.size must be equalTo 1
    }

    "have length 2 when the same product is added twice" in {
      val cart = new ShoppingCart()
      cart.add(book1)
      cart.add(book1)
      cart.size must be equalTo 2
    }

    "have length 2 when 2 products are added " in {
      val cart = new ShoppingCart()
      cart.add(book1)
      cart.add(book2)
      cart.size must be equalTo 2
    }

    "have length 1 when a product is removed after 2 were added" in {
      val cart = new ShoppingCart()
      cart.add(book1)
      cart.add(book2)
      cart.size must be equalTo 2
      cart.remove(book2)
      cart.size must be equalTo 1
    }

    "have length 1 when a product is removed after 2 of the same product were added" in {
      val cart = new ShoppingCart()
      cart.add(book1)
      cart.add(book1)
      cart.size must be equalTo 2
      cart.remove(book1)
      cart.size must be equalTo 1
    }

    "have length 2 when an invalid product is removed after 2 of the same product were added" in {
      val cart = new ShoppingCart()
      cart.add(book1)
      cart.add(book2)
      cart.size must be equalTo 2
      cart.remove(book3)
      cart.size must be equalTo 2
    }

    "should have length 0 when removing a product from an empty cart" in {
      val cart = new ShoppingCart()
      cart.remove(book1)
      cart.size should be equalTo 0
    }

    "should have length 1 when removing a product that doesnt exist in a cart" in {
      val cart = new ShoppingCart()
      cart.add(book1)
      cart.remove(book2)
      cart.size should be equalTo 1
    }

    "should calculate a total of 0 for an empty basket" in {
      val cart = new ShoppingCart()
      cart.total should be equalTo Price(0.0)
    }

    "should calculate a total for one book" in {
      val cart = new ShoppingCart()
      cart.add(book1)
      cart.total should be equalTo Price(15.95)
    }

    "should calculate a total for many book" in {
      val cart = new ShoppingCart()
      cart.add(book1)
      cart.add(book2)
      cart.add(book3)
      cart.total should be equalTo Price(40.84)
    }
  }

}
