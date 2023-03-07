package seedu.bigpp.command.viewercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.pc.PC;
import seedu.bigpp.pc.PCList;

public class ViewerAddCommand extends Command {

    public ViewerAddCommand(String arguments) {
        super.setArguments(arguments);
    }
    @Override
    public String executeCommand() {
        String name = super.getArguments();
        PC pc = new PC(name, false);
        PCList.addPC(pc);
        return "I have created the PC with the following name: " + name;
    }
}
