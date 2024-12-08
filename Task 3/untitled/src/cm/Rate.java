package cm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Rate {
    private CarParkKind kind;
    private BigDecimal hourlyNormalRate;
    private BigDecimal hourlyReducedRate;
    private ArrayList<Period> reduced = new ArrayList<>();
    private ArrayList<Period> normal = new ArrayList<>();

    public Rate(CarParkKind kind, ArrayList<Period> reducedPeriods, ArrayList<Period> normalPeriods, BigDecimal normalRate, BigDecimal reducedRate) {
        if (kind == null) {
            throw new IllegalArgumentException("kind cannot be null");
        }
        if (reducedPeriods == null || normalPeriods == null) {
            throw new IllegalArgumentException("periods cannot be null");
        }
        if (normalRate == null || reducedRate == null) {
            throw new IllegalArgumentException("The rates cannot be null");
        }
        if (normalRate.compareTo(BigDecimal.ZERO) < 0 || reducedRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("A rate cannot be negative");
        }
        if (normalRate.compareTo(reducedRate) <= 0) {
            throw new IllegalArgumentException("The normal rate cannot be less or equal to the reduced rate");
        }
        if (normalRate.compareTo(BigDecimal.TEN) > 0 || reducedRate.compareTo(BigDecimal.TEN) > 0) {
            throw new IllegalArgumentException("A rate cannot be above 10");
        }
        if (normalRate.compareTo(reducedRate) < 0) {
            throw new IllegalArgumentException("The normal rate cannot be less than the reduced rate");
        }
        if (!isValidPeriods(reducedPeriods) || !isValidPeriods(normalPeriods)) {
            throw new IllegalArgumentException("The periods are not valid individually");
        }
        if (!isValidPeriods(reducedPeriods, normalPeriods)) {
            throw new IllegalArgumentException("The periods overlaps");
        }
        this.kind = kind;
        this.hourlyNormalRate = normalRate;
        this.hourlyReducedRate = reducedRate;
        this.reduced = reducedPeriods;
        this.normal = normalPeriods;
    }

    /**
     * Checks if two collections of periods are valid together
     * @param periods1
     * @param periods2
     * @return true if the two collections of periods are valid together
     */
    private boolean isValidPeriods(ArrayList<Period> periods1, ArrayList<Period> periods2) {
        Boolean isValid = true;
        int i = 0;
        while (i < periods1.size() && isValid) {
            isValid = isValidPeriod(periods1.get(i), periods2);
            i++;
        }
        return isValid;
    }

    /**
     * checks if a collection of periods is valid
     * @param list the collection of periods to check
     * @return true if the periods do not overlap
     */
    private Boolean isValidPeriods(ArrayList<Period> list) {
        Boolean isValid = true;
        if (list.size() >= 2) {
            Period secondPeriod;
            int i = 0;
            int lastIndex = list.size()-1;
            while (i < lastIndex && isValid) {
                isValid = isValidPeriod(list.get(i), ((List<Period>)list).subList(i + 1, lastIndex+1));
                i++;
            }
        }
        return isValid;
    }

    /**
     * checks if a period is a valid addition to a collection of periods
     * @param period the Period addition
     * @param list the collection of periods to check
     * @return true if the period does not overlap in the collecton of periods
     */
    private Boolean isValidPeriod(Period period, List<Period> list) {
        Boolean isValid = true;
        int i = 0;
        while (i < list.size() && isValid) {
            isValid = !period.overlaps(list.get(i));
            i++;
        }
        return isValid;
    }
    public BigDecimal calculate(Period periodStay, CarParkKind kind) {
        if (periodStay == null) {
            throw new IllegalArgumentException("periodStay cannot be null");
        }
        int normalRateHours = periodStay.occurences(normal);
        int reducedRateHours = periodStay.occurences(reduced);
        BigDecimal thisPrice = null;
        
        if (kind == CarParkKind.VISITOR) {
            BigDecimal visitorTotal = (this.hourlyNormalRate.multiply(BigDecimal.valueOf(normalRateHours))).add(
                    this.hourlyReducedRate.multiply(BigDecimal.valueOf(reducedRateHours)));
            BigDecimal visitorMinDiscount = new BigDecimal("10");

            if (visitorTotal.compareTo(visitorMinDiscount) > 0) {
                visitorTotal = visitorTotal.subtract(BigDecimal.valueOf(10)).multiply(BigDecimal.valueOf(.5));
            }
            
            thisPrice = visitorTotal;
        }
        
        else if (kind == CarParkKind.MANAGEMENT) {
            BigDecimal managementTotal = (this.hourlyNormalRate.multiply(BigDecimal.valueOf(normalRateHours))).add(
                    this.hourlyReducedRate.multiply(BigDecimal.valueOf(reducedRateHours)));

            BigDecimal minimumPayable = new BigDecimal(4);

            if (managementTotal.compareTo(minimumPayable) < 0) {
                managementTotal = new BigDecimal(4);
            }
            
            thisPrice = managementTotal;
        }
        
        else if (kind == CarParkKind.STUDENT) {
            BigDecimal studentTotal = (this.hourlyNormalRate.multiply(BigDecimal.valueOf(normalRateHours))).add(
                    this.hourlyReducedRate.multiply(BigDecimal.valueOf(reducedRateHours)));

            BigDecimal minimumDiscount = new BigDecimal("5.50");

            if (studentTotal.compareTo(minimumDiscount) > 0) {
                BigDecimal excessAmount = studentTotal.subtract(minimumDiscount);
                studentTotal = minimumDiscount.add(excessAmount.multiply(new BigDecimal("0.75")));
            }

            thisPrice = studentTotal.setScale(2, RoundingMode.HALF_UP);
        }
        
        else if (kind == CarParkKind.STAFF) {
            BigDecimal staffTotal = (this.hourlyNormalRate.multiply(BigDecimal.valueOf(normalRateHours))).add(
                    this.hourlyReducedRate.multiply(BigDecimal.valueOf(reducedRateHours)));

            BigDecimal staffMaximum = new BigDecimal("16");

            if (staffTotal.compareTo(staffMaximum) > 0) {
                staffTotal = new BigDecimal("16");
            }
            
            thisPrice = staffTotal;
        }
        return thisPrice;
    }
}