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
            price = Float.parseFloat(argumentList[2]);
        } catch (NumberFormatException e) {
            throw new PPException(
                    "Please enter a valid price");
        }

        try {
            memory = Integer.parseInt(argumentList[3]);
        } catch (NumberFormatException e) {
            throw new PPException(
                    "Memory should be 8, 16, 32 or 64");
        }

        if (memory != 8 && memory != 16 && memory != 32 && memory != 64) {
            throw new PPException(
                    "Memory should be 8, 16, 32 or 64");
        }

        try {
            sticks = Integer.parseInt(argumentList[4]);
        } catch (NumberFormatException e) {
            throw new PPException(
                    "Sticks should be 1, 2 or 4");
        }

        if (sticks != 1 && sticks != 2 && sticks != 4) {
            throw new PPException(
                    "Sticks should be 1, 2 or 4");
        }

        try {
            speed = Integer.parseInt(argumentList[5]);
        } catch (NumberFormatException e) {
            throw new PPException(
                    "Speed should be 1600, 2000, 2666, 3200 or 3600");
        }

        if (speed != 1600 && speed != 2000 && speed != 2666 && speed != 3200 && speed != 3600) {
            throw new PPException(
                    "Speed should be 1600, 2000, 2666, 3200 or 3600");
        }

        try {
            power = Float.parseFloat(argumentList[6]);
        } catch (NumberFormatException e) {
            throw new PPException(
                    "Please enter a valid power");
        }

        if (price < 0 || memory < 0 || sticks < 0 || speed < 0 || power < 0) {
            throw new PPException("price, memory, sticks, speed and power should be positive");
        }

        RAM ram = new RAM(name, brand, price, memory, sticks, speed, power);

        return dataStorage.pcList.get(UI.pcBuilderMenu.getPCIndex()).setRam(ram);
    }
}
