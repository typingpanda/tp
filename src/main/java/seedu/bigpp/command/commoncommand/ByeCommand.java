package seedu.bigpp.command.commoncommand;

import seedu.bigpp.command.Command;

public class ByeCommand extends Command {

    /*
     * bye command to exit the program
     * 
     * @return the message displaying the exit message
     */
    @Override
    public String executeCommand() {
        return "Bye. Hope to see you again soon!";
    }
}
