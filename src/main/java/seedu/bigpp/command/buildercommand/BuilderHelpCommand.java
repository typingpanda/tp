package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.datastorage.DataStorage;

public class BuilderHelpCommand extends Command {
    private static final String HELP = "Here are the list of valid commands: \n"
            + String.format("%78s", "_".repeat(78))
            + String.format("%n|%-25s|%-50s|", " Command Type", " Command Usage")
            + String.format("%n|%-25s|%-50s|", "-".repeat(25), "-".repeat(50))
            + String.format("%n|%-25s|%-50s|"," List Component", " list COMPONENT_TYPE [-COMPONENT_FLAG lIST_FLAG]")
            + String.format("%n|%-25s|%-50s|"," Select Component", " select COMPONENT_TYPE COMPONENT_INDEX")
            + String.format("%n|%-25s|%-50s|", " Unselect Component", " unselect COMPONENT_TYPE")
            + String.format("%n|%-25s|%-50s|", " Compare Components", " compare COMPONENT_TYPE INDEX_1 & INDEX_2")
            + String.format("%n|%-25s|%-50s|", " Change Budget", " budget POSITIVE_INTEGER")
            + String.format("%n|%-25s|%-50s|", " Change PC Name", " name PC_NAME")
            + String.format("%n|%-25s|%-50s|", " Create Custom Component", " custom COMPONENT_TYPE SPEC1|SPEC_2|...")
            + String.format("%n|%-25s|%-50s|", " Back Command", " back")
            + String.format("%n|%-25s|%-50s|", " Exit program", " bye")
            + String.format("%n%78s", "-".repeat(78))
            + "\nFor more detailed documentation on commands, please refer to our user guide!\n";
//            + String.format("%n|%-25s|%-50s|"," select COMPONENT_TYPE COMPONENT_INDEX", " Adds the component of type COMPONENT_TYPE with index COMPONENT_INDEX to the PC")
//            + String.format("%n|%-25s|%-50s|", " unselect COMPONENT_TYPE", " Removes the component of type COMPONENT_TYPE from the PC")
//            + String.format("%n|%-25s|%-50s|", " compare COMPONENT_TYPE INDEX_1 & INDEX_2", " Compares all the specifications between the components of type COMPONENT_TYPE with indices INDEX_1 and INDEX_2")
//            + String.format("%n|%-25s|%-50s|", " budget POSITIVE_INTEGER", " Changes the budget of the PC to POSITIVE_INTEGER")
//            + String.format("%n|%-25s|%-50s|", " name PC_NAME", " Changes the name of the PC to PC_NAME")
//            + String.format("%n|%-25s|%-50s|", " custom COMPONENT_TYPE SPEC1|SPEC_2|...", " Creates a custom component of type COMPONENT_TYPE with all the SPECs and adds it to the list of components of that type")
//            + String.format("%n|%-25s|%-50s|", " back", " Exits Builder mode and returns to Viewer mode")

//            + "list <component> - List all components of a certain type\n"
//            + "name <new_name> - Change the name of the PC currently being edited to <new_name>\n"
//            + "budget <new_budget> - Change the budget of the PC currently being edited to <new_budget> \n"
//            + "select <component_type> <index> -  Add the component of type <component_type> with index <index> "
//            + "to the PC currently being edited \n"
//            + "info <component_type> - View all the specifications of the component of type "
//            + "<component_type> currently selected for the build\n"
//            + "unselect <component_type> - Remove the component of type <component_type> from the PC currently being"
//            + "edited\n"
//            + "custom <component_type> <component_specifications...> - Creates a custom component of type "
//            + "<component_type> with all the <component_specifications> and adds it to the list of components"
//            + " of that type\n"
//            + "compare <component_type> <index_1>&<index_2> Compares all the specifications between the components of"
//            + "type <component_type> with indices <index_1> and <index_2>\n";


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

