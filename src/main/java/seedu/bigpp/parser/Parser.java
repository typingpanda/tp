package seedu.bigpp.parser;

import seedu.bigpp.command.Command;
import seedu.bigpp.command.buildercommand.BuilderEditBudgetCommand;
import seedu.bigpp.command.buildercommand.BuilderEditNameCommand;
import seedu.bigpp.command.buildercommand.BuilderListComponentCommand;
import seedu.bigpp.command.commoncommand.BackCommand;
import seedu.bigpp.command.commoncommand.ByeCommand;
import seedu.bigpp.command.viewercommand.ViewerAddCommand;
import seedu.bigpp.command.viewercommand.ViewerDeleteCommand;
import seedu.bigpp.command.viewercommand.ViewerEditCommand;
import seedu.bigpp.command.viewercommand.ViewerViewCommand;
import seedu.bigpp.ui.UI;

public class Parser {

    public Command parseCommand(String userInput) {
        return parseBuilderCommand(userInput);
    }

    private Command parseViewerCommand(String userInput) {
        String commandWord = userInput.split(" ")[0];
        String arguments = userInput.split(" ")[1];

        commandWord = commandWord.toLowerCase();
        switch (commandWord) {
        case "add":
            return new ViewerAddCommand(arguments);
        case "delete":
            return new ViewerDeleteCommand(arguments);
        case "view":
            return new ViewerViewCommand(arguments);
        case "edit":
            return new ViewerEditCommand(arguments);
        default:
            return null;
        }
    }

    private Command parseBuilderCommand(String userInput) {

        String commandWord = userInput.split(" ")[0];
        String arguments = userInput.split(" ")[1];
        commandWord = commandWord.toLowerCase();

        switch (commandWord) {
        case "list":
            return new BuilderListComponentCommand(arguments);
        case "name":
            return new BuilderEditNameCommand(arguments);
        case "budget":
            return new BuilderEditBudgetCommand(arguments);
        default:
            return null;
        }

    }
}
