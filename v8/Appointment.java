// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-23m
// time spent: 18 hours

public class Appointment {

    private String name;
    private Time time;

    public Appointment(String name, Time time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return this.name;
    }

    public Time getTime() {
        return time;
    }

    public long getWaitTime() {
        int seconds = time.getHour() * 3600 + time.getMinute() * 60;
        return seconds * 1000 - Util.currentTimeEST();
    }

    public boolean isReady() {
        return time.getWaitTime() < 0;
    }
}