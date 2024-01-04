package com.copy.nested.arrow

import arrow.optics.copy
import com.copy.nested.Person
import com.copy.nested.Street
import com.copy.nested.address
import com.copy.nested.city
import com.copy.nested.name
import com.copy.nested.number
import com.copy.nested.street

fun main() {
    val person = Person()

    val modifiedPerson = Person.address.street.name.modify(person) { "Modified $it" }

    val modifiedPerson2 = person.copy {
        inside(Person.address.street) {
            Street.name set "Modified ${person.address.street.name}"
            Street.number set 456
        }
        Person.address.city.name set person.address.city.name + " City"
    }


    println("Original person: $person")
    println("Modified person: $modifiedPerson")
    println("Modified person2: $modifiedPerson2")
}

