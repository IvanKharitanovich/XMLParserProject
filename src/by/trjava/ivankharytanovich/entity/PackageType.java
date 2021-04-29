package by.trjava.ivankharytanovich.entity;

public enum PackageType {
    BOTTLES("BOTTLES"),
    BLISTER_PACK("BLISTER_PACK");

    private String packageName;

    PackageType(String packageName) {
        this.packageName = packageName;
    }
}
