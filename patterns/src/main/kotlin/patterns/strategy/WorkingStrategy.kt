package patterns.strategy

/**
 * Strategy pattern example in Kotlin.
 *
 * The Strategy pattern defines a family of algorithms, encapsulates each algorithm, and makes them interchangeable.
 * In this example, different work tasks (patterns.strategy.Homework, patterns.strategy.CleanUp, patterns.strategy.Cook) represent the interchangeable strategies,
 * and the patterns.strategy.WorkingRepository class acts as the context that uses these strategies.
 */

/**
 * Interface representing the common behavior for different work tasks.
 */
interface Work {
    /**
     * Performs the specific work task.
     */
    fun doWork()
}

/**
 * Concrete implementation of the patterns.strategy.Work interface representing the patterns.strategy.Homework task.
 */
class Homework : Work {
    override fun doWork() {
        println("patterns.strategy.Homework")
    }
}

/**
 * Concrete implementation of the patterns.strategy.Work interface representing the patterns.strategy.CleanUp task.
 */
class CleanUp : Work {
    override fun doWork() {
        println("patterns.strategy.CleanUp")
    }
}

/**
 * Concrete implementation of the patterns.strategy.Work interface representing the patterns.strategy.Cook task.
 */
class Cook : Work {
    override fun doWork() {
        println("patterns.strategy.Cook")
    }
}

/**
 * Context class that uses the specified work strategy to perform tasks.
 */
class WorkingRepository {
    /**
     * Performs the specified work task using the provided patterns.strategy.Work strategy.
     *
     * @param work The patterns.strategy.Work strategy representing the specific task to be performed.
     */
    fun doWork(work: Work) {
        work.doWork()
    }
}

/**
 * Main function demonstrating the usage of the Strategy pattern with different work tasks.
 */
fun main() {
    // Create instances of different work tasks
    val cleanUp = CleanUp()
    val cook = Cook()
    val homework = Homework()

    // Create an instance of the patterns.strategy.WorkingRepository (context)
    val workingRepository = WorkingRepository()

    // Use the patterns.strategy.WorkingRepository to perform different work tasks using different strategies
    workingRepository.doWork(cleanUp)
    workingRepository.doWork(cook)
    workingRepository.doWork(homework)
}
