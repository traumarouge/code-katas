package berlinclock

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TickerTest {

    @Test
    fun nextRegisterIncrementedAfter60Ticks() {
        var incrementCounter = 0

        val sut = Ticker(object : Register {
            override fun increment() {
                incrementCounter++
            }
        })

        // tick 59 times
        repeat(59) { sut.tick() }
        assertEquals(0, incrementCounter)

        // 60th tick
        sut.tick()
        assertEquals(1, incrementCounter)

        // tick another 60 times
        repeat(60) { sut.tick() }
        assertEquals(2, incrementCounter)
    }
}