package matchingbraces

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

import java.util.stream.Stream

class BracesMatcherTest {

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    fun matches(input: String, expectedResult: Boolean) {
        val sut = BracesMatcher()

        assertEquals(expectedResult, sut.matches(input))
    }

    companion object {

        @JvmStatic
        fun argumentsProvider(): Stream<Arguments> = Stream.of(
                arguments("", true),
                arguments("{", false),
                arguments("}", false),
                arguments("{}", true),
                arguments("}{", false),
                arguments("{{", false),
                arguments("{}{}", true),
                arguments("{{}}", true),
                arguments("{}[]", true),
                arguments("{[]}()", true),
                arguments("([]{})", true),
                arguments("([]{)}", false),
                arguments("[([]{})]()", true),
                arguments("[([]{)}]()", false),
                arguments("([{}({}[])])", true),
                arguments("([{}({}[])})", false))
    }
}