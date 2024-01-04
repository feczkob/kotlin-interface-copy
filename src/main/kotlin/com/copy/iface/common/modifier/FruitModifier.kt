package com.copy.iface.common.modifier

import com.copy.iface.common.fruit.Fruit

fun interface FruitModifier {
    fun modifyName(fruit: Fruit): Fruit
}
