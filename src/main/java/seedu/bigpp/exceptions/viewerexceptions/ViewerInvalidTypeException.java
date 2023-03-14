package seedu.bigpp.exceptions.viewerexceptions;

import seedu.bigpp.exceptions.PPException;

public class ViewerInvalidTypeException extends PPException{
    @Override
    public String getMessage() {
        return "Please enter an integer";
    }
}
