package sudokusolver

class SudokuSolver {

    val sudoku = Array(9) { IntArray(9) }

    fun placeHints(vararg hints: Hint) {
        hints.forEach { hint -> with(hint) { sudoku[cell.row][cell.column] = number } }
    }

    fun display() {
        (0..8).forEach { row -> println(sudoku[row].joinToString(separator = " ")) }
    }

    fun solve() = solve(Cell(0, 0))

    private fun solve(cell: Cell?): Boolean {
        if (cell == null) return true

        if (sudoku[cell.row][cell.column] != 0) return solve(cell.next())

        for (n in 1..9) {
            if (!valid(n, cell)) continue

            sudoku[cell.row][cell.column] = n

            if (solve(cell.next())) return true
            else sudoku[cell.row][cell.column] = 0
        }

        return false
    }

    private fun valid(n: Int, cell: Cell) =
            rowValid(n, cell) && columnValid(n, cell) && boxValid(n, cell)

    private fun rowValid(n: Int, cell: Cell) = sudoku[cell.row].all { it != n }

    private fun columnValid(n: Int, cell: Cell) = sudoku.all { it[cell.column] != n }

    private fun boxValid(n: Int, cell: Cell): Boolean {
        val r = (cell.row / 3) * 3
        val c = (cell.column / 3) * 3

        for (i in 0..2) {
            for (j in 0..2) {
                if (sudoku[r + i][c + j] == n) return false
            }
        }

        return true
    }
}