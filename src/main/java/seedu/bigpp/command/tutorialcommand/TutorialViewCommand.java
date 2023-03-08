package seedu.bigpp.command.tutorialcommand;

import seedu.bigpp.command.Command;

public class TutorialViewCommand extends Command {
    public TutorialViewCommand(String arguments) {
        super.setArguments(arguments);
    }

    public String executeCommand() {
        return "";
    }
}
