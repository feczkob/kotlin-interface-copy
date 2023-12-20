package com.copy.nested.arrow

import com.copy.nested.Person
import com.copy.nested.address
import com.copy.nested.name
import com.copy.nested.street

fun main() {
    val person = Person()

    val modifiedPerson = Person.address.street.name.modify(person) { "Modified $it" }


    println("Original person: $person")
    println("Modified person: $modifiedPerson")
}

