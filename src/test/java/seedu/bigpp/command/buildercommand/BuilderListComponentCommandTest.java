package seedu.bigpp.command.buildercommand;

import org.junit.jupiter.api.Test;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.PPException;
import seedu.bigpp.ui.UI;
import static seedu.bigpp.component.ComponentType.CPU_TYPE;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuilderListComponentCommandTest {

    private static final String EXPECTED_OUTPUT = "Here are all available components of type 'cpu': \n" + "1.\n"
        + "NAME: Intel core i3-10100\n" + "BRAND: Intel\n" + "PRICE: 99.5\n" + "CORES: 4\n" + "THREADS: 8\n"
        + "BASECLOCK: 3.6\n" + "BOOSTCLOCK: 4.3\n" + "POWER: 65.0\n" + "SOCKET: LGA1200\n" + "================\n"
        + "2.\n" + "NAME: Intel core i5-10600k\n" + "BRAND: Intel\n" + "PRICE: 182.47\n" + "CORES: 6\n"
        + "THREADS: 12\n" + "BASECLOCK: 4.1\n" + "BOOSTCLOCK: 4.8\n" + "POWER: 125.0\n" + "SOCKET: LGA1200\n"
        + "================\n" + "3.\n" + "NAME: Intel core i7-10700k\n" + "BRAND: Intel\n" + "PRICE: 269.95\n"
        + "CORES: 8\n" + "THREADS: 16\n" + "BASECLOCK: 3.8\n" + "BOOSTCLOCK: 5.1\n" + "POWER: 125.0\n"
        + "SOCKET: LGA1200\n" + "================\n" + "4.\n" + "NAME: Intel core i3-12100f\n" + "BRAND: Intel\n"
        + "PRICE: 106.93\n" + "CORES: 4\n" + "THREADS: 8\n" + "BASECLOCK: 3.3\n" + "BOOSTCLOCK: 4.3\n"
        + "POWER: 58.0\n" + "SOCKET: LGA1700\n" + "================\n" + "5.\n" + "NAME: Intel core i5-12600k\n"
        + "BRAND: Intel\n" + "PRICE: 213.82\n" + "CORES: 10\n" + "THREADS: 20\n" + "BASECLOCK: 3.7\n"
        + "BOOSTCLOCK: 4.9\n" + "POWER: 125.0\n" + "SOCKET: LGA1700\n" + "================\n" + "6.\n"
        + "NAME: Intel core i7-12700k\n" + "BRAND: Intel\n" + "PRICE: 312.88\n" + "CORES: 12\n" + "THREADS: 24\n"
        + "BASECLOCK: 3.6\n" + "BOOSTCLOCK: 5.0\n" + "POWER: 125.0\n" + "SOCKET: LGA1700\n" + "================\n"
        + "7.\n" + "NAME: AMD Ryzen 3 3200G\n" + "BRAND: AMD\n" + "PRICE: 97.5\n" + "CORES: 4\n" + "THREADS: 4\n"
        + "BASECLOCK: 3.6\n" + "BOOSTCLOCK: 4.0\n" + "POWER: 65.0\n" + "SOCKET: AM4\n" + "================\n"
        + "8.\n" + "NAME: AMD Ryzen 5 5600X\n" + "BRAND: AMD\n" + "PRICE: 156.64\n" + "CORES: 6\n" + "THREADS: 12\n"
        + "BASECLOCK: 3.7\n" + "BOOSTCLOCK: 4.6\n" + "POWER: 65.0\n" + "SOCKET: AM4\n" + "================\n"
        + "9.\n" + "NAME: AMD Ryzen 7 5800X\n" + "BRAND: AMD\n" + "PRICE: 211.33\n" + "CORES: 8\n" + "THREADS: 16\n"
        + "BASECLOCK: 3.8\n" + "BOOSTCLOCK: 4.7\n" + "POWER: 105.0\n" + "SOCKET: AM4\n" + "================\n"
        + "10.\n" + "NAME: AMD Ryzen 5 7600X\n" + "BRAND: AMD\n" + "PRICE: 240.86\n" + "CORES: 6\n"
        + "THREADS: 12\n" + "BASECLOCK: 4.7\n" + "BOOSTCLOCK: 5.3\n" + "POWER: 105.0\n" + "SOCKET: AM5\n"
        + "================\n" + "11.\n" + "NAME: AMD Ryzen 7 7700X\n" + "BRAND: AMD\n" + "PRICE: 341.29\n"
        + "CORES: 8\n" + "THREADS: 16\n" + "BASECLOCK: 4.5\n" + "BOOSTCLOCK: 5.4\n" + "POWER: 105.0\n"
        + "SOCKET: AM5\n" + "================\n" + "12.\n" + "NAME: AMD Ryzen 9 7950X\n" + "BRAND: AMD\n"
        + "PRICE: 589.0\n" + "CORES: 16\n" + "THREADS: 32\n" + "BASECLOCK: 4.5\n" + "BOOSTCLOCK: 5.7\n"
        + "POWER: 170.0\n" + "SOCKET: AM5\n" + "================\n";
        
    private DataStorage dataStorage = new DataStorage();

    @Test
    public void executeCommand_listCpu_success() throws PPException {

        dataStorage.initStringToComponentListMap();
        dataStorage.loadAll();

        UI.setPCBuilderMode(0);

        String listComponentCommandResult = new BuilderListComponentCommand(CPU_TYPE).executeCommand(dataStorage);
        assertEquals(EXPECTED_OUTPUT, listComponentCommandResult);
    }

    @Test
    public void executeCommand_listCpuMissingName_exceptionThrown() {
        dataStorage.initStringToComponentListMap();
        dataStorage.loadAll();

        UI.setPCBuilderMode(0);

        Exception exception = assertThrows(PPException.class, () -> new BuilderListComponentCommand("cpu -name")
                .executeCommand(dataStorage));
        assertEquals("Please enter a name after the flag", exception.getMessage());
    }

    @Test
    public void executeCommand_listCpuInvalidName_exceptionThrown() {
        dataStorage.initStringToComponentListMap();
        dataStorage.loadAll();

        UI.setPCBuilderMode(0);

        Exception exception = assertThrows(PPException.class, () -> new BuilderListComponentCommand("cpu -name -name")
                .executeCommand(dataStorage));
        assertEquals("Flag detected as a name. Please enter another name after the flag", exception.getMessage());
    }

    @Test
    public void executeCommand_listCpuMissingBrand_exceptionThrown() {
        dataStorage.initStringToComponentListMap();
        dataStorage.loadAll();

        UI.setPCBuilderMode(0);

        Exception exception = assertThrows(PPException.class, () -> new BuilderListComponentCommand("cpu -brand")
                .executeCommand(dataStorage));
        assertEquals("Please enter a brand after the flag", exception.getMessage());
    }

    @Test
    public void executeCommand_listCpuInvalidBrand_exceptionThrown() {
        dataStorage.initStringToComponentListMap();
        dataStorage.loadAll();

        UI.setPCBuilderMode(0);

        Exception exception = assertThrows(PPException.class, () -> new BuilderListComponentCommand("cpu -brand -price")
                .executeCommand(dataStorage));
        assertEquals("Flag detected as a brand. Please enter another brand after the flag", exception.getMessage());
    }

    @Test
    public void executeCommand_listCpuMissingPriceDescription_exceptionThrown() {
        dataStorage.initStringToComponentListMap();
        dataStorage.loadAll();

        UI.setPCBuilderMode(0);

        Exception exception = assertThrows(PPException.class, () -> new BuilderListComponentCommand("cpu -price")
                .executeCommand(dataStorage));
        assertEquals("Please enter a price description after the flag",
                exception.getMessage());
    }

    @Test
    public void executeCommand_listCpuIncompletePriceDescription_exceptionThrown() {
        dataStorage.initStringToComponentListMap();
        dataStorage.loadAll();

        UI.setPCBuilderMode(0);

        Exception exception = assertThrows(PPException.class, () -> new BuilderListComponentCommand(
                "cpu -price /from 10")
                        .executeCommand(dataStorage));
        assertEquals("Please enter the full price description after the flag containing the start and end price range",
                exception.getMessage());
    }

    @Test
    public void executeCommand_listCpuInvalidPriceType_exceptionThrown() {
        dataStorage.initStringToComponentListMap();
        dataStorage.loadAll();

        UI.setPCBuilderMode(0);

        Exception exception = assertThrows(PPException.class, () -> new BuilderListComponentCommand(
                "cpu -price /from ten /to 100").executeCommand(dataStorage));
        assertEquals("Start price must be a positive integer", exception.getMessage());
    }

    @Test
    public void executeCommand_listCpuInvalidPriceRange_exceptionThrown() {
        dataStorage.initStringToComponentListMap();
        dataStorage.loadAll();

        UI.setPCBuilderMode(0);

        Exception exception = assertThrows(PPException.class, () -> new BuilderListComponentCommand(
                "cpu -price /from 100 /to 10").executeCommand(dataStorage));
        assertEquals("Start price must be less than end price", exception.getMessage());
    }

    @Test
    public void executeCommand_listcpuInvalidPrice_exceptionThrown() {
        dataStorage.initStringToComponentListMap();
        dataStorage.loadAll();

        UI.setPCBuilderMode(0);

        Exception exception = assertThrows(PPException.class, () -> new BuilderListComponentCommand(
                "cpu -price /from -100 /to 100").executeCommand(dataStorage));
        assertEquals("Start price must be a positive integer", exception.getMessage());
    }

    @Test
    public void executeCommand_listcpuInvalidPriceDescription_exceptionThrown() {
        dataStorage.initStringToComponentListMap();
        dataStorage.loadAll();

        UI.setPCBuilderMode(0);

        Exception exception = assertThrows(PPException.class, () -> new BuilderListComponentCommand(
                "cpu -price from 100 to 100").executeCommand(dataStorage));
        assertEquals("Please use /from to specify the start price range", exception.getMessage());
    }
}
