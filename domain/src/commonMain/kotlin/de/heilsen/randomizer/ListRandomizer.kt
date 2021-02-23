package de.heilsen.randomizer

object ListRandomizer {
    fun List<String>.takeRandom(number: Int, sorted: Boolean = false): List<String> {
        return shuffled()
            .take(number)
            .run {
                when {
                    sorted -> sorted()
                    else -> this
                }
            }
    }

    fun List<String>.concatRandom(number: Int, sorted: Boolean = false, separator: String = "\n"): String {
        return takeRandom(number, sorted)
            .joinToString(separator)
    }
}
