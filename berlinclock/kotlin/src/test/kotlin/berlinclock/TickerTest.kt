package berlinclock

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TickerTest {

    @Test
    fun intervalListenerNotifiedAfter60Ticks() {
        var notifications = 0
        val sut = Ticker { notifications++ }

        // tick 59 times
        repeat(59) { sut.tick() }
        assertEquals(59, sut.count)
        assertEquals(0, notifications)

        // 60th tick
        sut.tick()
        assertEquals(0, sut.count)
        assertEquals(1, notifications)

        // tick another 60 times
        repeat(60) { sut.tick() }
        assertEquals(0, sut.count)
        assertEquals(2, notifications)
    }
}