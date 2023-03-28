package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.datastorage.DataStorage;

public class BuilderHelpCommand extends Command {
    private static final String HELP = "Here are the list of valid commands: \n"
            + "list <component> - List all components of a certain type\n"
            + "name <new_name> - Change the name of the PC currently being edited to <new_name>\n"
            + "budget <new_budget> - Change the budget of the PC currently being edited to <new_budget> \n"
            + "select <component_type> <index> -  Add the component of type <component_type> with index <index> "
            + "to the PC currently being edited \n"
            + "info <component_type> - View all the specifications of the component of type "
            + "<component_type> currently selected for the build\n"
            + "unselect <component_type> - Remove the component of type <component_type> from the PC currently being"
            + "edited\n"
            + "custom <component_type> <component_specifications...> - Creates a custom component of type "
            + "<component_type> with all the <component_specifications> and adds it to the list of components"
            + " of that type\n"
            + "compare <component_type> <index_1>&<index_2> Compares all the specifications between the components of"
            + "type <component_type> with indices <index_1> and <index_2>\n";


    /**
     * Help command to view the list of valid commands when in Builder mode
     * @return the list of valid commands
     */
    @Override
    public String executeCommand(DataStorage dataStorage) {
        return getHelp();
    }

    public static String getHelp() {
        return HELP;
    }
}

