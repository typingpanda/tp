package seedu.bigpp.ui;

import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.menu.PCBuilderMenu;
import seedu.bigpp.menu.PCViewerMenu;

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Scanner;

public abstract class UI {
    public static PrintStream out = System.out;
    public static PCBuilderMenu pcBuilderMenu = null;

    public static DecimalFormat moneyDecimalFormat = new DecimalFormat("#.00");

    private static final String LOGO1 = "          _____                    _____          " + "          _____                            _____      " + "              _____          \n" + "         /\\    \\                  /\\    \\                  /\\    \\                        " + "  /\\    \\                  /\\    \\         \n" + "        /::\\    \\                /::\\    \\                /::\\    \\                       " + " /::\\    \\                /::\\    \\        \n" + "       /::::\\    \\               \\:::\\    \\              /::::\\    \\                     " + " /::::\\    \\              /::::\\    \\       \n" + "      /::::::\\    \\               \\:::\\    \\            /::::::\\    \\                    " + "/::::::\\    \\            /::::::\\    \\      \n" + "     /:::/\\:::\\    \\               \\:::\\    \\          /:::/\\:::\\    \\                 " + " /:::/\\:::\\    \\          /:::/\\:::\\    \\     \n" + "    /:::/__\\:::\\    \\               \\:::\\    \\        /:::/  \\:::\\    \\                " + "/:::/__\\:::\\    \\        /:::/__\\:::\\    \\    \n";
    private static final String LOGO2 = "   /::::\\   \\:::\\    \\              /::::\\    \\      /:::/    \\:::\\ " + "   \\              /::::\\   \\:::\\    \\      /::::\\   \\:::\\    \\   \n" + "  /::::::\\   \\:::\\    \\    ____    /::::::\\    \\    /:::/    / \\:::\\    \\            /::::::\\ " + "  \\:::\\    \\    /::::::\\   \\:::\\    \\  \n" + " /:::/\\:::\\   \\:::\\ ___\\  /\\   \\  /:::/\\:::\\    \\  /:::/    /   \\:::\\ ___\\          " + "/:::/\\:::\\   \\:::\\____\\  /:::/\\:::\\   \\:::\\____\\ \n" + "/:::/__\\:::\\   \\:::|    |/::\\   \\/:::/  \\:::\\____\\/:::/____/  ___\\:::|    |        /:::/  " + "\\:::\\   \\:::|    |/:::/  \\:::\\   \\:::|    |\n" + "\\:::\\   \\:::\\  /:::|____|\\:::\\  /:::/    \\::/    /\\:::\\    \\ /\\  /:::|____|        \\::/    " + "\\:::\\  /:::|____|\\::/    \\:::\\  /:::|____|\n" + " \\:::\\   \\:::\\/:::/    /  \\:::\\/:::/    / \\/____/  \\:::\\    /::\\ \\::/    /          " + "\\/_____/\\:::\\/:::/    /  \\/_____/\\:::\\/:::/    / \n" + "  \\:::\\   \\::::::/    /    \\::::::/    /            \\:::\\   \\:::\\ \\/____/                    " + "\\::::::/    /            \\::::::/    /  \n";
    private static final String LOGO3 = "   \\:::\\   \\::::/    /      \\::::/____/              \\:::\\   " + "\\:::\\____\\                       \\::::/    /              \\::::/    /   \n" + "    \\:::\\  /:::/    /        \\:::\\    \\               \\:::\\  /:::/    /                        " + "\\::/____/                \\::/____/    \n" + "     \\:::\\/:::/    /          \\:::\\    \\               \\:::\\/:::/    /                          " + "~~                       ~~          \n" + "      \\::::::/    /            \\:::\\    \\               \\::::::/    /                              " + "                                  \n" + "       \\::::/    /              \\:::\\____\\               \\::::/    /                               " + "                                  \n" + "        \\::/____/                \\::/    /                \\::/____/                                  " + "                                \n" + "         ~~                       \\/____/                                                              " + "                              \n" + "                                                                                                        " + "                             \n";
    private static final String DIVIDER = "===================================================";

    private static UIState uiState = UIState.PCVIEWER;

    private static PCViewerMenu pcViewerMenu = new PCViewerMenu();
    private static Scanner in = new Scanner(System.in);

    public static UIState getUiState() {
        return uiState;
    }

    public static String getInput() {
        return in.nextLine();
    }

    public static void showWelcome() {
        try {
            out.print(LOGO1);
            Thread.sleep(500);
            out.print(LOGO2);
            Thread.sleep(500);
            out.println(LOGO3);
            out.println("Welcome to BigPP!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void updateUI(boolean isInitial, DataStorage dataStorage) {
        if (!isInitial) {
            clearTerminal();
        }
        out.println(DIVIDER);

        switch (uiState) {
        case PCVIEWER:
            pcViewerMenu.printMenu(dataStorage);
            break;
        case PCBUILDER:
            pcBuilderMenu.printMenu(dataStorage);
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
        pcBuilderMenu = null;
    }

    public static void setPCBuilderMode(int pcIndex) {
        uiState = UIState.PCBUILDER;
        pcBuilderMenu = new PCBuilderMenu(pcIndex);
    }
}
