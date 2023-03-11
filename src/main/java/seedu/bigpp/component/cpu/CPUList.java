package seedu.bigpp.component.cpu;

import java.util.ArrayList;

public abstract class CPUList {

    private static ArrayList<CPU> cpuList = new ArrayList<>();

    public static void addCPU(CPU cpu) {
        cpuList.add(cpu);
    }
}
