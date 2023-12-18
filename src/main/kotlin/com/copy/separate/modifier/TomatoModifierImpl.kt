package com.copy.separate.modifier

import com.copy.separate.fruit.Tomato


class TomatoModifierImpl : FruitModifier<Tomato> {

    override fun modify(fruit: Tomato): Tomato =
        Tomato(
            name = "Modified ${fruit.name}",
            color = fruit.color,
            taste = fruit.taste,
            didIKnowThatItsAFruit = fruit.didIKnowThatItsAFruit
        )

}