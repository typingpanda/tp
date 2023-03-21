package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.builderexceptions.BuilderMissingListException;
import seedu.bigpp.exceptions.builderexceptions.BuilderMissingNameException;
import seedu.bigpp.exceptions.builderexceptions.BuilderPriceFlagException;
import seedu.bigpp.exceptions.builderexceptions.BuilderPriceLogicException;
import seedu.bigpp.exceptions.builderexceptions.BuilderPriceMissingArguments;
import seedu.bigpp.exceptions.builderexceptions.BuilderIncorrectComponentException;
import seedu.bigpp.exceptions.builderexceptions.BuilderInvalidFlagArgument;
import seedu.bigpp.exceptions.builderexceptions.BuilderInvalidPriceType;
import seedu.bigpp.exceptions.builderexceptions.BuilderMissingBrandException;
import seedu.bigpp.exceptions.builderexceptions.BuilderMissingComponentException;
import seedu.bigpp.exceptions.builderexceptions.BuilderInvalidPriceNumber;

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
    public String executeCommand(DataStorage dataStorage) throws BuilderMissingListException,
            BuilderIncorrectComponentException, BuilderMissingComponentException, BuilderInvalidFlagArgument,
            BuilderInvalidPriceType, BuilderInvalidPriceNumber, BuilderPriceLogicException,
            BuilderPriceMissingArguments, BuilderMissingNameException, BuilderPriceFlagException,
            BuilderMissingBrandException {

        assert UI.getUiState() == UIState.PCBUILDER : "UI state should be PCBUILDER";

        String userInputString = getArguments();
        userInputString = userInputString.toLowerCase();

        String[] userInputStringArray = userInputString.split(" ");
        String componentType = userInputStringArray[0];

        if (userInputString.equals("")) {
            throw new BuilderMissingComponentException();
        }
        if (!dataStorage.stringToComponentListMap.containsKey(componentType)) {
            throw new BuilderIncorrectComponentException();
        }

        ComponentList<?> componentList = dataStorage.stringToComponentListMap.get(componentType);
        ArrayList<String> flagDescriptionArray = new ArrayList<String>();
        for (int i = 1; i < userInputStringArray.length; i++) {
            String flagCommand = userInputStringArray[i].trim();

            switch (flagCommand) {
            case NAME_FLAG:
                try {
                    if (userInputStringArray.length < i + 2) {
                        throw new BuilderMissingNameException();
                    }
                    String flagArgument = userInputStringArray[i + 1].trim();
                    if (isFlag(flagArgument)) {
                        throw new BuilderInvalidFlagArgument();
                    }
                    componentList = ComponentList.filterByName(componentList, flagArgument);
                    flagDescriptionArray.add("name: " + flagArgument);
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new BuilderInvalidFlagArgument();
                }
                break;
            case BRAND_FLAG:
                try {
                    if (userInputStringArray.length < i + 2) {
                        throw new BuilderMissingBrandException();
                    }
                    String flagArgument = userInputStringArray[i + 1].trim();
                    if (isFlag(flagArgument)) {
                        throw new BuilderInvalidFlagArgument();
                    }
                    componentList = ComponentList.filterByBrand(componentList, flagArgument);
                    flagDescriptionArray.add("brand: " + flagArgument);
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new BuilderInvalidFlagArgument();
                }
                break;
            case PRICE_FLAG:
                try {
                    if (hasFlag(Arrays.copyOfRange(userInputStringArray, i + 1, i + 4))) {
                        throw new BuilderInvalidFlagArgument();
                    }
                    if (userInputStringArray.length < i + 4) {
                        throw new BuilderPriceMissingArguments();
                    }
                    if (!(userInputStringArray[i + 1].equals("/from") && userInputStringArray[i + 3].equals("/to"))) {
                        throw new BuilderPriceFlagException();
                    }
                    String priceFrom = userInputStringArray[i + 2];
                    String priceTo = userInputStringArray[i + 4];
                    if (priceFrom.matches(".*d.*") || priceTo.matches(".*d.*")) {
                        throw new BuilderInvalidPriceType();
                    }
                    if (Float.parseFloat(priceFrom) > Float.parseFloat(priceTo)) {
                        throw new BuilderPriceLogicException();
                    }
                    if (Float.parseFloat(priceFrom) <= 0 || Float.parseFloat(priceTo) <= 0) {
                        throw new BuilderInvalidPriceNumber();
                    }
                    componentList = ComponentList.filterByPrice(componentList, priceFrom, priceTo);
                    flagDescriptionArray.add("price: from " + priceFrom + " to " + priceTo);
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new BuilderInvalidFlagArgument();
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
