package com.copy.iface.common.modifier

import com.copy.iface.common.fruit.Apple
import org.junit.jupiter.api.Test

class ModifierMethodsTest {
    @Test
    fun `modifyNameWithoutGenericParam() should modify the name of the fruit - Apple`() {
        // given
        val fruit: Apple = Apple()

        // when
        val modifiedFruit = modifyNameWithoutGenericParam(fruit)

        // then
        assert(modifiedFruit.name == "Modified ${fruit.name}")
    }

    @Test
    fun `modifyNameInlined() should modify the name of the fruit - Apple`() {
        // given
        val fruit: Apple = Apple()

        // when
        val modifiedFruit = modifyNameInlined(fruit)

        // then
        assert(modifiedFruit.name == "Modified ${fruit.name}")
    }

    @Test
    fun `modifyNameWithGenericParam() should modify the name of the fruit - Apple`() {
        // given
        val fruit: Apple = Apple()

        // when
        val modifiedFruit = modifyNameWithGenericParam(fruit)

        // then
        assert(modifiedFruit.name == "Modified ${fruit.name}")
    }
}
