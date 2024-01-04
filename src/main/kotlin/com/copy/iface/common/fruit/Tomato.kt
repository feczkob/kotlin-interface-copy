package com.copy.iface.common.fruit

class Tomato(
    override val name: String = "Tomato",
    override val color: String = "Red",
    override val taste: Taste = Taste.UMAMI,
    private val didIKnowThatItsAFruit: Boolean = false,
) : Fruit {
    // * uses its primary constructor
    override fun copy(
        name: String,
        color: String,
        taste: Taste,
    ): Tomato = Tomato(name, color, taste, didIKnowThatItsAFruit)

    // * we may define the copy method with all props, but it's not necessary
    fun copy(
        name: String = this.name,
        color: String = this.color,
        taste: Taste = this.taste,
        didIKnowThatItsAFruit: Boolean = this.didIKnowThatItsAFruit,
    ): Tomato = Tomato(name, color, taste, didIKnowThatItsAFruit)

    override fun toString() = "Tomato(name=$name, color=$color, taste=$taste, didIKnowThatItsAFruit=$didIKnowThatItsAFruit)"
}
