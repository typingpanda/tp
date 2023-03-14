package seedu.bigpp.command.commoncommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.ui.UI;

public class BackCommand extends Command {

    /*
     * back command to return to the previous menu. Does nothing if already in 
     * PCVieer menu
     * 
     * @return the message to be displayed to the user
     */
    @Override
    public String executeCommand() {
        switch (UI.getUiState()) {
        case PCVIEWER:
            return "Cannot go back from PCViewer";

        case PCBUILDER:
            UI.setPCViewerMode();
            return "returned to PCViewer";

        default:
            return "";
        }
    }
}
