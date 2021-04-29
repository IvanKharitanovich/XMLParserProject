package by.trjava.ivankharytanovich.entity;

public enum MedicationGroup {
    ANALGESICS("ANALGESICS"),
    ANTIBIOTIC("ANTIBIOTIC"),
    ANTISEPTIC("ANTISEPTIC"),
    HORMONE("HORMONE"),
    STIMULANTS("STIMULANTS");

    private String groupName;

    MedicationGroup(String groupName) {
        this.groupName = groupName;
    }

}
