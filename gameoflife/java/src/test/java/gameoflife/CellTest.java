package gameoflife;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;


class CellTest {

    @Test
    void neighbors() {

        Cell sut = new Cell(2, 3);
        Set<Cell> neighbors = sut.neighbors();

        //J-
        assertAll(
                () -> assertTrue(neighbors.contains(new Cell(1, 2))),
                () -> assertTrue(neighbors.contains(new Cell(2, 2))),
                () -> assertTrue(neighbors.contains(new Cell(3, 2))),
                () -> assertTrue(neighbors.contains(new Cell(1, 3))),
                () -> assertTrue(neighbors.contains(new Cell(3, 3))),
                () -> assertTrue(neighbors.contains(new Cell(1, 4))),
                () -> assertTrue(neighbors.contains(new Cell(2, 4))),
                () -> assertTrue(neighbors.contains(new Cell(3, 4))),
                () -> assertTrue(neighbors.size() == 8));
        //J+
    }
}
