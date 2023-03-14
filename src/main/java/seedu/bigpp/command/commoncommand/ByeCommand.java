package seedu.bigpp.command.commoncommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.datastorage.DataStorage;

public class ByeCommand extends Command {

    @Override
    public String executeCommand(DataStorage dataStorage) {

        return "Bye. Hope to see you again soon!";
    }
}
