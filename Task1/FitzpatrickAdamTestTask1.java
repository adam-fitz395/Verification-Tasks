package cm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.NullString;

import static org.junit.jupiter.api.Assertions.*;

public class FitzpatrickAdamTestTask1 {
    // Period(int start, int end) Tests
    @Test
    void startLessThanZero() {
        int start = -1;
        int end = 14;
        new cm.Period(start, end);
    }

    @Test
    void endGreaterThanTwentyFour() {
        int start = 15;
        int end = 25;
        new cm.Period(start, end);
    }

    @Test
    void startNullEndNull() {
        int start = Integer.parseInt(null);
        int end = Integer.parseInt(null);
        new cm.Period(start, end);
    }

    @Test
    void startNull() {
        int start = Integer.parseInt(null);
        int end = 12;
        new cm.Period(start, end);
    }

    @Test
    void endNull () {
        int start = 14;
        int end = Integer.parseInt(null);
        new cm.Period(start,end);
    }

    @Test
    void startEqualsEnd () {
        int start = 13;
        int end = 13;
        new cm.Period(start, end);
    }

    @Test
    void startGreaterThanEqualZero () {
        int start = 8;
        int end = 12;
        var period = new cm.Period(start,end);
        System.out.print(period);
    }

    @Test
    void startLessThanTwentyFour() {
        int start = 14;
        int end = 16;
        var period = new cm.Period(start,end);
        System.out.print(period);
    }

    @Test
    void endGreaterThanZero() {
        int start = 17;
        int end = 24;
        var period = new cm.Period(start,end);
        System.out.print(period);
    }

    @Test
    void endLessThanEqualToTwentyFour() {
        int start = 15;
        int end = 24;
        var period = new cm.Period(start,end);
        System.out.print(period);
    }

    @Test
    void startGreaterThanZeroEndLessThanEqualToTwentyFour() {
        int start = 17;
        int end = 21;
        var period = new cm.Period(start,end);
        System.out.print(period);
    }

    // duration() Tests
    @Test
    void maximumPeriod() {
        cm.Period period = new cm.Period(0, 24);
        assertEquals(24, period.duration());
        System.out.print(period.duration());
    }

    @Test
    void minimumPeriod() {
        cm.Period period = new cm.Period(1, 2);
        assertEquals(1, period.duration());
        System.out.print(period.duration());
    }

    // overlaps (Period period) Tests

    @Test
    void periodOverlaps() {
        cm.Period passedPeriod = new cm.Period(7, 10);
        cm.Period currentPeriod = new cm.Period(9, 11);
        assertTrue(passedPeriod.overlaps(currentPeriod));
    }

    @Test
    void noOverlap() {
        cm.Period passedPeriod = new cm.Period(2, 6);
        cm.Period currentPeriod = new cm.Period(8, 14);
        assertFalse(passedPeriod.overlaps(currentPeriod));
    }

}
