package marsrovers;

public final class CartesianCoordinate {

    public final int x;
    public final int y;

    public CartesianCoordinate(int x, int y) {

        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof CartesianCoordinate)) {
            return false;
        }

        CartesianCoordinate other = (CartesianCoordinate) o;

        return x == other.x && y == other.y;
    }


    @Override
    public int hashCode() {

        int result = 17;
        result = 37 * result + x;
        result = 37 * result + y;

        return result;
    }


    @Override
    public String toString() {

        return "" + x + " " + y;
    }
}
