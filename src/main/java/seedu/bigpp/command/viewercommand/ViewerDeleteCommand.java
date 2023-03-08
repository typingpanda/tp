package seedu.bigpp.command.viewercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.pc.PC;
import seedu.bigpp.pc.PCList;

public class ViewerDeleteCommand extends Command {

    public ViewerDeleteCommand(String arguments) {
        super.setArguments(arguments);
    }

    /**
     * Delete a PC of a given index from the PC list
     * @return if the index is a Prebuilt PC, inform the user that the PC of that index cannot be deleted. Or else,
     *         print the name of the PC deleted
     */
    @Override
    public String executeCommand() {
        int index = Integer.parseInt(super.getArguments()) - 1;
        PC pc = (PCList.getList()).get(index);
        if (pc.getIsPreBuilt()) {
            return "Unable to delete Prebuilt PC";
        }
        PCList.deletePC(index);
        return "Custom PC: [ " + pc.getName() + " ] has been deleted";
    }
}
