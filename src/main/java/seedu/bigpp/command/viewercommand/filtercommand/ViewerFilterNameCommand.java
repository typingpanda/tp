package seedu.bigpp.command.viewercommand.filtercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.PPException;
import seedu.bigpp.pc.PCList;

public class ViewerFilterNameCommand extends Command {

    public ViewerFilterNameCommand(String arguments) {
        super.setArguments(arguments);
    }

    /**
     * Filter PC list by a given name
     * @return inform the user that the filter has been applied
     */
    @Override
    public String executeCommand(DataStorage dataStorage) throws PPException {
        if (PCList.getIsFilter()){
            return "Please clear filter before creating a new one";
        }
        String name = super.getArguments();
        // throw exception if no name is provided
        if (name.equals("")) {
            throw new PPException("Please enter a name");
        }
        PCList.setFilterTrue();
        PCList.setFilterType("name");
        PCList.setArguments(name);
        return "PC List has been updated with the following filter: name " + name;
    }
}
