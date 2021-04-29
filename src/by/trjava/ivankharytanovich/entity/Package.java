package by.trjava.ivankharytanovich.entity;

import java.math.BigDecimal;

public class Package {
    private PackageType packageType;
    private double amount;
    private BigDecimal price;

    public PackageType getPackageType() {
        return packageType;
    }

    public void setPackageType(PackageType packageType) {
        this.packageType = packageType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Package aPackage = (Package) o;

        if (Double.compare(aPackage.amount, amount) != 0) return false;
        if (packageType != null ? !packageType.equals(aPackage.packageType) : aPackage.packageType != null)
            return false;
        return price != null ? price.equals(aPackage.price) : aPackage.price == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = packageType != null ? packageType.hashCode() : 0;
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Package { ");
        sb.append("packageType = ").append(packageType);
        sb.append(", amount = ").append(amount);
        sb.append(", price = ").append(price);
        sb.append(" }");
        return sb.toString();
    }
}
