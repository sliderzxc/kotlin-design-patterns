package patterns.strategy

/**
 * Strategy pattern example in Kotlin.
 *
 * The strategy pattern defines a family of algorithms, encapsulates each algorithm, and makes them interchangeable.
 * In this example, different database implementations (patterns.strategy.MySqlDatabase, patterns.strategy.PostgresqlDatabase, patterns.strategy.MongoDatabase)
 * represent the interchangeable strategies, and the patterns.strategy.DatabaseRepository class acts as the context that uses these strategies.
 */

/**
 * Interface representing a common database strategy.
 */
interface Database {
    /**
     * Inserts data into the database.
     *
     * @param data The data to be inserted.
     */
    fun insertData(data: String)
}

/**
 * Concrete database strategy representing MySQL database.
 */
class MySqlDatabase : Database {
    override fun insertData(data: String) {
        println("patterns.strategy.MySqlDatabase | add $data")
    }
}

/**
 * Concrete database strategy representing PostgreSQL database.
 */
class PostgresqlDatabase : Database {
    override fun insertData(data: String) {
        println("patterns.strategy.PostgresqlDatabase | add $data")
    }
}

/**
 * Concrete database strategy representing MongoDB.
 */
class MongoDatabase : Database {
    override fun insertData(data: String) {
        println("patterns.strategy.MongoDatabase | add $data")
    }
}

/**
 * Context class that uses a database strategy to add data to the database.
 */
class DatabaseRepository {
    /**
     * Adds data to the database using the specified database strategy.
     *
     * @param data The data to be added to the database.
     * @param database The database strategy to be used.
     */
    fun addDataToDatabase(data: String, database: Database) {
        database.insertData(data)
    }
}

/**
 * Main function demonstrating the usage of the Strategy pattern with database strategies.
 */
fun main() {
    // Create instances of different database strategies
    val mySqlDatabase = MySqlDatabase()
    val postgresqlDatabase = PostgresqlDatabase()
    val mongoDatabase = MongoDatabase()

    // Create an instance of the patterns.strategy.DatabaseRepository (context)
    val databaseRepository = DatabaseRepository()

    // Use the patterns.strategy.DatabaseRepository to add data to different databases using different strategies
    databaseRepository.addDataToDatabase("Hello patterns.strategy.MySqlDatabase", mySqlDatabase)
    databaseRepository.addDataToDatabase("Hello patterns.strategy.PostgresqlDatabase", postgresqlDatabase)
    databaseRepository.addDataToDatabase("Hello patterns.strategy.MongoDatabase", mongoDatabase)
}
