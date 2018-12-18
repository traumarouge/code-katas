package sudokusolver

fun main(args: Array<String>) {
    val hints = arrayOf(
            Hint(Cell(0, 0), 2), Hint(Cell(0, 6), 8), Hint(Cell(1, 1), 4),
            Hint(Cell(1, 4), 8), Hint(Cell(1, 8), 9), Hint(Cell(2, 1), 9),
            Hint(Cell(2, 6), 4), Hint(Cell(2, 7), 3), Hint(Cell(3, 3), 3),
            Hint(Cell(3, 8), 1), Hint(Cell(4, 2), 3), Hint(Cell(4, 5), 2),
            Hint(Cell(4, 7), 5), Hint(Cell(5, 2), 7), Hint(Cell(5, 7), 2),
            Hint(Cell(6, 0), 6), Hint(Cell(6, 4), 2), Hint(Cell(6, 6), 5),
            Hint(Cell(7, 3), 8), Hint(Cell(7, 5), 4), Hint(Cell(8, 0), 4),
            Hint(Cell(8, 1), 7), Hint(Cell(8, 3), 6), Hint(Cell(8, 4), 1))

    val solver = SudokuSolver()
    solver.placeHints(* hints)

    solver.solve()
    solver.display()
}
