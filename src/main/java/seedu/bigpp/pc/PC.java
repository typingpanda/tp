package seedu.bigpp.pc;

import seedu.bigpp.component.Component;
import seedu.bigpp.component.chassis.Chassis;
import seedu.bigpp.component.cpu.CPU;
import seedu.bigpp.component.cpucooler.CPUCooler;
import seedu.bigpp.component.gpu.GPU;
import seedu.bigpp.component.motherboard.Motherboard;
import seedu.bigpp.component.psu.PSU;
import seedu.bigpp.component.ram.RAM;
import seedu.bigpp.component.storage.Storage;
import seedu.bigpp.ui.UI;
import static seedu.bigpp.component.ComponentType.CHASSIS_TYPE;
import static seedu.bigpp.component.ComponentType.CPU_TYPE;
import static seedu.bigpp.component.ComponentType.CPU_COOLER_TYPE;
import static seedu.bigpp.component.ComponentType.GPU_TYPE;
import static seedu.bigpp.component.ComponentType.MOTHERBOARD_TYPE;
import static seedu.bigpp.component.ComponentType.PSU_TYPE;
import static seedu.bigpp.component.ComponentType.RAM_TYPE;
import static seedu.bigpp.component.ComponentType.STORAGE_TYPE;

public class PC {
    private String name;
    private Boolean isPrebuilt;
    private CPU cpu = null;
    private CPUCooler cpuCooler = null;
    private GPU gpu = null;
    private Motherboard motherboard = null;
    private RAM ram = null;
    private Storage storage = null;
    private PSU psu = null;
    private Chassis chassis = null;

    private int budget = -1;

    public PC(String name, Boolean isPrebuilt) {
        this.name = name;
        this.isPrebuilt = isPrebuilt;
    }

    public PC(PC pcCopy) {
        this.name = pcCopy.getName() + " (copy)";
        this.isPrebuilt = false;
        this.cpu = pcCopy.getCpu();
        this.cpuCooler = pcCopy.getCpuCooler();
        this.gpu = pcCopy.getGpu();
        this.motherboard = pcCopy.getMotherboard();
        this.ram = pcCopy.getRam();
        this.storage = pcCopy.getStorage();
        this.psu = pcCopy.getPsu();
        this.chassis = pcCopy.getChassis();
        this.budget = pcCopy.getBudget();
    }

    public void setChassis(Chassis chassis) {
        this.chassis = chassis;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setCpuCooler(CPUCooler cpuCooler) {
        this.cpuCooler = cpuCooler;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setPsu(PSU psu) {
        this.psu = psu;
    }

    public void setComponent(Component component) {
        if (component instanceof CPU) {
            setCpu((CPU) component);
        } else if (component instanceof CPUCooler) {
            setCpuCooler((CPUCooler) component);
        } else if (component instanceof GPU) {
            setGpu((GPU) component);
        } else if (component instanceof Motherboard) {
            setMotherboard((Motherboard) component);
        } else if (component instanceof RAM) {
            setRam((RAM) component);
        } else if (component instanceof Storage) {
            setStorage((Storage) component);
        } else if (component instanceof PSU) {
            setPsu((PSU) component);
        } else if (component instanceof Chassis) {
            setChassis((Chassis) component);
        }
    }

    public void setNullComponent(String componentType) {
        if (componentType.equals(CPU_TYPE)) {
            setCpu(null);
        } else if (componentType.equals(CPU_COOLER_TYPE)) {
            setCpuCooler(null);
        } else if (componentType.equals(GPU_TYPE)) {
            setGpu(null);
        } else if (componentType.equals(MOTHERBOARD_TYPE)) {
            setMotherboard(null);
        } else if (componentType.equals(RAM_TYPE)) {
            setRam(null);
        } else if (componentType.equals(STORAGE_TYPE)) {
            setStorage(null);
        } else if (componentType.equals(PSU_TYPE)) {
            setPsu(null);
        } else if (componentType.equals(CHASSIS_TYPE)) {
            setChassis(null);
        }
    }

    public CPU getCpu() {
        return cpu;
    }

    public CPUCooler getCpuCooler() {
        return cpuCooler;
    }

    public GPU getGpu() {
        return gpu;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public RAM getRam() {
        return ram;
    }

    public Storage getStorage() {
        return storage;
    }

    public PSU getPsu() {
        return psu;
    }

    public Chassis getChassis() {
        return chassis;
    }

    public Component getComponent(String componentName) {
        if (componentName.equals(CPU_TYPE)) {
            return getCpu();
        } else if (componentName.equals(CPU_COOLER_TYPE)) {
            return getCpuCooler();
        } else if (componentName.equals(GPU_TYPE)) {
            return getGpu();
        } else if (componentName.equals(MOTHERBOARD_TYPE)) {
            return getMotherboard();
        } else if (componentName.equals(RAM_TYPE)) {
            return getRam();
        } else if (componentName.equals(STORAGE_TYPE)) {
            return getStorage();
        } else if (componentName.equals(PSU_TYPE)) {
            return getPsu();
        } else if (componentName.equals(CHASSIS_TYPE)) {
            return getChassis();
        } else {
            return null;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBudget(int budget) {
        this.budget = budget;
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

    public String getBudgetString() {
        return (budget == -1) ? "infinite" : "$" + UI.moneyDecimalFormat.format(budget);
    }

    /**
     * Gets the cost of each of the components in the PC and returns the total.
     * @return totalCost
     */
    public float getCost() {
        float totalCost = 0.00f;
        Component[] components = { cpu, cpuCooler, gpu, motherboard, ram, storage, psu };
        for (Component component : components) {
            if (component != null) {
                totalCost += component.getPrice();
            }
        }
        // give price to 2 dp
        totalCost = Float.parseFloat(UI.moneyDecimalFormat.format(totalCost));
        return totalCost;
    }

    public String buildType(Boolean isPrebuilt) {
        if (isPrebuilt) {
            return "Prebuilt-PC:";
        } else {
            return "Custom-PC:";
        }
    }

    /**
     * Method to check if the PC is complete.
     * @return true if all components are not null, false otherwise.
     */
    public boolean isComplete() {
        if (cpu == null || gpu == null || motherboard == null || ram == null || storage == null || psu == null
                || chassis == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Method to print all the components of the PC.
     */
    public String viewComponents() {
        String componentString = "";

        componentString += this.toString() + "\n";
        componentString += ("Components:" + '\n');

        String[] componentNames = { "CPU        :", "CPU Cooler :", "GPU        :", "Motherboard:", "RAM        :",
            "Storage    :", "PSU        :", "Chassis    :" };

        Component[] components = { cpu, cpuCooler, gpu, motherboard, ram, storage, psu, chassis };

        int index = 0;
        for (Component component : components) {
            if (component != null) {
                // out.println(componentNames[index] + component.getName());
                componentString += (componentNames[index] + " " + component.getName() + '\n');
            } else {
                // out.println(componentNames[index] + ": - Not Selected -");
                componentString += (componentNames[index] + " - Not Selected -" + '\n');
            }
            index++;
        }
        return componentString;
    }

    /**
     * Method to print the PC's name and cost and build status.
     */
    @Override
    public String toString() {
        return buildType(isPrebuilt) + " [" + name + "]" + " - $" + getCost() + "/" + getBudgetString() + " - "
                + (isComplete() ? "Complete" : "Incomplete");
    }
}
