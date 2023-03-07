package seedu.bigpp.pc;

import seedu.bigpp.ui.UI;

import java.util.ArrayList;

public class PCList {
    private static ArrayList<PC> pcList = new ArrayList<>();

    public static ArrayList<PC> getList() {
        return pcList;
    }

    public static void printPcList() {
        
        if (pcList.size() > 0) {
            System.out.println("Here is the list of PC Builds:");
            for (int i = 0; i < pcList.size(); i++) {
                System.out.println((i + 1) + "." + pcList.get(i));
            }
        } else {
            System.out.println("List currently empty!");
        }
    }
}
