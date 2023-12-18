package com.copy.modifier

import com.copy.fruit.Fruit
import com.copy.fruit.Taste

class FruitModifierImpl<T: Fruit> : FruitModifier<T> {

    // * this unchecked cast warn cannot be avoided as of now (18. 12. 2023.)
    override fun modify(fruit: T): T {
        return fruit.copy(
            name = "Modified ${fruit.name}",
            color = "Modified ${fruit.color}",
            taste = Taste.UMAMI,
        ) as T
    }
}

inline fun <reified T: Fruit> modifyFruit(fruit: T): T {
    return fruit.copy(
        name = "Modified ${fruit.name}",
        color = "Modified ${fruit.color}",
        taste = Taste.UMAMI,
    ) as T
}