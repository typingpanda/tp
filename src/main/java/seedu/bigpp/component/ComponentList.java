package seedu.bigpp.component;

import seedu.bigpp.component.chassis.Chassis;
import seedu.bigpp.component.cpu.CPU;
// import seedu.bigpp.component.gpu.GPU;
// import seedu.bigpp.component.motherboard.Motherboard;
// import seedu.bigpp.component.psu.PSU;
// import seedu.bigpp.component.ram.RAM;
// import seedu.bigpp.component.storage.Storage;

import java.util.ArrayList;

public class ComponentList<T> extends ArrayList<Component> {

    /*
     * Lists all components in the list. If the list is filtered, the indexes of the
     * components in the original list will be shown.
     * 
     * @return a string containing all the components in the list
     */
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

    public static ComponentList<?> filterBySocket(ComponentList<?> componentList, String socket,
            ArrayList<Integer> componentIndexes) {
        ComponentList<?> filteredComponentList = new ComponentList<>();
        for (int i = 0; i <= componentList.size() - 1; i++) {
            CPU cpu = (CPU) componentList.get(i);
            if (cpu.getSocket().toLowerCase().equals(socket)) {
                filteredComponentList.add(componentList.get(i));
                componentIndexes.add(i + 1);
            }
        }
        return filteredComponentList;
    }

    public static ComponentList<?> filterByPower(ComponentList<?> componentList, int from, int to,
            ArrayList<Integer> componentIndexes) {
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

    public static ComponentList<?> filterByBoostClock(ComponentList<?> componentList, Float from, Float to,
            ArrayList<Integer> componentIndexes) {
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

    public static ComponentList<?> filterByBaseClock(ComponentList<?> componentList, Float from, Float to,
            ArrayList<Integer> componentIndexes) {
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

    public static ComponentList<?> filterByThread(ComponentList<?> componentList, int thread,
            ArrayList<Integer> componentIndexes) {
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

    public static ComponentList<?> filterByCore(ComponentList<?> componentList, int core,
            ArrayList<Integer> componentIndexes) {
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

    public static ComponentList<?> filterBySize(ComponentList<?> componentList, String size,
            ArrayList<Integer> componentIndexes) {
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

    /*
     * Filters the list of components by name. Adds the index of the component in
     * the original list to the componentIndexes list.
     * 
     * @param componentList the list of components to be filtered
     */
    public static ComponentList<?> filterByName(ComponentList<?> componentList, String name,
            ArrayList<Integer> componentIndexes) {
        ComponentList<?> filteredComponentList = new ComponentList<>();
        for (int i = 0; i <= componentList.size() - 1; i++) {
            if (componentList.get(i).getName().toLowerCase().contains(name)) {
                filteredComponentList.add(componentList.get(i));
                componentIndexes.add(i + 1);
            }
        }
        return filteredComponentList;
    }

    /*
     * Filters the list of components by brand. Adds the index of the component in
     * the original list to the componentIndexes list.
     * 
     * @return componentList the list of components to be filtered
     */
    public static ComponentList<?> filterByBrand(ComponentList<?> componentList, String brand,
            ArrayList<Integer> componentIndexes) {
        ComponentList<?> filteredComponentList = new ComponentList<>();
        for (int i = 0; i <= componentList.size() - 1; i++) {
            if (componentList.get(i).getBrand().toLowerCase().contains(brand)) {
                filteredComponentList.add(componentList.get(i));
                componentIndexes.add(i + 1);
            }
        }
        return filteredComponentList;
    }

    /*
     * Filters the list of components by price. Adds the index of the component in
     * the original list to the componentIndexes list.
     * 
     * @return componentList the list of components to be filtered
     */
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
