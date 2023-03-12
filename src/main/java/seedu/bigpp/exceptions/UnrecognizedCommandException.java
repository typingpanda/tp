package seedu.bigpp.exceptions;

public class UnrecognizedCommandException extends PPException{
    @Override
    public String getMessage() {
        return "Unrecognized command";
    }
}
