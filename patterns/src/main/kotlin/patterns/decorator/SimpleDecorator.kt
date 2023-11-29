package patterns.decorator

/**
 * Decorator pattern example in Kotlin.
 *
 * The Decorator pattern allows behavior to be added to an individual object, either statically or dynamically,
 * without affecting the behavior of other objects from the same class. In this example, the `patterns.decorator.Animal` interface
 * represents the basic behavior of animals, and concrete implementations (`patterns.decorator.SimpleAnimal`, `patterns.decorator.Bird`, `patterns.decorator.Lion`) provide
 * specific behaviors for different types of animals. The `patterns.decorator.Bird` and `patterns.decorator.Lion` classes also have additional methods (`fly`, `run`).
 */

/**
 * Interface representing the basic behavior of an animal.
 */
interface Animal {
    /**
     * Performs the eating behavior of the animal.
     */
    fun eat()
}

/**
 * Concrete implementation of the patterns.decorator.Animal interface representing a simple animal.
 */
class SimpleAnimal : Animal {
    override fun eat() {
        println("SimpleAnimal | eat")
    }
}

/**
 * Concrete implementation of the patterns.decorator.Animal interface representing a bird.
 */
class Bird : Animal {
    override fun eat() {
        println("Bird | eat")
    }

    /**
     * Additional method specific to birds - simulates flying behavior.
     */
    fun fly() {
        println("Bird | fly")
    }
}

/**
 * Concrete implementation of the patterns.decorator.Animal interface representing a lion.
 */
class Lion : Animal {
    override fun eat() {
        println("Lion | eat")
    }

    /**
     * Additional method specific to lions - simulates running behavior.
     */
    fun run() {
        println("Lion | run")
    }
}

/**
 * Main function demonstrating the usage of the Decorator pattern with different types of animals.
 */
fun main() {
    // Create an instance of a simple animal and demonstrate its eating behavior
    val simpleAnimal = SimpleAnimal()
    simpleAnimal.eat()

    // Create an instance of a bird and demonstrate its eating and flying behavior
    val birdWithoutType = Bird()
    birdWithoutType.eat()
    birdWithoutType.fly()

    // Create an instance of a lion and demonstrate its eating and running behavior
    val lionWithoutType = Lion()
    lionWithoutType.eat()
    lionWithoutType.run()

    // Create an instance of a bird with the patterns.decorator.Animal type, demonstrating polymorphism
    val birdWithAnimalType: Animal = Bird()
    birdWithAnimalType.eat()
    // birdWithAnimalType.fly() // Cannot call fly() here as the type is patterns.decorator.Animal, not patterns.decorator.Bird
}
