package com.copy.iface.common.fruit

data class Banana(
    override val name: String = "Banana",
    override val color: String = "Yellow",
    override val taste: Taste = Taste.SWEET,
    val length: Int = 10,
) : Fruit {

    // * uses its copy method
    override fun copy(
        name: String,
        color: String,
        taste: Taste,
    ): Banana = copy(
        name = name,
        color = color,
        taste = taste,
        length = length,
    )
}