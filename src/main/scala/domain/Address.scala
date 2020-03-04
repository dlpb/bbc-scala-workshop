package domain

case class Address(number: Int, street: String, town: String, county: String, postcode: String) {
  override def toString = s"$number, $street, $town, $county, $postcode"
}
