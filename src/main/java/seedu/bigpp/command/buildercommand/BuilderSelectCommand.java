package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.component.Component;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.PPIndexOutOfBoundsException;
import seedu.bigpp.exceptions.builderexceptions.BuilderIncorrectComponentException;
import seedu.bigpp.exceptions.builderexceptions.BuilderMissingIndexException;
import seedu.bigpp.exceptions.builderexceptions.BuilderMissingSelectException;
import seedu.bigpp.exceptions.builderexceptions.BuilderInvalidTypeException;
import seedu.bigpp.ui.UI;
import seedu.bigpp.ui.UIState;

public class BuilderSelectCommand extends Command {

    public BuilderSelectCommand(String arguments) {
        setArguments(arguments);
    }

    /**
     * Change the Component of the PC that the builder is working on
     * @return Added Component message
     */
    @Override
    public String executeCommand(DataStorage dataStorage) throws BuilderMissingSelectException,
            BuilderIncorrectComponentException,
            BuilderMissingIndexException, PPIndexOutOfBoundsException, BuilderInvalidTypeException {
        assert UI.getUiState() == UIState.PCBUILDER : "UI state should be PCBUILDER";

        String inputString = getArguments();
        // throw exception if no component is selected eg. "select"
        if (inputString.equals("")) {
            throw new BuilderMissingSelectException();
        }

        String[] inputArray = inputString.split(" ", 2);
        String componentTypeString = inputArray[0];
        componentTypeString = componentTypeString.toLowerCase();

        // throw exception if component type is not valid eg. "select jfk"
        if (!dataStorage.stringToComponentListMap.containsKey(componentTypeString)) {
            throw new BuilderIncorrectComponentException();
        }

        // throw exception if no index is selected eg. "select cpu"
        if (inputArray.length == 1) {

            throw new BuilderMissingIndexException();
        }

        // throw exception if index is not a number eg. "select cpu a"
        if (inputArray[1].matches(".*\\D.*")) {
            throw new BuilderInvalidTypeException();
        }

        int componentIndex = Integer.parseInt(inputArray[1]) - 1;

        // throw exception if index is out of bounds eg. "select cpu 100"
        if (componentIndex < 0 || componentIndex >= dataStorage.stringToComponentListMap.get(inputArray[0]).size()) {
            throw new PPIndexOutOfBoundsException();
        }

        int pcIndex = UI.builderMenu.getPCIndex();
        Component selectedComponent = (Component) dataStorage.stringToComponentListMap.get(componentTypeString)
                .get(componentIndex);

        dataStorage.pcList.get(pcIndex).setComponent(selectedComponent);

        return componentTypeString + " added! : " + selectedComponent.getName();
    }
}
