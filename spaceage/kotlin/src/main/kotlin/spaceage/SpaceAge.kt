package spaceage

import spaceage.Planet.*
import kotlin.math.round

const val EARTH_YEAR_SECONDS: Double = 60 * 60 * 24 * 365.25

enum class Planet {
    EARTH, MARS, VENUS, JUPITER
}


fun spaceAge(seconds: Long, planet: Planet = EARTH): Double {
    val earthYears = seconds / EARTH_YEAR_SECONDS

    return round(when (planet) {
        EARTH -> earthYears
        MARS -> earthYears / 1.8808158
        VENUS -> earthYears / 0.61519726
        JUPITER -> earthYears / 11.862615
    } * 100) / 100
}