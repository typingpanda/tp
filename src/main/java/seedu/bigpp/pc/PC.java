package seedu.bigpp.pc;

public class PC {
    private String name;
    // private CPU cpu;

    public PC(String name) {
        this.name = name;
        // this.cpu = new CPU();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PC [category=" + category + ", description=" + description + ", link=" + link + ", name=" + name
                + ", price=" + price + ", tag=" + tag + "]";
    }
}
