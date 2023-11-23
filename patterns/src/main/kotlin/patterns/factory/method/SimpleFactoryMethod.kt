package patterns.factory.method

/**
 * Factory Method pattern example in Kotlin.
 *
 * The Factory Method pattern defines an interface for creating an object but leaves the choice of its type to the subclasses,
 * creating the object in a method with a common interface.
 * In this example, the patterns.factory.method.FoodFactory object acts as a factory that determines the patterns.factory.method.FoodType based on the provided patterns.factory.method.Food object.
 */

/**
 * Enumeration representing the types of food.
 */
enum class FoodType {
    FRUIT,
    VEGETABLE,
    MEAT,
}

/**
 * Sealed class representing different types of food.
 */
sealed class Food

/**
 * Object representing a patterns.factory.method.Tomato, a subtype of patterns.factory.method.Food.
 */
data object Tomato : Food()

/**
 * Object representing patterns.factory.method.Chicken, a subtype of patterns.factory.method.Food.
 */
data object Chicken : Food()

/**
 * Object representing patterns.factory.method.Apple, a subtype of patterns.factory.method.Food.
 */
data object Apple : Food()

/**
 * Object representing patterns.factory.method.Cucumber, a subtype of patterns.factory.method.Food.
 */
data object Cucumber : Food()

/**
 * Object acting as a factory for determining the patterns.factory.method.FoodType based on the provided patterns.factory.method.Food object.
 */
object FoodFactory {
    /**
     * Determines the patterns.factory.method.FoodType based on the provided patterns.factory.method.Food object.
     *
     * @param food The patterns.factory.method.Food object for which the patterns.factory.method.FoodType is to be determined.
     * @return The patterns.factory.method.FoodType corresponding to the provided patterns.factory.method.Food.
     */
    fun foodTypeByFood(food: Food): FoodType {
        return when(food) {
            Tomato -> FoodType.VEGETABLE
            Chicken -> FoodType.MEAT
            Apple -> FoodType.FRUIT
            Cucumber -> FoodType.VEGETABLE
        }
    }
}

/**
 * Main function demonstrating the usage of the Factory Method pattern with the patterns.factory.method.FoodFactory.
 */
fun main() {
    // Using the patterns.factory.method.FoodFactory to determine the patterns.factory.method.FoodType for different patterns.factory.method.Food objects
    val firstType = FoodFactory.foodTypeByFood(Tomato)
    val secondType = FoodFactory.foodTypeByFood(Apple)

    // Printing the determined FoodTypes
    println(firstType)
    println(secondType)
}
