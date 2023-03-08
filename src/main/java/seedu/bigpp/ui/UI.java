package seedu.bigpp.ui;

import seedu.bigpp.menu.MainMenu;
import seedu.bigpp.menu.PCViewerMenu;
import seedu.bigpp.menu.TutorialMenu;
import seedu.bigpp.menu.ComponentMenu;
import seedu.bigpp.menu.BuilderMenu;
import java.io.PrintStream;
import java.util.Scanner;

public abstract class UI {
    
    public static final PrintStream OUT = System.out;
    public static final String LOGO = "add logo here";

    private static UIState uiState = UIState.MAIN_MENU;
    private static final String DIVIDER = "===================================================";
    private static final Scanner in = new Scanner(System.in);


    public static UIState getUiState() {
        return uiState;
    }

    public static String getInput() {
        return in.nextLine();
    }

    public static void updateUI() {
        clearTerminal();
        OUT.println(DIVIDER);

        switch (uiState) {
        case MAIN_MENU:
            MainMenu.printMenu();
            break;
        case VIEWER:
            PCViewerMenu.printMenu();
            break;
        case BUILDER:
            BuilderMenu.printMenu();
            break;
        case TUTORIAL:
            TutorialMenu.printMenu();
            break;
        case COMPONENT:
            ComponentMenu.printMenu();
            break;
        default:
            break;
        }

        OUT.println(DIVIDER);
    }

    public static void clearTerminal() {
        OUT.println("\033[H\033[2J");
    }

    public static void showResult(String result) {
        OUT.println(result);
    }

    public static void setMainMenuMode() {
        uiState = UIState.MAIN_MENU;
    }

    public static void setViewerMode() {
        uiState = UIState.VIEWER;
    }

    public static void setBuilderMode() {
        uiState = UIState.BUILDER;
    }

    public static void setTutorialMode() {
        uiState = UIState.TUTORIAL;
    }

    public static void setComponentMode() {
        uiState = UIState.COMPONENT;
    }
}
