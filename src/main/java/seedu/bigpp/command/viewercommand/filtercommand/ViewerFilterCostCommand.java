package seedu.bigpp.command.viewercommand.filtercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.PPException;
import seedu.bigpp.pc.PCList;

public class ViewerFilterCostCommand extends Command {

    public ViewerFilterCostCommand(String arguments) {
        super.setArguments(arguments);
    }

    /**
     * Filter PC List by cost of a given value.
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
            throw new PPException("Please input a value");
        }
        if (argument.matches(".*\\D.*")) {
            throw new PPException("Please enter an integer");
        }
        int cost = Integer.parseInt(argument);
        if (cost < 0) {
            throw new PPException("Please enter a valid index");
        }
        PCList.setFilterTrue();
        PCList.setFilterType("cost");
        PCList.setArguments(argument);
        return "List has been filtered by cost of " + cost;
    }
}
