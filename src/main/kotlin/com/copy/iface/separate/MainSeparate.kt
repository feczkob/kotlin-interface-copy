package com.copy.iface.separate

import com.copy.iface.separate.fruit.Apple
import com.copy.iface.separate.fruit.Banana
import com.copy.iface.separate.fruit.Tomato
import com.copy.iface.separate.modifier.AppleModifierImpl
import com.copy.iface.separate.modifier.BananaModifierImpl
import com.copy.iface.separate.modifier.TomatoModifierImpl
import com.copy.iface.separate.modifier.modifyFruit

fun main() {
    val apple = Apple()
    val banana = Banana()
    val tomato = Tomato()

    // 1.1
    println("1.1")
    val modifiedApple = modifyFruit(apple)
    val modifiedBanana = modifyFruit(banana)
    val modifiedTomato = modifyFruit(tomato)

    println(modifiedApple)
    println(modifiedBanana)
    println(modifiedTomato)

    // 1.2
    println("1.2")
    val appleModifier = AppleModifierImpl()
    val bananaModifier = BananaModifierImpl()
    val tomatoModifier = TomatoModifierImpl()

    val modifiedApple2 = appleModifier.modifyName(apple)
    val modifiedBanana2 = bananaModifier.modifyName(banana)
    val modifiedTomato2 = tomatoModifier.modifyName(tomato)

    println(modifiedApple2)
    println(modifiedBanana2)
    println(modifiedTomato2)
}
