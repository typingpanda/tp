package seedu.bigpp.menu;

import static seedu.bigpp.ui.UI.out;

public class BuilderMenu {

    public static void printMenu() {
        out.println("PC builder");
        out.println("What would you like to do?");
        out.println("Add component");
        out.println("Remove component");
        out.println("View PC");
        out.println("back");
        out.println("exit");
    }
}
