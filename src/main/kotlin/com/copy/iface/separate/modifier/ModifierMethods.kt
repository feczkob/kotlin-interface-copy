package com.copy.iface.separate.modifier

import com.copy.iface.separate.fruit.Apple
import com.copy.iface.separate.fruit.Banana
import com.copy.iface.separate.fruit.Fruit
import com.copy.iface.separate.fruit.Tomato

fun modifyFruit(fruit: Fruit): Fruit =
    when (fruit) {
        is Apple ->
            fruit.copy(
                name = "Modified ${fruit.name}",
            )
        is Banana ->
            fruit.copy(
                name = "Modified ${fruit.name}",
            )
        is Tomato ->
            Tomato(
                name = "Modified ${fruit.name}",
                color = fruit.color,
                taste = fruit.taste,
                didIKnowThatItsAFruit = fruit.didIKnowThatItsAFruit,
            )
        else -> error("Unknown fruit type")
    }
