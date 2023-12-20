# Kotlin - implement copy method for interfaces

## Problem description
We often use interfaces to define a contract for a set of our classes in Object Oriented Programming. Sometimes the implementing classes are 
[data classes](https://kotlinlang.org/docs/data-classes.html) that have powerful methods like `copy` and `equals` and it is also common to declare properties as `val`
in order to make them immutable. Furthermore, not only `data` but also regular classes 
([why wouldn't I make every eligible class a data class?](https://stackoverflow.com/questions/39650646/why-wouldnt-i-make-every-eligable-kotlin-class-a-data-class)) 
may implement the interface that do not have the `copy` method by default.
These two features together yield to immutable classes that conform to a common interface, without the possibility
of handling them uniformly (i.e. without the need to know their actual (sub)types when dealing with the interface),
that leads to retrieving the actual (sub)types of the objects each time and either 
invoking the `copy` method or modifying them in some other way. We seek for a solution that allows us to update the properties of our objects
in an easier manner, avoiding boilerplate and without the need of knowing their actual types.
We assume that properties of the interface form a proper subset of the properties of the implementing classes properties'.
Thus, the problem formulation is really similar to [this](https://stackoverflow.com/questions/77647393/abstract-over-the-copy-function-from-a-data-class).

## Examples
The `Fruit` interface declares the `name`, `color` and `taste` properties as `val`, and the implementing classes
extend this model with an appropriate property for demonstration.
The `Fruit` interface is implemented by the `Apple`, `Banana` and `Tomato` classes, the former two are `data` classes,
the latter is a regular one.
In the following we will update the `name` property of our `Fruit` objects. 

### 1 - Updating the `name` property without the defining the `copy` method on the `Fruit` interface

#### 1.1 - Using the `when` construct
We can define a conditional expression with multiple branches using Kotlin's 
[when construct](https://kotlinlang.org/docs/control-flow.html#when-expression).
It's useful to combine it with the [is and !is operators](https://kotlinlang.org/docs/typecasts.html#is-and-is-operators).

#### 1.2 - Using subclasses

TODO

### 2 - Updating the `name` property with the `copy` method on the `Fruit` interface
Defining `copy` on the interface and implement it in the subclasses 
An `override` either calls the `constructor` or the `copy` method originating from the `data` class.

#### 2.1 - Using methods

TODO

#### 2.2 - Using a generic class

TODO


## Resources
- [Unchecked cast for Kotlin Collections](https://stackoverflow.com/questions/36569421/kotlin-how-to-work-with-list-casts-unchecked-cast-kotlin-collections-listkot)
- [Unchecked cast at generic Kotlin factory](https://stackoverflow.com/questions/55053649/unchecked-cast-at-generic-kotlin-factory)
- [Handling unchecked cast warning in Kotlin](https://stackoverflow.com/questions/61520115/is-there-any-way-to-handle-unchecked-cast-warning-without-using-supress-in-kotli)
