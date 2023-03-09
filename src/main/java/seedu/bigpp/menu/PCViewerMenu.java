package seedu.bigpp.menu;

import static seedu.bigpp.ui.UI.OUT;
import seedu.bigpp.pc.PCList;

public class PCViewerMenu extends Menu {

    public void printMenu() {
        OUT.println("PC viewer");
        PCList.printPcList();
        OUT.println("What would you like to do?");
        OUT.println("View PC");
        OUT.println("Build PC");
        OUT.println("back");
        OUT.println("exit");
    }
}
