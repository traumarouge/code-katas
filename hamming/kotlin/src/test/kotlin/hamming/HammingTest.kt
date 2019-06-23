package hamming

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.*
import org.junit.jupiter.params.provider.MethodSource

import java.lang.IllegalArgumentException
import java.util.stream.Stream

class HammingTest {

    @Test
    fun invalidArguments() {
        assertThrows<IllegalArgumentException> { hammingDistance("A", "AA") }
        assertThrows<IllegalArgumentException> { hammingDistance("AA", "A") }
    }

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    fun hammingDistance(a: String, b: String, expectedDistance: Int) {
        assertEquals(expectedDistance, hammingDistance(a, b))
    }

    companion object {

        @JvmStatic
        fun argumentsProvider(): Stream<Arguments> = Stream.of(
                arguments("", "", 0),
                arguments("A", "A", 0),
                arguments("A", "G", 1),
                arguments("AT", "CT", 1),
                arguments("AG", "CT", 2),
                arguments("AAG", "AAA", 1),
                arguments("AAA", "AAG", 1),
                arguments("TAG", "GAT", 2),
                arguments("GGACG", "GGTCG", 1),
                arguments("GATAC", "GCATA", 4),
                arguments("GGACTGA", "GGACTGA", 0),
                arguments("ACCAGGG", "ACTATGG", 2),
                arguments("GGACGGATTCTGA", "AGGACGGATTCTT", 10)
        )
    }
}