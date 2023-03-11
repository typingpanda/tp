package seedu.bigpp.ui;

import seedu.bigpp.menu.PCViewerMenu;
import seedu.bigpp.menu.PCBuilderMenu;
import java.io.PrintStream;
import java.util.Scanner;

public abstract class UI {
    public static PrintStream out = System.out;
    public static PCBuilderMenu builderMenu = null;
    
    private static final String LOGO = "add logo here";
    private static final String DIVIDER = "===================================================";
    
    private static UIState uiState = UIState.PCVIEWER;
    
    private static PCViewerMenu viewerMenu = new PCViewerMenu();
    private static Scanner in = new Scanner(System.in);
    

    public static UIState getUiState() {
        return uiState;
    }

    public static String getInput() {
        return in.nextLine();
    }

    public static void showWelcome() {
        out.println(LOGO);
        out.println("Welcome to BigPP!");
    }

    public static void updateUI(boolean isInitial) {
        if (!isInitial) {
            clearTerminal();
        }
        out.println(DIVIDER);

        switch (uiState) {
        case PCVIEWER:
            viewerMenu.printMenu();
            break;
        case PCBUILDER:
            builderMenu.printMenu();
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

    public static void setPCViewerMode() {
        uiState = UIState.PCVIEWER;
        builderMenu = null;
    }

    public static void setPCBuilderMode(int pcIndex) {
        uiState = UIState.PCBUILDER;
        builderMenu = new PCBuilderMenu(pcIndex);
    }
}
