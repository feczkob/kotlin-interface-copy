package com.copy.fruit

data class Apple(
    override val name: String = "Apple",
    override val color: String = "Red",
    override val taste: Taste = Taste.SWEET,
    val size: Int,
) : Fruit {

    // * uses its primary constructor
    override fun copy(
        name: String,
        color: String,
        taste: Taste,
    ): Apple = Apple(name, color, taste, size)
}