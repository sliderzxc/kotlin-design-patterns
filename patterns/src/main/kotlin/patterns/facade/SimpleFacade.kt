package patterns.facade

/**
 * Facade pattern example in Kotlin.
 *
 * The Facade pattern provides a unified interface to a set of interfaces in a subsystem. It defines a higher-level
 * interface that makes the subsystem easier to use. In this example, the `patterns.facade.FoodOrderFacade` acts as a simplified
 * interface to the more complex subsystems (`patterns.facade.FoodOrderSystem` and `patterns.facade.BankSystem`) for ordering food products.
 */

/**
 * Enumeration representing the types of food products.
 */
enum class ProductType {
    Pizza,
    Spaghetti,
    Burger
}

/**
 * Sealed class representing different food products with their respective prices.
 */
sealed class Product(val price: Int) {
    data class Pizza(val size: String) : Product(350)
    data class Spaghetti(val sauceType: String) : Product(300)
    data class Burger(val cheeseType: String) : Product(280)
}

/**
 * Data class representing a check with the ordered product type and its price.
 */
data class Check(
    val product: ProductType,
    val price: Int
)

/**
 * Class simulating a bank system for handling monetary transactions.
 */
class BankSystem {
    private var availableMoney = 10000

    /**
     * Withdraws money from the bank system.
     *
     * @param money The amount of money to withdraw.
     * @return The withdrawn amount, or 0 if there are insufficient funds.
     */
    fun withdrawMoney(money: Int): Int {
        return if (availableMoney > money) money else 0
    }
}

/**
 * Class simulating a food order system for ordering food products.
 */
class FoodOrderSystem {

    /**
     * Orders a specific food product and handles monetary transactions using the bank system.
     *
     * @param productType The type of food product to order.
     * @param money The amount of money to pay for the ordered product.
     * @return A patterns.facade.Check object containing information about the ordered product and the payment.
     * @throws InsufficientFundsException if there are insufficient funds to complete the order.
     */
    fun orderProduct(productType: ProductType): Check {
        // Logic for ordering the product
        val productPrice = when (productType) {
            ProductType.Pizza -> Product.Pizza("").price
            ProductType.Spaghetti -> Product.Spaghetti("").price
            ProductType.Burger -> Product.Burger("").price
        }

        val bankSystem = BankSystem()
        val withdrawnMoney = bankSystem.withdrawMoney(productPrice)

        return if (withdrawnMoney > 0) {
            Check(productType, withdrawnMoney)
        } else {
            // Handling the situation when there are insufficient funds
            throw InsufficientFundsException("Not enough money to order $productType")
        }
    }
}

/**
 * Class acting as a facade to simplify the usage of the food order system and bank system.
 */
class FoodOrderFacade {
    private val foodOrderSystem = FoodOrderSystem()
    private val bankSystem = BankSystem()

    /**
     * Orders a specific food product using the facade. Handles monetary transactions internally.
     *
     * @param productType The type of food product to order.
     * @return A patterns.facade.Check object containing information about the ordered product and the payment.
     * @throws InsufficientFundsException if there are insufficient funds to complete the order.
     */
    fun orderProduct(productType: ProductType): Check {
        val productPrice = when (productType) {
            ProductType.Pizza -> Product.Pizza("").price
            ProductType.Spaghetti -> Product.Spaghetti("").price
            ProductType.Burger -> Product.Burger("").price
        }

        val withdrawnMoney = bankSystem.withdrawMoney(productPrice)

        return if (withdrawnMoney > 0) {
            foodOrderSystem.orderProduct(productType)
        } else {
            throw InsufficientFundsException("Not enough money to order $productType")
        }
    }
}

/**
 * Custom exception class for handling insufficient funds during a transaction.
 *
 * @param message A descriptive message indicating the cause of the exception.
 */
class InsufficientFundsException(message: String) : Exception(message)

/**
 * Main function demonstrating the usage of the Facade pattern with the `patterns.facade.FoodOrderFacade`.
 */
fun main() {
    val foodOrderFacade = FoodOrderFacade()

    try {
        val pizzaCheck = foodOrderFacade.orderProduct(ProductType.Pizza)
        println("Pizza ordered! Price: ${pizzaCheck.price}")
    } catch (e: InsufficientFundsException) {
        println("Error: ${e.message}")
    }

    try {
        val spaghettiCheck = foodOrderFacade.orderProduct(ProductType.Spaghetti)
        println("Spaghetti ordered! Price: ${spaghettiCheck.price}")
    } catch (e: InsufficientFundsException) {
        println("Error: ${e.message}")
    }

    try {
        val burgerCheck = foodOrderFacade.orderProduct(ProductType.Burger)
        println("Burger ordered! Price: ${burgerCheck.price}")
    } catch (e: InsufficientFundsException) {
        println("Error: ${e.message}")
    }
}
