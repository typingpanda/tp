package seedu.bigpp.exceptions.builderexceptions;

import seedu.bigpp.exceptions.PPException;

public class BuilderInvalidTypeException extends PPException{
    @Override
    public String getMessage() {
        return "Please enter an integer";
    }
}
