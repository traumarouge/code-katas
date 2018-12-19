package berlinclock

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BerlinClockTest {

    @Test
    fun triggerTicksOnDefaultInitializedBerlinClock() {
        val sut = BerlinClock()
        assertEquals("-----------------------", sut.toString())

        sut.triggerTicks(50000)
        assertEquals("HH--hhh-MMMMMMMMMM-mmm-", sut.toString())
    }


    @Test
    fun initializedWithHoursAndMinutes() {
        val sut = BerlinClock(hours = 13, minutes = 53)
        assertEquals("HH--hhh-MMMMMMMMMM-mmm-", sut.toString())
    }

    @Test
    fun resetHoursOneMinuteAfterMidnight() {
        val sut = BerlinClock(hours = 23, minutes = 59)
        assertEquals("HHHHhhh-MMMMMMMMMMMmmmm", sut.toString())

        sut.triggerTicks(60)
        assertEquals("HHHHhhhh---------------", sut.toString())

        sut.triggerTicks(60)
        assertEquals("-------------------m---", sut.toString())
    }
}