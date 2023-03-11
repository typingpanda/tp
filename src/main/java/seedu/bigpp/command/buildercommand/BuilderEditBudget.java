package seedu.bigpp.command.buildercommand;

import seedu.bigpp.command.Command;
import seedu.bigpp.builder.Builder;
import seedu.bigpp.builder.CurrentBuilder;

public class BuilderEditBudget extends Command {
    public BuilderEditBudget(String arguments) {
        super.setArguments(arguments);
    }

    @Override
    public String executeCommand() {
        int budget = Integer.parseInt(super.getArguments());
        Builder currentBuilder = CurrentBuilder.getBuilder();
        currentBuilder.setBudget(budget);
        return "Current build budget is now: " + budget;
    }
}
