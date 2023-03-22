package seedu.bigpp.exceptions.builderexceptions;

import seedu.bigpp.exceptions.PPException;

public class BuilderPriceLogicException extends PPException {
    @Override
    public String getMessage() {
        return "Price to must be greater than price from";
    }
}
