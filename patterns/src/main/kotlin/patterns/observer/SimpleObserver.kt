package patterns.observer

/**
 * A simple implementation of the Observer pattern where a subject (patterns.observer.SimpleObserver) maintains a list of
 * observers (patterns.observer.CustomObserver) that are notified of any changes in the subject's state (text).
 */
class SimpleObserver {
    private val observers = mutableListOf<CustomObserver>()
    private var text = "Empty text"

    /**
     * Adds an observer to the list of observers.
     *
     * @param observer The observer to be added.
     */
    fun addObserver(observer: CustomObserver) {
        observers.add(observer)
    }

    /**
     * Updates the text state and notifies all registered observers.
     *
     * @param text The new text to be set.
     */
    fun changeText(text: String) {
        this.text = text
        observers.forEach { observer -> observer.observe(text) }
    }
}

/**
 * Interface for custom observers that will be notified of changes in the subject's state.
 */
interface CustomObserver {
    /**
     * Called when the observed subject's state changes.
     *
     * @param text The new text value of the subject.
     */
    fun observe(text: String)
}

/**
 * Main function demonstrating the usage of the patterns.observer.SimpleObserver and patterns.observer.CustomObserver interfaces.
 */
fun main() {
    // Creating an instance of patterns.observer.SimpleObserver
    val observer = SimpleObserver()

    // Adding the first observer anonymously
    observer.addObserver(object : CustomObserver {
        override fun observe(text: String) {
            println("First observer: $text")
        }
    })

    // Adding the second observer using a named instance
    val secondObserver = object : CustomObserver {
        override fun observe(text: String) {
            println("Second observer: $text")
        }
    }
    observer.addObserver(secondObserver)

    // Triggering a change in text and notifying observers
    observer.changeText("Hello 2 Observers!")

    println("---------------------------------")

    // Adding the third observer anonymously after the initial change
    observer.addObserver(object : CustomObserver {
        override fun observe(text: String) {
            println("Third observer: $text")
        }
    })

    // Triggering another change in text and notifying observers
    observer.changeText("Hello 3 Observers!")
}
