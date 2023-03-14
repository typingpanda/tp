package seedu.bigpp.exceptions.builderexceptions;

import seedu.bigpp.exceptions.PPException;

public class BuilderMissingListException extends PPException {

    @Override
    public String getMessage() {
        return "Please enter a component type to list";
    }
}
