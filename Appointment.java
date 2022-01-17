// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-21f
// time spent: 2.5 hours

public class Appointment {
    private long time;
    private String name;

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