package fizzbuzz

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("FizzBuzz")
class FizzBuzzTest {

    @DisplayName("numbers from 1 up to 10")
    @ParameterizedTest(name = "{0} should be \"{1}\"")
    @CsvSource(
            "1, 1", "2, 2", "3, fizz",
            "4, 4", "5, buzz", "6, fizz",
            "7, 7", "8, 8", "9, fizz",
            "10, buzz")
    fun sayNumbers(number: Int, expected: String) {
        assertEquals(expected, fizzBuzz(number))
    }


    @DisplayName("fizz numbers from 1 up to 30")
    @ParameterizedTest(name = "{0} should be \"fizz\"")
    @ValueSource(ints = [3, 6, 9, 12, 18, 21, 24, 27])
    fun fizzNumbers(number: Int) {
        assertEquals("fizz", fizzBuzz(number))
    }


    @DisplayName("buzz numbers from 1 up to 50")
    @ParameterizedTest(name = "{0} should be \"buzz\"")
    @ValueSource(ints = [5, 10, 20, 25, 35, 40, 50])
    fun buzzNumbers(number: Int) {
        assertEquals("buzz", fizzBuzz(number))
    }


    @DisplayName("fizz-buzz numbers from 1 up to 90")
    @ParameterizedTest(name = "{0} should be \"fizz-buzz\"")
    @ValueSource(ints = [15, 30, 45, 60, 75, 90])
    fun fizzBuzzNumbers(number: Int) {
        assertEquals("fizz-buzz", fizzBuzz(number))
    }


    @DisplayName("given number must not be less than one")
    @Test
    fun assertNumberInRange() {
        assertThrows<IllegalArgumentException> {
            fizzBuzz(0)
        }
    }
}
