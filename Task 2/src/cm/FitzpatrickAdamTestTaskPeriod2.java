package cm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FitzpatrickAdamTestTaskPeriod2 {

    // cm.Period(int start, int end) Tests
    @Test
    void startLessThanZero() {
        int start = -1;
        int end = 14;
        assertThrows(IllegalArgumentException.class, () -> new cm.Period(start, end),
                "start should be less than 0");
    }

    @Test
    void endLessThanZero() {
        int start = 5;
        int end = -1;
        assertThrows(IllegalArgumentException.class, () -> new cm.Period(start, end),
                "end should be less than 0");
    }

    @Test
    void endGreaterThanTwentyFour() {
        int start = 15;
        int end = 25;
        assertThrows(IllegalArgumentException.class, () -> new cm.Period(start, end),
                "end should be greater than 24");
    }

    @Test
    void startGreaterThanTwentyFour() {
        int start = 25;
        int end = 12;
        assertThrows(IllegalArgumentException.class, () -> new cm.Period(start, end),
                "start should be greater than 24");

    }

    @Test
    void startEqualsEnd() {
        int start = 13;
        int end = 13;
        assertThrows(IllegalArgumentException.class, () -> new cm.Period(start, end),
                "start should be equal to end");
    }

    @Test
    void startAndEndInvalid() {
        int start = 26;
        int end = 27;
        assertThrows(IllegalArgumentException.class, () -> new cm.Period(start, end),
                "start and end should be invalid");
    }

    @Test
    void validPeriod() {
        int start = 8;
        int end = 12;
        Period period = new Period(start, end);
        assertNotNull(period, "Period should not be null");
    }

    // duration() Tests
    @Test
    void maximumPeriod() {
        cm.Period period = new cm.Period(0, 24);
        assertEquals(24, period.duration(), "duration should be equal to 24");
    }

    @Test
    void minimumPeriod() {
        cm.Period period = new cm.Period(1, 2);
        assertEquals(1, period.duration(), "duration should be equal to 1");
    }

    // overlaps (cm.Period period) Tests
    @Test
    void periodOverlaps() {
        cm.Period passedPeriod = new cm.Period(7, 10);
        cm.Period currentPeriod = new cm.Period(9, 11);
        assertTrue(passedPeriod.overlaps(currentPeriod), "expected overlap between periods");
    }

    @Test
    void noOverlap() {
        cm.Period passedPeriod = new cm.Period(2, 6);
        cm.Period currentPeriod = new cm.Period(8, 14);
        assertFalse(passedPeriod.overlaps(currentPeriod), "expected no overlap between periods");
    }
}
