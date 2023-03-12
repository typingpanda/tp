package seedu.bigpp.command.buildercommand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuilderListComponentCommandTest {
    @Test
    public void executeCommand_listComponentCommand_success() {
        String editNameCommandResult = new BuilderListComponentCommand("cpu").executeCommand();
        assertEquals("Current build name is now: PC2", editNameCommandResult);
    }
}
