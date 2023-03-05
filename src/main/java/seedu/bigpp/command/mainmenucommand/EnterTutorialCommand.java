package seedu.bigpp.command.mainmenucommand;

import seedu.bigpp.command.Command;

import seedu.bigpp.ui.UI;

public class EnterTutorialCommand extends Command {

    @Override
    public String executeCommand() {
        UI.setTutorialMode();
        return "Changed to tutorial mode";
    }
}
