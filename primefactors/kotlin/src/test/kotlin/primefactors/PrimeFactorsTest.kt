package primefactors

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrimeFactorsTest {

    @Test
    fun primeFactors() {
        assertEquals(emptyList<Int>(), primeFactors(1))
        assertEquals(listOf(2), primeFactors(2))
        assertEquals(listOf(3, 3), primeFactors(9))
        assertEquals(listOf(2, 2, 3), primeFactors(12))
        assertEquals(listOf(5, 17, 23, 461), primeFactors(901255))
    }
}