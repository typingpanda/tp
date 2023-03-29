package seedu.bigpp.command.buildercommand;

import seedu.bigpp.datastorage.DataStorage;
import org.junit.jupiter.api.Test;
import seedu.bigpp.exceptions.PPException;
import seedu.bigpp.ui.UI;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuilderSelectCommandTest {
    private DataStorage dataStorage = new DataStorage();

    private String expectedResultSuccess = "cpu added! : Intel core i3-10100";
    private String expectedEmptyExceptionMessage = "Please select a component";

    @Test
    public void excecuteCommand_selectCommand_success() throws PPException {
        dataStorage.initStringToComponentListMap();
        dataStorage.loadAll();

        UI.setPCBuilderMode(0);

        String selectCommandResult = new BuilderSelectCommand("cpu 1").executeCommand(dataStorage);
        assertEquals(expectedResultSuccess, selectCommandResult);
    }

    @Test
    public void excecuteCommand_selectCommandEmpty_exceptionThrown() {
        dataStorage.initStringToComponentListMap();
        dataStorage.loadAll();

        UI.setPCBuilderMode(0);

        Exception exception = assertThrows(PPException.class, () -> new BuilderSelectCommand("").executeCommand(
                dataStorage));
        assertEquals(expectedEmptyExceptionMessage,
                exception.getMessage());
    }
}
