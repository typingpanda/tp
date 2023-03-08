package seedu.bigpp.pc;

import java.util.ArrayList;
import static seedu.bigpp.ui.UI.OUT;

public abstract class PCList {
    private static ArrayList<PC> pcList = new ArrayList<>();

    public static ArrayList<PC> getList() {
        return pcList;
    }

    /**
     * Add PC to the PC list
     * @param pc the PC that will be added to the list
     */
    public static void addPC(PC pc) {
        pcList.add(pc);
    }

    /**
     * Remove PC from the PC list
     * @param index the position of the PC in the PC list
     */
    public static void deletePC(int index) {
        pcList.remove(index);
    }

    public static void printPcList() {
        if (pcList.size() > 0) {
            OUT.println("Here is the list of PC Builds:");
            for (int i = 0; i < pcList.size(); i++) {
                OUT.println((i + 1) + "." + pcList.get(i));
            }
        } else {
            OUT.println("List currently empty!");
        }
    }
}
