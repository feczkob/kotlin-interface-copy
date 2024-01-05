# Kotlin - Playing with the copy method

## Implement copy method for interfaces
:one:: We often use interfaces to define a contract for a set of our classes in Object Oriented Programming. Sometimes the implementing classes are 
[`data` classes](https://kotlinlang.org/docs/data-classes.html) :package: that have powerful methods like `copy` and `equals`.
The [`copy` function](https://kotlinlang.org/docs/data-classes.html#copying) allows us to copy an object while altering some of its properties. 

:two:: It is also common to declare properties as `val` in order to make them immutable. Furthermore, not only `data` but also regular classes 
([why wouldn't I make every eligible class a `data` class?](https://stackoverflow.com/questions/39650646/why-wouldnt-i-make-every-eligable-kotlin-class-a-data-class)) 
may implement the interface and those classes do not have the `copy` method by default.

:one:-:two:: These yield to (immutable) classes that conform to a common interface, without the possibility
of handling them uniformly (i.e. without the need to know their actual (sub)types when dealing with the interface).
This leads to retrieving the actual (sub)types of the objects each time and either 
invoking the `copy` method or modifying them in some other way. 

### Problem formulation
We seek :eyes: for a solution that allows us to update the properties of our objects in an easier manner, 
avoiding boilerplate and without the need of knowing their actual types.
We want to define a method on the interface that lets us update its properties.
We focus on the interface itself rather than the implementing classes: if the subtypes would really imply totally different flows 
(e.g. flows that operate on the subtype specific properties too), then the 
**Visitor pattern** :cowboy_hat_face: should be taken into consideration as detailed [here](https://medium.com/javarevisited/java-write-code-thats-mode-readable-scalable-and-maintainable-6bbfd000809e). 
Thus, the problem formulation is really similar to [this](https://stackoverflow.com/questions/77647393/abstract-over-the-copy-function-from-a-data-class).

:warning: We assume that properties of the interface form a proper subset of the properties of the implementing (data) classes.

:information_source: As we will see, the proposed solution does not work if
1. the `copy` method is defined on the interface
2. the implementing `data` class' properties are the same as the declared props of the interface
<details>
  <summary>Spoiler</summary>

:exclamation: Even though the `data` class defines a `copy` method, we cannot mark it as an `override` of the one defined on the interface:
> Function 'copy' generated for the data class has default values for parameters, and conflicts with member of supertype 'Fruit'
</details>

### Demonstration
The `Fruit` interface declares the `name`, `color` and `taste` properties as `val`, and the implementing classes
extend this model with an appropriate property for demonstration: the `Apple` :apple:, `Banana` :banana: and `Tomato` :tomato: classes, 
the former two are `data` classes, while the latter is a regular one.
In the following subsections we will update the `name` property of our `Fruit` objects, but keep in mind that any other property of 
the interface could be updated in a similar manner.

#### 1 - Updating the `name` property without the defining the `copy` method on the `Fruit` interface
:arrow_forward: See classes in `src/main/kotlin/com/copy/iface/separate` and run `src/main/kotlin/com/copy/iface/separate/MainSeparate.kt`.

##### 1.1 - Using the `when` construct
See `src/main/kotlin/com/copy/iface/separate/modifier/ModifierMethods.kt`.

We can define a conditional expression with multiple branches using Kotlin's 
[`when` construct](https://kotlinlang.org/docs/control-flow.html#when-expression) (it's useful to combine it with the [`is` and `!is` operators](https://kotlinlang.org/docs/typecasts.html#is-and-is-operators)).

We differentiate between the types of the objects and call the `copy` method (for `Apple` and `Banana`) or
create a new object (for `Tomato`). Whenever we want to modify the name of the `Fruit` we have to get its actual subtype
(this is what we would like to avoid), unless
we put this method into a dedicated service (but then what about the possibly modifiable other props of `Fruit`?).
So we cannot _really_ deal with a `Fruit` as `Fruit`.
Furthermore, this approach violates the _O_ (Open-closed principle: software entities should be open for extension, closed for modification) of the 
[SOLID](https://en.wikipedia.org/wiki/SOLID) principles :books:: a new branch should be added to the
`when` expressions every time we create a new subtype of `Fruit` (this wouldn't happen often, but the possibility is there).

##### 1.2 - Using subclasses
See `src/main/kotlin/com/copy/iface/separate/modifier/FruitModifier.kt` and its implementations.

A similar solution to the one above ([1.1](#11---using-the-when-construct)) is to define a `FruitModifier` 
interface and implement it with `Fruit` subtype specific subclasses.
The `modifyName` method delegates to the `copy` method of the `data` classes or calls the constructor of `Tomato`.
This approach would mean that a new `Modifier` class should be created for each new subtype of `Fruit` 
and also a new method should be added to `FruitModifier` and implemented in its subclasses whenever we want to modify another property of `Fruit`.

#### 2 - Updating the `name` property with the `copy` method on the `Fruit` interface
:arrow_forward: See classes in `src/main/kotlin/com/copy/iface/common` and run `src/main/kotlin/com/copy/iface/common/MainCommon.kt`.

We may define the `copy` method on the interface: this method takes all of the `Fruit` properties as arguments and returns a new `Fruit` object.
An `override` of this either calls the `copy` method (`Banana`) originating from the `data` class or the constructor (`Apple` and `Tomato`).
This method should have default values for all of its parameters, so that it can be called with an arbitrary number of arguments.

:information_source: The implementing `data` classes will have two `copy` methods: one from the interface and one from the `data` class.

_Notice that the name of the method is up to us: the chosen `copy` name is suitable because its purpose is the same as the `copy` method of the `data` classes._

It's important to note here that these methods should be defined only **once** :recycle:, and their implementation is very easy:
they simply delegate to the appropriate object creation.

Now we may use the `copy` method defined on the `Fruit` interface (notice the `Fruit` type declaration) as follows:
```kotlin
val apple: Fruit = Apple()
val modifiedApple: Fruit = apple.copy(name = "Modified ${apple.name}")
```

:bulb: Play a bit with the `Tomato` class: add the `data` modifier to it and see what happens.
<details>
  <summary>Spoiler</summary>
  
  :exclamation: The IDE complains about the `copy` method that takes all primary constructor arguments as parameters:
  > Conflicting overloads: public final fun copy(name: String = ..., color: String = ..., taste: Taste = ..., didIKnowThatItsAFruit: Boolean = ...): 
  > Tomato defined in com.copy.iface.common.fruit.Tomato
</details>

##### Built-in copy method of the implementing data classes
:bulb: As it was mentioned in the [Problem formulation](#problem-formulation), the `copy` method of the implementing `data` classes cannot 
override the one defined on the interface. Replace the `Apple` class with the following:
```kotlin
data class Apple(
    override val name: String = "Apple",
    override val color: String = "Red",
    override val taste: Taste = Taste.SWEET,
) : Fruit
```
> Function 'copy' generated for the data class has default values for parameters, and conflicts with member of supertype 'Fruit'

We cannot use the `copy` method of the `data` class as an implementation of the one defined on the interface since it lacks the `override` modifier. 
Because of this, the proposed solution would not work for `data` classes that have the same properties as the interface. 

##### 2.1 - Using methods
See `src/main/kotlin/com/copy/iface/common/modifier/ModifierMethods.kt`.

There are three different methods that modify the `name` property of the `Fruit` objects defined in this class,
but they all ultimately call the `copy` method of the `Fruit` interface. There are certain scenarios where
they may or may not be used, the programmer has to decide which one to use in a specific case.
:exclamation: As we can see the IDE complains that there is an unchecked cast in the `modifyNameWithGenericParam` method:
> Unchecked cast: Fruit to T

:warning: Since we declared `T` to be the subtype of `Fruit` with `<T : Fruit>`, in my opinion we can disregard this warning.

##### 2.2 - Using a modifier interface
See `src/main/kotlin/com/copy/iface/common/modifier/FruitModifier.kt` and its implementation.

Similarly to [1.2](#12---using-subclasses) we can define a `FruitModifier` interface, but this time without the unnecessary 
type parameter `T`. This should be implemented by only one class, the `FruitModifierImpl` that delegates to the `copy` method of the `Fruit` interface.
With this solution we reduced :arrow_down: the number of classes and methods, however we still have to create a new method in 
`FruitModifierImpl` whenever we want to modify another property of `Fruit`, but this is what we wanted all along:
to treat the `Fruit` objects uniformly.

### Conclusion
:white_check_mark: This repository shows how to implement the `copy` method for an interface in order to handle these objects uniformly,
without the need to retrieve their actual types and to reduce boilerplate and duplicated code. Also, the same can be done
for `abstract` classes.

### Resources
- [Unchecked cast for Kotlin Collections](https://stackoverflow.com/questions/36569421/kotlin-how-to-work-with-list-casts-unchecked-cast-kotlin-collections-listkot)
- [Unchecked cast at generic Kotlin factory](https://stackoverflow.com/questions/55053649/unchecked-cast-at-generic-kotlin-factory)
- [Handling unchecked cast warning in Kotlin](https://stackoverflow.com/questions/61520115/is-there-any-way-to-handle-unchecked-cast-warning-without-using-supress-in-kotli)
- [Copyable interface without arguments in Kotlin](https://stackoverflow.com/questions/43667628/write-a-copyable-interface-more-elegant-than-in-java)
- [Open-closed principle](https://en.wikipedia.org/wiki/Open%E2%80%93closed_principle)

## Usage of the Arrow library 
See classes in `src/main/kotlin/com/copy/nested` and compare `src/main/kotlin/com/copy/nested/arrow/MainArrow.kt` with 
`src/main/kotlin/com/copy/nested/regular/MainRegular.kt`.

A simple demonstration how the Arrow library can make one's life easier when trying to update nested properties.

### Resources
- [Arrow](https://arrow-kt.io/learn/overview/)
