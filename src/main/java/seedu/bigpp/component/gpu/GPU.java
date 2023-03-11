package seedu.bigpp.component.gpu;

import seedu.bigpp.component.Component;

public class GPU extends Component {
    private int power;
    private String size;

    public GPU(String name, String brand, float price, int power, String size) {
        super.setName(name);
        super.setBrand(brand);
        super.setPrice(price);
        this.power = power;
        this.size = size;
    }

    public int getPower() {
        return power;
    }

    public String getSize() {
        return size;
    }

    public void setPower(int power) {
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
