package seedu.bigpp.component.cpu;

public class CPU {
    private String name;
    private String brand;
    private String socket;
    private String core;
    private String clock;
    private String price;

    public CPU(String name, String brand, String socket, String core, String clock, String price) {
        this.name = name;
        this.brand = brand;
        this.socket = socket;
        this.core = core;
        this.clock = clock;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getSocket() {
        return socket;
    }

    public String getCore() {
        return core;
    }

    public String getClock() {
        return clock;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "cpu [brand=" + brand + ", clock=" + clock + ", core=" + core + ", name=" + name + ", price=" + price
                + ", socket=" + socket + "]";
    }
}
