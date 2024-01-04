package com.copy.iface.common

import com.copy.iface.common.fruit.Apple
import com.copy.iface.common.fruit.Banana
import com.copy.iface.common.fruit.Tomato
import com.copy.iface.common.modifier.FruitModifierImpl
import com.copy.iface.common.modifier.modifyNameInlined
import com.copy.iface.common.modifier.modifyNameWithGenericParam
import com.copy.iface.common.modifier.modifyNameWithoutGenericParam

fun main() {
    val apple = Apple()
    val banana = Banana()
    val tomato = Tomato()

    // 2.1
    println("2.1")
    val modifiedApple = modifyNameWithoutGenericParam(apple)
    val modifiedBanana = modifyNameInlined(banana)
    val modifiedTomato = modifyNameWithGenericParam(tomato)

    println(modifiedApple)
    println(modifiedBanana)
    println(modifiedTomato)

    // 2.2
    println("2.2")
    val modifier = FruitModifierImpl()

    val modifiedApple2 = modifier.modifyName(apple)
    val modifiedBanana2 = modifier.modifyName(banana)
    val modifiedTomato2 = modifier.modifyName(tomato)

    println(modifiedApple2)
    println(modifiedBanana2)
    println(modifiedTomato2)
}
