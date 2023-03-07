package seedu.bigpp.pc;

import java.util.ArrayList;

public class PCList {
    private static ArrayList<PC> pcList = new ArrayList<>();

    public static void addPC (PC pc) {
        pcList.add(pc);
    }
}
