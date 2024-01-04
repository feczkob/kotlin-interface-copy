package com.copy.iface.separate.fruit

data class Apple(
    override val name: String = "Apple",
    override val color: String = "Red",
    override val taste: Taste = Taste.SWEET,
    val type: AppleType = AppleType.FUJI,
) : Fruit

enum class AppleType {
    FUJI,
    GRANNY_SMITH,
    PINK_LADY,
}
