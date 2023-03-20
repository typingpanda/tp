package seedu.bigpp.exceptions.builderexceptions;

import seedu.bigpp.exceptions.PPException;

public class BuilderMissingBrandException extends PPException {
    @Override
    public String getMessage() {
        return "Please enter a brand";
    }
}
