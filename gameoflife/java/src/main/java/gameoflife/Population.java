package gameoflife;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;


final class Population {

    private final Set<Cell> cells;

    Population(Set<Cell> cells) {

        this.cells = new HashSet<>(cells);
    }

    Set<Cell> survivors(Rule rule) {

        return cells.stream().filter(cell -> rule.test(neighborsInPopulation(cell))).collect(toSet());
    }


    Set<Cell> revitalized(Rule rule) {

        return cells.stream()
            .flatMap(cell -> cell.neighbors().stream().filter(neighbor -> !cells.contains(neighbor)))
            .filter(deadNeighbor -> rule.test(neighborsInPopulation(deadNeighbor)))
            .collect(toSet());
    }


    private int neighborsInPopulation(Cell cell) {

        return (int) cell.neighbors().stream().filter(cells::contains).count();
    }


    Set<Cell> cells() {

        return Collections.unmodifiableSet(cells);
    }
}
