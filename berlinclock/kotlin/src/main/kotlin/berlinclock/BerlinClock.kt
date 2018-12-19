package berlinclock

class BerlinClock(val hours: Int = 0, val minutes: Int = 0) {

    private val largeHours = LightBar(4)
    private val smallHours = LightBar(4, largeHours)
    private val largeMinutes = LightBar(11, smallHours)
    private val smallMinutes = LightBar(4, largeMinutes)

    private val ticker = Ticker {
        if (smallHours.isFull() && largeHours.isFull()) {
            smallHours.reset()
            largeHours.reset()
        }

        smallMinutes.increment()
    }

    init {
        val seconds = 3600 * hours + 60 * minutes
        triggerTicks(seconds)
    }

    fun triggerTicks(ticks: Int) {
        repeat(ticks) { ticker.tick() }
    }

    override fun toString() = StringBuilder().apply {
        append(largeHours.toString().replace('*', 'H'))
        append(smallHours.toString().replace('*', 'h'))
        append(largeMinutes.toString().replace('*', 'M'))
        append(smallMinutes.toString().replace('*', 'm'))
    }.toString()
}