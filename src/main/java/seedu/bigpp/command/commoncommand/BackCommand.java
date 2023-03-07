package seedu.bigpp.command.commoncommand;

import seedu.bigpp.command.Command;

import seedu.bigpp.ui.UI;

public class BackCommand extends Command {

    @Override
    public String executeCommand() {
        switch (UI.getUiState()) {
        case MAIN_MENU:
            return "cannot go back from main menu";
        case VIEWER:
            UI.setMainMenuMode();
            return "returned to main menu";
        case BUILDER:
            UI.setViewerMode();
            return "returned to viewer";
        case TUTORIAL:
            UI.setMainMenuMode();
            return "returned to main menu";
        case COMPONENT:
            UI.setBuilderMode();
            return "returned to builder";
        default:
            return "";
        }
    }
}
