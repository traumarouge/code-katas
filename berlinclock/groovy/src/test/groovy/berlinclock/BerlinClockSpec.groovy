package berlinclock

import spock.lang.Specification


class BerlinClockSpec extends Specification {


    def "lights shown before any ticks represent 00:00"() {

        def sut = new BerlinClock()

        expect:
        sut.toString() == '-----------------------'
    }


    def "lights shown after 50000 ticks represent 13:53"() {

        setup:
        def sut = new BerlinClock()
        sut.triggerTicks(50000)

        expect:
        sut.toString() == 'HH--hhh-MMMMMMMMMM-mmm-'
    }


    def "clock can be initialized using constructor args"() {

        setup:
        def sut = new BerlinClock(13, 53)

        expect:
        sut.toString() == 'HH--hhh-MMMMMMMMMM-mmm-'
    }
}
