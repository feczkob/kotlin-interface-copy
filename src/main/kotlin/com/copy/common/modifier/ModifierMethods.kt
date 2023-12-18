package com.copy.common.modifier

import com.copy.common.fruit.Fruit


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