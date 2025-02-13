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
        } catch (NumberFormatException e) {
            throw new PPException(
                    "Please enter a valid price");
        }

        try {
            size = Integer.parseInt(argumentList[4]);
        } catch (NumberFormatException e) {
            throw new PPException(
                    "Size should be 512, 1024, 2048 or 4096");
        }

        if (size != 512 && size != 1024 && size != 2048 && size != 4096) {
            throw new PPException(
                    "Size should be 512, 1024, 2048 or 4096");
        }

        try {
            power = Float.parseFloat(argumentList[5]);
        } catch (NumberFormatException e) {
            throw new PPException(
                    "Please enter a valid power");
        }

        // Check if all the values are positive
        if (price < 0 || power < 0 || size < 0) {
            throw new PPException("price, power and size should be positive");
        }

        String type = argumentList[3].trim();
        if (!type.equals("ssd") && !type.equals("hdd")) {
            throw new PPException("Please enter a valid type for the custom component (ssd, hdd)");
        }
        Storage storage = new Storage(name, brand, price, type, size, power);

        return dataStorage.pcList.get(UI.pcBuilderMenu.getPCIndex()).setStorage(storage);
    }
}
