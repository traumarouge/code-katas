package sudokusolver

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SudokuSolverTest {

    @Test
    fun initialize() {
        val sut = SudokuSolver()

        val allZero = sut.sudoku.all { r -> r.all { c -> c == 0 } }

        assertTrue(allZero)
    }

    @Test
    fun placeHints() {
        val hints = arrayOf(
                Hint(Cell(0, 0), 2),
                Hint(Cell(2, 3), 5),
                Hint(Cell(8, 8), 7))

        val sut = SudokuSolver()
        sut.placeHints(*hints)

        assertEquals(2, sut.sudoku[0][0])
        assertEquals(5, sut.sudoku[2][3])
        assertEquals(7, sut.sudoku[8][8])
    }

    @Test
    fun solve() {
        val hints = arrayOf(
                Hint(Cell(0, 0), 2), Hint(Cell(0, 6), 8), Hint(Cell(1, 1), 4),
                Hint(Cell(1, 4), 8), Hint(Cell(1, 8), 9), Hint(Cell(2, 1), 9),
                Hint(Cell(2, 6), 4), Hint(Cell(2, 7), 3), Hint(Cell(3, 3), 3),
                Hint(Cell(3, 8), 1), Hint(Cell(4, 2), 3), Hint(Cell(4, 5), 2),
                Hint(Cell(4, 7), 5), Hint(Cell(5, 2), 7), Hint(Cell(5, 7), 2),
                Hint(Cell(6, 0), 6), Hint(Cell(6, 4), 2), Hint(Cell(6, 6), 5),
                Hint(Cell(7, 3), 8), Hint(Cell(7, 5), 4), Hint(Cell(8, 0), 4),
                Hint(Cell(8, 1), 7), Hint(Cell(8, 3), 6), Hint(Cell(8, 4), 1))

        val sut = SudokuSolver()
        sut.placeHints(*hints)

        assertTrue(sut.solve())
        assertEquals(listOf(2, 1, 6, 4, 3, 9, 8, 7, 5), sut.sudoku[0].toList())
        assertEquals(listOf(3, 4, 5, 2, 8, 7, 6, 1, 9), sut.sudoku[1].toList())
        assertEquals(listOf(7, 9, 8, 5, 6, 1, 4, 3, 2), sut.sudoku[2].toList())
        assertEquals(listOf(9, 2, 4, 3, 5, 8, 7, 6, 1), sut.sudoku[3].toList())
        assertEquals(listOf(1, 6, 3, 7, 4, 2, 9, 5, 8), sut.sudoku[4].toList())
        assertEquals(listOf(8, 5, 7, 1, 9, 6, 3, 2, 4), sut.sudoku[5].toList())
        assertEquals(listOf(6, 8, 1, 9, 2, 3, 5, 4, 7), sut.sudoku[6].toList())
        assertEquals(listOf(5, 3, 2, 8, 7, 4, 1, 9, 6), sut.sudoku[7].toList())
        assertEquals(listOf(4, 7, 9, 6, 1, 5, 2, 8, 3), sut.sudoku[8].toList())
    }
}