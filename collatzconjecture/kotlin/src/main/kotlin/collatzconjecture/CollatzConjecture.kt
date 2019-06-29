package collatzconjecture

import java.lang.IllegalArgumentException

fun calculateSteps(number: Int): Int {

    if (number <= 0) throw IllegalArgumentException()

    var n = number
    var steps = 0

    while (n != 1) {
        n = if (n.rem(2) == 0) n / 2 else n * 3 + 1
        steps++
    }

    return steps
}