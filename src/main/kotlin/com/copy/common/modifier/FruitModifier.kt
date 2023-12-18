package com.copy.common.modifier

import com.copy.common.fruit.Fruit


fun interface FruitModifier<T : Fruit> {
    fun modifyName(fruit: T): T
}