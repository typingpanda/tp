package seedu.bigpp.pc;
import java.util.ArrayList;
import static seedu.bigpp.ui.UI.out;
public class PCList extends ArrayList<PC> {

    private static Boolean isFilter;
    private static String costFrom;
    private static String costTo;
    private static String name;
    private static String built;

    public PCList() {
        isFilter = false;
        built = "";
        costFrom = "";
        costTo = "";
        name = "";

    }
    public void printPcList() {
        if (isFilter) {
            printAltPcList();
        }
        else {
            if (this.size() > 0) {
                out.println("Here is the list of PC Builds:");
                for (int i = 0; i < this.size(); i++) {
                    out.println((i + 1) + "." + this.get(i));
                }
            }
            else {
                out.println("List currently empty!");
            }
        }
    }
    public void printAltPcList() {
        int pcCount = 0;
        if (this.size() > 0) {
            out.println("Here is the list of PC Builds:");
            for (int i = 0; i < this.size(); i++) {
                if (filterByBuilt(this.get(i), getIsBuilt()) && filterByCost(this.get(i),
                        getCostFrom(), getCostTo()) && filterByName(this.get(i), getName())) {
                    out.println((i + 1) + "." + this.get(i));
                    pcCount += 1;
                }
            }
            if (pcCount == 0) {
                out.println("Filtered list is empty");
            }
        } else {
            out.println("List currently empty!");
        }
    }
    public static Boolean getIsFilter() {
        return isFilter;
    }
    public static String getIsBuilt() {
        return built;
    }
    public static String getName() {
        return name;
    }
    public static String getCostFrom() {
        return costFrom;
    }
    public static String getCostTo() {
        return costTo;
    }
    public static void setFilterTrue() {
        isFilter = true;
    }
    public static void setFilterFalse() {
        isFilter = false;
    }

    public static void setBuilt(String input) {
        built = input;
    }

    public static void setName(String input) {
        name = input;
    }
    public static void setCostFrom(String input) {
        costFrom = input;
    }
    public static void setCostTo(String input) {
        costTo = input;
    }
    public static Boolean filterByCost(PC pc, String costFrom, String costTo) {
        if (costFrom == "") {
            return true;
        }
        if (pc.getCost() >= Integer.parseInt(costFrom) && pc.getCost() <= Integer.parseInt(costTo)) {
            return true;
        }
        else {
            return false;
        }
    }
    public static Boolean filterByName(PC pc, String name) {
        if (name == "") {
            return true;
        }
        if (pc.getName().toLowerCase().contains(name)) {
          return true;
        }
        else {
            return false;
        }
    }

    public static Boolean filterByBuilt(PC pc, String built) {
        if (built == "") {
            return true;
        }
        Boolean isBuilt = null;
        switch(built) {
        case "complete":
            isBuilt = true;
            break;
        case "incomplete":
            isBuilt = false;
            break;
        default:
            break;
        }
        if (pc.isComplete() == isBuilt) {
            return true;
        }
        else {
            return false;
        }
    }
}
