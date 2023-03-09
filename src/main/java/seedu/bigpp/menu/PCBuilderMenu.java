package seedu.bigpp.menu;

import seedu.bigpp.pc.PC;
import static seedu.bigpp.ui.UI.OUT;

public class PCBuilderMenu extends Menu {

    private PC pc;

    public PCBuilderMenu(PC pc) {
        this.pc = pc;
    }

    public void printMenu() {
        OUT.println("PC builder");
        pc.printComponents();
        OUT.println("Add component");
        OUT.println("Remove component");
        OUT.println("View PC");
        OUT.println("back");
        OUT.println("exit");
    }
}
