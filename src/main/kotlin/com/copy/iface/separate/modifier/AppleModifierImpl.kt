package com.copy.iface.separate.modifier

import com.copy.iface.separate.fruit.Apple

class AppleModifierImpl : FruitModifier<Apple> {

    override fun modifyName(fruit: Apple): Apple =
        fruit.copy(
            name = "Modified ${fruit.name}",
        )

}