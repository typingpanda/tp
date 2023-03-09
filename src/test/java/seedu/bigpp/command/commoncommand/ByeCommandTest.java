package seedu.bigpp.command.commoncommand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ByeCommandTest {
    @Test
    public void testByeCommand() {
        ByeCommand byeCommand = new ByeCommand();
        String expectedOutput = "Bye. Hope to see you again soon!";
        String actualOutput = byeCommand.executeCommand();
        assertEquals(expectedOutput, actualOutput);
    }
}
