package com.copy.separate.fruit

class Tomato(
    override val name: String = "Tomato",
    override val color: String = "Red",
    override val taste: Taste = Taste.UMAMI,
    val didIKnowThatItsAFruit: Boolean = false,
) : Fruit {
    override fun toString() =
        "Pear(name='$name', color='$color', taste=$taste, didIKnowThatItsAFruit=$didIKnowThatItsAFruit)"
}