package seedu.bigpp.component.ram;

import seedu.bigpp.component.Component;

public class RAM extends Component {
    private int memory;
    private int sticks;
    private int speed;
    private int power;

    public RAM(String name, String brand, float price, int memory, int sticks, int speed, int power) {
        super.setName(name);
        super.setBrand(brand);
        super.setPrice(price);
        this.memory = memory;
        this.sticks = sticks;
        this.speed = speed;
        this.power = power;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getSticks() {
        return sticks;
    }

    public void setSticks(int sticks) {
        this.sticks = sticks;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "RAM{" +
                "name='" + super.getName() + '\'' +
                ", brand='" + super.getBrand() + '\'' +
                ", price=" + super.getPrice() +
                ", memory=" + memory +
                ", sticks=" + sticks +
                ", speed=" + speed +
                ", power=" + power +
                '}';
    }
}
