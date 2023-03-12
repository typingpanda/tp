package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.component.Component;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.pc.PCList;
import seedu.bigpp.ui.UI;

import javax.xml.crypto.Data;
import java.util.Map;
import java.util.ArrayList;

public class BuilderListComponentCommand<T> extends Command {

    public BuilderListComponentCommand(String arguments) {
        setArguments(arguments);
    }

    /*
     * Change the budget of the current PC that the builder is working on
     *
     * @return the new budget of the PC
     */
    @Override
    public String executeCommand() {
        String componentTypeString = getArguments();
        String outputString = "Here are all available components of type \'" + componentTypeString + "\': \n";
        ArrayList<Component> componentList = DataStorage.stringToComponentListMap.get(componentTypeString);
        int componentNumber = 1;
        for (Component component : componentList) {
            outputString += componentNumber + "." + "\n" + component.toString() + "\n" + "================\n";
            componentNumber += 1;
        }
        return outputString;
    }
}



