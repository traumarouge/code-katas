package spaceage

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SpaceAgeTest {

    @Test
    fun ageOnEarth() {
        assertEquals(31.69, spaceAge(1000000000))
    }


    @Test
    fun ageOnMars() {
        assertEquals(39.25, spaceAge(2329871239, Planet.MARS))
    }


    @Test
    fun ageOnVenus() {
        assertEquals(9.78, spaceAge(189839836, Planet.VENUS))
    }


    @Test
    fun ageOnJupiter() {
        assertEquals(2.41, spaceAge(901876382, Planet.JUPITER))
    }
}