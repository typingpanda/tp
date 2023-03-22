package seedu.bigpp.exceptions.builderexceptions;

import seedu.bigpp.exceptions.PPException;

public class BuilderPriceFlagException extends PPException {
    @Override
    public String getMessage() {
        return "Please use /from and /to to specify the price range.";
    }
}
