package by.trjava.ivankharytanovich.entity;

public enum Version {
    TABLET("TABLET"),
    LIQUID("LIQUID"),
    CAPSULES("CAPSULES"),
    DROPS("DROPS"),
    INJECTIONS("INJECTIONS");

    private String versionName;

    Version(String versionName) {
        this.versionName = versionName;
    }
}
