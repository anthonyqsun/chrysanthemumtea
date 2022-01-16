public class Appointment {
    private long time;
    private String name;

    public Appointment() {
        this.time = System.currentTimeMillis() + (1000 * 60 * 5);
        this.name = "mykolyk";
    }
    
    public Appointment(String name) {
        this.time = System.currentTimeMillis() + (1000 * 60 * 5);
        this.name = name;
    }

    public Appointment(long time, String name) {
        this.time = time;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isReady() {
        return Math.abs(this.time - System.currentTimeMillis()) < (1000 * 60 * 5);
    }

    // TODO: make it return something a human would understand
    public long waitTime() {
        return this.time - System.currentTimeMillis();
    }

    public String toString() {
        return name + " has an appt @ " + time;
    }
}
