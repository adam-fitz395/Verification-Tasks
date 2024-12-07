package cm;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class FitzpatrickAdamTestTaskRate2 {
    @Test
    void validCarParkKind() {
        CarParkKind kind = CarParkKind.STAFF;

        // Creating valid reduced and normal periods
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(18, 20));

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        normalPeriods.add(new Period(8, 12));
        normalPeriods.add(new Period(14, 18));

        // Initializing BigDecimal rates
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);

        // Creating a cm.CarParkKind.cm.Rate object
        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate, "CarParkKind should be valid");
    }

    @Test
    void validReducedPeriods() {
        CarParkKind kind = CarParkKind.STUDENT;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(6, 10));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));


        BigDecimal normalRate = new BigDecimal(7);
        BigDecimal reducedRate = new BigDecimal(3);


        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertNotNull(rate, "ReducedPeriods should be valid");
    }

    @Test
    void validNormalPeriods() {
        CarParkKind kind = CarParkKind.MANAGEMENT;


        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(9, 11));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(15, 17));


        BigDecimal normalRate = new BigDecimal(9);
        BigDecimal reducedRate = new BigDecimal(6);


        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertNotNull(rate, "NormalPeriods should be valid");
    }

    @Test
    void normalRateLessThanEqualTen() {
        CarParkKind kind = CarParkKind.VISITOR;


        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(1, 3));
        reducedPeriods.add(new Period(18, 20));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(4, 9));
        normalPeriods.add(new Period(14, 17));


        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(0);


        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertNotNull(rate, "normalRate should be less than or equal to 10");
    }

    @Test
    void normalRateGreaterThanEqualZero() {
        CarParkKind kind = CarParkKind.STUDENT;


        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(3, 6));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(8, 12));


        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(1);


        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertNotNull(rate, "normalRate should be greater than or equal to 0");
    }

    @Test
    void reducedRateLessThanEqualTen() {
        CarParkKind kind = CarParkKind.MANAGEMENT;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(12, 19));
        reducedPeriods.add(new Period(19, 20));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(1, 12));
        normalPeriods.add(new Period(20, 24));

        BigDecimal normalRate = new BigDecimal(9);
        BigDecimal reducedRate = new BigDecimal(6);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertNotNull(rate, "reducedRate should be less than or equal to 10");
    }

    @Test
    void reducedRateGreaterThanEqualZero() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(1, 5));
        reducedPeriods.add(new Period(9, 12));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(5, 9));
        normalPeriods.add(new Period(12, 18));

        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertNotNull(rate, "reducedRate should be greater than or equal to 0");

    }

    @Test
    void reducedLessThanNormal() {
        CarParkKind kind = CarParkKind.VISITOR;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(12, 19));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(1, 11));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertNotNull(rate, "reducedRate should be less than normalRate");
    }

    @Test
    void invalidCarParkKind() {
        CarParkKind kind = null;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(1, 9));
        reducedPeriods.add(new Period(18, 23));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(12, 18));

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(6);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "CarParkKind should be invalid");
    }

    @Test
    void overlappingReducedPeriods() {
        CarParkKind kind = CarParkKind.MANAGEMENT;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(7, 12));
        reducedPeriods.add(new Period(8, 13));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(1, 7));
        normalPeriods.add(new Period(13, 24));

        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(2);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "reducedPeriods should overlap");
    }

    @Test
    void overlappingNormalPeriods() {
        CarParkKind kind = CarParkKind.STUDENT;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(3, 6));
        reducedPeriods.add(new Period(8, 9));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 14));
        normalPeriods.add(new Period(12, 16));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(0);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "normalPeriods should overlap");
    }

    @Test
    void reducedOverlapsNormal() {
        CarParkKind kind = CarParkKind.VISITOR;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(9, 17));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(13, 19));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(0);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "reducedPeriods should overlap normalPeriods");
    }

    @Test
    void normalRateGreaterThanTen() {
        CarParkKind kind = CarParkKind.VISITOR;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(1, 6));
        reducedPeriods.add(new Period(7, 8));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(9, 13));
        normalPeriods.add(new Period(18, 23));

        BigDecimal normalRate = new BigDecimal(14);
        BigDecimal reducedRate = new BigDecimal(6);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "normalRate should be greater than 10");
    }

    @Test
    void normalRateLessThanZero() {
        CarParkKind kind = CarParkKind.MANAGEMENT;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(1, 2));
        reducedPeriods.add(new Period(9, 10));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(3, 5));
        normalPeriods.add(new Period(7, 8));

        BigDecimal normalRate = new BigDecimal(-8);
        BigDecimal reducedRate = new BigDecimal(8);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "normalRate should be less than 0");
    }

    @Test
    void reducedRateGreaterThanTen() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0, 1));
        reducedPeriods.add(new Period(10, 12));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(2, 4));
        normalPeriods.add(new Period(6, 9));

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(11);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "reducedRate should be greater than 10");
    }

    @Test
    void reducedRateLessThanZero() {
        CarParkKind kind = CarParkKind.STUDENT;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(1, 3));
        reducedPeriods.add(new Period(10, 12));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(4, 6));
        normalPeriods.add(new Period(8, 9));

        BigDecimal normalRate = new BigDecimal(7);
        BigDecimal reducedRate = new BigDecimal(-4);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "reducedRate should be less than 0");
    }

    @Test
    void normalLessThanReduced() {
        CarParkKind kind = CarParkKind.MANAGEMENT;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(1, 4));
        reducedPeriods.add(new Period(8, 10));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(5, 7));

        BigDecimal normalRate = new BigDecimal(7);
        BigDecimal reducedRate = new BigDecimal(9);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "normalRate should be less than reducedRate");
    }

    @Test
    void reducedPeriodsNull() {
        CarParkKind kind = CarParkKind.STUDENT;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(5, 7));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(3);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, null, normalPeriods, normalRate, reducedRate),
                "reducedPeriods should be null");
    }

    @Test
    void normalPeriodsNull() {
        CarParkKind kind = CarParkKind.STAFF;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(2, 7));

        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(2);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, null, normalRate, reducedRate),
                "normalPeriods should be null");
    }

    @Test
    void normalRateNull() {
        CarParkKind kind = CarParkKind.STAFF;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(5, 9));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(1, 3));

        BigDecimal reducedRate = new BigDecimal(2);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, null, reducedRate),
                "normalPeriods should be null");

    }

    @Test
    void reducedRateNull() {
        CarParkKind kind = CarParkKind.VISITOR;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(1, 9));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(10, 15));

        BigDecimal normalRate = new BigDecimal(2);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, null),
                "normalPeriods should be null");
    }

    @Test
    void overlappingSeparatePeriods() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(2, 6));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(5, 8));

        BigDecimal normalRate = new BigDecimal(7);
        BigDecimal reducedRate = new BigDecimal(4);

        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "Overlapping periods between normal and reduced periods should throw an exception.");
    }

    @Test
    void overlappingTwoPeriods() {
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(1, 2));
        reducedPeriods.add(new Period(3, 4));
        reducedPeriods.add(new Period(5, 6));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(2, 4));

        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(3);
        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "Overlapping periods between normal and reduced periods should throw an exception.");
    }

    @Test
    void duplicatePeriods() {
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(1, 2));
        reducedPeriods.add(new Period(1, 2));
        reducedPeriods.add(new Period(3, 4));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(14, 15));

        BigDecimal normalRate = new BigDecimal(9);
        BigDecimal reducedRate = new BigDecimal(6);
        assertThrows(IllegalArgumentException.class,
                () -> new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate),
                "Overlapping periods between normal and reduced periods should throw an exception.");
    }

    // calculate(cm.cm.Period periodStay) Tests
    @Test
    void validStayPeriod() {
        CarParkKind kind = CarParkKind.MANAGEMENT;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(1, 8));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(9, 15));

        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(4);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period periodStay = new Period(12, 14);

        BigDecimal result = rate.calculate(periodStay, kind);

        assertEquals(new BigDecimal(12), result);
    }
    @Test
    void mixedStay() {
        CarParkKind kind = CarParkKind.VISITOR;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(2, 4));
        reducedPeriods.add(new Period(7, 9));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(5, 6));
        normalPeriods.add(new Period(10, 12));

        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(3);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period periodStay = new Period(3, 11);

        BigDecimal result = rate.calculate(periodStay, kind);

        assertEquals(new BigDecimal(5.5), result);
    }

    @Test
    void freePeriod(){
        CarParkKind kind = CarParkKind.STUDENT;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(6, 8));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period periodStay = new Period(2, 5);

        BigDecimal result = rate.calculate(periodStay, kind);

        assertEquals(new BigDecimal(0), result);
    }

    @Test
    void invalidStayPeriod() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(6, 10));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(14, 17));

        BigDecimal normalRate = new BigDecimal(7);
        BigDecimal reducedRate = new BigDecimal(2);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertThrows(IllegalArgumentException.class,
                () -> new Period(14, 12),
                "stayPeriod should be invalid");
    }
}
