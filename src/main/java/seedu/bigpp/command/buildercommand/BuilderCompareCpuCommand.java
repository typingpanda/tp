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

        // throw exception if command does not contain & eg. "compare cpu 1"
        if (!inputString.contains("&")) {
            throw new BuilderMissingIndexException();
        }

        String[] componentIndexes = inputString.split("&", 2);
        String firstComponent = componentIndexes[0].trim();

        //check if firstComponent is a number
        if (firstComponent.matches(".*\\D.*")) {
            throw new BuilderInvalidTypeException();
        }
        int firstComponentIndex = Integer.parseInt(firstComponent) - 1;

        //check if secondComponent is a number
        String secondComponent = componentIndexes[1].trim();
        if (secondComponent.matches(".*\\D.*")) {
            throw new BuilderInvalidTypeException();
        }
        int secondComponentIndex = Integer.parseInt(secondComponent) - 1;

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
        String outputString = String.format("%n|%-12s|%-20s|%-20s|", "____________", "____________________", "____________________");
        outputString += String.format("|%-12s|%-20s|%-20s|", "NAME", firstComponentObject.getName(),
                secondComponentObject.getName());
        outputString += String.format("%n|%-12s|%-20s|%-20s|", "------------", "--------------------", "--------------------");
        outputString += String.format("%n|%-12s|%-20s|%-20s|", "PRICE", "$" + firstComponentObject.getPrice(),
                "$" + secondComponentObject.getPrice());
        outputString += String.format("%n|%-12s|%-20s|%-20s|", "SOCKET", firstComponentObject.getSocket(),
                secondComponentObject.getSocket());
        outputString += String.format("%n|%-12s|%-20s|%-20s|", "CORES", firstComponentObject.getCores(),
                secondComponentObject.getCores());
        outputString += String.format("%n|%-12s|%-20s|%-20s|", "THREADS", firstComponentObject.getThreads(),
                secondComponentObject.getThreads());
        outputString += String.format("%n|%-12s|%-20s|%-20s|", "BASE CLOCK", firstComponentObject.getBaseClock() + "GHz", secondComponentObject.getBaseClock()+ "GHz");
        outputString += String.format("%n|%-12s|%-20s|%-20s|", "BOOST CLOCK", firstComponentObject.getBoostClock()+ "GHz", secondComponentObject.getBoostClock()+ "GHz");
        outputString += String.format("%n|%-12s|%-20s|%-20s|", "POWER", firstComponentObject.getPower()+ "W", secondComponentObject.getPower()+ "W");
        outputString += String.format("%n|%-12s|%-20s|%-20s|", "------------", "--------------------", "--------------------");
        return outputString;
    }
}
