package seedu.bigpp.datastorage;

import static seedu.bigpp.ui.UI.out;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import seedu.bigpp.component.chassis.Chassis;
import seedu.bigpp.component.chassis.ChassisList;
import seedu.bigpp.component.cpu.CPU;
import seedu.bigpp.component.cpu.CPUList;
import seedu.bigpp.component.cpucooler.CPUCooler;
import seedu.bigpp.component.cpucooler.CPUCoolerList;
import seedu.bigpp.component.gpu.GPU;
import seedu.bigpp.component.gpu.GPUList;
import seedu.bigpp.component.motherboard.Motherboard;
import seedu.bigpp.component.motherboard.MotherboardList;
import seedu.bigpp.component.psu.PSU;
import seedu.bigpp.component.psu.PSUList;
import seedu.bigpp.component.ram.RAM;
import seedu.bigpp.component.ram.RAMList;
import seedu.bigpp.component.storage.Storage;
import seedu.bigpp.component.storage.StorageList;

public abstract class DataStorage {
    private static final String CHASSIS_PATH = "./userdata/chassis/chassis.json";
    private static final String CPU_PATH = "./userdata/cpu/cpu.json";
    private static final String CPU_COOLER_PATH = "./userdata/cpucooler/cpucooler.json";
    private static final String GPU_PATH = "./userdata/gpu/gpu.json";
    private static final String MOTHERBOARD_PATH = "./userdata/motherboard/motherboard.json";
    private static final String PSU_PATH = "./userdata/psu/psu.json";
    private static final String RAM_PATH = "./userdata/ram/ram.json";
    private static final String STORAGE_PATH = "./userdata/storage/storage.json";

    private static final String PREBUILT_PATH = "./userdata/prebuilt/prebuilt.json";
    private static final String USER_PATH = "./userdata/user/user.json";

    private static final Gson GSON = new Gson();

    /**
     * Loads all the components from the json files.
     */
    public static void loadAll() {
        loadChassis();
        loadCPU();
        loadCPUCooler();
        loadGPU();
        loadMotherboard();
        loadPSU();
        loadRAM();
        loadStorage();
    }

    /**
     * Loads all the chassis from the json file into ChassisList.
     */
    public static void loadChassis() {
        try {
            String json = Files.readString(Paths.get(CHASSIS_PATH));

            Map<String, Chassis> chassisMap = GSON.fromJson(json, new TypeToken<Map<String, Chassis>>() {
            }.getType());

            // Add each chassis to the chassis list
            chassisMap.forEach((name, chassis) -> ChassisList.addChassis(chassis));

        } catch (IOException e) {
            out.println(CHASSIS_PATH + " not found");
            System.exit(1);
        }
    }

    /**
     * Loads all the CPU from the json file into CPUList.
     */
    public static void loadCPU() {
        try {
            String json = Files.readString(Paths.get(CPU_PATH));

            Map<String, CPU> cpuMap = GSON.fromJson(json, new TypeToken<Map<String, CPU>>() {
            }.getType());

            // Add each CPU to the CPU list
            cpuMap.forEach((name, cpu) -> CPUList.addCPU(cpu));

        } catch (IOException e) {
            out.println(CPU_PATH + " not found");
            System.exit(1);
        }
    }

    /**
     * Loads all the CPU Cooler from the json file into CPUCoolerList.
     */
    public static void loadCPUCooler() {
        try {
            String json = Files.readString(Paths.get(CPU_COOLER_PATH));

            Map<String, CPUCooler> cpuCoolerMap = GSON.fromJson(json, new TypeToken<Map<String, CPUCooler>>() {
            }.getType());

            // Add each CPU Cooler to the CPU Cooler list
            cpuCoolerMap.forEach((name, cpuCooler) -> CPUCoolerList.addCPUCooler(cpuCooler));

        } catch (IOException e) {
            out.println(CPU_COOLER_PATH + " not found");
            System.exit(1);
        }
    }

    /**
     * Loads all the GPU from the json file into GPUList.
     */
    public static void loadGPU() {
        try {
            String json = Files.readString(Paths.get(GPU_PATH));

            Map<String, GPU> gpuMap = GSON.fromJson(json, new TypeToken<Map<String, GPU>>() {
            }.getType());

            // Add each GPU to the GPU list
            gpuMap.forEach((name, gpu) -> GPUList.addGPU(gpu));

        } catch (IOException e) {
            out.println(GPU_PATH + " not found");
            System.exit(1);
        }
    }

    /**
     * Loads all the Motherboard from the json file into MotherboardList.
     */
    public static void loadMotherboard() {
        try {
            String json = Files.readString(Paths.get(MOTHERBOARD_PATH));

            Map<String, Motherboard> motherboardMap = GSON.fromJson(json, new TypeToken<Map<String, Motherboard>>() {
            }.getType());

            // Add each Motherboard to the Motherboard list
            motherboardMap.forEach((name, motherboard) -> MotherboardList.addMotherboard(motherboard));

        } catch (IOException e) {
            out.println(MOTHERBOARD_PATH + " not found");
            System.exit(1);
        }
    }

    /**
     * Loads all the PSU from the json file into PSUList.
     */
    public static void loadPSU() {
        try {
            String json = Files.readString(Paths.get(PSU_PATH));

            Map<String, PSU> psuMap = GSON.fromJson(json, new TypeToken<Map<String, PSU>>() {
            }.getType());

            // Add each PSU to the PSU list
            psuMap.forEach((name, psu) -> PSUList.addPSU(psu));

        } catch (IOException e) {
            out.println(PSU_PATH + " not found");
            System.exit(1);
        }
    }

    /**
     * Loads all the RAM from the json file into RAMList.
     */
    public static void loadRAM() {
        try {
            String json = Files.readString(Paths.get(RAM_PATH));

            Map<String, RAM> ramMap = GSON.fromJson(json, new TypeToken<Map<String, RAM>>() {
            }.getType());

            // Add each RAM to the RAM list
            ramMap.forEach((name, ram) -> RAMList.addRAM(ram));

        } catch (IOException e) {
            out.println(RAM_PATH + " not found");
            System.exit(1);
        }
    }

    /**
     * Loads all the Storage from the json file into StorageList.
     */
    public static void loadStorage() {
        try {
            String json = Files.readString(Paths.get(STORAGE_PATH));

            Map<String, Storage> storageMap = GSON.fromJson(json, new TypeToken<Map<String, Storage>>() {
            }.getType());

            // Add each Storage to the Storage list
            storageMap.forEach((name, storage) -> StorageList.addStorage(storage));

        } catch (IOException e) {
            out.println(STORAGE_PATH + " not found");
            System.exit(1);
        }
    }
}
