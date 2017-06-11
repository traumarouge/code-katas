package fizzbuzz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayName("FizzBuzz")
class FizzBuzzTest {

    @DisplayName("say numbers 1 up to 10")
    @ParameterizedTest(name = "{0} should be \"{1}\"")
    @CsvSource({ "1, 1", "2, 2", "3, fizz", "4, 4", "5, buzz", "6, fizz", "7, 7", "8, 8", "9, fizz", "10, buzz" })
    void sayNumbers(int number, String expected) {

        assertEquals(expected, FizzBuzz.say(number));
    }


    @DisplayName("fizz numbers from 1 up to 30")
    @ParameterizedTest(name = "{0} is \"fizz\"")
    @ValueSource(ints = { 3, 6, 9, 12, 18, 21, 24, 27 })
    void fizzNumbers(int number) {

        assertEquals("fizz", FizzBuzz.say(number));
    }


    @DisplayName("buzz numbers from 1 up to 50")
    @ParameterizedTest(name = "{0} is \"buzz\"")
    @ValueSource(ints = { 5, 10, 20, 25, 35, 40, 50 })
    void buzzNumbers(int number) {

        assertEquals("buzz", FizzBuzz.say(number));
    }


    @DisplayName("fizzbuzz numbers from 1 up to 90")
    @ParameterizedTest(name = "{0} is \"fizzbuzz\"")
    @ValueSource(ints = { 15, 30, 45, 60, 75, 90 })
    void fizzbuzzNumbers(int number) {

        assertEquals("fizzbuzz", FizzBuzz.say(number));
    }


    @DisplayName("given number must not be less than 1")
    @Test
    void assertNumberInRange() {

        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.say(0));
    }
}
