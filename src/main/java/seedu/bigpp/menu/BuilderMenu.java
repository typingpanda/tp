package seedu.bigpp.menu;

import static seedu.bigpp.ui.UI.OUT;

public abstract class BuilderMenu extends Menu{

    public static void printMenu() {
        OUT.println("PC builder");
        OUT.println("What would you like to do?");
        OUT.println("Add component");
        OUT.println("Remove component");
        OUT.println("View PC");
        OUT.println("back");
        OUT.println("exit");
    }
}
