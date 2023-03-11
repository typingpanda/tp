package seedu.bigpp.component.cpucooler;

import java.util.ArrayList;

public abstract class CPUCoolerList {
    private static ArrayList<CPUCooler> cpuCoolerList = new ArrayList<>();

    public static void addCPUCooler(CPUCooler cpuCooler) {
        cpuCoolerList.add(cpuCooler);
    }
}
