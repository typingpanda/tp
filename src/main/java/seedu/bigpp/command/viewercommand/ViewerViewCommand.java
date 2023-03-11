package seedu.bigpp.command.viewercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.pc.PC;
import seedu.bigpp.pc.PCList;

public class ViewerViewCommand extends Command {

    public ViewerViewCommand(String arguments) {
        super.setArguments(arguments);
    }

    /**
     *
     */
    @Override
    public String executeCommand() {
        String index = super.getArguments();
        PC pc = (PCList.getList()).get(Integer.parseInt(index) - 1);
        return pc.printComponents();
    }
}
