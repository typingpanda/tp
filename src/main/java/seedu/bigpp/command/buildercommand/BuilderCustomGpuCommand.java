package seedu.bigpp.command.buildercommand;

import seedu.bigpp.component.gpu.GPU;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.PPException;
import seedu.bigpp.ui.UI;

public class BuilderCustomGpuCommand extends BuilderCustomComponentCommand {

    public BuilderCustomGpuCommand(String arguments) {
        super(arguments);
    }

    public int getExpectedArgumentLength() {
        return 5;
    }

    public String addNewComponent(String[] argumentList, DataStorage dataStorage, String name, String brand)
            throws PPException {
        float price = 0;
        float power = 0;

        try {
            price = Float.parseFloat(argumentList[2]);
            power = Float.parseFloat(argumentList[3]);

            // Check if all the values are positive
            if (price < 0 ||  power < 0) {
                throw new PPException("price and power should be positive");
            }

        } catch (NumberFormatException e) {
            throw new PPException(
                    "price and power should be floats");
        }

        String size = argumentList[4].trim();
        if (size.equals("")) {
            throw new PPException("Please enter a valid size for the custom component");
        }
        GPU gpu = new GPU(name, brand, price, power, size);

        dataStorage.pcList.get(UI.pcBuilderMenu.getPCIndex()).setGpu(gpu);

        return "GPU added: " + gpu.getName();
    }
}
