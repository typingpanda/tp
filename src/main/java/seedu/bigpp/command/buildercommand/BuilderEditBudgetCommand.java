package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.exceptions.PPException;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.builderexceptions.BuilderMinBudgetException;
import seedu.bigpp.exceptions.builderexceptions.BuilderInvalidNumberBudgetException;
import seedu.bigpp.exceptions.builderexceptions.BuilderMissingBudgetException;
import seedu.bigpp.exceptions.builderexceptions.BuilderInvalidTypeBudgetException;
import seedu.bigpp.ui.UI;
import seedu.bigpp.ui.UIState;

public class BuilderEditBudgetCommand extends Command {

    public BuilderEditBudgetCommand(String arguments) {
        super.setArguments(arguments);
    }

    /**
     * Change the budget of the current PC that the builder is working on
     * @return the new budget of the PC
     */
    @Override
    public String executeCommand(DataStorage dataStorage) throws PPException {
        assert UI.getUiState() == UIState.PCBUILDER : "UI state should be PCBUILDER";

        String argument = super.getArguments();
        if (argument.equals("")) {
            throw new BuilderMissingBudgetException();
        }
        if (argument.matches(".*\\D.*") && !argument.matches("-1")) {
            throw new BuilderInvalidTypeBudgetException();
        }

        int budget = Integer.parseInt(super.getArguments());

        if (budget <= 0 && budget != -1) {
            throw new BuilderInvalidNumberBudgetException();
        }

        int pcIndex = UI.builderMenu.getPCIndex();
        float currentCost = dataStorage.pcList.get(pcIndex).getCost();

        if (budget < currentCost) {
            throw new BuilderMinBudgetException();
        }
        
        dataStorage.pcList.get(pcIndex).setBudget(budget);
        return "Current build budget is now: " + dataStorage.pcList.get(pcIndex).getBudgetString();
    }
}
