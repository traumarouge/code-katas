package collatzconjecture

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows

import java.lang.IllegalArgumentException

class CollatzConjectureTest {

    @Test
    fun numberMustBePositive() {
        assertThrows<IllegalArgumentException> { calculateSteps(0) }
        assertThrows<IllegalArgumentException> { calculateSteps(-1) }
    }

    @ParameterizedTest
    @CsvSource("1,0", "2,1", "16,4", "12,9", "1000000,152")
    fun calculateSteps(number: Int, expectedSteps: Int) {
        assertEquals(expectedSteps, calculateSteps(number))
    }
}