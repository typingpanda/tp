package seedu.bigpp.component;

import seedu.bigpp.component.chassis.Chassis;
import seedu.bigpp.component.cpu.CPU;
import seedu.bigpp.component.gpu.GPU;
import seedu.bigpp.component.motherboard.Motherboard;
import seedu.bigpp.component.psu.PSU;
import seedu.bigpp.component.ram.RAM;
import seedu.bigpp.component.storage.Storage;

import java.util.ArrayList;

public class ComponentList<T> extends ArrayList<Component> {

    public String getListString(ArrayList<Integer> componentIndexes) {
        String outputString = "";

        if (componentIndexes.size() == 0) {
            for (int i = 0; i < super.size(); i++) {
                outputString += (i + 1) + "." + "\n" + super.get(i).toString() + "\n" + "================\n";
            }

        } else {
            for (int i = 0; i < super.size(); i++) {
                outputString += componentIndexes.get(i).toString() + "." + "\n" + super.get(i)
                        .toString() + "\n" + "================\n";
            }
        }

        return outputString;
    }

    //filter by power with from and to range that are integers
    public static ComponentList<?> filterByPower(ComponentList<?> componentList, int from, int to, ArrayList<Integer>
            componentIndexes) {
        ComponentList<?> filteredComponentList = new ComponentList<>();
        for (int i = 0; i <= componentList.size() - 1; i++) {
            CPU cpu = (CPU) componentList.get(i);
            if (cpu.getPower() >= from && cpu.getPower() <= to) {
                filteredComponentList.add(componentList.get(i));
                componentIndexes.add(i + 1);
            }
        }
        return filteredComponentList;
    }


    //filter by boostclock with from and to range
    public static ComponentList<?> filterByBoostClock(ComponentList<?> componentList, Float from, Float to, ArrayList<Integer>
            componentIndexes) {
        ComponentList<?> filteredComponentList = new ComponentList<>();
        for (int i = 0; i <= componentList.size() - 1; i++) {
            CPU cpu = (CPU) componentList.get(i);
            if (cpu.getBoostClock() >= from && cpu.getBoostClock() <= to) {
                filteredComponentList.add(componentList.get(i));
                componentIndexes.add(i + 1);
            }
        }
        return filteredComponentList;
    }

    public static ComponentList<?> filterByBaseClock(ComponentList<?> componentList, Float from, Float to, ArrayList<Integer>
            componentIndexes) {
        ComponentList<?> filteredComponentList = new ComponentList<>();
        for (int i = 0; i <= componentList.size() - 1; i++) {
            CPU cpu = (CPU) componentList.get(i);
            if (cpu.getBaseClock() >= from && cpu.getBaseClock() <= to) {
                filteredComponentList.add(componentList.get(i));
                componentIndexes.add(i + 1);
            }
        }
        return filteredComponentList;
    }


    public static ComponentList<?> filterByThread(ComponentList<?> componentList, int thread, ArrayList<Integer>
            componentIndexes) {
        ComponentList<?> filteredComponentList = new ComponentList<>();
        for (int i = 0; i <= componentList.size() - 1; i++) {
            CPU cpu = (CPU) componentList.get(i);
            if (cpu.getThreads() == thread) {
                filteredComponentList.add(componentList.get(i));
                componentIndexes.add(i + 1);
            }
        }
        return filteredComponentList;
    }

    public static ComponentList<?> filterByCore(ComponentList<?> componentList, int core, ArrayList<Integer>
            componentIndexes) {
        ComponentList<?> filteredComponentList = new ComponentList<>();
        for (int i = 0; i <= componentList.size() - 1; i++) {
            CPU cpu = (CPU) componentList.get(i);
            if (cpu.getCores() == core) {
                filteredComponentList.add(componentList.get(i));
                componentIndexes.add(i + 1);
            }
        }
        return filteredComponentList;
    }

    public static ComponentList<?> filterBySize(ComponentList<?> componentList, String size, ArrayList<Integer>
            componentIndexes) {
        ComponentList<?> filteredComponentList = new ComponentList<>();
        for (int i = 0; i <= componentList.size() - 1; i++) {
            Chassis chassis = (Chassis) componentList.get(i);
            if (chassis.getSize().toLowerCase().contains(size)) {
                filteredComponentList.add(componentList.get(i));
                componentIndexes.add(i + 1);
            }
        }
        return filteredComponentList;
    }

    public static ComponentList<?> filterByName(ComponentList<?> componentList, String name, ArrayList<Integer>
            componentIndexes) {
        ComponentList<?> filteredComponentList = new ComponentList<>();
        for (int i = 0; i <= componentList.size() - 1; i++) {
            if (componentList.get(i).getName().toLowerCase().contains(name)) {
                filteredComponentList.add(componentList.get(i));
                componentIndexes.add(i + 1);
            }
        }
        return filteredComponentList;
    }

    public static ComponentList<?> filterByBrand(ComponentList<?> componentList, String brand, ArrayList<Integer>
            componentIndexes) {
        ComponentList<?> filteredComponentList = new ComponentList<>();
        for (int i = 0; i <= componentList.size() - 1; i++) {
            if (componentList.get(i).getBrand().toLowerCase().contains(brand)) {
                filteredComponentList.add(componentList.get(i));
                componentIndexes.add(i + 1);
            }
        }
        return filteredComponentList;
    }

    public static ComponentList<?> filterByPrice(ComponentList<?> componentList, String priceFrom, String priceTo,
            ArrayList<Integer> componentIndexes) {
        ComponentList<?> filteredComponentList = new ComponentList<>();
        for (int i = 0; i <= componentList.size() - 1; i++) {
            if (componentList.get(i).getPrice() >= Float.parseFloat(priceFrom) && componentList.get(i)
                    .getPrice() <= Float.parseFloat(
                            priceTo)) {
                filteredComponentList.add(componentList.get(i));
                componentIndexes.add(i + 1);
            }
        }
        return filteredComponentList;
    }
}
