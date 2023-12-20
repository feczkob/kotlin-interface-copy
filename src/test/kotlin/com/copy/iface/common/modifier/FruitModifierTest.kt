package com.copy.iface.common.modifier

import com.copy.iface.common.fruit.Apple
import com.copy.iface.common.fruit.Banana
import com.copy.iface.common.fruit.Tomato
import com.copy.iface.common.modifier.FruitModifierImpl
import org.junit.jupiter.api.Test

class FruitModifierTest {

    @Test
    fun `modifyName() should modify the name of the fruit - Apple`() {
        // given
        val fruitModifier = FruitModifierImpl<Apple>()
        val fruit: Apple = Apple()

        // when
        val modifiedFruit = fruitModifier.modifyName(fruit)

        // then
        assert(modifiedFruit.name == "Modified ${fruit.name}")
    }

    @Test
    fun `modifyName() should modify the name of the fruit - Banana`() {
        // given
        val fruitModifier = FruitModifierImpl<Banana>()
        val fruit: Banana = Banana()

        // when
        val modifiedFruit = fruitModifier.modifyName(fruit)

        // then
        assert(modifiedFruit.name == "Modified ${fruit.name}")
    }

    @Test
    fun `modifyName() should modify the name of the fruit - Tomato`() {
        // given
        val fruitModifier = FruitModifierImpl<Tomato>()
        val fruit: Tomato = Tomato()

        // when
        val modifiedFruit = fruitModifier.modifyName(fruit)

        // then
        assert(modifiedFruit.name == "Modified ${fruit.name}")
    }
}