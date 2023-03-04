package seedu.bigpp.component;

public abstract class Component {
    private String name;
    private String brand;
    private float price;

    public String getName() {
        return this.name;
    }

    public String getBrand() {
        return this.brand;
    }

    public float getPrice() {
        return this.price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract String toString();
}
