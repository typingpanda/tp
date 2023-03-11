package seedu.bigpp.component.motherboard;

import java.util.ArrayList;

public abstract class MotherboardList {
    private static ArrayList<Motherboard> motherboardList = new ArrayList<>();

    public static void addMotherboard(Motherboard motherboard) {
        motherboardList.add(motherboard);
    }

    public static ArrayList<Motherboard> getMotherboardList() {
        return motherboardList;
    }
}
