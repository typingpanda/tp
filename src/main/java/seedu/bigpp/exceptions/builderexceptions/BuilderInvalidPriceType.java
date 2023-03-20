package seedu.bigpp.exceptions.builderexceptions;

import seedu.bigpp.exceptions.PPException;

public class BuilderInvalidPriceType extends PPException {
    @Override
    public String getMessage() {
        return "Price must be an integer";
    }
}
