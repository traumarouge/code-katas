package berlinclock

import spock.lang.Specification


class TickerSpec extends Specification {


    def "ticker increments light bar after 60 ticks"() {

        setup:
        def lightBar = Mock(LightBar)
        def sut = new Ticker()
        sut >> lightBar

        when:
        59.times { sut.tick() }

        then:
        0 * lightBar.increment()

        when:
        sut.tick()

        then:
        1 * lightBar.increment()
    }
}
