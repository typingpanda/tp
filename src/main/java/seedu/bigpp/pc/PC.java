package seedu.bigpp.pc;

import seedu.bigpp.component.cpu.CPU;
import static seedu.bigpp.ui.UI.out;

public class PC {
    private String name;
    // private CPU cpu;
    private Boolean isPrebuilt;

    private CPU cpu = null;

    private int budget;

    public PC(String name, Boolean isPrebuilt) {
        this.name = name;
        // this.cpu = new CPU();
        this.isPrebuilt = isPrebuilt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean getIsPreBuilt() {
        return isPrebuilt;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setCPU(CPU cpu) {
        this.cpu = cpu;
    }

    public Float getCost() {
        Float totalCost = 0.00F;
        if (cpu == null) {
            return totalCost;
        }
        totalCost += cpu.getPrice();
        return totalCost;
    }

    public String buildType(Boolean isPrebuilt) {
        if (isPrebuilt) {
            return "Prebuilt-PC:";
        } else {
            return "Custom-PC:";
        }
    }

    public void printComponents() {
        out.println(cpu);
        // print other components when classes are created for individual components
    }

    @Override
    public String toString() {
        return buildType(isPrebuilt) + " [" + name + "]" + " - $" + getCost();
    }
}
