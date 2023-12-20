package com.copy

import com.copy.common.modifier.modifyNameInlined
import com.copy.common.modifier.modifyNameWithGenericParam
import com.copy.common.modifier.modifyNameWithoutGenericParam
import com.copy.separate.modifier.AppleModifierImpl
import com.copy.separate.modifier.modifyFruit
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import com.copy.common.fruit.Apple as AppleCommon
import com.copy.common.modifier.FruitModifierImpl as FruitModifierImplCommon
import com.copy.separate.fruit.Apple as AppleSeparate

class InterfaceCopyTest {

    @Test
    fun `modifierImpls' results match - Apple`() {
        val appleCommon: AppleCommon = AppleCommon()
        val appleSeparate: AppleSeparate = AppleSeparate()

        val appleModifierCommon = FruitModifierImplCommon<AppleCommon>()
        val appleModifierSeparate = AppleModifierImpl()

        assertEquals(
            appleModifierCommon.modifyName(appleCommon).name,
            appleModifierSeparate.modifyName(appleSeparate).name,
        )
    }

    @Test
    fun `modifierMethods' results match`() {
        val appleCommon: AppleCommon = AppleCommon()
        val appleSeparate: AppleSeparate = AppleSeparate()

        assertEquals(
            modifyNameWithoutGenericParam(appleCommon).name,
            modifyFruit(appleSeparate).name,
        )

        assertEquals(
            modifyNameInlined(appleCommon).name,
            modifyFruit(appleSeparate).name,
        )

        assertEquals(
            modifyNameWithGenericParam(appleCommon).name,
            modifyFruit(appleSeparate).name,
        )
    }
}