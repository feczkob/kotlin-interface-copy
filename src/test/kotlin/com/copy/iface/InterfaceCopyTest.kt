package com.copy.iface

import com.copy.iface.common.modifier.modifyNameInlined
import com.copy.iface.common.modifier.modifyNameWithGenericParam
import com.copy.iface.common.modifier.modifyNameWithoutGenericParam
import com.copy.iface.separate.modifier.AppleModifierImpl
import com.copy.iface.separate.modifier.modifyFruit
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import com.copy.iface.common.fruit.Apple as AppleCommon
import com.copy.iface.common.modifier.FruitModifierImpl as FruitModifierImplCommon
import com.copy.iface.separate.fruit.Apple as AppleSeparate

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