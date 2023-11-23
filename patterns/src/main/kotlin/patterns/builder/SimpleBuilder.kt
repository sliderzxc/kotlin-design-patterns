package patterns.builder

/**
 * Represents a simple data structure, constructed using the Builder design pattern.
 *
 * @property title The title of the structure.
 * @property description The description of the structure.
 * @property count The count associated with the structure.
 */
class SimpleBuilder private constructor(
    val title: String,
    val description: String,
    val count: Int
) {

    /**
     * Builder class for constructing instances of [SimpleBuilder].
     */
    class Builder {
        private var title: String = "DefaultTitle"
        private var description: String = "DefaultDescription"
        private var count: Int = -9999

        /**
         * Sets the title for the structure being built.
         *
         * @param title The title to be set.
         * @return The builder instance for method chaining.
         */
        fun setTitle(title: String): Builder {
            this.title = title
            return this
        }

        /**
         * Sets the description for the structure being built.
         *
         * @param description The description to be set.
         * @return The builder instance for method chaining.
         */
        fun setDescription(description: String): Builder {
            this.description = description
            return this
        }

        /**
         * Sets the count for the structure being built.
         *
         * @param count The count to be set.
         * @return The builder instance for method chaining.
         */
        fun setCount(count: Int): Builder {
            this.count = count
            return this
        }

        /**
         * Builds and returns an instance of [SimpleBuilder] with the specified properties.
         *
         * @return The constructed [SimpleBuilder] instance.
         */
        fun build(): SimpleBuilder {
            return SimpleBuilder(title, description, count)
        }
    }
}

/**
 * Main function demonstrating the usage of the patterns.builder.SimpleBuilder and its Builder class.
 */
fun main() {
    // Example 1: Creating a patterns.builder.SimpleBuilder instance with specified title and description.
    val simpleBuilder1 = SimpleBuilder.Builder()
        .setTitle("Main Title 1")
        .setDescription("Some Description 1")
        .build()

    println("Title 1: ${simpleBuilder1.title}")
    println("Description 1: ${simpleBuilder1.description}")
    println("Count 1: ${simpleBuilder1.count}")

    println("-----------------------------------------------------")

    // Example 2: Creating a patterns.builder.SimpleBuilder instance with specified title and count.
    val simpleBuilder2 = SimpleBuilder.Builder()
        .setTitle("Main Title 2")
        .setCount(127)
        .build()

    println("Title 2: ${simpleBuilder2.title}")
    println("Description 2: ${simpleBuilder2.description}")
    println("Count 2: ${simpleBuilder2.count}")
}