package seedu.bigpp.component.chassis;

import java.util.ArrayList;

public abstract class ChassisList {
    private static ArrayList<Chassis> chassisList = new ArrayList<>();

    public static void addChassis(Chassis chassis) {
        chassisList.add(chassis);
    }

    public static ArrayList<Chassis> getChassisList() {
        return chassisList;
    }
}
