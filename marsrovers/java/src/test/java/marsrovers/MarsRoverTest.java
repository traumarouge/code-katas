package marsrovers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MarsRoverTest {

    @Test
    void processCommandL() {

        CartesianCoordinate coordinate = new CartesianCoordinate(2, 3);
        MarsRover sut = new MarsRover(coordinate);
        assertEquals("2 3 N", sut.status());

        sut.process("L");
        assertEquals("2 3 W", sut.status());

        sut.process("L");
        assertEquals("2 3 S", sut.status());

        sut.process("L");
        assertEquals("2 3 E", sut.status());

        sut.process("L");
        assertEquals("2 3 N", sut.status());
    }


    @Test
    void processCommandR() {

        CartesianCoordinate coordinate = new CartesianCoordinate(2, 3);
        MarsRover sut = new MarsRover(coordinate);
        assertEquals("2 3 N", sut.status());

        sut.process("R");
        assertEquals("2 3 E", sut.status());

        sut.process("R");
        assertEquals("2 3 S", sut.status());

        sut.process("R");
        assertEquals("2 3 W", sut.status());

        sut.process("R");
        assertEquals("2 3 N", sut.status());
    }


    @Test
    void processCommandF() {

        CartesianCoordinate coordinate = new CartesianCoordinate(2, 3);
        MarsRover sut = new MarsRover(coordinate);
        assertEquals("2 3 N", sut.status());

        sut.process("F");
        assertEquals("2 4 N", sut.status());

        sut.process("R");
        sut.process("F");
        assertEquals("3 4 E", sut.status());

        sut.process("R");
        sut.process("F");
        assertEquals("3 3 S", sut.status());

        sut.process("R");
        sut.process("F");
        assertEquals("2 3 W", sut.status());
    }


    @Test
    void processCommands() {

        CartesianCoordinate coordinate = new CartesianCoordinate(2, 3);
        MarsRover sut = new MarsRover(coordinate);
        assertEquals("2 3 N", sut.status());

        sut.process("FRFRFRF");
        assertEquals("2 3 W", sut.status());
    }
}
