package seedu.bigpp.command.commoncommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.datastorage.DataStorage;

public class UnrecognizedCommand extends Command {
    @Override
    public String executeCommand(DataStorage dataStorage) {
        return "Unrecognised command.";
    }
}
