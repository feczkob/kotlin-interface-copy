package com.copy.iface.separate.fruit

class Tomato(
    override val name: String = "Tomato",
    override val color: String = "Red",
    override val taste: Taste = Taste.UMAMI,
    val didIKnowThatItsAFruit: Boolean = false,
) : Fruit {
    override fun toString() =
        "Tomato(name=$name, color=$color, taste=$taste, didIKnowThatItsAFruit=$didIKnowThatItsAFruit)"
}