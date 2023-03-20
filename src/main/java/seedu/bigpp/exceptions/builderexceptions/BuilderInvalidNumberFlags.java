package seedu.bigpp.exceptions.builderexceptions;

import seedu.bigpp.exceptions.PPException;

public class BuilderInvalidNumberFlags extends PPException{
    @Override
    public String getMessage() {
        return "Please enter a valid number of flags";
    }
    
}
