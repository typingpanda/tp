package seedu.bigpp.menu;

import static seedu.bigpp.ui.UI.OUT;
import static seedu.bigpp.ui.UI.LOGO;

public class MainMenu extends Menu {

    public static void printMenu() {
        OUT.println(LOGO);
        OUT.println("Welcome to BigPP!");
        OUT.println("What would you like to do?");
        OUT.println("PC viewer");
        OUT.println("PC tutorial");
        OUT.println("exit");
    }
}
