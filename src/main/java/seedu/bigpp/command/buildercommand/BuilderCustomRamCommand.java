package seedu.bigpp.command.buildercommand;

import seedu.bigpp.component.ram.RAM;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.PPException;
import seedu.bigpp.ui.UI;

public class BuilderCustomRamCommand extends BuilderCustomComponentCommand {

    public BuilderCustomRamCommand(String arguments) {
        super(arguments);
    }

    public int getExpectedArgumentLength() {
        return 7;
    }

    public String addNewComponent(String[] argumentList, DataStorage dataStorage, String name, String brand)
            throws PPException {
        float price = 0;
        float power = 0;
        int memory = 0;
        int sticks = 0;
        int speed = 0;

        try {
            price = Float.parseFloat(argumentList[1]);
            power = Float.parseFloat(argumentList[6]);
            memory = Integer.parseInt(argumentList[2]);
            sticks = Integer.parseInt(argumentList[3]);
            speed = Integer.parseInt(argumentList[4]);

            // Check if all the values are positive
            if (price < 0 ||  power < 0 || memory < 0 || sticks < 0 || speed < 0) {
                throw new PPException("price, power, memory, sticks, and speed should be positive");
            }

        } catch (NumberFormatException e) {
            throw new PPException(
                    "price and power should be floats, memory sticks and speed should be integers");
        }
        RAM ram = new RAM(name, brand, price, memory, sticks, speed, power);

        dataStorage.pcList.get(UI.pcBuilderMenu.getPCIndex()).setRam(ram);

        return "RAM added: " + ram.getName();
    }
}
