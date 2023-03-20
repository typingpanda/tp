package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.component.cpu.CPU;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.PPIndexOutOfBoundsException;
import seedu.bigpp.exceptions.builderexceptions.BuilderInvalidTypeException;
import seedu.bigpp.exceptions.builderexceptions.BuilderMissingIndexException;

public class BuilderCompareCpuCommand extends Command {

    public BuilderCompareCpuCommand(String arguments) {
        setArguments(arguments);
    }

    /**
     * Compare all the specifications between 2 selected cpu components
     * @return the comparison table of the 2 components
     */
    @Override
    public String executeCommand(DataStorage dataStorage)
            throws BuilderMissingIndexException, BuilderInvalidTypeException, PPIndexOutOfBoundsException {
        String inputString = getArguments();

        // throw exception if command does not contain "&"
        if (!inputString.contains("&")) {
            throw new BuilderMissingIndexException();
        }

        String[] componentIndexes = inputString.split("&", 2);
        String firstComponent = componentIndexes[0].trim();
        String secondComponent = componentIndexes[1].trim();

        //check if firstComponent and secondComponent is a number
        int firstComponentIndex;
        int secondComponentIndex;
        try {
            firstComponentIndex = Integer.parseInt(firstComponent) - 1;
            secondComponentIndex = Integer.parseInt(secondComponent) - 1;
        } catch (NumberFormatException e) {
            throw new BuilderInvalidTypeException();
        }

        //check if index is out of bounds
        if (firstComponentIndex < 0 || firstComponentIndex >= dataStorage.stringToComponentListMap.get("cpu").size()) {
            throw new PPIndexOutOfBoundsException();
        }
        if (secondComponentIndex < 0 || secondComponentIndex >= dataStorage.stringToComponentListMap.get("cpu")
                .size()) {
            throw new PPIndexOutOfBoundsException();
        }

        //get the 2 components
        CPU firstComponentObject = (CPU) dataStorage.stringToComponentListMap.get("cpu").get(firstComponentIndex);
        CPU secondComponentObject = (CPU) dataStorage.stringToComponentListMap.get("cpu").get(secondComponentIndex);

        //format the comparison table in outputString
        String outputString = String.format("%86s", "_".repeat(86));
        outputString += String.format("%n|%-12s|%-35s|%-35s|", "NAME", firstComponentObject.getName(),
                secondComponentObject.getName());
        outputString += String.format("%n|%-12s|%-35s|%-35s|", "-".repeat(12), "-".repeat(35), "-".repeat(35));
        outputString += String.format("%n|%-12s|%-35s|%-35s|", "PRICE", "$" + firstComponentObject.getPrice(),
                "$" + secondComponentObject.getPrice());
        outputString += String.format("%n|%-12s|%-35s|%-35s|", "SOCKET", firstComponentObject.getSocket(),
                secondComponentObject.getSocket());
        outputString += String.format("%n|%-12s|%-35s|%-35s|", "CORES", firstComponentObject.getCores(),
                secondComponentObject.getCores());
        outputString += String.format("%n|%-12s|%-35s|%-35s|", "THREADS", firstComponentObject.getThreads(),
                secondComponentObject.getThreads());
        outputString += String.format("%n|%-12s|%-35s|%-35s|", "BASE CLOCK",
                firstComponentObject.getBaseClock() + "GHz", secondComponentObject.getBaseClock() + "GHz");
        outputString += String.format("%n|%-12s|%-35s|%-35s|", "BOOST CLOCK",
                firstComponentObject.getBoostClock() + "GHz", secondComponentObject.getBoostClock() + "GHz");
        outputString += String.format("%n|%-12s|%-35s|%-35s|", "POWER", firstComponentObject.getPower() + "W",
                secondComponentObject.getPower() + "W");
        outputString += String.format("%n%-86s", "_".repeat(86));
        return outputString;
    }
}
