package seedu.bigpp.exceptions.builderexceptions;

import seedu.bigpp.exceptions.PPException;

public class BuilderPriceMissingArguments extends PPException{
    @Override
    public String getMessage() {
        return "Please enter description for price from and price to";
    }
}
