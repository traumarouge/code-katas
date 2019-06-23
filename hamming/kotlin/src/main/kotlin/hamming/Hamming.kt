package hamming

import java.lang.IllegalArgumentException

fun hammingDistance(a: String, b: String): Int {

    if (a.length != b.length)
        throw IllegalArgumentException("Arguments must have same length")

    var distance = 0

    for ((i, c) in a.withIndex()) {
        if (c != b[i]) distance++
    }

    return distance
}