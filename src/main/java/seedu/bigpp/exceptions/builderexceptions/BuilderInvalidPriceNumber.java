package seedu.bigpp.exceptions.builderexceptions;

import seedu.bigpp.exceptions.PPException;

public class BuilderInvalidPriceNumber extends PPException {
    @Override
    public String getMessage() {
        return "Price must be a positive integer";
    }
    
}
