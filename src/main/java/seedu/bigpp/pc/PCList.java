package seedu.bigpp.pc;

import java.io.PrintStream;
import java.util.ArrayList;

public abstract class PCList {
    private static ArrayList<PC> pcList = new ArrayList<>();

    public static ArrayList<PC> getList() {
        return pcList;
    }

    public static void addPC(PC pc) {
        pcList.add(pc);
    }

    public static void printPcList(PrintStream out) {
        if (pcList.size() > 0) {
            out.println("Here is the list of PC Builds:");
            for (int i = 0; i < pcList.size(); i++) {
                out.println((i + 1) + "." + pcList.get(i));
            }
        } else {
            out.println("List currently empty!");
        }
    }
}
