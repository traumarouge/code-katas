package armstrong

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ArmstrongTest {

    @Test
    fun isArmstrongNumber() {
        assertTrue(isArmstrongNumber(5))
        assertTrue(isArmstrongNumber(153))
        assertTrue(isArmstrongNumber(9474))
        assertTrue(isArmstrongNumber(9926315))
    }

    @Test
    fun isNotArmstrongNumber() {
        assertFalse(isArmstrongNumber(10))
        assertFalse(isArmstrongNumber(100))
        assertFalse(isArmstrongNumber(9475))
        assertFalse(isArmstrongNumber(9926314))
    }
}