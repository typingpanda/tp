package seedu.bigpp.menu;

import seedu.bigpp.pc.PC;
import static seedu.bigpp.ui.UI.out;

public class PCBuilderMenu extends Menu {

    private PC pc;

    public PCBuilderMenu(PC pc) {
        this.pc = pc;
    }

    public void printMenu() {
        out.println("PC builder");
        pc.printComponents();
        out.println("Add component");
        out.println("Remove component");
        out.println("View PC");
        out.println("back");
        out.println("exit");
    }
}
