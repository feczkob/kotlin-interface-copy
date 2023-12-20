package com.copy.separate.modifier

import com.copy.separate.fruit.Banana

class BananaModifierImpl : FruitModifier<Banana> {

    override fun modifyName(fruit: Banana): Banana =
        fruit.copy(
            name = "Modified ${fruit.name}",
        )

}