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

            if (sticks != 1 && sticks != 2 && sticks != 4) {
                throw new PPException("sticks should be 1, 2 or 4");
            }

            if (memory != 8 && memory != 16 && memory != 32 && memory != 64) {
                throw new PPException("memory should be 8, 16, 32 or 64");
            }

            if (speed != 1600 && speed != 2000 && speed != 2666 && speed != 3200 && speed != 3600) {
                throw new PPException("speed should be 1600, 2000, 2666, 3200 or 3600");
            }

            // Check if all the values are positive
            if (price < 0 || power < 0 || memory < 0 || sticks < 0 || speed < 0) {
                throw new PPException("price, power, memory, sticks, and speed should be positive");
            }

        } catch (NumberFormatException e) {
            throw new PPException(
                    "price and power should be floats, memory sticks and speed should be integers");
        }
        RAM ram = new RAM(name, brand, price, memory, sticks, speed, power);

        return dataStorage.pcList.get(UI.pcBuilderMenu.getPCIndex()).setRam(ram);
    }
}
