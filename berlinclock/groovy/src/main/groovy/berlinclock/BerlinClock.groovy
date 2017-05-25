package berlinclock


class BerlinClock {

    private final ticker
    private final bigHours
    private final smallHours
    private final bigMinutes
    private final smallMinutes


    BerlinClock() { this(0, 0) }


    BerlinClock(int hour, int minute) {
        ticker = new Ticker()
        bigHours = new LightBar(4)
        smallHours = new LightBar(4)
        bigMinutes = new LightBar(11)
        smallMinutes = new LightBar(4)

        ticker >> smallMinutes >> bigMinutes >> smallHours >> bigHours

        int seconds = 3600 * hour + 60 * minute
        triggerTicks(seconds)
    }


    void triggerTicks(int ticks) {
        ticks.times { ticker.tick() }
    }


    @Override
    String toString() {
        StringBuilder sb = new StringBuilder()

        bigHours.lights().each { sb << (it ? 'H' : '-') }
        smallHours.lights().each { sb << (it ? 'h' : '-') }
        bigMinutes.lights().each { sb << (it ? 'M' : '-') }
        smallMinutes.lights().each { sb << (it ? 'm' : '-') }

        sb
    }
}