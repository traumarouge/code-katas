package marsrovers


class MarsRover {

    private enum Direction {

        NORTH(forward: { rover -> rover.moveUp() }),
        EAST(forward: { rover -> rover.moveRight() }),
        SOUTH(forward: { rover -> rover.moveDown() }),
        WEST(forward: { rover -> rover.moveLeft() })

        Closure forward


        void right(rover) { rover.direction = next() }


        void left(rover) { rover.direction = previous() }


        @Override
        String toString() { name()[0] }
    }


    private Direction direction
    private CartesianCoordinate coordinate


    MarsRover(CartesianCoordinate coordinate) {
        this.coordinate = coordinate
        direction = Direction.NORTH
    }


    void process(String command) {
        command.each {
            switch (it) {
                case 'L':
                    direction.left(this)
                    break
                case 'R':
                    direction.right(this)
                    break
                case 'F':
                    direction.forward(this)
                    break
            }
        }
    }


    String status() { "$coordinate $direction" }


    private void moveUp() {
        coordinate = new CartesianCoordinate(coordinate.x, coordinate.y + 1)
    }


    private void moveDown() {
        coordinate = new CartesianCoordinate(coordinate.x, coordinate.y - 1)
    }


    private void moveRight() {
        coordinate = new CartesianCoordinate(coordinate.x + 1, coordinate.y)
    }


    private void moveLeft() {
        coordinate = new CartesianCoordinate(coordinate.x - 1, coordinate.y)
    }
}