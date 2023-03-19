package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.component.cpu.CPU;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.builderexceptions.BuilderInvalidCustomArgumentLengthException;
import seedu.bigpp.ui.UI;

public class BuilderCustomCpuCommand extends Command {

    public BuilderCustomCpuCommand(String arguments) {
        super.setArguments(arguments);
    }

    @Override
    public String executeCommand(DataStorage dataStorage) throws BuilderInvalidCustomArgumentLengthException {
        String arguments = super.getArguments();
        String[] argumentList = arguments.split("\\|");

        if (argumentList.length != 9) {
            throw new BuilderInvalidCustomArgumentLengthException();
        }

        String name = argumentList[0].trim();
        if (name.equals("")) {
            return "Please enter a valid name for the custom component";
        }

        String brand = argumentList[1].trim();
        if (brand.equals("")) {
            return "Please enter a valid brand for the custom component";
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
        } catch (NumberFormatException e) {
            return "price, baseClock, boostClock and power should be a float, cores and threads should be an integer";
        }

        String socket = argumentList[8].trim();
        if (socket.equals("")) {
            return "Please enter a valid socket for the custom component";
        }

        CPU cpu = new CPU(name, brand, price, cores, threads, baseClock, boostClock, power, socket);

        dataStorage.pcList.get(UI.builderMenu.getPCIndex()).setCpu(cpu);

        return "CPU added: " + cpu.getName();
    }

}
