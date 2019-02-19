package atbash

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class AtbashTest {

    @ParameterizedTest
    @MethodSource("encodeArgumentsProvider")
    fun encode(plainText: String, expectedCipherText: String) {
        assertEquals(expectedCipherText, encode(plainText))
    }

    @ParameterizedTest
    @MethodSource("decodeArgumentsProvider")
    fun decode(cipherText: String, expectedPlainText: String) {
        assertEquals(expectedPlainText, decode(cipherText))
    }

    companion object {

        @JvmStatic
        fun encodeArgumentsProvider() = Stream.of(
                arguments("yes", "bvh"),
                arguments("OMG", "lnt"),
                arguments("exercism", "vcvix rhn"),
                arguments("mindblowingly", "nrmwy oldrm tob"),
                arguments("Truth is fiction.", "gifgs rhurx grlm"),
                arguments("Testing123, testing123", "gvhgr mt123 gvhgr mt123"))

        @JvmStatic
        fun decodeArgumentsProvider() = Stream.of(
                arguments("bvh", "yes"),
                arguments("lnt", "omg"),
                arguments("vcvix rhn", "exercism"),
                arguments("nrmwy oldrm tob", "mindblowingly"),
                arguments("gifgs rhurx grlm", "truthisfiction"),
                arguments("gvhgr mt123 gvhgr mt123", "testing123testing123"))
    }
}