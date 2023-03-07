package seedu.bigpp.command.commoncommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.ui.UI;
import seedu.bigpp.ui.UIState;

public class BackCommand extends Command {

    @Override
    public String executeCommand() {
        UI.visitedMenusStack.pop();
        UIState previousState = UI.visitedMenusStack.peek();
        UI.visitedMenusStack.pop();
        switch (previousState) {
        case MAIN_MENU:
            UI.setMainMenuMode();
            break;
        case VIEWER:
            UI.setViewerMode();
            break;
        case BUILDER:
            UI.setBuilderMode();
            break;
        case TUTORIAL:
            UI.setTutorialMode();
            break;
        default:
            break;
        }
        return "returned to previous menu";
    }
}
