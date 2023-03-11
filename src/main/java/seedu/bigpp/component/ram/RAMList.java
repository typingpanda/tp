package seedu.bigpp.component.ram;

import java.util.ArrayList;

public abstract class RAMList {
    private static ArrayList<RAM> ramList = new ArrayList<>();

    public static void addRAM(RAM ram) {
        ramList.add(ram);
    }
}
