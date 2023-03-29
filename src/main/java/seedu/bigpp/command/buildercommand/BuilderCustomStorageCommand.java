package seedu.bigpp.command.buildercommand;

import seedu.bigpp.component.storage.Storage;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.PPException;
import seedu.bigpp.ui.UI;

public class BuilderCustomStorageCommand extends BuilderCustomComponentCommand {

    public BuilderCustomStorageCommand(String arguments) {
        super(arguments);
    }

    public int getExpectedArgumentLength() {
        return 6;
    }

    public String addNewComponent(String[] argumentList, DataStorage dataStorage, String name, String brand)
            throws PPException {
        float price = 0;
        float power = 0;
        int size = 0;

        try {
            price = Float.parseFloat(argumentList[2]);
            power = Float.parseFloat(argumentList[3]);
            size = Integer.parseInt(argumentList[5]);

            // Check if all the values are positive
            if (price < 0 || power < 0 || size < 0) {
                throw new PPException("price, power and size should be positive");
            }

        } catch (NumberFormatException e) {
            throw new PPException(
                    "price and power should be floats, size should be an integer");
        }

        String type = argumentList[1].trim();
        if (type.equals("")) {
            throw new PPException("Please enter a valid type for the custom component");
        }
        Storage storage = new Storage(name, brand, price, type, size, power);

        return dataStorage.pcList.get(UI.pcBuilderMenu.getPCIndex()).setStorage(storage);
    }
}
