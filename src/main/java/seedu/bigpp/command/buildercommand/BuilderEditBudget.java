package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.pc.PCList;
import seedu.bigpp.ui.UI;

public class BuilderEditBudget extends Command {
    public BuilderEditBudget(String arguments) {
        super.setArguments(arguments);
    }

    @Override
    public String executeCommand() {
        int budget = Integer.parseInt(super.getArguments());
        int pcIndex = UI.builderMenu.getPCIndex();
        PCList.getPC(pcIndex).setBudget(budget);
        return "Current build budget is now: " + budget;
    }
}
