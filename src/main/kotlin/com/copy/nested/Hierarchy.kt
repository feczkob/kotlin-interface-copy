package com.copy.nested

import arrow.optics.optics

@optics
data class Person(
    val name: String = "Joci",
    val age: Int = 30,
    val address: Address = Address(),
) {
    companion object
}
@optics
data class Address(
    val street: Street = Street(),
    val city: City = City(),
) {
    companion object
}
@optics
data class Street(
    val name: String = "Petofi Street",
    val number: Int? = 123,
) {
    companion object
}
@optics
data class City(
    val name: String = "Miskolc",
    val country: String = "Hungary",
) {
    companion object
}