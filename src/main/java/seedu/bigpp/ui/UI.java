package seedu.bigpp.ui;

import seedu.bigpp.pc.PCList;

import java.io.PrintStream;
import java.util.Scanner;

public abstract class UI {
    private static UIState uiState = UIState.MAIN_MENU;

    private static final String DIVIDER = "===================================================";

    private static final String LOGO = "add logo here";

    private static final Scanner in = new Scanner(System.in);
    private static final PrintStream out = System.out;

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
            printMainMenu();
            break;
        case VIEWER:
            printViewer();
            break;
        case BUILDER:
            printBuilder();
            break;
        case TUTORIAL:
            printTutorial();
            break;
        case COMPONENT:
            printComponent();
            break;
        default:
            break;
        }

        out.println(DIVIDER);
    }

    public static void clearTerminal() {
        out.println("\033[H\033[2J");
    }

    public static void printMainMenu() {
        out.println(LOGO);
        out.println("Welcome to BigPP!");
        out.println("What would you like to do?");
        out.println("PC viewer");
        out.println("PC tutorial");
        out.println("exit");
    }

    public static void printViewer() {
        out.println("PC viewer");
        PCList.printPcList(out);
        out.println("What would you like to do?");
        out.println("View PC");
        out.println("Build PC");
        out.println("back");
        out.println("exit");
    }

    public static void printBuilder() {
        out.println("PC builder");
        out.println("What would you like to do?");
        out.println("Add component");
        out.println("Remove component");
        out.println("View PC");
        out.println("back");
        out.println("exit");
    }

    public static void printTutorial() {
        out.println("PC tutorial");
        out.println("What would you like to do?");
        out.println("View tutorial");
        out.println("back");
        out.println("exit");
    }

    public static void printComponent() {
        out.println("Component");
        out.println("What would you like to do?");
        out.println("View component");
        out.println("back");
        out.println("exit");
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
