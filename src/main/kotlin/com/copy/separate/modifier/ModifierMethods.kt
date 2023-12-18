package com.copy.separate.modifier

import com.copy.separate.fruit.Apple
import com.copy.separate.fruit.Banana
import com.copy.separate.fruit.Fruit
import com.copy.separate.fruit.Tomato

fun modifyFruit(fruit: Fruit): Fruit =
    when(fruit) {
        is Apple -> fruit.copy(
            name = "Modified ${fruit.name}",
        )
        is Banana -> fruit.copy(
            name = "Modified ${fruit.name}",
        )
        is Tomato -> Tomato(
            name = "Modified ${fruit.name}",
            color = fruit.color,
            taste = fruit.taste,
            didIKnowThatItsAFruit = fruit.didIKnowThatItsAFruit
        )
        else -> error("Unknown fruit type")
    }