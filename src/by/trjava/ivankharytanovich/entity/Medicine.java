package by.trjava.ivankharytanovich.entity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

public class Medicine {
    private String id;
    private Boolean recipeStatusNeeded;
    private String name;
    private String organisationName;
    private MedicationGroup group;
    private String[] analogs;
    private Version version;
    private Date issueDate;
    private Date expirationDate;
    private String registerOrganisationName;
    private Package aPackage;
    private Dosage dosage;

    private Medicine() {
    }

    public String getId() {
        return id;
    }

    public Boolean getRecipeStatusNeeded() {
        return recipeStatusNeeded;
    }

    public String getName() {
        return name;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public MedicationGroup getGroup() {
        return group;
    }

    public String[] getAnalogs() {
        return analogs;
    }

    public Version getVersion() {
        return version;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getRegisterOrganisationName() {
        return registerOrganisationName;
    }

    public Package getaPackage() {
        return aPackage;
    }

    public Dosage getDosage() {
        return dosage;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Medicine { ");
        sb.append("id = '").append(id).append('\'');
        sb.append(", recipeStatusNeeded = ").append(recipeStatusNeeded);
        sb.append(", name = '").append(name).append('\'');
        sb.append(", organisationName = '").append(organisationName).append('\'');
        sb.append(", group = ").append(group);
        sb.append(", analogs = ").append(analogs == null ? "null" : Arrays.asList(analogs).toString());
        sb.append(", version = ").append(version);
        sb.append(", issueDate = ").append(issueDate);
        sb.append(", expirationDate = ").append(expirationDate);
        sb.append(", registerOrganisationName = '").append(registerOrganisationName).append('\'');
        sb.append(", packageType = ").append(aPackage);
        sb.append(", dosage = ").append(dosage);
        sb.append(" }");
        return sb.toString();
    }

    public static Builder newBuilder() {
        return new Medicine().new Builder();
    }


    public class Builder {

        private Builder() {
        }

        public Builder setId(String id) {
            Medicine.this.id = id;
            return this;
        }

        public Builder setRecipeStatusNeeded(Boolean recipeStatusNeeded) {
            Medicine.this.recipeStatusNeeded = recipeStatusNeeded;
            return this;
        }

        public Builder setName(String name) {
            Medicine.this.name = name;
            return this;
        }

        public Builder setOrganisation(String organisation) {
            Medicine.this.organisationName = organisation;
            return this;
        }

        public Builder setGroup(MedicationGroup group) {
            Medicine.this.group = group;
            return this;
        }

        public Builder setAnalogs(String[] analogs) {
            Medicine.this.analogs = analogs;
            return this;
        }

        public Builder setVersion(Version version) {
            Medicine.this.version = version;
            return this;
        }

        public Builder setIssueDate(Date issueDate) {
            Medicine.this.issueDate = issueDate;
            return this;
        }

        public Builder setExpirationDate(Date expirationDate) {
            Medicine.this.expirationDate = expirationDate;
            return this;
        }

        public Builder setRegisterOrganisation(String registerOrganisationName) {
            Medicine.this.registerOrganisationName = registerOrganisationName;
            return this;
        }


        public Builder setAPackage(Package aPackage) {
            Medicine.this.aPackage = aPackage;
            return this;
        }

        public Builder setTypeOfPackage(PackageType packageType) {
            Medicine.this.aPackage.setPackageType(packageType);
            return this;
        }

        public Builder setPackageAmount(double amount) {
            Medicine.this.aPackage.setAmount(amount);
            return this;
        }

        public Builder setPackagePrice(BigDecimal price) {
            Medicine.this.aPackage.setPrice(price);
            return this;
        }

        public Builder setDosage(Dosage dosage) {
            Medicine.this.dosage = dosage;
            return this;
        }

        public Builder setDosageAmount(double dosage) {
            Medicine.this.dosage.setDosage(dosage);
            return this;
        }

        public Builder setDosageFrequency(Frequency frequency) {
            Medicine.this.dosage.setFrequency(frequency);
            return this;
        }

        public Builder setFrequencyDays(int days) {
            Medicine.this.dosage.getFrequency().setDays(days);
            return this;
        }

        public Builder setFrequencyPerDay(int perDay) {
            Medicine.this.dosage.getFrequency().setPerDay(perDay);
            return this;
        }

        public Medicine build() {
            return Medicine.this;
        }

    }

}
