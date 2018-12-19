package berlinclock

class LightBar(private val numberOfLights: Int,
               private val next: Register? = null) : Register {

    private var lightsOn = 0

    override fun reset() {
        lightsOn = 0
    }

    override fun increment() {
        if (lightsOn < numberOfLights) {
            lightsOn++
        } else {
            lightsOn = 0
            next?.increment()
        }
    }

    override fun isFull() = lightsOn == numberOfLights

    override fun toString() = StringBuilder().apply {
        append("*".repeat(lightsOn))
        append("-".repeat(numberOfLights - lightsOn))
    }.toString()
}