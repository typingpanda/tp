package seedu.bigpp.pc;

import seedu.bigpp.component.cpu.CPU;

public class PC {
    private String name;
    // private CPU cpu;
    private Boolean isPrebuilt;

    private CPU cpu = null;

    public PC(String name, Boolean isPrebuilt) {
        this.name = name;
        // this.cpu = new CPU();
        this.isPrebuilt = isPrebuilt;
    }

    public String getName() {
        return name;
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
            return "Prebuilt-PC";
        } else {
            return "Custom-PC";
        }
    }

    @Override
    public String toString() {
        return buildType(isPrebuilt) + " [" + name + "]" + " - $" + getCost();
    }
}
