package com.copy.nested.regular

import com.copy.nested.Person

fun main() {
    val person = Person()

    val modifiedPerson = person.copy(
        address = person.address.copy(
            street = person.address.street.copy(
                name = "Modified ${person.address.street.name}",
            ),
        ),
    )

    val modifiedPerson2 = person.copy(
        address = person.address.copy(
            street = person.address.street.copy(
                name = "Modified ${person.address.street.name}",
                number = 456,
            ),
            city = person.address.city.copy(
                name = person.address.city.name + " City",
            ),
        ),
    )

    println("Original person: $person")
    println("Modified person: $modifiedPerson")
    println("Modified person2: $modifiedPerson2")
}