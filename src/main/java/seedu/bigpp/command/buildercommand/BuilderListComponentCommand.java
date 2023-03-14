package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.component.Component;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.builderexceptions.BuilderMissingListException;
import seedu.bigpp.exceptions.builderexceptions.BuilderIncorrectComponentException;

import java.util.ArrayList;

public class BuilderListComponentCommand extends Command {

    public BuilderListComponentCommand(String arguments) {
        setArguments(arguments);
    }

    /**
     * Change the budget of the current PC that the builder is working on
     * @return the new budget of the PC
     */
    @Override
    public String executeCommand(DataStorage dataStorage) throws BuilderMissingListException,
            BuilderIncorrectComponentException {
        String componentTypeString = getArguments();

        //throw exception if no component type is specified eg. "list"
        if (componentTypeString.equals("")) {
            throw new BuilderMissingListException();
        }

        componentTypeString = componentTypeString.toLowerCase();

        //throw exception if component type is not valid eg. "list jfk"
        if (!dataStorage.stringToComponentListMap.containsKey(componentTypeString)) {
            throw new BuilderIncorrectComponentException();
        }

        String outputString = "Here are all available components of type '" + componentTypeString + "': \n";
        ArrayList<Component> componentList = dataStorage.stringToComponentListMap.get(componentTypeString);
        int componentNumber = 1;
        for (Component component : componentList) {
            outputString += componentNumber + "." + "\n" + component.toString() + "\n" + "================\n";
            componentNumber += 1;
        }
        return outputString;
    }
}
