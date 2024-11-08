package cm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FitzpatrickAdamPeriodTests {

    // cm.Period(int start, int end) Tests
    @Test
    void startLessThanZero() {
        int start = -1;
        int end = 14;
        assertThrows(IllegalArgumentException.class, () -> new cm.Period(start, end),
                "Expected IllegalArgumentException for start < 0");
    }

    @Test
    void endGreaterThanTwentyFour() {
        int start = 15;
        int end = 25;
        assertThrows(IllegalArgumentException.class, () -> new cm.Period(start, end),
                "Expected IllegalArgumentException for end > 24");
    }

    @Test
    void startNullEndNull() {
        Integer start = null;
        Integer end = null;
        assertThrows(IllegalArgumentException.class, () -> new cm.Period(start, end),
                "Expected IllegalArgumentException for start and end being null");
    }

    @Test
    void startNull() {
        Integer start = null;
        int end = 12;
        assertThrows(IllegalArgumentException.class, () -> new cm.Period(start, end),
                "Expected IllegalArgumentException for start being null");
    }

    @Test
    void endNull() {
        int start = 14;
        Integer end = null;
        assertThrows(IllegalArgumentException.class, () -> new cm.Period(start, end),
                "Expected IllegalArgumentException for end being null");
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
        cm.Period period = new cm.Period(start, end);
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

    // overlaps (Period period) Tests
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

    @Test
    void nullCurrentPeriod() {
        cm.Period passedPeriod = new cm.Period(14, 22);
        cm.Period currentPeriod = null;
        assertThrows(IllegalArgumentException.class, () -> passedPeriod.overlaps(currentPeriod),
                "Expected IllegalArgumentException for null current period in overlap check");
    }
}
