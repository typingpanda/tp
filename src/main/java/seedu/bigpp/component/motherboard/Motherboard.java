package seedu.bigpp.component.motherboard;

import seedu.bigpp.component.Component;

public class Motherboard extends Component {
    private String formFactor;
    private String socket;
    private int power;

    public Motherboard(String name, String brand, float price, String formFactor, String socket, int power) {
        super.setName(name);
        super.setBrand(brand);
        super.setPrice(price);
        this.formFactor = formFactor;
        this.socket = socket;
        this.power = power;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Motherboard{" +
                "name='" + super.getName() + '\'' +
                ", brand='" + super.getBrand() + '\'' +
                ", price=" + super.getPrice() +
                ", formFactor='" + formFactor + '\'' +
                ", socket='" + socket + '\'' +
                ", power=" + power +
                '}';
    }

}
