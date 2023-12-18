package com.copy.modifier

import com.copy.fruit.Fruit

fun interface FruitModifier<T: Fruit> {
    fun modify(fruit: T): T
}