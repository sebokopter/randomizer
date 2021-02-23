import de.heilsen.randomizer.ListRandomizer.concatRandom
import platform.posix.exit

fun main() {
    val input = readLine() ?: return exit(-1)

    val output = input.lines()
        .concatRandom(
            number = 10,
            sorted = true
        )

    println(output)
}

