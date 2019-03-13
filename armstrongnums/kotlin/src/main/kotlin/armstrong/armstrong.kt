package armstrong

import kotlin.math.pow


infix fun Int.pow(exponent: Int) = toDouble().pow(exponent).toInt()

fun isArmstrongNumber(number: Int): Boolean {
    val digits = number.toString().toList()

    return number == digits
            .map { it.toString().toInt() }
            .map { it pow digits.size }
            .sum()
}