package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.PPException;

public abstract class BuilderCustomComponentCommand extends Command {

    public BuilderCustomComponentCommand(String arguments) {
        super.setArguments(arguments);
    }

    public abstract int getExpectedArgumentLength();
    public abstract String addNewComponent(String[] argumentList, DataStorage dataStorage, String name, String brand)
            throws PPException;
    @Override
    public String executeCommand(DataStorage dataStorage) throws PPException {
        String arguments = super.getArguments();
        String[] argumentList = arguments.split("\\|");
        if (argumentList.length != getExpectedArgumentLength()) {
            throw new PPException("Please enter a valid number of arguments for the custom component");
        }

        String name = argumentList[0].trim();
        if (name.equals("")) {
            throw new PPException("Please enter a valid name for the custom component");
        }

        String brand = argumentList[1].trim();
        if (brand.equals("")) {
            throw new PPException("Please enter a valid brand for the custom component");
        }

        return addNewComponent(argumentList, dataStorage, name, brand);
    }

}

