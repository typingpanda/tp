package seedu.bigpp.pc;

import java.util.ArrayList;
import static seedu.bigpp.ui.UI.out;

public class PCList extends ArrayList<PC> {

    private static Boolean isFilter;
    private static String filterType;
    private static String arguments;

    public PCList() {
        this.isFilter = false;
        this.filterType = "";
        this.arguments = "";
    }

    public void printPcList() {
        if (isFilter) {
            printAltPcList();
        } else  {
            if (this.size() > 0) {
                out.println("Here is the list of PC Builds:");
                for (int i = 0; i < this.size(); i++) {
                    out.println((i + 1) + "." + this.get(i));
                }
            } else {
                out.println("List currently empty!");
            }
        }
    }

    public void printAltPcList() {
        ArrayList<PC> filterList = new ArrayList();
        switch (filterType) {
        case "name":
            for (int i = 0; i < this.size(); i++) {
                if ((this.get(i).getName()).contains(getArguments())) {
                    filterList.add(this.get(i));
                }
            }
            break;
        case "built":
            if (getArguments().equals("complete")) {
                for (int i = 0; i < this.size(); i++) {
                    if (this.get(i).isComplete()) {
                        filterList.add(this.get(i));
                    }
                }
            }
            else {
                for (int i = 0; i < this.size(); i++) {
                    if (!(this.get(i).isComplete())) {
                        filterList.add(this.get(i));
                    }
                }
            }
            break;
        case "cost":
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).getCost() >= Integer.parseInt(getArguments())) {
                    filterList.add(this.get(i));
                }
            }
            break;
        default:
            break;
        }
        if (filterList.size() > 0) {
            out.println("Here is the list of PC Builds:");
            for (int i = 0; i < filterList.size(); i++) {
                out.println((i + 1) + "." + filterList.get(i));
            }
        } else {
            out.println("List currently empty!");
        }
    }

    public String getArguments() {
        return arguments;
    }

    public static Boolean getIsFilter() {
        return isFilter;
    }
    public static void setFilterTrue() {
        isFilter = true;
    }
    public static void setFilterFalse() {
        isFilter = false;
    }
    public static void setFilterType (String input) {
        filterType = input;
    }
    public static void setArguments (String input) {
        arguments = input;
    }
}
