package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.pc.PCList;
import seedu.bigpp.ui.UI;

public class BuilderEditBudgetCommand extends Command {
    
    public BuilderEditBudgetCommand(String arguments) {
        super.setArguments(arguments);
    }

    /*
     * Change the budget of the current PC that the builder is working on
     * 
     * @return the new budget of the PC
     */
    @Override
    public String executeCommand() {
        int budget = Integer.parseInt(super.getArguments());
        int pcIndex = UI.builderMenu.getPCIndex();
        PCList.getPC(pcIndex).setBudget(budget);
        return "Current build budget is now: " + budget;
    }
}
