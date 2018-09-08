package gameoflife

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GenerationTest {

    @Test
    fun blinker() {
        val cells = setOf(Cell(1, 2), Cell(2, 2), Cell(3, 2))
        val sut = Generation(Population(cells))

        // ___
        // ###
        // ___

        val secondGeneration = sut.next()

        var expected = setOf(Cell(2, 1), Cell(2, 2), Cell(2, 3))
        assertEquals(expected, secondGeneration.population.cells)

        // _#_
        // _#_
        // _#_

        val thirdGeneration = secondGeneration.next()

        expected = cells
        assertEquals(expected, thirdGeneration.population.cells)
    }


    @Test
    fun beacon() {
        val cells = setOf(
                Cell(1, 1), Cell(2, 1), Cell(1, 2),
                Cell(4, 3), Cell(3, 4), Cell(4, 4))
        val sut = Generation(Population(cells))

        // ##__
        // #___
        // ___#
        // __##

        val secondGeneration = sut.next()

        var expected = setOf(
                Cell(1, 1), Cell(2, 1), Cell(1, 2), Cell(2, 2),
                Cell(3, 3), Cell(4, 3), Cell(3, 4), Cell(4, 4))
        assertEquals(expected, secondGeneration.population.cells)

        // ##__
        // ##__
        // __##
        // __##

        val thirdGeneration = secondGeneration.next()

        expected = cells
        assertEquals(expected, thirdGeneration.population.cells)
    }
}