package cm;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class FitzpatrickAdamRateTests {

    @Test
    void validCarParkKind() {
        cm.CarParkKind kind = cm.CarParkKind.STAFF;

        // Creating valid reduced and normal periods
        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(12, 14));
        reducedPeriods.add(new cm.Period(18, 20));

        ArrayList<cm.Period> normalPeriods = new java.util.ArrayList<cm.Period>();
        normalPeriods.add(new cm.Period(8, 12));
        normalPeriods.add(new cm.Period(14, 18));

        // Initializing BigDecimal rates
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);

        // Creating a Rate object
        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
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
    }

    @Test
    void reducedRateGreaterThanEqualTen() {
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
    }

    @Test
    void reducedRateLessThanEqualZero() {
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

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
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

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
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

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
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

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
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

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
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

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
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

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
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

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
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

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
    }

    // calculate(Period periodStay) Tests
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

        Period periodStay = new Period(14, 12);
      
        BigDecimal result = rate.calculate(periodStay);
    }

    @Test
    void overlappingPeriods() {
        cm.CarParkKind kind = cm.CarParkKind.STAFF;

        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(2, 6));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(5, 8));

        BigDecimal normalRate = new BigDecimal(7);
        BigDecimal reducedRate = new BigDecimal(4);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period periodStay = new Period(3, 7);
      
        BigDecimal result = rate.calculate(periodStay);
    }
}
