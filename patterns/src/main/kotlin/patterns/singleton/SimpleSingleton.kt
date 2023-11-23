package patterns.singleton

/**
 * Singleton object representing a simple counter with an add operation.
 * The singleton ensures that only one instance of the object is created.
 */
object SimpleSingleton {
    private var count = 0

    /**
     * Initializes the singleton object and prints a message.
     */
    init {
        println("Initialize a singleton object")
    }

    /**
     * Adds the specified number to the counter and prints the result.
     *
     * @param number The number to be added to the counter.
     */
    fun add(number: Int) {
        println("Result of add: $count + $number = ${count + number}")
        count += number
    }
}

/**
 * Class representing a non-singleton object with a counter and an add operation.
 */
class NotSingleton {
    private var count = 0

    /**
     * Initializes the non-singleton object and prints a message.
     */
    init {
        println("Initialize a NOT singleton object")
    }

    /**
     * Adds the specified number to the counter and prints the result.
     *
     * @param number The number to be added to the counter.
     */
    fun add(number: Int) {
        println("Result of add: $count + $number = ${count + number}")
        count += number
    }
}

/**
 * Main function demonstrating the usage of the patterns.singleton.SimpleSingleton and
 * patterns.singleton.NotSingleton classes.
 */
fun main() {
    println("--------------------------------------------")
    println("Singleton: ")
    SimpleSingleton.add(10)
    SimpleSingleton.add(20)

    println("--------------------------------------------")
    println("Not singleton: ")
    NotSingleton().add(69)
    NotSingleton().add(11)
}
