package binary

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class BinaryTest {

    @ParameterizedTest
    @CsvSource(
            "0,0", "1,1", "2,10", "3,11", "12,1100", "15,1111", "16,10000",
            "127,1111111", "128,10000000", "255,11111111", "256,100000000")
    fun toBinary(number: Long, expected: String) {
        assertEquals(expected, toBinary(number))
    }


    @Test
    fun toBinaryArgumentMustBePositiveNumber() {
        assertThrows<IllegalArgumentException> { toBinary(-1) }
    }


    @ParameterizedTest
    @CsvSource(
            "0,00000000", "1,00000001", "10,00000010", "11,00000011", "1100,00001100",
            "1111,00001111", "10000,00010000", "1111111,01111111", "10000000,10000000",
            "11111111,11111111", "100000000,0000000100000000")
    fun expandToBytes(binary: String, expected: String) {
        assertEquals(expected, expandToBytes(binary))
    }


    @ParameterizedTest
    @ValueSource(strings = ["", " ", "x", "2", "0000 11"])
    fun expandToBytesArgumentMustBeBinary(binary: String) {
        assertThrows<IllegalArgumentException> { expandToBytes(binary) }
    }


    @ParameterizedTest
    @CsvSource(
            "00000000,11111111", "00000001,11111110", "00000010,11111101", "00000011,11111100",
            "00001100,11110011", "00001111,11110000", "00010000,11101111", "01111111,10000000",
            "10000000,01111111", "11111111,00000000", "0000000100000000,1111111011111111")
    fun onesComplement(binary: String, expected: String) {
        assertEquals(expected, onesComplement(binary))
    }


    @ParameterizedTest
    @ValueSource(strings = ["", " ", "x", "2", "0000 11", "00001112", "0000111", "000011110"])
    fun onesComplementArgumentMustBeByte(binary: String) {
        assertThrows<IllegalArgumentException> { onesComplement(binary) }
    }


    @ParameterizedTest
    @CsvSource(
            "00000000,00000000", "00000001,11111111", "00000010,11111110", "00000011,11111101",
            "00001100,11110100", "00001111,11110001", "00010000,11110000", "01111111,10000001",
            "10000000,10000000", "11111111,00000001", "0000000100000000,1111111100000000")
    fun twosComplement(binary: String, expected: String) {
        assertEquals(expected, twosComplement(binary))
    }


    @ParameterizedTest
    @ValueSource(strings = ["", " ", "x", "2", "0000 11", "00001112", "0000111", "000011110"])
    fun twosComplementArgumentMustBeByte(binary: String) {
        assertThrows<IllegalArgumentException> { twosComplement(binary) }
    }
}