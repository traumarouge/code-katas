package leapyear

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LeapYearTest {

    @Test
    fun isLeap() {

        // divisible by 400
        assertTrue(isLeap(1600))
        assertTrue(isLeap(2000))

        // divisible by 100 but not by 400
        assertFalse(isLeap(1900))
        assertFalse(isLeap(1800))

        // divisible by 4
        assertTrue(isLeap(2012))
        assertTrue(isLeap(2016))

        // not divisible by 4
        assertFalse(isLeap(2014))
        assertFalse(isLeap(2015))
    }
}