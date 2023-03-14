package seedu.bigpp.menu;

import seedu.bigpp.pc.PCList;

import static seedu.bigpp.ui.UI.out;

public class PCViewerMenu extends Menu {

    public void printMenu() {
        out.println("PC viewer");
        PCList.printPcList();
        out.println("What would you like to do?");
        out.println("Add PC");
        out.println("View PC");
        out.println("Edit PC");
        out.println("Delete PC");
        out.println("back");
        out.println("exit");
    }
}
