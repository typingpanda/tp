package seedu.bigpp.command.viewercommand.filtercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.PPException;
import seedu.bigpp.pc.PCList;

public class ViewerFilterIsBuiltCommand extends Command {

    public ViewerFilterIsBuiltCommand(String arguments) {
        super.setArguments(arguments);
    }

    /**
     * Filter PC List by whether it is built or not
     * @return inform the user that the filter has been applied
     */
    @Override
    public String executeCommand(DataStorage dataStorage) throws PPException {
        // throw exception if no index is selected
        if (PCList.getIsFilter()){
            return "Please clear filter before creating a new one";
        }
        String argument = super.getArguments();
        if (argument.equals("")) {
            throw new PPException("Please enter either complete or incomplete");
        }
        if (argument.equals("complete") || argument.equals("incomplete")) {
            PCList.setFilterTrue();
            PCList.setFilterType("built");
            PCList.setArguments(argument);
        }
        else {
            return "Please enter either complete or incomplete";
        }
        return "PC List has been updated with the following filter: built " + argument;
    }
}
