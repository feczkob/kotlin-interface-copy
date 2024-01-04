package com.copy.iface.separate.modifier

import com.copy.iface.separate.fruit.Tomato

class TomatoModifierImpl : FruitModifier<Tomato> {
    override fun modifyName(fruit: Tomato): Tomato =
        Tomato(
            name = "Modified ${fruit.name}",
            color = fruit.color,
            taste = fruit.taste,
            didIKnowThatItsAFruit = fruit.didIKnowThatItsAFruit,
        )
}
