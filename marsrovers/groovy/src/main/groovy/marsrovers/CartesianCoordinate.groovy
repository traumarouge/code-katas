package marsrovers

import groovy.transform.Immutable


@Immutable
class CartesianCoordinate {

    int x
    int y


    @Override
    String toString() { "$x $y" }
}