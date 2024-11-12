package cm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FitzpatrickAdamPeriodTests {

    // cm.cm.Period(int start, int end) Tests
    @Test
    void startLessThanZero() {
        int start = -1;
        int end = 14;
        assertThrows(IllegalArgumentException.class, () -> new cm.Period(start, end),
                "Expected IllegalArgumentException for start < 0");
    }

    @Test
    void endLessThanZero() {
        int start = 5;
        int end = -1;
        assertThrows(IllegalArgumentException.class, () -> new cm.Period(start, end),
                "End should be less than 0");
    }

    @Test
    void endGreaterThanTwentyFour() {
        int start = 15;
        int end = 25;
        assertThrows(IllegalArgumentException.class, () -> new cm.Period(start, end),
                "Expected IllegalArgumentException for end > 24");
    }

    @Test
    void startGreaterThan24() {
        int start = 25;
        int end = 12;
        assertThrows(IllegalArgumentException.class, () -> new cm.Period(start, end),
                "Expected IllegalArgumentException for end > 24");

    }

    @Test
    void startEqualsEnd() {
        int start = 13;
        int end = 13;
        assertThrows(IllegalArgumentException.class, () -> new cm.Period(start, end),
                "Expected IllegalArgumentException for start == end");
    }

    // Valid cases
    @Test
    void validPeriod() {
        int start = 8;
        int end = 12;
        Period period = new Period(start, end);
        assertInstanceOf(cm.Period.class, period);
        assertNotNull(period, "Expected valid period creation for start=8, end=12");
    }

    // duration() Tests
    @Test
    void maximumPeriod() {
        cm.Period period = new cm.Period(0, 24);
        assertEquals(24, period.duration(), "Expected duration of 24 for period (0, 24)");
    }

    @Test
    void minimumPeriod() {
        cm.Period period = new cm.Period(1, 2);
        assertEquals(1, period.duration(), "Expected duration of 1 for period (1, 2)");
    }

    // overlaps (cm.Period period) Tests
    @Test
    void periodOverlaps() {
        cm.Period passedPeriod = new cm.Period(7, 10);
        cm.Period currentPeriod = new cm.Period(9, 11);
        assertTrue(passedPeriod.overlaps(currentPeriod), "Expected overlap between periods (7, 10) and (9, 11)");
    }

    @Test
    void noOverlap() {
        cm.Period passedPeriod = new cm.Period(2, 6);
        cm.Period currentPeriod = new cm.Period(8, 14);
        assertFalse(passedPeriod.overlaps(currentPeriod), "Expected no overlap between periods (2, 6) and (8, 14)");
    }
}
