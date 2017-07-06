package marsrovers;

public class MarsRover {

    private enum Direction {

        NORTH("N") {

            @Override
            void forward(MarsRover rover) {

                rover.moveUp();
            }
        },
        EAST("E") {

            @Override
            void forward(MarsRover rover) {

                rover.moveRight();
            }
        },
        SOUTH("S") {

            @Override
            void forward(MarsRover rover) {

                rover.moveDown();
            }
        },
        WEST("W") {

            @Override
            void forward(MarsRover rover) {

                rover.moveLeft();
            }
        };

        private final String name;

        Direction(String name) {

            this.name = name;
        }

        void right(MarsRover rover) {

            rover.setDirection(values()[(ordinal() + 1) % values().length]);
        }


        void left(MarsRover rover) {

            rover.setDirection(values()[(ordinal() + values().length - 1) % values().length]);
        }


        abstract void forward(MarsRover rover);


        @Override
        public String toString() {

            return name;
        }
    }

    private CartesianCoordinate coordinate;
    private Direction direction;

    public MarsRover(CartesianCoordinate coordinate) {

        this.coordinate = coordinate;
        direction = Direction.NORTH;
    }

    public void process(String command) {

        command.chars().forEach(c -> {
            switch (c) {
                case 'L':
                    direction.left(this);
                    break;

                case 'R':
                    direction.right(this);
                    break;

                case 'F':
                    direction.forward(this);
                    break;
            }
        });
    }


    public String status() {

        return coordinate + " " + direction;
    }


    private void setDirection(Direction direction) {

        this.direction = direction;
    }


    private void moveUp() {

        coordinate = new CartesianCoordinate(coordinate.x, coordinate.y + 1);
    }


    private void moveDown() {

        coordinate = new CartesianCoordinate(coordinate.x, coordinate.y - 1);
    }


    private void moveRight() {

        coordinate = new CartesianCoordinate(coordinate.x + 1, coordinate.y);
    }


    private void moveLeft() {

        coordinate = new CartesianCoordinate(coordinate.x - 1, coordinate.y);
    }
}
