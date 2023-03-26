package seedu.bigpp.component.motherboard;

import seedu.bigpp.component.Component;
import static seedu.bigpp.component.ComponentType.MOTHERBOARD_TYPE;

public class Motherboard extends Component {
    public static final String COMPONENT_STRING = MOTHERBOARD_TYPE;
    private String size;
    private String socket;
    private float power;

    public Motherboard(String name, String brand, float price, String size, String socket, float power) {
        super.setName(name);
        super.setBrand(brand);
        super.setPrice(price);
        this.size = size;
        this.socket = socket;
        this.power = power;
    }

    public String getFormFactor() {
        return size;
    }

    public void setFormFactor(String size) {
        this.size = size;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "NAME: " + super.getName() +
                "\nBRAND: " + super.getBrand() +
                "\nPRICE: " + super.getPrice() +
                "\nSIZE: " + size +
                "\nSOCKET: " + socket +
                "\nPOWER: " + power;
    }

}
