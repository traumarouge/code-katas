package gameoflife;

import java.util.HashSet;
import java.util.Set;

import static gameoflife.Rule.CONWAY_REVITALIZATION_RULE;
import static gameoflife.Rule.CONWAY_SURVIVAL_RULE;


final class Generation {

    private final Population population;

    Generation(Set<Cell> cells) {

        this.population = new Population(cells);
    }


    private Generation(Population population) {

        this.population = population;
    }

    Generation next() {

        Set<Cell> cells = new HashSet<>();

        cells.addAll(population.survivors(CONWAY_SURVIVAL_RULE));
        cells.addAll(population.revitalized(CONWAY_REVITALIZATION_RULE));

        return new Generation(new Population(cells));
    }


    Set<Cell> cells() {

        return population.cells();
    }
}
