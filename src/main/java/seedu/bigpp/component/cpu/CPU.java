package seedu.bigpp.component.cpu;

import seedu.bigpp.component.Component;

public class CPU extends Component {
    private int cores;
    private int threads;
    private float baseClock;
    private float boostClock;
    private int power;
    private String socket;

    public CPU(String name, float price, int cores, int threads, float baseClock, float boostClock, int power,
            String brand, String socket) {
        super.setName(name);
        super.setBrand(brand);
        super.setPrice(price);
        this.cores = cores;
        this.threads = threads;
        this.baseClock = baseClock;
        this.boostClock = boostClock;
        this.power = power;
        this.socket = socket;
    }

    public int getCores() {
        return this.cores;
    }

    public int getThreads() {
        return this.threads;
    }

    public float getBaseClock() {
        return this.baseClock;
    }

    public float getBoostClock() {
        return this.boostClock;
    }

    public int getPower() {
        return this.power;
    }

    public String getSocket() {
        return this.socket;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public void setBaseClock(float baseClock) {
        this.baseClock = baseClock;
    }

    public void setBoostClock(float boostClock) {
        this.boostClock = boostClock;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "name='" + super.getName() + '\'' +
                ", brand='" + super.getBrand() + '\'' +
                ", price=" + super.getPrice() +
                ", cores=" + cores +
                ", threads=" + threads +
                ", baseClock=" + baseClock +
                ", boostClock=" + boostClock +
                ", power=" + power +
                ", socket='" + socket + '\'' +
                '}';
    }
}