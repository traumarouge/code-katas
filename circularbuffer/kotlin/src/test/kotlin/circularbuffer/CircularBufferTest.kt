package circularbuffer

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CircularBufferTest {

    @Test
    fun readingFromEmptyBufferThrowsException() {

        val sut = CircularBuffer<Int>(3)

        assertThrows<EmptyBufferReadException> { sut.read() }
    }

    @Test
    fun singleElementWrittenToBufferCanBeRead() {

        val sut = CircularBuffer<Int>(3)
        sut.write(23)

        assertEquals(23, sut.read())
    }

    @Test
    fun elementsWrittenToBufferCanBeReadOnlyOnce() {
        val sut = CircularBuffer<Int>(3)
        sut.write(23)

        assertEquals(23, sut.read())
        assertThrows<EmptyBufferReadException> { sut.read() }
    }

    @Test
    fun readingFromBufferRemovesOldestElement() {
        val sut = CircularBuffer<Int>(3)
        sut.write(23)
        sut.write(42)

        assertEquals(23, sut.read())
        assertEquals(42, sut.read())
    }

    @Test
    fun writingToFullBufferOverwritesOldestElement() {
        val sut = CircularBuffer<Int>(3)
        for (i in 1..3) sut.write(i)
        sut.write(4) // writing to full buffer

        for (i in 1..3) assertNotEquals(1, sut.read())
    }

    @Test
    fun overwritingElementMakesNextElementOldest() {
        val sut = CircularBuffer<Int>(3)
        for (i in 1..3 + 1) sut.write(i)

        assertEquals(2, sut.read())
        assertEquals(3, sut.read())
        assertEquals(4, sut.read())
    }
}