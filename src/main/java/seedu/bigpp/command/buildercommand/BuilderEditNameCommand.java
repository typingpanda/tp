package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.pc.PCList;
import seedu.bigpp.ui.UI;

public class BuilderEditNameCommand extends Command {

    public BuilderEditNameCommand(String arguments) {
        super.setArguments(arguments);
    }

    @Override
    public String executeCommand() {
        String name = super.getArguments();
        int pcIndex = UI.builderMenu.getPCIndex();
        PCList.getPC(pcIndex).setName(name);
        return "Current build name is now: " + name;
    }
}
