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
     * Lists all components of a given component type including optional flags
     * that would filter the list of components. Such as filtering for name, price
     * and brand.
     * 
     * @return a string containing all components of a given component type
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
        ArrayList<Integer> componentIndexes = new ArrayList<Integer>();
        ArrayList<String> flagsArray = new ArrayList<String>();

        if (userInputStringArray.length > 1) {
            String[] flagAndDescriptionArray = Arrays.copyOfRange(userInputStringArray, 1, userInputStringArray.length);

            if (containsFlag(flagAndDescriptionArray, NAME_FLAG)) {
                componentList = handleNameFlag(componentList, flagsArray, flagAndDescriptionArray, componentIndexes);
            }
            if (containsFlag(flagAndDescriptionArray, BRAND_FLAG)) {
                componentList = handleBrandFlag(componentList, flagsArray, flagAndDescriptionArray, componentIndexes);
            }
            if (containsFlag(flagAndDescriptionArray, PRICE_FLAG)) {
                componentList = handlePriceFlag(userInputString, componentList, flagsArray, flagAndDescriptionArray,
                        componentIndexes);
            } else if (!hasFlag(flagAndDescriptionArray)) {
                throw new PPException("Please enter a valid flag after the component type");
            }
        }

        String outputString = "";

        if (componentList.size() == 0) {
            outputString = "There are no components of type '" + componentType + "' ";
        } else {
            outputString = "Here are all available components of type '" + componentType + "': \n";
        }

        if (flagsArray.size() > 0) {
            outputString += "meeting the following criteria: \n";
            for (String flagDescription : flagsArray) {
                outputString += flagDescription + "\n";
            }
        }

        return outputString + componentList.getListString(componentIndexes);
    }

    private ComponentList<?> handlePriceFlag(String userInputString, ComponentList<?> componentList,
            ArrayList<String> flagsArray, String[] flagAndDescriptionArray, ArrayList<Integer> componentIndexes)
            throws PPException {
        int priceFlagIndex = indexOfFlag(flagAndDescriptionArray, PRICE_FLAG);
        if (priceFlagIndex == flagAndDescriptionArray.length - 1) {
            throw new PPException("Please enter a price description after the flag");
        }
        String flagPriceDescription = userInputString.split(PRICE_FLAG)[1].trim();
        if (flagPriceDescription.split(" ").length < 4) {
            throw new PPException(
                    "Please enter the full price description after the flag containing the start " +
                    "and end price range");
        }
        String[] flagPriceDescriptionArray = Arrays.copyOfRange(flagPriceDescription.split(" "), 0, 4);
        if (hasFlag(flagPriceDescriptionArray)) {
            throw new PPException(
                    "Flag detected in price description. Please enter a different price description after the flag");
        }
        String fromFlag = flagPriceDescriptionArray[0].trim();
        if (!fromFlag.equals("/from")) {
            throw new PPException("Please use /from to specify the start price range.");
        }
        String priceFrom = flagPriceDescriptionArray[1].trim();
        if (priceFrom.matches(".*\\D.*")) {
            throw new PPException("Start price must be an integer");
        }
        String toFlag = flagPriceDescriptionArray[2].trim();
        if (!toFlag.equals("/to")) {
            throw new PPException("Please use /to to specify the end price range.");
        }
        String priceTo = flagPriceDescriptionArray[3].trim();

        if (priceTo.matches(".*\\D.*")) {
            throw new PPException("End price must be an integer");
        }

        int priceFromInt = Integer.parseInt(priceFrom);
        int priceToInt = Integer.parseInt(priceTo);

        if (priceFromInt > priceToInt) {
            throw new PPException("Price from must be smaller than price to");
        }
        if (priceFromInt < 0 || priceToInt < 0) {
            throw new PPException("Price must be greater than 0");
        }
        if (priceFromInt > 1000000 || priceToInt > 1000000) {
            throw new PPException("Price must be smaller than 1000000");
        }
        componentList = ComponentList.filterByPrice(componentList, priceFrom, priceTo, componentIndexes);
        flagsArray.add("price: " + priceFrom + " to " + priceTo);
        return componentList;
    }

    private ComponentList<?> handleBrandFlag(ComponentList<?> componentList, ArrayList<String> flagsArray,
            String[] flagAndDescriptionArray, ArrayList<Integer> componentIndexes) throws PPException {
        int brandFlagIndex = indexOfFlag(flagAndDescriptionArray, BRAND_FLAG);
        if (brandFlagIndex == flagAndDescriptionArray.length - 1) {
            throw new PPException("Please enter a brand after the flag");
        }
        String brand = flagAndDescriptionArray[brandFlagIndex + 1].trim();
        if (isFlag(brand)) {
            throw new PPException("Flag detected as a brand. Please enter another brand after the flag");
        }
        componentList = ComponentList.filterByBrand(componentList, brand, componentIndexes);
        flagsArray.add("brand: " + brand);
        return componentList;
    }

    private ComponentList<?> handleNameFlag(ComponentList<?> componentList, ArrayList<String> flagsArray,
            String[] flagAndDescriptionArray, ArrayList<Integer> componentIndexes) throws PPException {
        int nameFlagIndex = indexOfFlag(flagAndDescriptionArray, NAME_FLAG);
        if (nameFlagIndex == flagAndDescriptionArray.length - 1) {
            throw new PPException("Please enter a name after the flag");
        }
        String name = flagAndDescriptionArray[nameFlagIndex + 1].trim();
        if (isFlag(name)) {
            throw new PPException("Flag detected as a name. Please enter another name after the flag");
        }
        flagsArray.add("name: " + name);
        componentList = ComponentList.filterByName(componentList, name, componentIndexes);
        return componentList;
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

    private static boolean containsFlag(String[] flagAndDescriptionArray, String flag) {
        for (String flagAndDescription : flagAndDescriptionArray) {
            if (flagAndDescription.equals(flag)) {
                return true;
            }
        }
        return false;
    }

    private static int indexOfFlag(String[] flagAndDescriptionArray, String flag) {
        for (int i = 0; i < flagAndDescriptionArray.length; i++) {
            if (flagAndDescriptionArray[i].equals(flag)) {
                return i;
            }
        }
        return -1;
    }
}
