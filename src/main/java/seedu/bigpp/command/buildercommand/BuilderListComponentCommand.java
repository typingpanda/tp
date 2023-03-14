package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.component.Component;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.PPException;
import seedu.bigpp.exceptions.builderexceptions.BuilderMissingComponentException;
import seedu.bigpp.exceptions.builderexceptions.BuilderIncorrectComponentException;
import static seedu.bigpp.datastorage.DataStorage.stringToComponentListMap;

import java.util.ArrayList;

public class BuilderListComponentCommand extends Command {

    public BuilderListComponentCommand(String arguments) {
        setArguments(arguments);
    }

    /**
     * Change the budget of the current PC that the builder is working on
     *
     * @return the new budget of the PC
     */
    @Override
    public String executeCommand() throws PPException {
        String componentTypeString = getArguments();
        if (componentTypeString.equals("")) {
            throw new BuilderMissingComponentException();
        }
        if (!stringToComponentListMap.containsKey(componentTypeString)) {
            throw new BuilderIncorrectComponentException();
        }

        String outputString = "Here are all available components of type '" + componentTypeString + "': \n";
        ArrayList<Component> componentList = DataStorage.stringToComponentListMap.get(componentTypeString);
        int componentNumber = 1;
        for (Component component : componentList) {
            outputString += componentNumber + "." + "\n" + component.toString() + "\n" + "================\n";
            componentNumber += 1;
        }
        return outputString;
    }
}



