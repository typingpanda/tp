package seedu.bigpp.parser;

import seedu.bigpp.command.Command;
import seedu.bigpp.ui.UI;

import seedu.bigpp.command.mainmenucommand.ByeCommand;
import seedu.bigpp.command.mainmenucommand.EnterViewerCommand;
import seedu.bigpp.command.mainmenucommand.EnterTutorialCommand;

import seedu.bigpp.command.viewercommand.ViewerAddCommand;

public class Parser {

    public Command parseCommand(String userInput) {
        switch (UI.getUiState()) {

        case MAIN_MENU:
            return parseMainMenuCommand(userInput);

        case VIEWER:
            return parseViewerCommand(userInput);

        case BUILDER:
            return parseBuilderCommand(userInput);

        case TUTORIAL:
            return parseTutorialCommand(userInput);

        case COMPONENT:
            return parseComponentCommand(userInput);

        default:
            return null;
        }
    }

    private Command parseMainMenuCommand(String userInput) {
        String commandWord = userInput.split(" ")[0];

        commandWord = commandWord.toLowerCase();

        switch (commandWord) {
        case "viewer":
            return new EnterViewerCommand();
        case "tutorial":
            return new EnterTutorialCommand();
        case "exit":
            return new ByeCommand();
        default:
            return null;
        }
    }

    private Command parseViewerCommand(String userInput) {
        String commandWord = userInput.split(" ")[0];
        String arguments = userInput.split(" ")[1];

        commandWord = commandWord.toLowerCase();
        switch (commandWord) {
            case "add":
                return new ViewerAddCommand(arguments);
            default:
                return null;
        }
    }

    private Command parseBuilderCommand(String userInput) {
        String commandWord = userInput.split(" ")[0];

        commandWord = commandWord.toLowerCase();
        return null;
    }

    private Command parseTutorialCommand(String userInput) {
        String commandWord = userInput.split(" ")[0];

        commandWord = commandWord.toLowerCase();
        return null;
    }

    private Command parseComponentCommand(String userInput) {
        String commandWord = userInput.split(" ")[0];

        commandWord = commandWord.toLowerCase();
        return null;
    }
}
