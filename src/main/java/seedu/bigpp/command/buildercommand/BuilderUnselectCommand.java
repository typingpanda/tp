package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.builderexceptions.BuilderIncorrectComponentException;
import seedu.bigpp.exceptions.builderexceptions.BuilderMissingComponentException;
import seedu.bigpp.exceptions.builderexceptions.BuilderNullComponentException;
import seedu.bigpp.pc.PCList;
import seedu.bigpp.ui.UI;

public class BuilderUnselectCommand extends Command {

    public BuilderUnselectCommand(String arguments) {
        setArguments(arguments);
    }

    /**
     * Change the Component of the PC that the builder is working on
     * @return Added Component message
     */
    @Override
    public String executeCommand(DataStorage dataStorage)
            throws BuilderIncorrectComponentException, BuilderMissingComponentException, BuilderNullComponentException {

        String componentTypeString = getArguments();
        // throw exception if no component is selected .eg. "Unselect"
        if (componentTypeString.equals("")) {
            throw new BuilderMissingComponentException();
        }

        componentTypeString = componentTypeString.toLowerCase();
        componentTypeString = componentTypeString.trim();

        // throw exception if component type is not valid .eg. "unselect jfk"
        if (!dataStorage.stringToComponentListMap.containsKey(componentTypeString)) {
            throw new BuilderIncorrectComponentException();
        }

        int pcIndex = UI.builderMenu.getPCIndex();

        if (PCList.getPC(pcIndex).getComponent(componentTypeString) == null) {
            throw new BuilderNullComponentException();
        }

        PCList.getPC(pcIndex).setNullComponent(componentTypeString);

        assert PCList.getPC(pcIndex).getComponent(componentTypeString) == null : "Component should be null";

        return componentTypeString + " removed!";
    }
}
