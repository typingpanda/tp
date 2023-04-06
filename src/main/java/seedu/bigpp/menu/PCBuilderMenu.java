package seedu.bigpp.menu;

import seedu.bigpp.datastorage.DataStorage;

import static seedu.bigpp.ui.UI.out;

public class PCBuilderMenu extends Menu {

    private int pcIndex;

    public PCBuilderMenu(int pcIndex) {
        this.pcIndex = pcIndex;
    }

    public int getPCIndex() {
        return pcIndex;
    }

    public void printMenu(DataStorage dataStorage) {
        out.println("\033[95;1mPC builder\033[0;0m");
        out.println(dataStorage.pcList.get(pcIndex).viewComponents());
        out.println("\033[95;1mWhat would you like to do?\033[0;0m");
    }
}
