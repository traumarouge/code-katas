package sudokusolver

data class Cell(val row: Int, val column: Int) {

    fun next() = when {
        column == 8 && row == 8 -> null
        column == 8 -> Cell(row + 1, 0)
        else -> Cell(row, column + 1)
    }
}
