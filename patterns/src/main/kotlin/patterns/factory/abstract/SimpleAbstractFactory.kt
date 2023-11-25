package patterns.factory.abstract

/**
 * Abstract Factory pattern example in Kotlin.
 *
 * The Abstract Factory pattern provides an interface for creating families of related or dependent objects
 * without specifying their concrete classes. In this example, the `patterns.factory.abstract.TreeFactory` is an abstract factory that
 * defines the creation of different types of trees. Subclasses of `patterns.factory.abstract.TreeFactory` (e.g., `patterns.factory.abstract.AcaciaFactory`, `patterns.factory.abstract.BirchFactory`)
 * provide concrete implementations for creating specific types of trees (e.g., `patterns.factory.abstract.Acacia`, `patterns.factory.abstract.Birch`).
 */

/**
 * Interface representing a generic tree.
 */
interface Tree

/**
 * Concrete implementation of the patterns.factory.abstract.Tree interface representing an patterns.factory.abstract.Acacia tree.
 */
class Acacia : Tree

/**
 * Concrete implementation of the patterns.factory.abstract.Tree interface representing a patterns.factory.abstract.Birch tree.
 */
class Birch : Tree

/**
 * Concrete implementation of the patterns.factory.abstract.Tree interface representing an patterns.factory.abstract.AppleTree.
 */
class AppleTree : Tree

/**
 * Abstract class representing a generic tree factory.
 */
abstract class TreeFactory {
    /**
     * Abstract method for creating a specific type of tree.
     *
     * @return The created tree.
     */
    abstract fun makeTree(): Tree

    companion object {
        /**
         * Factory method for creating instances of concrete patterns.factory.abstract.TreeFactory subclasses based on the specified type.
         *
         * @param T The type of tree for which the factory is created.
         * @return An instance of the corresponding concrete patterns.factory.abstract.TreeFactory subclass.
         * @throws IllegalArgumentException if the specified type is undefined.
         */
        inline fun <reified T : Tree> createFactory(): TreeFactory {
            return when (T::class) {
                Acacia::class -> AcaciaFactory()
                Birch::class -> BirchFactory()
                AppleTree::class -> AppleTreeFactory()
                else -> throw IllegalArgumentException("Undefined tree type")
            }
        }
    }
}

/**
 * Concrete implementation of the patterns.factory.abstract.TreeFactory creating patterns.factory.abstract.Acacia trees.
 */
class AcaciaFactory : TreeFactory() {
    override fun makeTree(): Tree {
        println("Created patterns.factory.abstract.Acacia")
        return Acacia()
    }
}

/**
 * Concrete implementation of the patterns.factory.abstract.TreeFactory creating patterns.factory.abstract.Birch trees.
 */
class BirchFactory : TreeFactory() {
    override fun makeTree(): Tree {
        println("Created patterns.factory.abstract.Birch")
        return Birch()
    }
}

/**
 * Concrete implementation of the patterns.factory.abstract.TreeFactory creating patterns.factory.abstract.AppleTree.
 */
class AppleTreeFactory : TreeFactory() {
    override fun makeTree(): Tree {
        println("Created patterns.factory.abstract.AppleTree")
        return AppleTree()
    }
}

/**
 * Main function demonstrating the usage of the Abstract Factory pattern with different tree types.
 */
fun main() {
    // Create instances of tree factories for different tree types
    val birchFactory = TreeFactory.createFactory<Birch>()
    val appleTreeFactory = TreeFactory.createFactory<AppleTree>()
    val acaciaFactory = TreeFactory.createFactory<Birch>()

    // Use the tree factories to create specific types of trees
    val birch = birchFactory.makeTree()
    val appleTree = appleTreeFactory.makeTree()
    val acacia = acaciaFactory.makeTree()

    // Check if the created trees are of the correct types
    println("Is right birch: ${birch is Birch}")
    println("Is right appleTree: ${appleTree is AppleTree}")
    println("Is right acacia: ${acacia is Acacia}")
}
