package berlinclock

class Ticker(private val next: Register? = null) {

    private var count = 0

    fun tick() {
        count++

        if (count == 60) {
            count = 0
            next?.increment()
        }
    }
}