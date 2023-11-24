package patterns.observer

/**
 * Observer pattern example in Kotlin.
 *
 * The Observer pattern defines a one-to-many dependency between objects so that when one object changes state,
 * all its dependents are notified and updated automatically. In this example, patterns.observer.WeatherListener acts as the subject,
 * and patterns.observer.WeatherDataListener represents the observer interface.
 */

/**
 * Data class representing weather data with a temperature value.
 *
 * @property temperature The temperature value in degrees Celsius.
 */
data class WeatherData(
    val temperature: Float
)

/**
 * Concrete implementation of the Observer pattern. Acts as the subject that maintains a list of observers
 * (patterns.observer.WeatherDataListener) and notifies them when weather data is updated.
 */
class WeatherListener : Listener<WeatherDataListener> {
    private val listeners = mutableListOf<WeatherDataListener>()

    /**
     * Updates all registered observers with the provided weather data.
     *
     * @param weatherData The new weather data to be observed.
     */
    fun updateWeather(weatherData: WeatherData) {
        listeners.forEach { weatherDataListener ->
            weatherDataListener.observe(weatherData)
        }
    }

    /**
     * Adds a new observer to the list of listeners.
     *
     * @param listener The observer to be added.
     */
    override fun addListener(listener: WeatherDataListener) {
        listeners.add(listener)
    }

    /**
     * Removes an observer from the list of listeners.
     *
     * @param listener The observer to be removed.
     */
    override fun removeListener(listener: WeatherDataListener) {
        listeners.remove(listener)
    }
}

/**
 * Interface defining the contract for all observer implementations in the Observer pattern.
 *
 * @param T The type of observer.
 */
interface Listener<T> {
    /**
     * Adds a new observer to the list of listeners.
     *
     * @param listener The observer to be added.
     */
    fun addListener(listener: T)

    /**
     * Removes an observer from the list of listeners.
     *
     * @param listener The observer to be removed.
     */
    fun removeListener(listener: T)
}

/**
 * Functional interface representing an observer for weather data.
 */
fun interface WeatherDataListener {
    /**
     * Called when new weather data is observed.
     *
     * @param data The new weather data.
     */
    fun observe(data: WeatherData)
}

/**
 * Main function demonstrating the usage of the Observer pattern with patterns.observer.WeatherListener and patterns.observer.WeatherDataListener.
 */
fun main() {
    // Create an instance of patterns.observer.WeatherListener
    val weatherListener = WeatherListener()

    // Add two observers to the patterns.observer.WeatherListener
    weatherListener.addListener {
        println("First Weather patterns.observer.Listener | Data: $it")
    }
    weatherListener.addListener {
        println("Second Weather patterns.observer.Listener | Data: $it")
    }

    // Update weather data and notify observers
    weatherListener.updateWeather(WeatherData(36.6f))
    println("---------------------------------------------------------")

    // Add a new observer after the weather data has been updated
    weatherListener.addListener {
        println("Third Weather patterns.observer.Listener | Data: $it")
    }

    // Update weather data again and notify all observers
    weatherListener.updateWeather(WeatherData(40.0f))
}