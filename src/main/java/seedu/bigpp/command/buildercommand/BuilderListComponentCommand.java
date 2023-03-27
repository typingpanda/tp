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

    private static final String NAME_FLAG = "-name";
    private static final String PRICE_FLAG = "-price";
    private static final String BRAND_FLAG = "-brand";
    private static final String CORE_FLAG = "-core";
    private static final String THREAD_FLAG = "-thread";
    private static final String BASE_CLOCK_FLAG = "-baseclock";
    private static final String BOOST_CLOCK_FLAG = "-boostclock";
    private static final String POWER_FLAG = "-power";
    private static final String SOCKET_FLAG = "-socket";
    private static final String SIZE_FLAG = "-size";
    private static final String RPM_FLAG = "-rpm";
    private static final String NOISE_FLAG = "-noise";
    private static final String MEMORY_FLAG = "-memory";
    private static final String STICKS_FLAG = "-sticks";
    private static final String SPEED_FLAG = "-speed";
    private static final String TYPE_FLAG = "-type";
    private static final String FORM_FACTOR_FLAG = "-formfactor";
    private static final String EFFICIENCY_FLAG = "-efficiency";

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
        ArrayList<Integer> componentIndexes = new ArrayList<Integer>();
        ArrayList<String> flagsArray = new ArrayList<String>();

        if (userInputStringArray.length > 1) {
            String[] flagAndDescriptionArray = Arrays.copyOfRange(userInputStringArray, 1, userInputStringArray.length);
            if (hasFlag(userInputStringArray)) {
                if (containsFlag(flagAndDescriptionArray, NAME_FLAG)) {
                    componentList = handleNameFlag(componentList, flagsArray, flagAndDescriptionArray,
                            componentIndexes);
                }
                if (containsFlag(flagAndDescriptionArray, BRAND_FLAG)) {
                    componentList = handleBrandFlag(componentList, flagsArray, flagAndDescriptionArray,
                            componentIndexes);
                }
                if (containsFlag(flagAndDescriptionArray, PRICE_FLAG)) {
                    componentList = handlePriceFlag(userInputString, componentList, flagsArray, flagAndDescriptionArray,
                            componentIndexes);
                }

                switch (componentType) {
                case "chassis":
                    if (containsFlag(flagAndDescriptionArray, SIZE_FLAG)) {
                        componentList = handleSizeFlag(componentList, flagsArray, flagAndDescriptionArray,
                                componentIndexes);
                    }
                case "cpu":
                    // handle core, thread, baseclock, boostclock, power and socket flag
                    if (containsFlag(flagAndDescriptionArray, CORE_FLAG)) {
                        componentList = handleCoreFlag(componentList, flagsArray, flagAndDescriptionArray,
                                componentIndexes);
                    }
                    if (containsFlag(flagAndDescriptionArray, THREAD_FLAG)) {
                        componentList = handleThreadFlag(componentList, flagsArray, flagAndDescriptionArray,
                                componentIndexes);
                    }

                    if (containsFlag(flagAndDescriptionArray, BASE_CLOCK_FLAG)) {
                        componentList = handleBaseClockFlag(userInputString, componentList, flagsArray,
                                flagAndDescriptionArray, componentIndexes);
                    }
                    if (containsFlag(flagAndDescriptionArray, BOOST_CLOCK_FLAG)) {
                        componentList = handleBoostClockFlag(userInputString, componentList, flagsArray,
                                flagAndDescriptionArray, componentIndexes);
                    }
                    if (containsFlag(flagAndDescriptionArray, POWER_FLAG)) {
                        componentList = handlePowerFlag(userInputString, componentList, flagsArray,
                                flagAndDescriptionArray, componentIndexes);
                    }

                case "cpucooler":
                    //handle rpm, noise and power flag
                case "gpu":
                    //handle power and size flag
                case "motherboard":
                    //handle formfactor, socket and power flag
                case "psu":
                    //handle efficiency, formfactor and power flag
                case "ram":
                    //handle memory, sticks, speed and power flag
                case "storage":
                    //handle type, size and power flag
                }

            } else {
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

    //handle power flag with int from and int to range
    private ComponentList<?> handlePowerFlag(String userInputString, ComponentList<?> componentList,
            ArrayList<String> flagsArray,
            String[] flagAndDescriptionArray, ArrayList<Integer> componentIndexes) throws PPException {
        int powerFlagIndex = indexOfFlag(flagAndDescriptionArray, POWER_FLAG);
        if (powerFlagIndex == flagAndDescriptionArray.length - 1) {
            throw new PPException("Please enter a description after the flag");
        }

        String powerDescription = userInputString.split(POWER_FLAG)[1].trim().toLowerCase();
        if (powerDescription.split(" ").length < 4) {
            throw new PPException("Please enter a full power description");
        }

        String[] powerDescriptionArray = Arrays.copyOfRange(powerDescription.split(" "), 0, 4);
        if (hasFlag(powerDescriptionArray)) {
            throw new PPException("Flag detected in power description. Please enter a valid power range");
        }

        String fromFlag = powerDescriptionArray[0];
        if (!fromFlag.equals("/from")) {
            throw new PPException("Please enter '/from' before the power range");
        }

        String powerFrom = powerDescriptionArray[1];
        if (powerFrom.matches(".*\\D.*")) {
            throw new PPException("Power start range must be an integer");
        }

        String toFlag = powerDescriptionArray[2];
        if (!toFlag.equals("/to")) {
            throw new PPException("Please enter '/to' before the power range");
        }

        String powerTo = powerDescriptionArray[3];
        if (powerTo.matches(".*\\D.*")) {
            throw new PPException("Power end range must be an integer");
        }

        int powerFromInt = Integer.parseInt(powerFrom);
        int powerToInt = Integer.parseInt(powerTo);

        if (powerFromInt > powerToInt) {
            throw new PPException("Power start range must be smaller than power end range");
        }

        if (powerFromInt < 0 || powerToInt < 0) {
            throw new PPException("Power must be a positive integer");
        }

        if (powerFromInt > 10000 || powerToInt > 10000) {
            throw new PPException("Power must be less than 10000W");
        }

        componentList = ComponentList.filterByPower(componentList, powerFromInt, powerToInt, componentIndexes);

        flagsArray.add("Power: " + powerFrom + "W to " + powerTo + "W");

        return componentList;
    }

    // handle boost clock flag, boost clock is a float and has a /from and /to flag
    private ComponentList<?> handleBoostClockFlag(String userInputString, ComponentList<?> componentList,
            ArrayList<String> flagsArray,
            String[] flagAndDescriptionArray, ArrayList<Integer> componentIndexes) throws PPException {
        int boostClockFlagIndex = indexOfFlag(flagAndDescriptionArray, BOOST_CLOCK_FLAG);
        if (boostClockFlagIndex == flagAndDescriptionArray.length - 1) {
            throw new PPException("Please enter a description after the flag");
        }

        String boostClockDescription = userInputString.split(BOOST_CLOCK_FLAG)[1].trim().toLowerCase();
        if (boostClockDescription.split(" ").length < 4) {
            throw new PPException("Please enter a full boost clock description");
        }

        String[] boostClockDescriptionArray = Arrays.copyOfRange(boostClockDescription.split(" "), 0, 4);
        if (hasFlag(boostClockDescriptionArray)) {
            throw new PPException(
                    "Flag detected in boost clock description. Please enter a valid boost clock description");
        }

        String fromFlag = boostClockDescriptionArray[0];
        if (!fromFlag.equals("/from")) {
            throw new PPException("Please use /from to specify the lower bound of the boost clock");
        }

        String boostClockLowerBoundString = boostClockDescriptionArray[1];
        if (boostClockLowerBoundString.matches(".*\\D.*")) {
            throw new PPException("Please enter a float for the lower bound of the boost clock");
        }

        String toFlag = boostClockDescriptionArray[2];
        if (!toFlag.equals("/to")) {
            throw new PPException("Please use /to to specify the upper bound of the boost clock");
        }

        String boostClockUpperBoundString = boostClockDescriptionArray[3];
        if (boostClockUpperBoundString.matches(".*\\D.*")) {
            throw new PPException("Please enter a float for the upper bound of the boost clock");
        }

        float boostClockLowerBound = Float.parseFloat(boostClockLowerBoundString);
        float boostClockUpperBound = Float.parseFloat(boostClockUpperBoundString);

        if (boostClockLowerBound > boostClockUpperBound) {
            throw new PPException("Please enter a lower bound that is smaller than the upper bound");
        }

        if (boostClockLowerBound < 0 || boostClockUpperBound < 0) {
            throw new PPException("Please enter a positive boost clock");
        }

        if (boostClockLowerBound > 100 || boostClockUpperBound > 100) {
            throw new PPException("Please enter a boost clock that is smaller than 100");
        }

        flagsArray.add("Boost Clock: " + boostClockLowerBound + " to " + boostClockUpperBound);
        componentList = ComponentList.filterByBoostClock(componentList, boostClockLowerBound, boostClockUpperBound,
                componentIndexes);

        return componentList;

    }

    //handle base clock flag, base clock is a float and has a /from and /to flag
    private ComponentList<?> handleBaseClockFlag(String userInputString, ComponentList<?> componentList,
            ArrayList<String> flagsArray,
            String[] flagAndDescriptionArray, ArrayList<Integer> componentIndexes) throws PPException {
        int baseClockFlagIndex = indexOfFlag(flagAndDescriptionArray, BASE_CLOCK_FLAG);
        if (baseClockFlagIndex == flagAndDescriptionArray.length - 1) {
            throw new PPException("Please enter a description after the flag");
        }

        String baseClockDescription = userInputString.split(BASE_CLOCK_FLAG)[1].trim().toLowerCase();
        if (baseClockDescription.split(" ").length < 4) {
            throw new PPException("Please enter a full base clock description");
        }

        String[] baseClockDescriptionArray = Arrays.copyOfRange(baseClockDescription.split(" "), 0, 4);
        if (hasFlag(baseClockDescriptionArray)) {
            throw new PPException(
                    "Flag detected in base clock description. Please enter a valid base clock description");
        }
        String fromFlag = baseClockDescriptionArray[0].trim();
        if (!fromFlag.equals("/from")) {
            throw new PPException("Please use /from to specify the lower bound of the base clock");
        }

        String fromBaseClock = baseClockDescriptionArray[1].trim();
        if (fromBaseClock.matches(".*\\D.*")) {
            throw new PPException("Base clock should be a float");
        }

        String toFlag = baseClockDescriptionArray[2].trim();
        if (!toFlag.equals("/to")) {
            throw new PPException("Please use /to to specify the upper bound of the base clock");
        }

        String toBaseClock = baseClockDescriptionArray[3].trim();
        if (toBaseClock.matches(".*\\D.*")) {
            throw new PPException("Base clock should be a float");
        }

        float fromBaseClockFloat = Float.parseFloat(fromBaseClock);
        float toBaseClockFloat = Float.parseFloat(toBaseClock);

        if (fromBaseClockFloat > toBaseClockFloat) {
            throw new PPException("Start range must be smaller than end range");
        }

        if (fromBaseClockFloat < 0 || toBaseClockFloat < 0) {
            throw new PPException("Base clock cannot be negative");
        }

        if (fromBaseClockFloat > 100 || toBaseClockFloat > 100) {
            throw new PPException("Base clock cannot be greater than 100");
        }

        flagsArray.add("Base clock from " + fromBaseClock + " to " + toBaseClock);
        componentList = ComponentList.filterByBaseClock(componentList, fromBaseClockFloat, toBaseClockFloat,
                componentIndexes);
        return componentList;
    }

    private ComponentList<?> handleThreadFlag(ComponentList<?> componentList, ArrayList<String> flagsArray,
            String[] flagAndDescriptionArray, ArrayList<Integer> componentIndexes) throws PPException {
        int threadFlagIndex = indexOfFlag(flagAndDescriptionArray, THREAD_FLAG);
        if (threadFlagIndex == flagAndDescriptionArray.length - 1) {
            throw new PPException("Please enter a thread number after the flag");
        }

        String thread = flagAndDescriptionArray[threadFlagIndex + 1].trim().toLowerCase();

        if (isFlag(thread)) {
            throw new PPException("Flag detected in thread description. Please enter a valid thread number");
        }

        if (!thread.equals("4") && !thread.equals("8") && !thread.equals("12") && !thread.equals("16") && !thread
                .equals("20") && !thread.equals("24") && !thread.equals("32")) {
            throw new PPException("Please enter a valid thread number (4, 8, 12, 16, 20, 24 or 32)");
        }

        if (thread.matches(".*\\D.*")) {
            throw new PPException("Please enter an integer for thread number");
        }
        int threadInt = Integer.parseInt(thread);
        flagsArray.add("Thread: " + thread);

        componentList = ComponentList.filterByThread(componentList, threadInt, componentIndexes);
        return componentList;
    }

    private ComponentList<?> handleCoreFlag(ComponentList<?> componentList, ArrayList<String> flagsArray,
            String[] flagAndDescriptionArray, ArrayList<Integer> componentIndexes) throws PPException {
        int coreFlagIndex = indexOfFlag(flagAndDescriptionArray, CORE_FLAG);
        if (coreFlagIndex == flagAndDescriptionArray.length - 1) {
            throw new PPException("Please enter a core number after the flag");
        }

        String core = flagAndDescriptionArray[coreFlagIndex + 1].trim().toLowerCase();

        if (isFlag(core)) {
            throw new PPException("Flag detected in core description. Please enter a valid core number");
        }

        if (!core.equals("4") && !core.equals("6") && !core.equals("8") && !core.equals("10") && !core.equals(
                "12") && !core.equals("16")) {
            throw new PPException("Please enter a valid core number (4, 6, 8, 10, 12 or 16)");
        }
        flagsArray.add("core: " + core);

        if (core.matches(".*\\D.*")) {
            throw new PPException("Please enter an integer for core number");
        }

        int coreInt = Integer.parseInt(core);
        componentList = ComponentList.filterByCore(componentList, coreInt, componentIndexes);
        return componentList;
    }

    private ComponentList<?> handleSizeFlag(ComponentList<?> componentList, ArrayList<String> flagsArray,
            String[] flagAndDescriptionArray, ArrayList<Integer> componentIndexes) throws PPException {
        int sizeFlagIndex = indexOfFlag(flagAndDescriptionArray, SIZE_FLAG);
        if (sizeFlagIndex == flagAndDescriptionArray.length - 1) {
            throw new PPException("Please enter a size after the flag");
        }

        String size = flagAndDescriptionArray[sizeFlagIndex + 1].trim().toLowerCase();

        if (isFlag(size)) {
            throw new PPException("Flag detected in size description. Please enter a valid size");
        }

        if (!size.equals("micro") && !size.equals("mini") && !size.equals("mid") && !size.equals("full")) {
            throw new PPException("Please enter a valid size (micro, mini, mid or full)");
        }
        flagsArray.add("size: " + size);
        componentList = ComponentList.filterBySize(componentList, size, componentIndexes);
        return componentList;
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
                    "Please enter the full price description after the flag containing the start " + "and end price range");
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
        String brand = flagAndDescriptionArray[brandFlagIndex + 1].trim().toLowerCase();
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
        String name = flagAndDescriptionArray[nameFlagIndex + 1].trim().toLowerCase();
        if (isFlag(name)) {
            throw new PPException("Flag detected as a name. Please enter another name after the flag");
        }
        flagsArray.add("name: " + name);
        componentList = ComponentList.filterByName(componentList, name, componentIndexes);
        return componentList;
    }

    private static boolean isFlag(String flag) {
        return flag.equals(NAME_FLAG) || flag.equals(PRICE_FLAG) || flag.equals(BRAND_FLAG) || flag.equals(
                SIZE_FLAG) || flag.equals(CORE_FLAG) || flag.equals(THREAD_FLAG) || flag.equals(BASE_CLOCK_FLAG) || flag
                        .equals(BOOST_CLOCK_FLAG) || flag
                                .equals(POWER_FLAG) || flag.equals(SOCKET_FLAG) || flag.equals(RPM_FLAG) || flag.equals(
                                        NOISE_FLAG) || flag.equals(MEMORY_FLAG) || flag.equals(STICKS_FLAG) || flag
                                                .equals(
                                                        SPEED_FLAG) || flag.equals(TYPE_FLAG) || flag.equals(
                                                                FORM_FACTOR_FLAG) || flag
                                                                        .equals(EFFICIENCY_FLAG);
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
