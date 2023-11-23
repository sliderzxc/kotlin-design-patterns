package patterns.builder

/**
 * Data class representing a patterns.builder.Car with a name and maximum speed.
 *
 * @property name The name of the car.
 * @property maxSpeed The maximum speed of the car.
 */
data class Car(
    val name: String,
    val maxSpeed: Int
)

/**
 * Data class representing a patterns.builder.CarShowroom containing a list of cars.
 *
 * @property cars The list of cars in the showroom.
 */
data class CarShowroom(
    val cars: List<Car>
)

/**
 * Builder class for constructing a patterns.builder.CarShowroom.
 */
class CarShowroomBuilder {
    private var cars = mutableListOf<Car>()

    /**
     * Function to specify a list of cars for the showroom using a DSL.
     *
     * @param block The DSL block for specifying cars in the showroom.
     */
    fun cars(block: CarContainer.() -> Unit) {
        val carContainer = CarContainer().apply(block)
        cars.addAll(carContainer.content)
    }

    /**
     * Builds and returns a patterns.builder.CarShowroom instance.
     *
     * @return The constructed patterns.builder.CarShowroom.
     */
    fun build() = CarShowroom(cars)
}

/**
 * Container class for holding a list of cars during the building process.
 */
class CarContainer {

    /**
     * The list of cars being constructed.
     */
    val content: MutableList<Car> = mutableListOf()

    /**
     * Function to add a car to the container using a DSL.
     *
     * @param block The DSL block for specifying car properties.
     * @return The constructed patterns.builder.Car instance.
     */
    inline fun car(block: CarBuilder.() -> Unit): Car {
        return CarBuilder().apply(block).build().also { content.add(it) }
    }
}

/**
 * Builder class for constructing a patterns.builder.Car.
 */
class CarBuilder {
    /**
     * The name of the car.
     */
    var name: String = "DefaultName"

    /**
     * The maximum speed of the car.
     */
    var maxSpeed = 0

    /**
     * Builds and returns a patterns.builder.Car instance.
     *
     * @return The constructed patterns.builder.Car.
     */
    fun build() = Car(name, maxSpeed)
}

/**
 * DSL function for creating a patterns.builder.CarShowroom using a builder.
 *
 * @param block The DSL block for specifying the patterns.builder.CarShowroom properties.
 * @return The constructed patterns.builder.CarShowroom.
 */
fun carShowroom(block: CarShowroomBuilder.() -> Unit) = CarShowroomBuilder().apply(block).build()

/**
 * Main function demonstrating the usage of the patterns.builder.carShowroom DSL.
 */
fun main() {
    val carShowroom = carShowroom {
        cars {
            car {
                name = "Tesla"
                maxSpeed = 260
            }
            car {
                name = "Audi"
                maxSpeed = 300
            }
            car {
                name = "BMW"
                maxSpeed = 280
            }
        }
    }
    println(carShowroom.cars.joinToString(" | "))
}
