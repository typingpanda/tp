package seedu.bigpp.command.buildercommand;

import seedu.bigpp.component.psu.PSU;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.PPException;
import seedu.bigpp.pc.FormFactorEnum;
import seedu.bigpp.ui.UI;

public class BuilderCustomPsuCommand extends BuilderCustomComponentCommand {

    public BuilderCustomPsuCommand(String arguments) {
        super(arguments);
    }

    public int getExpectedArgumentLength() {
        return 6;
    }

    public String addNewComponent(String[] argumentList, DataStorage dataStorage, String name, String brand)
            throws PPException {
        float price = 0;
        float power = 0;

        try {
            price = Float.parseFloat(argumentList[5]);
            power = Float.parseFloat(argumentList[4]);

            // Check if all the values are positive
            if (price < 0 || power < 0) {
                throw new PPException("price and power should be positive");
            }

        } catch (NumberFormatException e) {
            throw new PPException(
                    "price and power should be floats");
        }

        String efficiency = argumentList[2].trim();
        String formFactor = argumentList[3].trim().toLowerCase();
        if (efficiency.equals("")) {
            throw new PPException("Please enter a efficiency for the custom component");
        }
        if (FormFactorEnum.isFormFactor(formFactor) == false) {
            throw new PPException("Please enter a valid formfactor for the custom component (mini, micro, atx)");
        }
        PSU psu = new PSU(name, price, brand, efficiency, formFactor, power);

        return dataStorage.pcList.get(UI.pcBuilderMenu.getPCIndex()).setPsu(psu);
    }
}
