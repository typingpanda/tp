package seedu.bigpp.menu;

import static seedu.bigpp.ui.UI.out;

import seedu.bigpp.datastorage.DataStorage;

public class PCViewerMenu extends Menu {
    public void printMenu(DataStorage dataStorage) {
        out.println("\033[34;1m" +"PC VIEWER\033[34;0m");
        dataStorage.pcList.printPcList();
        out.println("\033[34;1mWhat would you like to do?\033[34;0m");
    }
}
