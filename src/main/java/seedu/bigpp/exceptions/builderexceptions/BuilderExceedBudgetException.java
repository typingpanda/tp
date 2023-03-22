package seedu.bigpp.exceptions.builderexceptions;

import seedu.bigpp.exceptions.PPException;

public class BuilderExceedBudgetException extends PPException {
    @Override
    public String getMessage() {
        return "You have exceeded your budget, component not added.";
    }
}
