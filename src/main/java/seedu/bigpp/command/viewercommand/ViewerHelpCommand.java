package seedu.bigpp.command.viewercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.datastorage.DataStorage;

public class ViewerHelpCommand extends Command {
    private static final String HELP = "Here are the list of valid commands: \n"
            + "add <name> : Add a new PC of a given name \n"
            + "delete <index> :  Delete the PC of a given index \n"
            + "edit <index> : Edit the PC of a given index \n"
            + "view <index> : Display all the components of the PC of a given index \n"
            + "filter -name <PC_NAME> : Filter PC List by a given name\n"
            + "filter -price /from <PC_START_PRICE> /to <PC_END_PRICE> : Filter PC List by a given price range\n"
            + "filter -built <PC_ISCOMPLETE> : Filter PC List by a built of complete or incomplete\n"
            + "filter -clear : Clear all filters that were applied previously\n";


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
