package seedu.bigpp.component.gpu;

import java.util.ArrayList;

public abstract class GPUList {
    private static ArrayList<GPU> gpuList = new ArrayList<>();

    public static void addGPU(GPU gpu) {
        gpuList.add(gpu);
    }
}
