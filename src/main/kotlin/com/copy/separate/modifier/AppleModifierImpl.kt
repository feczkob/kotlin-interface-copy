package com.copy.separate.modifier

import com.copy.separate.fruit.Apple

class AppleModifierImpl : FruitModifier<Apple> {

    override fun modify(fruit: Apple): Apple =
        fruit.copy(
            name = "Modified ${fruit.name}",
        )

}