package seedu.bigpp.command.viewercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.exceptions.PPException;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.pc.PC;
import seedu.bigpp.pc.PCList;

public class ViewerAddCommand extends Command {

    public ViewerAddCommand(String arguments) {
        super.setArguments(arguments);
    }

    /**
     * Add new PC of a given name to the PC list
     * @return the name of the PC created
     */
    @Override
    public String executeCommand(DataStorage dataStorage) throws PPException {
        if (PCList.getIsFilter()){
            return "Please clear filter before adding a new pc";
        }
        String name = super.getArguments();
        // throw exception if no name is provided
        if (name.equals("")) {
            throw new PPException("Please enter a name");
        }
        PC pc = new PC(name, false);
        dataStorage.pcList.add(pc);
        return "Custom PC: [ " + name + " ] has been created";
    }
}
