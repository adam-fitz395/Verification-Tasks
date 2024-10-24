package cm;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
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

        ArrayList<cm.Period> normalPeriods = new java.util.ArrayList<cm.Period>;
        normalPeriods.add(new cm.Period(8, 12));
        normalPeriods.add(new cm.Period(14, 18));

        // Initializing BigDecimal rates
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);

        // Creating a Rate object
        cm.Rate rate = new cm.Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
    }
}
