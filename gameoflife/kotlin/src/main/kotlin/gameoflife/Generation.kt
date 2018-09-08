package gameoflife

class Generation(val population: Population) {

    fun next(): Generation {
        val cells = mutableSetOf<Cell>()

        cells.addAll(population.survivorCells())
        cells.addAll(population.revitalizedCells())

        return Generation(Population(cells))
    }
}