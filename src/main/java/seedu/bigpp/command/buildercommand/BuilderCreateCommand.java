package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.builder.Builder;
import seedu.bigpp.builder.CurrentBuilder;

public class BuilderCreateCommand extends Command {
    public BuilderCreateCommand(String arguments) {
        super.setArguments(arguments);
    }

    @Override
    public String executeCommand() {
        int index = Integer.parseInt(super.getArguments());
        Builder builder = new Builder(index);
        CurrentBuilder.setBuilder(builder);
        return "Build: [ " + builder.getName() + " ] is currently being edited";
    }

}
