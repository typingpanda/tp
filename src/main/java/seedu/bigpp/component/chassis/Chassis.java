package seedu.bigpp.component.chassis;

import seedu.bigpp.component.Component;

public class Chassis extends Component {
    private String size;

    public Chassis(String name, String brand, float price, String size) {
        super.setName(name);
        super.setBrand(brand);
        super.setPrice(price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Chassis{" +
                "name='" + super.getName() + '\'' +
                ", brand='" + super.getBrand() + '\'' +
                ", price=" + super.getPrice() +
                ", size='" + size + '\'' +
                '}';
    }
}
