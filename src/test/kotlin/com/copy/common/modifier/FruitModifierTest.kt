package com.copy.common.modifier

import com.copy.common.fruit.Apple
import com.copy.common.fruit.Banana
import com.copy.common.fruit.Tomato
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