package primefactors

fun primeFactors(number: Int): List<Int> {
    val factors = mutableListOf<Int>()
    var n = number

    for (d in 2..number) {
        while (n.rem(d) == 0) {
            factors.add(d).also { n /= d }
        }

        if (n == 1) return factors
    }

    return emptyList()
}