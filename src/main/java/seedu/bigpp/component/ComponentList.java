package seedu.bigpp.component;

import java.util.ArrayList;

public class ComponentList<T> extends ArrayList<Component> {

    public String getListString() {
        String outputString = "";

        for (int i = 0; i < super.size(); i++) {
            outputString += (i + 1) + "." + "\n" + super.get(i).toString() + "\n" + "================\n";
        }

        return outputString;
    }

    public static ComponentList<?> filterByName(ComponentList<?> componentList, String name) {
        ComponentList<?> filteredComponentList = new ComponentList<>();
        for (Component component : componentList) {
            if (component.getName().toLowerCase().contains(name)) {
                filteredComponentList.add(component);
            }
        }
        return filteredComponentList;
    }

    public static ComponentList<?> filterByBrand(ComponentList<?> componentList, String brand) {
        ComponentList<?> filteredComponentList = new ComponentList<>();
        for (Component component : componentList) {
            if (component.getBrand().toLowerCase().contains(brand)) {
                filteredComponentList.add(component);
            }
        }
        return filteredComponentList;
    }

    public static ComponentList<?> filterByPrice(ComponentList<?> componentList, String priceFrom, String priceTo) {
        ComponentList<?> filteredComponentList = new ComponentList<>();
        for (Component component : componentList) {
            if (component.getPrice() >= Float.parseFloat(priceFrom) && component.getPrice() <= Float.parseFloat(
                    priceTo)) {
                filteredComponentList.add(component);
            }
        }
        return filteredComponentList;
    }
}
