package seedu.bigpp.component.gpu;

import seedu.bigpp.component.Component;

public class GPU extends Component {
    private float power;
    private String size;

    public GPU(String name, String brand, float price, float power, String size) {
        super.setName(name);
        super.setBrand(brand);
        super.setPrice(price);
        this.power = power;
        this.size = size;
    }

    public float getPower() {
        return power;
    }

    public String getSize() {
        return size;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "GPU{" +
                "name='" + super.getName() + '\'' +
                ", brand='" + super.getBrand() + '\'' +
                ", price=" + super.getPrice() +
                ", power=" + power +
                ", size='" + size + '\'' +
                '}';
    }
}
