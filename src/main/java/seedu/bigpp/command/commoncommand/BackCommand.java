package seedu.bigpp.command.commoncommand;
import seedu.bigpp.command.Command;
import seedu.bigpp.ui.UI;
import seedu.bigpp.ui.UIState;

public class BackCommand extends Command {

    @Override
    public String executeCommand() {
        int previousStateIndex = UI.visitedMenus.size() - 2;
        UIState previousState = UI.visitedMenus.get(previousStateIndex);
        UI.visitedMenus.remove(previousStateIndex + 1);
        UI.visitedMenus.remove(previousStateIndex);
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
