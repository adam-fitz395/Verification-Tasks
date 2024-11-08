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
                    normalRate.compareTo(new BigDecimal(0)) < 0 ||
                    normalRate.compareTo(new BigDecimal(10)) > 0 ||
                    reducedRate.compareTo(new BigDecimal(0)) < 0 ||
                    reducedRate.compareTo(new BigDecimal(10)) > 0 ||
                    normalRate.compareTo(reducedRate) < 0 ||
                    (reducedPeriods.size() == 2 && reducedPeriods.get(0).overlaps(reducedPeriods.get(1))) ||
                    (normalPeriods.size() == 2 && normalPeriods.get(0).overlaps(normalPeriods.get(1))) ||
                    (reducedPeriods.size() == 1 && normalPeriods.size() == 1 && reducedPeriods.get(0).overlaps(normalPeriods.get(0)))
            ) {
                throw new IllegalArgumentException();
            }
            this.kind = kind;
            reducedPeriodsList = reducedPeriods;
            normalPeriodsList = normalPeriods;
            hourlyNormalRate = normalRate;
            hourlyReducedRate = reducedRate;
        }

        public BigDecimal calculate(Period periodStay) throws IllegalArgumentException {
            if (periodStay == null) {
                throw new IllegalArgumentException();
            }
            BigDecimal totalCost = BigDecimal.ZERO;

            for (Period reducedPeriod : reducedPeriodsList) {
                if (periodStay.overlaps(reducedPeriod)) {
                    // Calculate overlap duration with reduced period
                    int overlapStart = Math.max(periodStay.startHour, reducedPeriod.startHour);
                    int overlapEnd = Math.min(periodStay.endHour, reducedPeriod.endHour);
                    int overlapDuration = overlapEnd - overlapStart;

                    // Add the cost for the overlap duration at the reduced rate
                    totalCost = totalCost.add(hourlyReducedRate.multiply(BigDecimal.valueOf(overlapDuration)));
                }
            }

            // Calculate cost for normal periods
            for (Period normalPeriod : normalPeriodsList) {
                if (periodStay.overlaps(normalPeriod)) {
                    // Calculate overlap duration with normal period
                    int overlapStart = Math.max(periodStay.startHour, normalPeriod.startHour);
                    int overlapEnd = Math.min(periodStay.endHour, normalPeriod.endHour);
                    int overlapDuration = overlapEnd - overlapStart;

                    // Add the cost for the overlap duration at the normal rate
                    totalCost = totalCost.add(hourlyNormalRate.multiply(BigDecimal.valueOf(overlapDuration)));
                }
            }

            return totalCost;
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
