package seedu.bigpp.component;

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
