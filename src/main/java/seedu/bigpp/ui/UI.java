package seedu.bigpp.ui;

import seedu.bigpp.menu.MainMenu;
import seedu.bigpp.menu.PCViewerMenu;
import seedu.bigpp.menu.TutorialMenu;
import seedu.bigpp.menu.ComponentMenu;
import seedu.bigpp.menu.BuilderMenu;
import java.io.PrintStream;
import java.util.Scanner;
public abstract class UI {
    
    private static UIState uiState = UIState.MAIN_MENU;
    private static final String DIVIDER = "===================================================";
    private static final Scanner in = new Scanner(System.in);

    public static final String LOGO = "add logo here";
    public static final PrintStream out = System.out;

    public static UIState getUiState() {
        return uiState;
    }

    public static String getInput() {
        return in.nextLine();
    }

    public static void updateUI() {
        clearTerminal();
        out.println(DIVIDER);

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

        out.println(DIVIDER);
    }

    public static void clearTerminal() {
        out.println("\033[H\033[2J");
    }

    public static void showResult(String result) {
        out.println(result);
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
