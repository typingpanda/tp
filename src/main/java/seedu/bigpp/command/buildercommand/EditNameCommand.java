package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.builder.Builder;
import seedu.bigpp.builder.CurrentBuilder;

public class EditNameCommand extends Command {

    public EditNameCommand(String arguments) {
        super.setArguments(arguments);
    }

    @Override
    public String executeCommand() {
        String name = super.getArguments();
        Builder currentBuilder = CurrentBuilder.getBuilder();
        currentBuilder.setName(name);
        return "Current build name is now: " + name;
    }
}
