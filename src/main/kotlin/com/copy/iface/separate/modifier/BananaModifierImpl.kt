package com.copy.iface.separate.modifier

import com.copy.iface.separate.fruit.Banana

class BananaModifierImpl : FruitModifier<Banana> {
    override fun modifyName(fruit: Banana): Banana =
        fruit.copy(
            name = "Modified ${fruit.name}",
        )
}
