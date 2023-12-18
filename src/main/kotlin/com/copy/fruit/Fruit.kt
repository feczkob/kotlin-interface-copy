package com.copy.fruit

interface Fruit {
    val name: String
    val color: String
    val taste: Taste

    fun copy(
        name: String = this.name,
        color: String = this.color,
        taste: Taste = this.taste,
    ): Fruit
}