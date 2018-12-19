package berlinclock

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LightBarTest {

    @Test
    fun incrementRegister() {
        val sut = LightBar(2)
        assertEquals("--", sut.toString())

        sut.increment()
        assertEquals("*-", sut.toString())

        sut.increment()
        assertEquals("**", sut.toString())

        // third increment causes overflow
        sut.increment()
        assertEquals("--", sut.toString())
    }


    @Test
    fun nextRegisterIncrementedOnRegisterOverflow() {
        var incrementCounter = 0

        val sut = LightBar(2, object : Register {
            override fun reset() = throw UnsupportedOperationException()

            override fun increment() {
                incrementCounter++
            }

            override fun isFull() = throw UnsupportedOperationException()
        })

        // increment 2 times
        repeat(2) { sut.increment() }
        assertEquals(0, incrementCounter)

        // 3rd increment
        sut.increment()
        assertEquals(1, incrementCounter)

        // increment another 3 times
        repeat(3) { sut.increment() }
        assertEquals(2, incrementCounter)
    }
}