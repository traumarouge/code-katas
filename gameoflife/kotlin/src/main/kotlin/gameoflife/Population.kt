package gameoflife

class Population(cells: Set<Cell>) {

    companion object {
        val CONWAY_SURVIVAL_RULE = { n: Int -> n in 2..3 }
        val CONWAY_REVITALIZATION_RULE = { n: Int -> n == 3 }
    }

    val cells = cells.toSet()


    fun survivorCells() = cells.filter { CONWAY_SURVIVAL_RULE(neighborsInPopulation(it)) }.toSet()


    fun revitalizedCells() = cells
            .flatMap { cellInPopulation -> cellInPopulation.neighbors.filter { it !in cells } }
            .filter { deadNeighbor -> CONWAY_REVITALIZATION_RULE(neighborsInPopulation(deadNeighbor)) }
            .toSet()


    private fun neighborsInPopulation(cell: Cell) = cell.neighbors.filter { it in cells }.count()
}