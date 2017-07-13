package leapyear;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class LeapYearTest {

    @Test
    void isLeap() {

        // divisible by 400
        assertTrue(LeapYear.isLeap(1600));
        assertTrue(LeapYear.isLeap(2000));

        // divisible by 100 but not by 400
        assertFalse(LeapYear.isLeap(1900));
        assertFalse(LeapYear.isLeap(1800));

        // divisible by 4
        assertTrue(LeapYear.isLeap(2012));
        assertTrue(LeapYear.isLeap(2016));

        // not divisible by 4
        assertFalse(LeapYear.isLeap(2014));
        assertFalse(LeapYear.isLeap(2015));
    }
}
