package seedu.bigpp.command.viewercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.datastorage.DataStorage;

public class ViewerHelpCommand extends Command {
    private static final String HELP = "Here are the list of valid commands: \n"
            + "Add <name> - Add a new PC of a given name \n"
            + "Delete <index> -  Delete the PC of a given index \n"
            + "Edit <index> - Edit the PC of a given index \n"
            + "View <index> - Display all the components of the PC of a given index \n";

    /**
     * Help command to view the list of valid commands
     * @return the list of valid commands
     */
    @Override
    public String executeCommand(DataStorage dataStorage) {
        return getHelp();
    }

    private static String getHelp() {
        return HELP;
    }
}
