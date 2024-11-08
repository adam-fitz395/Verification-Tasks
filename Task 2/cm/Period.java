package cm;

public class Period {
    int startHour;
    int endHour;

    public Period(int start, int end) throws IllegalArgumentException {
        if (start < 0 || start >= 24 || end <= 0 || end > 24 || start >= end) {
            throw new IllegalArgumentException();
        }
        startHour = start;
        endHour = end;
    }

    public boolean overlaps(Period period) throws IllegalArgumentException {
        if (null == period) {
            throw new IllegalArgumentException();
        }
        return (period.startHour >= startHour && period.startHour < endHour) ||
                (period.endHour <= endHour && period.endHour > startHour);
    }

    public int duration() {
        return endHour - startHour;
    }

    @Override
    public String toString() {
        return "cm.Period{" + "startHour=" + startHour + ", endHour=" + endHour + '}';
    }
}