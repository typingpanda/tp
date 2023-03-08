package seedu.bigpp.menu;

import static seedu.bigpp.ui.UI.OUT;

public abstract class ComponentMenu extends Menu {

    public static void printMenu() {
        OUT.println("Component");
        OUT.println("What would you like to do?");
        OUT.println("View component");
        OUT.println("back");
        OUT.println("exit");
    }
}
