package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.component.cpu.CPU;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.PPException;
import seedu.bigpp.ui.UI;

public class BuilderCustomCpuCommand extends Command {

    public BuilderCustomCpuCommand(String arguments) {
        super.setArguments(arguments);
    }

    @Override
    public String executeCommand(DataStorage dataStorage) throws PPException {
        String arguments = super.getArguments();
        String[] argumentList = arguments.split("\\|");

        if (argumentList.length != 9) {
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

        float price = 0;
        int cores = 0;
        int threads = 0;
        float baseClock = 0;
        float boostClock = 0;
        float power = 0;

        try {
            price = Float.parseFloat(argumentList[2]);
            cores = Integer.parseInt(argumentList[3]);
            threads = Integer.parseInt(argumentList[4]);
            baseClock = Float.parseFloat(argumentList[5]);
            boostClock = Float.parseFloat(argumentList[6]);
            power = Float.parseFloat(argumentList[7]);

            // Check if all the values are positive
            if (price < 0 || cores < 0 || threads < 0 || baseClock < 0 || boostClock < 0 || power < 0) {
                throw new PPException("price, baseClock, boostClock, power, cores and threads should be positive");
            }

        } catch (NumberFormatException e) {
            throw new PPException(
                    "price, baseClock, boostClock and power should be a float, cores and threads should be an integer");
        }

        String socket = argumentList[8].trim();
        if (socket.equals("")) {
            throw new PPException("Please enter a valid socket for the custom component");
        }

        CPU cpu = new CPU(name, brand, price, cores, threads, baseClock, boostClock, power, socket);

        dataStorage.pcList.get(UI.pcBuilderMenu.getPCIndex()).setCpu(cpu);

        return "CPU added: " + cpu.getName();
    }

}
