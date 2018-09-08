package gameoflife

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PopulationTest {

    @Test
    fun cellHaving2NeighborsShouldSurvive() {
        val cells = setOf(Cell(4, 1), Cell(1, 2), Cell(2, 2), Cell(3, 2))
        val sut = Population(cells)

        // ___#
        // ###_
        // ____

        val expected = setOf(Cell(2, 2), Cell(3, 2))
        assertEquals(expected, sut.survivorCells())
    }


    @Test
    fun cellHaving3NeighborsShouldSurvive() {
        val cells = setOf(Cell(1, 1), Cell(3, 1), Cell(2, 2), Cell(1, 3))
        val sut = Population(cells)

        // #_#_
        // _#__
        // #___

        val expected = setOf(Cell(2, 2))
        assertEquals(expected, sut.survivorCells())
    }


    @Test
    fun cellHavingLessThan2NeighborsShouldDie() {
        val cells = setOf(Cell(1, 1), Cell(2, 2), Cell(4, 3))
        val sut = Population(cells)

        // #___
        // _#__
        // ___#

        val expected = emptySet<Cell>()
        assertEquals(expected, sut.survivorCells())
    }


    @Test
    fun cellHavingMoreThan3NeighborsShouldDie() {
        val cells = setOf(Cell(1, 1), Cell(3, 1), Cell(2, 2), Cell(1, 3), Cell(3, 3))
        val sut = Population(cells)

        // #_#_
        // _#__
        // #_#_

        val expected = emptySet<Cell>()
        assertEquals(expected, sut.survivorCells())
    }


    @Test
    fun deadCellHaving3NeighborsShouldBeBorn() {
        val cells = setOf(Cell(1, 1), Cell(3, 1), Cell(4, 2), Cell(3, 3))
        val sut = Population(cells)

        // #_#_
        // _**#
        // __#_

        val expected = setOf(Cell(2, 2), Cell(3, 2))
        assertEquals(expected, sut.revitalizedCells())
    }
}