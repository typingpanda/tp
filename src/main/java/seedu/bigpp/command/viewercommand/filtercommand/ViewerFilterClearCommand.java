package seedu.bigpp.command.viewercommand.filtercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.PPException;
import seedu.bigpp.pc.PCList;

public class ViewerFilterClearCommand extends Command {

    /**
     * Clear filter and reset to default settings
     * @return inform the user that the filter has been cleared
     */
    @Override
    public String executeCommand(DataStorage dataStorage) throws PPException {
        PCList.setFilterFalse();
        PCList.setFilterType("");
        PCList.setArguments("");
        return "Filter has been cleared";
    }
}
