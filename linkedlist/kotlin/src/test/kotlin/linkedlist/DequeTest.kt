package linkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

import java.lang.IllegalStateException

class DequeTest {

    @Test
    fun shiftEmptyDeque() {
        val sut = Deque<Int>()

        assertThrows<IllegalStateException> { sut.shift() }
    }

    @Test
    fun popEmptyDeque() {
        val sut = Deque<Int>()

        assertThrows<IllegalStateException> { sut.pop() }
    }

    @Test
    fun pushThenPop() {
        val sut = Deque<Int>()

        sut.push(10)
        sut.push(20)

        assertEquals(20, sut.pop())
        assertEquals(10, sut.pop())
    }

    @Test
    fun pushThenShift() {
        val sut = Deque<Int>()

        sut.push(10)
        sut.push(20)

        assertEquals(10, sut.shift())
        assertEquals(20, sut.shift())
    }

    @Test
    fun unShiftThenShift() {
        val sut = Deque<Int>()

        sut.unShift(10)
        sut.unShift(20)

        assertEquals(20, sut.shift())
        assertEquals(10, sut.shift())
    }

    @Test
    fun unShiftThenPop() {
        val sut = Deque<Int>()

        sut.unShift(10)
        sut.unShift(20)

        assertEquals(10, sut.pop())
        assertEquals(20, sut.pop())
    }

    @Test
    fun example() {
        val sut = Deque<Int>()

        sut.push(10)
        sut.push(20)

        assertEquals(20, sut.pop())

        sut.push(30)

        assertEquals(10, sut.shift())

        sut.unShift(40)
        sut.push(50)

        assertEquals(40, sut.shift())
        assertEquals(50, sut.pop())
        assertEquals(30, sut.shift())
    }
}