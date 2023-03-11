package seedu.bigpp.command.viewercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.pc.PCList;
import seedu.bigpp.ui.UI;

public class ViewerEditCommand extends Command {
    public ViewerEditCommand(String arguments) {
        super.setArguments(arguments);
    }

    /**
     * Add new PC of a given name to the PC list
     * @return the name of the PC created
     */
    @Override
    public String executeCommand() {
        int pcIndex = Integer.parseInt(super.getArguments()) - 1;
        UI.setPCBuilderMode(pcIndex);
        return "Currently editing PC: " + PCList.getPC(pcIndex).getName();
    }
}
