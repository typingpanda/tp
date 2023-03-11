package seedu.bigpp.component.cpucooler;

import seedu.bigpp.component.Component;

public class CPUCooler extends Component {
    private int rpm;
    private float noise;
    private float power;

    public CPUCooler(String name, String brand, float price, int rpm, float noise, float power) {
        super.setName(name);
        super.setBrand(brand);
        super.setPrice(price);
        this.rpm = rpm;
        this.noise = noise;
        this.power = power;
    }

    public int getRpm() {
        return rpm;
    }

    public float getNoise() {
        return noise;
    }

    public float getPower() {
        return power;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public void setNoise(float noise) {
        this.noise = noise;
    }

    public void setPower(float power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "CPUCooler{" +
                "name='" + super.getName() + '\'' +
                ", brand='" + super.getBrand() + '\'' +
                ", price=" + super.getPrice() +
                ", rpm=" + rpm +
                ", noise=" + noise +
                ", power=" + power +
                '}';
    }
}
