package seedu.bigpp.pc;

public enum FormFactorEnum {

    MINI(1), MICRO(2), ATX(3);

    private int value;

    FormFactorEnum(int value) {
        this.value = value;
    }

    public int getFormFactor() {
        return value;
    }

    public static int getFormFactorFromString(String formFactor) {
        switch (formFactor) {
        case "mini":
            return 1;
        case "micro":
            return 2;
        case "atx":
            return 3;
        default:
            return 0;
        }
    }

}
