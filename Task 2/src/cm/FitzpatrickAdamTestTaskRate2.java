package cm;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class FitzpatrickAdamTestTaskRate2 {
    @Test
    void validCarParkKind() {
        cm.CarParkKind kind = cm.CarParkKind.STAFF;

        // Creating valid reduced and normal periods
        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(12, 14));
        reducedPeriods.add(new cm.Period(18, 20));

        ArrayList<cm.Period> normalPeriods = new ArrayList<cm.Period>();
        normalPeriods.add(new cm.Period(8, 12));
        normalPeriods.add(new cm.Period(14, 18));

        // Initializing BigDecimal rates
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);

        // Creating a cm.CarParkKind.cm.Rate object
        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate, "CarParkKind should be valid");
    }

    @Test
    void validReducedPeriods() {
        cm.CarParkKind kind = cm.CarParkKind.STUDENT;

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(6, 10));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(10, 12));


        BigDecimal normalRate = new BigDecimal(7);
        BigDecimal reducedRate = new BigDecimal(3);


        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertNotNull(rate, "ReducedPeriods should be valid");
    }

    @Test
    void validNormalPeriods() {
        cm.CarParkKind kind = cm.CarParkKind.MANAGEMENT;


        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(9, 11));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(15, 17));


        BigDecimal normalRate = new BigDecimal(9);
        BigDecimal reducedRate = new BigDecimal(6);


        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertNotNull(rate, "NormalPeriods should be valid");
    }

    @Test
    void normalRateLessThanEqualTen() {
        cm.CarParkKind kind = cm.CarParkKind.VISITOR;


        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(1, 3));
        reducedPeriods.add(new cm.Period(18, 20));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(4, 9));
        normalPeriods.add(new Period(14, 17));


        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(0);


        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertNotNull(rate, "normalRate should be less than or equal to 10");
    }

    @Test
    void normalRateGreaterThanEqualZero() {
        cm.CarParkKind kind = cm.CarParkKind.STUDENT;


        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(3, 6));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(8, 12));


        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(1);


        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertNotNull(rate, "normalRate should be greater than or equal to 0");
    }

    @Test
    void reducedRateLessThanEqualTen() {
        cm.CarParkKind kind = cm.CarParkKind.MANAGEMENT;

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(12, 19));
        reducedPeriods.add(new cm.Period(19, 20));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(1, 12));
        normalPeriods.add(new cm.Period(20, 24));

        BigDecimal normalRate = new BigDecimal(9);
        BigDecimal reducedRate = new BigDecimal(6);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertNotNull(rate, "reducedRate should be less than or equal to 10");
    }

    @Test
    void reducedRateGreaterThanEqualZero() {
        cm.CarParkKind kind = cm.CarParkKind.STAFF;

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(1, 5));
        reducedPeriods.add(new cm.Period(9, 12));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(5, 9));
        normalPeriods.add(new cm.Period(12, 18));

        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertNotNull(rate, "reducedRate should be greater than or equal to 0");

    }

    @Test
    void reducedLessThanNormal() {
        cm.CarParkKind kind = cm.CarParkKind.VISITOR;

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(12, 19));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(1, 11));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertNotNull(rate, "reducedRate should be less than normalRate");
    }

    @Test
    void invalidCarParkKind() {
        cm.CarParkKind kind = null;

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(1, 9));
        reducedPeriods.add(new cm.Period(18, 23));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(9, 12));
        normalPeriods.add(new cm.Period(12, 18));

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(6);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "CarParkKind should be invalid");
    }

    @Test
    void overlappingReducedPeriods() {
        cm.CarParkKind kind = cm.CarParkKind.MANAGEMENT;

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(7, 12));
        reducedPeriods.add(new cm.Period(8, 13));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(1, 7));
        normalPeriods.add(new cm.Period(13, 24));

        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(2);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "reducedPeriods should overlap");
    }

    @Test
    void overlappingNormalPeriods() {
        cm.CarParkKind kind = cm.CarParkKind.STUDENT;

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(3, 6));
        reducedPeriods.add(new cm.Period(8, 9));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(10, 14));
        normalPeriods.add(new cm.Period(12, 16));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(0);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "normalPeriods should overlap");
    }

    @Test
    void reducedOverlapsNormal() {
        cm.CarParkKind kind = cm.CarParkKind.VISITOR;

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(9, 17));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(13, 19));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(0);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "reducedPeriods should overlap normalPeriods");
    }

    @Test
    void normalRateGreaterThanTen() {
        cm.CarParkKind kind = cm.CarParkKind.VISITOR;

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(1, 6));
        reducedPeriods.add(new cm.Period(7, 8));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(9, 13));
        normalPeriods.add(new cm.Period(18, 23));

        BigDecimal normalRate = new BigDecimal(14);
        BigDecimal reducedRate = new BigDecimal(6);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "normalRate should be greater than 10");
    }

    @Test
    void normalRateLessThanZero() {
        cm.CarParkKind kind = cm.CarParkKind.MANAGEMENT;

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(1, 2));
        reducedPeriods.add(new cm.Period(9, 10));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(3, 5));
        normalPeriods.add(new cm.Period(7, 8));

        BigDecimal normalRate = new BigDecimal(-8);
        BigDecimal reducedRate = new BigDecimal(8);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "normalRate should be less than 0");
    }

    @Test
    void reducedRateGreaterThanTen() {
        cm.CarParkKind kind = cm.CarParkKind.STAFF;

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(0, 1));
        reducedPeriods.add(new cm.Period(10, 12));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(2, 4));
        normalPeriods.add(new cm.Period(6, 9));

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(11);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "reducedRate should be greater than 10");
    }

    @Test
    void reducedRateLessThanZero() {
        cm.CarParkKind kind = cm.CarParkKind.STUDENT;

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(1, 3));
        reducedPeriods.add(new cm.Period(10, 12));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(4, 6));
        normalPeriods.add(new cm.Period(8, 9));

        BigDecimal normalRate = new BigDecimal(7);
        BigDecimal reducedRate = new BigDecimal(-4);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "reducedRate should be less than 0");
    }

    @Test
    void normalLessThanReduced() {
        cm.CarParkKind kind = cm.CarParkKind.MANAGEMENT;

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(1, 4));
        reducedPeriods.add(new cm.Period(8, 10));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(5, 7));

        BigDecimal normalRate = new BigDecimal(7);
        BigDecimal reducedRate = new BigDecimal(9);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "normalRate should be less than reducedRate");
    }

    @Test
    void reducedPeriodsNull() {
        cm.CarParkKind kind = cm.CarParkKind.STUDENT;

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(5, 7));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(3);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, null, normalPeriods, normalRate, reducedRate),
                "reducedPeriods should be null");
    }

    @Test
    void normalPeriodsNull() {
        cm.CarParkKind kind = cm.CarParkKind.STAFF;
        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(2, 7));

        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(2);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, null, normalRate, reducedRate),
                "normalPeriods should be null");
    }

    @Test
    void normalRateNull() {
        cm.CarParkKind kind = cm.CarParkKind.STAFF;
        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(5, 9));

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(1, 3));

        BigDecimal reducedRate = new BigDecimal(2);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, null, reducedRate),
                "normalPeriods should be null");

    }

    @Test
    void reducedRateNull() {
        cm.CarParkKind kind = CarParkKind.VISITOR;

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(1, 9));

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(10, 15));

        BigDecimal normalRate = new BigDecimal(2);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, null),
                "normalPeriods should be null");
    }

    @Test
    void overlappingSeparatePeriods() {
        cm.CarParkKind kind = cm.CarParkKind.STAFF;

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(2, 6));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(5, 8));

        BigDecimal normalRate = new BigDecimal(7);
        BigDecimal reducedRate = new BigDecimal(4);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "Overlapping periods between normal and reduced periods should throw an exception.");
    }

    @Test
    void overlappingTwoPeriods() {
        cm.CarParkKind kind = cm.CarParkKind.STUDENT;
        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(1, 2));
        reducedPeriods.add(new cm.Period(3, 4));
        reducedPeriods.add(new cm.Period(5, 6));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(2, 4));

        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(3);
        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "Overlapping periods between normal and reduced periods should throw an exception.");
    }

    @Test
    void duplicatePeriods() {
        cm.CarParkKind kind = cm.CarParkKind.STUDENT;
        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(1, 2));
        reducedPeriods.add(new cm.Period(1, 2));
        reducedPeriods.add(new cm.Period(3, 4));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(14, 15));

        BigDecimal normalRate = new BigDecimal(9);
        BigDecimal reducedRate = new BigDecimal(6);
        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "Overlapping periods between normal and reduced periods should throw an exception.");
    }

    // calculate(cm.cm.Period periodStay) Tests
    @Test
    void validStayPeriod() {
        cm.CarParkKind kind = cm.CarParkKind.MANAGEMENT;

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(1, 8));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(9, 15));

        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(4);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period periodStay = new Period(12, 14);

        BigDecimal result = rate.calculate(periodStay);

        assertEquals(new BigDecimal(12), result);
    }
    @Test
    void mixedStay() {
        cm.CarParkKind kind = cm.CarParkKind.VISITOR;

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(2, 4));
        reducedPeriods.add(new cm.Period(7, 9));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(5, 6));
        normalPeriods.add(new cm.Period(10, 12));

        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(3);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period periodStay = new Period(3, 11);

        BigDecimal result = rate.calculate(periodStay);

        assertEquals(new BigDecimal(27), result);
    }

    @Test
    void freePeriod(){
        cm.CarParkKind kind = cm.CarParkKind.STUDENT;

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(6, 8));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(10, 12));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period periodStay = new Period(2, 5);

        BigDecimal result = rate.calculate(periodStay);

        assertEquals(new BigDecimal(0), result);
    }

    @Test
    void invalidStayPeriod() {
        cm.CarParkKind kind = cm.CarParkKind.STAFF;

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(6, 10));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(14, 17));

        BigDecimal normalRate = new BigDecimal(7);
        BigDecimal reducedRate = new BigDecimal(2);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertThrows(IllegalArgumentException.class,
                () -> new Period(14, 12),
                "stayPeriod should be invalid");
    }
}
