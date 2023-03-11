package seedu.bigpp.command.commoncommand;

import org.junit.jupiter.api.Test;
import seedu.bigpp.ui.UI;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackCommandTest {

    @Test
    public void executeCommand_backCommand_success() {
        BackCommand backCommand = new BackCommand();
        UI.setPCViewerMode();
        String PCViewerBackCommandResult = backCommand.executeCommand();
        assertEquals("Cannot go back from PCViewer", PCViewerBackCommandResult);

        UI.setPCBuilderMode(null);
        String PCBuilderBackCommandResult = backCommand.executeCommand();
        assertEquals("returned to PCViewer", PCBuilderBackCommandResult);
    }
}
