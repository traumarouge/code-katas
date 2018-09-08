package gameoflife

data class Cell(val x: Int, val y: Int) {

    val neighbors
        get() = setOf(
                copy(x = x - 1, y = y - 1),
                copy(y = y - 1),
                copy(x = x + 1, y = y - 1),
                copy(x = x - 1),
                copy(x = x + 1),
                copy(x = x - 1, y = y + 1),
                copy(y = y + 1),
                copy(x = x + 1, y = y + 1))
}
