// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-21f
// time spent: 8.0 hours

public class Appointment {
    private String name;
    private long millisSinceMidnight;
    private String time;
    private final long MILLIS_IN_DAY = 86_400_000;

    public Appointment(String name, String time) {
        this.time = time;
        this.millisSinceMidnight = parseTimeEST(time);
        this.name = name;
    }

    public long parseTimeEST(String time) { // returns appt time in millis since epoch
        int seconds = 0;
        int colonIndex = -1;

        // TODO: make sure only HH:MM is taken in;
        for (int i = 0; i < time.length() - 1; i++) {
            if (time.substring(i, i + 2).equals("pm")) {
                seconds += 12 * 60 * 60;
            }

            if (time.substring(i, i + 1).equals(":")) {
                colonIndex = i;
            }
        }

        int hours = Integer.parseInt(time.substring(0, colonIndex));
        if (hours == 12) {
            hours = 0;
        }

        hours = hours - 24 + 5; // UTC is 5 hours ahead of EST
        int minutes = Integer.parseInt(time.substring(colonIndex + 1, colonIndex + 3));

        seconds += hours * 3600 + minutes * 60;

        return (long) (System.currentTimeMillis() / MILLIS_IN_DAY) * MILLIS_IN_DAY + seconds * 1000;
    }

    public String getName() {
        return this.name;
    }

    public boolean isReady() {
        return getWaitTime() < 0;
    }

    // TODO: make it return something a human would understand
    public long getWaitTime() {
        return millisSinceMidnight-System.currentTimeMillis();
    }

    public String toString() {
        return name + " has an appt @ " + time;
    }
}
