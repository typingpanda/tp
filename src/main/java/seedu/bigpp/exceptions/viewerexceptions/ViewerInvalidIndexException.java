package seedu.bigpp.exceptions.viewerexceptions;

import seedu.bigpp.exceptions.PPIndexOutOfBoundsException;

public class ViewerInvalidIndexException extends PPIndexOutOfBoundsException {

    /**
     * Return a message to inform the user that the index being accessed is out of the list range
     */
    @Override
    public String getMessage() {
        return "Please enter a valid index";
    }
}
