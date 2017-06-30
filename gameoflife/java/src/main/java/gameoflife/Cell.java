package gameoflife;

import java.util.HashSet;
import java.util.Set;


final class Cell {

    private final int x;
    private final int y;

    Cell(int x, int y) {

        this.x = x;
        this.y = y;
    }

    Set<Cell> neighbors() {

        Set<Cell> neighbors = new HashSet<>();
        neighbors.add(new Cell(x - 1, y - 1));
        neighbors.add(new Cell(x, y - 1));
        neighbors.add(new Cell(x + 1, y - 1));
        neighbors.add(new Cell(x - 1, y));
        neighbors.add(new Cell(x + 1, y));
        neighbors.add(new Cell(x - 1, y + 1));
        neighbors.add(new Cell(x, y + 1));
        neighbors.add(new Cell(x + 1, y + 1));

        return neighbors;
    }


    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof Cell)) {
            return false;
        }

        Cell cell = (Cell) o;

        return cell.x == x && cell.y == y;
    }


    @Override
    public int hashCode() {

        int result = 17;
        result = 37 * result + x;
        result = 37 * result + y;

        return result;
    }
}
