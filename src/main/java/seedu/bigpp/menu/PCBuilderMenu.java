package seedu.bigpp.menu;

import seedu.bigpp.pc.PCList;

import static seedu.bigpp.ui.UI.out;

public class PCBuilderMenu extends Menu {

    private int pcIndex;

    public PCBuilderMenu(int pcIndex) {
        this.pcIndex = pcIndex;
    }

    public int getPCIndex() {
        return pcIndex;
    }

    public void printMenu() {
        out.println("PC builder");
        out.println(PCList.getPC(pcIndex).viewComponents());
        out.println("What would you like to do?");
        out.println("Edit name");
        out.println("Set budget");
        out.println("List components");
        out.println("Select components");
        out.println("back");
    }
}
