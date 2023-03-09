package seedu.bigpp.menu;

import static seedu.bigpp.ui.UI.OUT;

public abstract class TutorialMenu extends Menu {

    public static void printMenu() {
        OUT.println("PC tutorial");
        OUT.println("What would you like to do?");
        OUT.println("View tutorial");
        OUT.println("back");
        OUT.println("exit");
    }
}
