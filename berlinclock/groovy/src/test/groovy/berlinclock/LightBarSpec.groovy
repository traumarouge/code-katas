package berlinclock

import spock.lang.*


class LightBarSpec extends Specification {


    def "incrementing light bar changes its lights"() {

        setup:
        def sut = new LightBar(2)

        expect:
        sut.lights() == [false, false]

        when:
        sut.increment()

        then:
        sut.lights() == [true, false]

        when:
        sut.increment()

        then:
        sut.lights() == [true, true]

        when:
        sut.increment()

        then:
        sut.lights() == [false, false]
    }


    def "light bar overflow increments next light bar"() {

        setup:
        def sut = new LightBar(4)
        def next = Mock(LightBar)
        sut >> next

        when:
        4.times { sut.increment() }

        then:
        0 * next.increment()

        when:
        sut.increment()

        then:
        1 * next.increment()
    }
}
