package seedu.bigpp;

import seedu.bigpp.command.Command;
import seedu.bigpp.command.mainmenucommand.ByeCommand;
import seedu.bigpp.parser.Parser;
import seedu.bigpp.ui.UI;

public class BigPP {

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        new BigPP().run();
    }

    public void run() {
        UI.updateUI();
        UI.initializeVisitedMenusStack();
        runLoopUntilExit();
    }

    /**
     * Runs the program until the user issues the exit command.
     */
    private void runLoopUntilExit() {
        Command command;
        do {
            String userInput = UI.getInput();
            command = new Parser().parseCommand(userInput);
            String result = command.executeCommand();
            UI.updateUI();
            UI.showResult(result);
        } while (!(command instanceof ByeCommand));
    }

}
