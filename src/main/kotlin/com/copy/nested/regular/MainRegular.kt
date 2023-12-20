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

    println("Original person: $person")
    println("Modified person: $modifiedPerson")
}