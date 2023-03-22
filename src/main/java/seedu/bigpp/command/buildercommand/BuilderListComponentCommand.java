package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.PPException;

import seedu.bigpp.ui.UI;
import seedu.bigpp.ui.UIState;
import seedu.bigpp.component.ComponentList;
import java.util.ArrayList;
import java.util.Arrays;

public class BuilderListComponentCommand extends Command {

    public static final String NAME_FLAG = "-name";
    public static final String PRICE_FLAG = "-price";
    public static final String BRAND_FLAG = "-brand";

    public BuilderListComponentCommand(String arguments) {
        setArguments(arguments);
    }

    /**
     * Change the budget of the current PC that the builder is working on
     * @return the new budget of the PC
     */
    @Override
    public String executeCommand(DataStorage dataStorage) throws PPException {

        assert UI.getUiState() == UIState.PCBUILDER : "UI state should be PCBUILDER";

        String userInputString = getArguments();
        userInputString = userInputString.toLowerCase();

        String[] userInputStringArray = userInputString.split(" ");
        String componentType = userInputStringArray[0];

        if (userInputString.equals("")) {
            throw new PPException("Please enter a component");
        }
        if (!dataStorage.stringToComponentListMap.containsKey(componentType)) {
            throw new PPException(
                    "Please select a valid component (cpu,gpu,ram,storage,psu,motherboard,cpu-cooler,chassis)");
        }

        ComponentList<?> componentList = dataStorage.stringToComponentListMap.get(componentType);
        ArrayList<String> flagDescriptionArray = new ArrayList<String>();
        for (int i = 1; i < userInputStringArray.length; i++) {
            String flagCommand = userInputStringArray[i].trim();

            switch (flagCommand) {
            case NAME_FLAG:
                try {
                    if (userInputStringArray.length < i + 2) {
                        throw new PPException("Please enter a name");
                    }
                    String flagArgument = userInputStringArray[i + 1].trim();
                    if (isFlag(flagArgument)) {
                        throw new PPException("Please enter valid arguments for the flags");
                    }
                    componentList = ComponentList.filterByName(componentList, flagArgument);
                    flagDescriptionArray.add("name: " + flagArgument);
                    i++;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new PPException("Please enter valid arguments for the flags");
                }
                break;
            case BRAND_FLAG:
                try {
                    if (userInputStringArray.length < i + 2) {
                        throw new PPException("Please enter a brand");
                    }
                    String flagArgument = userInputStringArray[i + 1].trim();
                    if (isFlag(flagArgument)) {
                        throw new PPException("Please enter valid arguments for the flags");
                    }
                    componentList = ComponentList.filterByBrand(componentList, flagArgument);
                    flagDescriptionArray.add("brand: " + flagArgument);
                    i++;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new PPException("Please enter valid arguments for the flags");
                }
                break;
            case PRICE_FLAG:
                try {
                    if (hasFlag(Arrays.copyOfRange(userInputStringArray, i + 1, i + 4))) {
                        throw new PPException("Please enter valid arguments for the flags");
                    }
                    if (userInputStringArray.length < i + 4) {
                        throw new PPException("Please enter description for price from and price to");
                    }
                    if (!(userInputStringArray[i + 1].equals("/from") && userInputStringArray[i + 3].equals("/to"))) {
                        throw new PPException("Please use /from and /to to specify the price range.");
                    }
                    String priceFrom = userInputStringArray[i + 2];
                    String priceTo = userInputStringArray[i + 4];
                    if (priceFrom.matches(".*d.*") || priceTo.matches(".*d.*")) {
                        throw new PPException("Price must be an integer");
                    }
                    if (Float.parseFloat(priceFrom) > Float.parseFloat(priceTo)) {
                        throw new PPException("Price to must be greater than price from");
                    }
                    if (Float.parseFloat(priceFrom) <= 0 || Float.parseFloat(priceTo) <= 0) {
                        throw new PPException("Price must be a positive integer");
                    }
                    componentList = ComponentList.filterByPrice(componentList, priceFrom, priceTo);
                    flagDescriptionArray.add("price: from " + priceFrom + " to " + priceTo);
                    i += 4;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new PPException("Please enter valid arguments for the flags");
                }
                break;
            default:
                break;
            }
        }
        String outputString = "";

        if (componentList.size() == 0) {
            outputString = "There are no components of type '" + componentType + "' ";
        } else {
            outputString = "Here are all available components of type '" + componentType + "': \n";
        }

        if (flagDescriptionArray.size() > 0) {
            outputString += "meeting the following criteria: \n";
            for (String flagDescription : flagDescriptionArray) {
                outputString += flagDescription + "\n";
            }
        }

        return outputString + componentList.getListString();
    }

    private static boolean isFlag(String flag) {
        return flag.equals(NAME_FLAG) || flag.equals(PRICE_FLAG) || flag.equals(BRAND_FLAG);
    }

    private static boolean hasFlag(String[] userInputStringArray) {
        for (String flag : userInputStringArray) {
            if (isFlag(flag)) {
                return true;
            }
        }
        return false;
    }
}
