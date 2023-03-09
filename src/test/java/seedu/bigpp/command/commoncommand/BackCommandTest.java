package seedu.bigpp.command.commoncommand;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import seedu.bigpp.ui.UI;

public class BackCommandTest {

    @Test
    public void testExecuteCommand() {
        // Arrange
        BackCommand backCommand = new BackCommand();
        UI.setPCViewerMode();
        UI.updateUI();

        // Act
        String result = backCommand.executeCommand();

        // Assert
        assertEquals("Cannot go back from PCViewer", result);
    }
}
