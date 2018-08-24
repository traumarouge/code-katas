package fizzbuzz

fun fizzBuzz(number: Int): String = when {
    number < 1 -> throw IllegalArgumentException()
    number % 15 == 0 -> "fizz-buzz"
    number % 3 == 0 -> "fizz"
    number % 5 == 0 -> "buzz"
    else -> "$number"
}
