package com.copy.iface.separate.fruit

data class Banana(
    override val name: String = "Banana",
    override val color: String = "Yellow",
    override val taste: Taste = Taste.SWEET,
    val length: Int = 10,
) : Fruit