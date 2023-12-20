package com.copy.iface.separate.modifier

import com.copy.iface.separate.fruit.Fruit

fun interface FruitModifier<T: Fruit> {
    fun modifyName(fruit: T): T
}