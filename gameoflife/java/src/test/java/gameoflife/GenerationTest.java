package gameoflife;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class GenerationTest {

    @Test
    void blinker() {

        // ___
        // ###
        // ___

        Set<Cell> cells = new HashSet<>();
        cells.add(new Cell(1, 2));
        cells.add(new Cell(2, 2));
        cells.add(new Cell(3, 2));

        Generation sut = new Generation(cells);
        Generation nextGeneration = sut.next();

        // _#_
        // _#_
        // _#_

        //J-
        assertAll(
                () -> assertTrue(nextGeneration.cells().contains(new Cell(2, 1))),
                () -> assertTrue(nextGeneration.cells().contains(new Cell(2, 2))),
                () -> assertTrue(nextGeneration.cells().contains(new Cell(2, 3))),
                () -> assertTrue(nextGeneration.cells().size() == 3)
        );
        //J+

        assertEquals(cells, nextGeneration.next().cells());
    }


    @Test
    void beacon() {

        // ##__
        // #___
        // ___#
        // __##

        Set<Cell> cells = new HashSet<>();
        cells.add(new Cell(1, 1));
        cells.add(new Cell(2, 1));
        cells.add(new Cell(1, 2));
        cells.add(new Cell(4, 3));
        cells.add(new Cell(3, 4));
        cells.add(new Cell(4, 4));

        Generation sut = new Generation(cells);
        Generation nextGeneration = sut.next();

        // ##__
        // ##__
        // __##
        // __##

        //J-
        assertAll(
                () -> assertTrue(nextGeneration.cells().contains(new Cell(1, 1))),
                () -> assertTrue(nextGeneration.cells().contains(new Cell(2, 1))),
                () -> assertTrue(nextGeneration.cells().contains(new Cell(1, 2))),
                () -> assertTrue(nextGeneration.cells().contains(new Cell(2, 2))),
                () -> assertTrue(nextGeneration.cells().contains(new Cell(3, 3))),
                () -> assertTrue(nextGeneration.cells().contains(new Cell(4, 3))),
                () -> assertTrue(nextGeneration.cells().contains(new Cell(3, 4))),
                () -> assertTrue(nextGeneration.cells().contains(new Cell(4, 4))),
                () -> assertTrue(nextGeneration.cells().size() == 8)
        );
        //J+

        assertEquals(cells, nextGeneration.next().cells());
    }
}
