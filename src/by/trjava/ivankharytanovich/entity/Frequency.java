package by.trjava.ivankharytanovich.entity;

public class Frequency {
    private int days;
    private int perDay;

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getPerDay() {
        return perDay;
    }

    public void setPerDay(int perDay) {
        this.perDay = perDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Frequency frequency = (Frequency) o;

        if (days != frequency.days) return false;
        return perDay == frequency.perDay;
    }

    @Override
    public int hashCode() {
        int result = days;
        result = 31 * result + perDay;
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Frequency { ");
        sb.append("days = ").append(days);
        sb.append(", perDay = ").append(perDay);
        sb.append(" }");
        return sb.toString();
    }
}
