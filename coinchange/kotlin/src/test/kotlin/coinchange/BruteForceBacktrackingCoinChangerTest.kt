package coinchange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BruteForceBacktrackingCoinChangerTest {

    @Test
    fun singleCoinChange() {
        val sut = BruteForceBacktrackingCoinChanger(setOf(1, 5, 10, 25, 100))

        assertEquals(listOf(1), sut.change(1))
        assertEquals(listOf(25), sut.change(25))
    }

    @Test
    fun multipleCoinChange() {
        val sut = BruteForceBacktrackingCoinChanger(setOf(1, 5, 10, 25, 100))

        assertEquals(listOf(5, 10), sut.change(15))
        assertEquals(listOf(1, 1, 1, 5), sut.change(8))
        assertEquals(listOf(1, 1, 1, 10, 10), sut.change(23))
    }

    @Test
    fun exoticCurrencyChange() {
        val sut = BruteForceBacktrackingCoinChanger(setOf(1, 4, 6))

        assertEquals(listOf(4, 4), sut.change(8))
        assertEquals(listOf(1, 6, 6), sut.change(13))
    }
}