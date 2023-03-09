package seedu.bigpp.ui;

import seedu.bigpp.menu.PCViewerMenu;
import seedu.bigpp.menu.PCBuilderMenu;
import seedu.bigpp.ui.UIState;
import seedu.bigpp.pc.PC;
import java.io.PrintStream;
import java.util.Scanner;

public abstract class UI {

    public static final String LOGO = "add logo here";
    private static final String DIVIDER = "===================================================";

    private static final Scanner in = new Scanner(System.in);
    public static final PrintStream OUT = System.out;

    private static UIState uiState = UIState.PCVIEWER;

    private static PCViewerMenu viewerMenu = new PCViewerMenu();
    private static PCBuilderMenu builderMenu = null;

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
        case PCVIEWER:
            viewerMenu.printMenu();
            break;
        case PCBUILDER:
            builderMenu.printMenu();
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

    public static void setPCViewerMode() {
        uiState = UIState.PCVIEWER;
        builderMenu = null;
    }

    public static void setPCBuilderMode(PC pc) {
        uiState = UIState.PCBUILDER;
        builderMenu = new PCBuilderMenu(pc);
    }
}
