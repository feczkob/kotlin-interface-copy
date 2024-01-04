package com.copy.iface.common.modifier

import com.copy.iface.common.fruit.Fruit

fun modifyNameWithoutGenericParam(fruit: Fruit): Fruit =
    fruit.copy(
        name = "Modified ${fruit.name}",
    )

inline fun <reified T : Fruit> modifyNameInlined(fruit: T): T =
    fruit.copy(
        name = "Modified ${fruit.name}",
    ) as T

fun <T : Fruit> modifyNameWithGenericParam(fruit: T): T =
    fruit.copy(
        name = "Modified ${fruit.name}",
    ) as T
