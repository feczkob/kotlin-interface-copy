package com.copy

import com.copy.fruit.Apple
import com.copy.fruit.Banana
import com.copy.fruit.Fruit
import com.copy.fruit.Taste
import com.copy.modifier.FruitModifierImpl
import com.copy.modifier.modifyFruit


fun main() {
    val modifier = FruitModifierImpl<Fruit>()

    val apple = Apple("Apple", "Red", Taste.SWEET, 10)
    val modifiedApple = modifyFruit(apple)
    val modifiedApple2 = modifier.modify(apple)
    println(modifiedApple)
    println(modifiedApple2)

    val banana = Banana(length = 10)
    val modifiedBanana = modifyFruit(banana)
    val modifiedBanana2 = modifier.modify(banana)
    println(modifiedBanana)
    println(modifiedBanana2)
}

