package seedu.bigpp.exceptions.builderexceptions;

import seedu.bigpp.exceptions.PPException;

public class BuilderInvalidFlagArgument extends PPException{
    @Override
    public String getMessage() {
        return "Please enter valid arguments for the flags";
    }
    
}
