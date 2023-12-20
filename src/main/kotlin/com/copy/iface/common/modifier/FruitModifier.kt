package com.copy.iface.common.modifier

import com.copy.iface.common.fruit.Fruit


fun interface FruitModifier<T : Fruit> {
    fun modifyName(fruit: T): T
}