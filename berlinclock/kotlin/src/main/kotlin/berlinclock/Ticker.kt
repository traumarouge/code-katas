package berlinclock

class Ticker(private val intervalListener: () -> Unit) {

    var count = 0
        private set

    fun tick() {
        count++

        if (count == 60) {
            count = 0
            intervalListener.invoke()
        }
    }
}