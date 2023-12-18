package com.copy.separate.modifier

import com.copy.separate.fruit.Fruit

fun interface FruitModifier<T: Fruit> {
    fun modify(fruit: T): T
}