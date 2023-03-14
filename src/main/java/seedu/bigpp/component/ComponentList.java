package seedu.bigpp.component;

import java.util.ArrayList;

public class ComponentList<T> extends ArrayList<Component> {
    public String getListString() {
        String outputString = "";

        for (int i = 0; i < this.size(); i++) {
            outputString += (i + 1) + "." + "\n" + this.get(i).toString() + "\n" + "================\n";
        }

        return outputString;
    }
}
