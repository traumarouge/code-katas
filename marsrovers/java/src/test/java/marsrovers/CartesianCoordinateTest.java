package marsrovers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class CartesianCoordinateTest {

    @Test
    void createInstance() {

        CartesianCoordinate sut = new CartesianCoordinate(2, 3);

        assertEquals("2 3", sut.toString());
        assertEquals(2, sut.x);
        assertEquals(3, sut.y);
    }


    @Test
    void equalsContract() {

        CartesianCoordinate sut = new CartesianCoordinate(2, 3);

        assertTrue(sut.equals(sut));
        assertTrue(sut.equals(new CartesianCoordinate(2, 3)));
        assertFalse(sut.equals(new CartesianCoordinate(2, 2)));
        assertFalse(sut.equals(new CartesianCoordinate(3, 3)));
        assertFalse(sut.equals(null));
    }


    @Test
    void hashCodeContract() {

        CartesianCoordinate sut = new CartesianCoordinate(2, 3);

        assertEquals(23350, sut.hashCode());
        assertEquals(new CartesianCoordinate(2, 3).hashCode(), sut.hashCode());
        assertNotEquals(new CartesianCoordinate(0, 0).hashCode(), sut.hashCode());
    }
}
