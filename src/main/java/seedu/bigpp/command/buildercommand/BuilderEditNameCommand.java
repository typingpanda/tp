package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.pc.PCList;
import seedu.bigpp.ui.UI;

public class BuilderEditNameCommand extends Command {

    public BuilderEditNameCommand(String arguments) {
        super.setArguments(arguments);
    }

    /*
     * Change the name of the current PC that the builder is working on
     * 
     * @return the new name of the PC
     */
    @Override
    public String executeCommand() {
        String name = super.getArguments();
        if (name.equals("")) {
            return "Please enter a name for your PC";
        }
        int pcIndex = UI.builderMenu.getPCIndex();
        PCList.getPC(pcIndex).setName(name);
        return "Current build name is now: " + name;
    }
}
