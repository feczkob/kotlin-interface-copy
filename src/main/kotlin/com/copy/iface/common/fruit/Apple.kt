package com.copy.iface.common.fruit

data class Apple(
    override val name: String = "Apple",
    override val color: String = "Red",
    override val taste: Taste = Taste.SWEET,
    val type: AppleType = AppleType.FUJI,
) : Fruit {

    // * uses its primary constructor
    override fun copy(
        name: String,
        color: String,
        taste: Taste,
    ): Apple = Apple(name, color, taste, type)
}

enum class AppleType {
    FUJI, GRANNY_SMITH, PINK_LADY
}