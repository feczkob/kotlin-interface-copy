package com.copy.iface.separate.fruit

interface Fruit {
    val name: String
    val color: String
    val taste: Taste
}

enum class Taste {
    SWEET, SOUR, BITTER, SALTY, UMAMI
}