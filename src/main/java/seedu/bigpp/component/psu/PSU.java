package seedu.bigpp.component.psu;

import seedu.bigpp.component.Component;

public class PSU extends Component {
    private String efficiency;
    private String formFactor;
    private int power;

    public PSU(String name, float price, String brand, String efficiency, String formFactor, int power) {
        super.setName(name);
        super.setPrice(price);
        super.setBrand(brand);
        this.efficiency = efficiency;
        this.formFactor = formFactor;
        this.power = power;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "PSU{" +
                "name='" + super.getName() + '\'' +
                ", brand='" + super.getBrand() + '\'' +
                ", price=" + super.getPrice() +
                ", efficiency='" + efficiency + '\'' +
                ", formFactor='" + formFactor + '\'' +
                ", power=" + power +
                '}';
    }
}
