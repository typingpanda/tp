package seedu.bigpp.command.commoncommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.datastorage.DataStorage;

public class UnrecognizedCommand extends Command {

    /*
     * Unrecognized command to be executed when the user inputs an invalid command
     * 
     * @return the message to be displaying an unrecognised command received
     */
    @Override
    public String executeCommand(DataStorage dataStorage) {
        return "Unrecognised command.";
    }
}
