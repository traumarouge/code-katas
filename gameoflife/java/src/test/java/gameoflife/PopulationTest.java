package gameoflife;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static gameoflife.Rule.CONWAY_REVITALIZATION_RULE;
import static gameoflife.Rule.CONWAY_SURVIVAL_RULE;

import static org.junit.jupiter.api.Assertions.assertTrue;


class PopulationTest {

    @Test
    void cellHaving2NeighborsShouldSurvive() {

        // ___#
        // ###_
        // ____

        Set<Cell> cells = new HashSet<>();
        cells.add(new Cell(4, 1));
        cells.add(new Cell(1, 2));
        cells.add(new Cell(2, 2));
        cells.add(new Cell(3, 2));

        Population sut = new Population(cells);
        Set<Cell> survivors = sut.survivors(CONWAY_SURVIVAL_RULE);

        assertTrue(survivors.contains(new Cell(2, 2)));
        assertTrue(survivors.contains(new Cell(3, 2)));
        assertTrue(survivors.size() == 2);
    }


    @Test
    void cellHaving3NeighborsShouldSurvive() {

        // #_#_
        // _#__
        // #___

        Set<Cell> cells = new HashSet<>();
        cells.add(new Cell(1, 1));
        cells.add(new Cell(3, 1));
        cells.add(new Cell(2, 2));
        cells.add(new Cell(2, 3));

        Population sut = new Population(cells);
        Set<Cell> survivors = sut.survivors(CONWAY_SURVIVAL_RULE);

        assertTrue(survivors.contains(new Cell(2, 2)));
        assertTrue(survivors.size() == 1);
    }


    @Test
    void cellHavingLessThan2NeighborsShouldDie() {

        // #___
        // _#__
        // ___#

        Set<Cell> cells = new HashSet<>();
        cells.add(new Cell(1, 1));
        cells.add(new Cell(2, 2));
        cells.add(new Cell(4, 3));

        Population sut = new Population(cells);
        Set<Cell> survivors = sut.survivors(CONWAY_SURVIVAL_RULE);

        assertTrue(survivors.isEmpty());
    }


    @Test
    void cellHavingMoreThan3NeighborsShouldDie() {

        // #_#_
        // _#__
        // #_#_

        Set<Cell> cells = new HashSet<>();
        cells.add(new Cell(1, 1));
        cells.add(new Cell(3, 1));
        cells.add(new Cell(2, 2));
        cells.add(new Cell(1, 3));
        cells.add(new Cell(3, 3));

        Population sut = new Population(cells);
        Set<Cell> survivors = sut.survivors(CONWAY_SURVIVAL_RULE);

        assertTrue(survivors.isEmpty());
    }


    @Test
    void deadCellHaving3NeighborsShouldBeBorn() {

        // #_#_
        // _**#
        // __#_

        Set<Cell> cells = new HashSet<>();
        cells.add(new Cell(1, 1));
        cells.add(new Cell(3, 1));
        cells.add(new Cell(4, 2));
        cells.add(new Cell(3, 3));

        Population sut = new Population(cells);
        Set<Cell> revitalized = sut.revitalized(CONWAY_REVITALIZATION_RULE);

        assertTrue(revitalized.contains(new Cell(2, 2)));
        assertTrue(revitalized.contains(new Cell(3, 2)));
        assertTrue(revitalized.size() == 2);
    }
}
