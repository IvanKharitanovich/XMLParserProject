package by.trjava.ivankharytanovich.entity;

public class Dosage {
    private double dosage;
    private Frequency frequency;

    public double getDosage() {
        return dosage;
    }

    public void setDosage(double dosage) {
        this.dosage = dosage;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dosage dosage1 = (Dosage) o;

        if (Double.compare(dosage1.dosage, dosage) != 0) return false;
        return frequency != null ? frequency.equals(dosage1.frequency) : dosage1.frequency == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(dosage);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (frequency != null ? frequency.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Dosage { ");
        sb.append("dosage = ").append(dosage);
        sb.append(", frequency = ").append(frequency);
        sb.append(" }");
        return sb.toString();
    }
}
