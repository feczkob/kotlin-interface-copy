package com.copy.iface.common.modifier

import com.copy.iface.common.fruit.Fruit


class FruitModifierImpl : FruitModifier {

    override fun modifyName(fruit: Fruit): Fruit {
        return fruit.copy(
            name = "Modified ${fruit.name}",
        )
    }
}

