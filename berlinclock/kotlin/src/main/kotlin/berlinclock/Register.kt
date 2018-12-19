package berlinclock

interface Register {

    fun reset()

    fun increment()

    fun isFull(): Boolean
}