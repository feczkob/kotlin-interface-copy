package com.copy.common.modifier

import com.copy.common.fruit.Fruit


class FruitModifierImpl<T : Fruit> : FruitModifier<T> {

    override fun modifyName(fruit: T): T {
        return fruit.copy(
            name = "Modified ${fruit.name}",
        ) as T
    }
}

