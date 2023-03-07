package seedu.bigpp.command;

public abstract class Command {

    private String arguments;

    public abstract String executeCommand();

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    public String getArguments() {
        return arguments;
    }
}
