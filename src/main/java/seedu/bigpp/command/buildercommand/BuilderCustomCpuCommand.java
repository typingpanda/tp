package seedu.bigpp.command.buildercommand;

import seedu.bigpp.component.cpu.CPU;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.PPException;
import seedu.bigpp.ui.UI;

public class BuilderCustomCpuCommand extends BuilderCustomComponentCommand {

    public BuilderCustomCpuCommand(String arguments) {
        super(arguments);
    }

    public int getExpectedArgumentLength() {
        return 9;
    }

    public String addNewComponent(String[] argumentList, DataStorage dataStorage, String name, String brand)
            throws PPException {
        float price = 0;
        int cores = 0;
        int threads = 0;
        float baseClock = 0;
        float boostClock = 0;
        float power = 0;

        try {
            price = Float.parseFloat(argumentList[2]);
        } catch (NumberFormatException e) {
            throw new PPException(
                    "Please enter a valid price");
        }

        try {
            cores = Integer.parseInt(argumentList[3]);
        } catch (NumberFormatException e) {
            throw new PPException(
                    "Please enter a valid number of cores");
        }

        try {
            threads = Integer.parseInt(argumentList[4]);
        } catch (NumberFormatException e) {
            throw new PPException(
                    "Please enter a valid number of threads");
        }

        try {
            baseClock = Float.parseFloat(argumentList[5]);
        } catch (NumberFormatException e) {
            throw new PPException(
                    "Please enter a valid base clock");
        }

        try {
            boostClock = Float.parseFloat(argumentList[6]);
        } catch (NumberFormatException e) {
            throw new PPException(
                    "Please enter a valid boost clock");
        }

        try {
            power = Float.parseFloat(argumentList[7]);
        } catch (NumberFormatException e) {
            throw new PPException(
                    "Please enter a valid power");
        }

        if (price < 0 || cores < 0 || threads < 0 || baseClock < 0 || boostClock < 0 || power < 0) {
            throw new PPException("price, cores, threads, base clock, boost clock and power should be positive");
        }

        String socket = argumentList[8].trim();
        if (!socket.equals("LGA1200") && !socket.equals("LGA1700") && !socket.equals("AM4") && !socket.equals("AM5")) {
            throw new PPException("Please enter a valid socket for the custom component (LGA1200, LGA1700, AM4, AM5))");
        }
        CPU cpu = new CPU(name, brand, price, cores, threads, baseClock, boostClock, power, socket);

        return dataStorage.pcList.get(UI.pcBuilderMenu.getPCIndex()).setCpu(cpu);
    }
}
