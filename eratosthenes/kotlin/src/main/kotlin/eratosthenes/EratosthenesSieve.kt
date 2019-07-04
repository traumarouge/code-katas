package eratosthenes

fun findPrimes(limit: Int): List<Int> {
    val masks = BooleanArray(limit + 1)

    for (n in 2..limit) {
        val nSqr = n * n
        if (nSqr >= limit) break

        for (x in nSqr..limit step n) {
            masks[x] = true
        }
    }

    return masks.asSequence()
            .mapIndexed { index, _ -> index }
            .filter { it >= 2 && !masks[it] }
            .toList()
}