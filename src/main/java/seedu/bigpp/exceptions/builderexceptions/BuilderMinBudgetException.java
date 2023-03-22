package seedu.bigpp.exceptions.builderexceptions;

import seedu.bigpp.exceptions.PPException;

public class BuilderMinBudgetException extends PPException {
    @Override
    public String getMessage() {
        return "You have set a budget that is lower than the current cost of the build, please set a higher budget.";
    }
}
