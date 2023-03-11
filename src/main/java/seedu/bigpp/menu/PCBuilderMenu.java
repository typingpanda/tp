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
        PCList.getPC(pcIndex).printComponents();
        out.println("Add component");
        out.println("Remove component");
        out.println("View PC");
        out.println("back");
        out.println("exit");
    }
}
