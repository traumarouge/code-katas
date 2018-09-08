package gameoflife

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CellTest {

    @Test
    fun neighbors() {
        val sut = Cell(2, 3)

        val expected = setOf(
                Cell(1, 2), Cell(2, 2), Cell(3, 2),
                Cell(1, 3), Cell(3, 3),
                Cell(1, 4), Cell(2, 4), Cell(3, 4))

        assertEquals(expected, sut.neighbors)
    }
}