package cm;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Rate {
    CarParkKind kind;
    ArrayList<Period> reducedPeriodsList;
    ArrayList<Period> normalPeriodsList;
    BigDecimal hourlyNormalRate;
    BigDecimal hourlyReducedRate;

    public Rate(CarParkKind kind, ArrayList<Period> reducedPeriods, ArrayList<Period> normalPeriods, BigDecimal normalRate, BigDecimal reducedRate) throws IllegalArgumentException {
        if (kind == null ||
                normalRate.compareTo(BigDecimal.ZERO) < 0 ||
                reducedRate.compareTo(BigDecimal.ZERO) < 0 ||
                normalRate.compareTo(reducedRate) < 0) {
            throw new IllegalArgumentException("Invalid rates or car park kind.");
        }

        if (kind != CarParkKind.STAFF || kind != CarParkKind.STUDENT || kind != CarParkKind.MANAGEMENT || kind != CarParkKind.VISITOR) {
            throw new IllegalArgumentException("Invalid CarParkKind");
        }

        // Check for overlapping periods in reduced and normal lists
        for (Period reducedPeriod : reducedPeriods) {
            for (Period normalPeriod : normalPeriods) {
                if (reducedPeriod.overlaps(normalPeriod)) {
                    throw new IllegalArgumentException("Reduced and normal periods overlap.");
                }
            }
        }

        this.kind = kind;
        this.reducedPeriodsList = reducedPeriods;
        this.normalPeriodsList = normalPeriods;
        this.hourlyNormalRate = normalRate;
        this.hourlyReducedRate = reducedRate;
    }

    public BigDecimal calculate(Period periodStay) throws IllegalArgumentException {
        if (periodStay == null) {
            throw new IllegalArgumentException("Period stay cannot be null.");
        }

        BigDecimal totalCost = BigDecimal.ZERO;
        int hoursStayed = periodStay.duration();

        for (int i = 0; i < hoursStayed; i++) {
            int currentHour = periodStay.startHour + i;

            if (isInReducedPeriod(currentHour)) {
                totalCost = totalCost.add(hourlyReducedRate);
            } else if (isInNormalPeriod(currentHour)) {
                totalCost = totalCost.add(hourlyNormalRate);
            } else {
                throw new IllegalArgumentException("Hour outside of defined periods.");
            }
        }

        return totalCost;
    }

    private boolean isInReducedPeriod(int hour) {
        for (Period period : reducedPeriodsList) {
            if (hour >= period.startHour && hour < period.endHour) {
                return true;
            }
        }
        return false;
    }

    private boolean isInNormalPeriod(int hour) {
        for (Period period : normalPeriodsList) {
            if (hour >= period.startHour && hour < period.endHour) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "kind=" + kind +
                ", reducedPeriodsList=" + reducedPeriodsList +
                ", normalPeriodsList=" + normalPeriodsList +
                ", hourlyNormalRate=" + hourlyNormalRate +
                ", hourlyReducedRate=" + hourlyReducedRate +
                '}';
    }
}
