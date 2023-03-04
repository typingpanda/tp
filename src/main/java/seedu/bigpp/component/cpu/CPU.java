package seedu.bigpp.component.cpu;

import seedu.bigpp.component.Component;

public class CPU extends Component {
    private String socket;
    private int core;
    private float clock;

    public CPU(String socket, int core, float clock) {
        this.socket = socket;
        this.core = core;
        this.clock = clock;
    }

    public String getSocket() {
        return socket;
    }

    public int getCore() {
        return core;
    }

    public float getClock() {
        return clock;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public void setClock(float clock) {
        this.clock = clock;
    }

    @Override
    public String toString() {
        return "CPU [socket=" + socket + ", core=" + core + ", clock=" + clock + ", name=" + super.getName()
                + ", brand=" + super.getBrand() + ", price=" + super.getPrice() + "]";
    }

}
