package seedu.bigpp.menu;

import static seedu.bigpp.ui.UI.out;
import static seedu.bigpp.ui.UI.LOGO;

public class MainMenu extends Menu {

    public static void printMenu() {
        out.println(LOGO);
        out.println("Welcome to BigPP!");
        out.println("What would you like to do?");
        out.println("PC viewer");
        out.println("PC tutorial");
        out.println("exit");
    }
}
