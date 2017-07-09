package marsrovers

import spock.lang.*


class MarsRoverSpec extends Specification {

    def sut = new MarsRover(new CartesianCoordinate(2, 3))


    def "rover turns left when processing command 'L'"() {

        when:
        sut.process('L')

        then:
        sut.status() == '2 3 W'

        when:
        sut.process('L')

        then:
        sut.status() == '2 3 S'

        when:
        sut.process('L')

        then:
        sut.status() == '2 3 E'

        when:
        sut.process('L')

        then:
        sut.status() == '2 3 N'
    }


    def "rover turns right when processing command 'R'"() {

        when:
        sut.process('R')

        then:
        sut.status() == '2 3 E'

        when:
        sut.process('R')

        then:
        sut.status() == '2 3 S'

        when:
        sut.process('R')

        then:
        sut.status() == '2 3 W'

        when:
        sut.process('R')

        then:
        sut.status() == '2 3 N'
    }


    def "rover moves forward when processing command 'F'"() {

        when:
        sut.process('F')

        then:
        sut.status() == '2 4 N'

        when:
        sut.process('R')
        sut.process('F')

        then:
        sut.status() == '3 4 E'

        when:
        sut.process('R')
        sut.process('F')

        then:
        sut.status() == '3 3 S'

        when:
        sut.process('R')
        sut.process('F')

        then:
        sut.status() == '2 3 W'
    }


    def "rover processes a chain of commands"() {

        when:
        sut.process('FRFRFRF')

        then:
        sut.status() == '2 3 W'

        when:
        sut.process('FLFLFLF')

        then:
        sut.status() == '2 3 N'
    }
}
