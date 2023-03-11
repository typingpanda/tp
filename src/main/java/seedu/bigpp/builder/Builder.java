package seedu.bigpp.builder;

import seedu.bigpp.pc.PC;
import seedu.bigpp.pc.PCList;

public class Builder {

    private int budget = 0;
    private PC pc;

    public Builder(int currentPCindex) {
        this.pc = PCList.getPC(currentPCindex - 1);
    }

    public String getName() {
        return this.pc.getName();
    }

    public int getBudget() {
        return budget;
    }

    public void setName(String name) {
        this.pc.setName(name);
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
