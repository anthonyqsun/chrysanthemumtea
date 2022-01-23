// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-23m
// time spent: 15 hours

public class Appointment {
    // private final long MILLIS_TO_2022 = Long.parseLong("1640995200000");
    private static final long MILLIS_IN_DAY = 86_400_000;

    private String name;
    private int[] time;

    public Appointment(String name) {
        this.name = name;
        this.time = parseTime("11:59 pm");
    }

    public Appointment(String name, String time) {
        this(name);
        this.time = parseTime(time);
    }

    public static long currentTime() {
        return (System.currentTimeMillis()-18_000_000) % MILLIS_IN_DAY; // 18 million millis in 5 hours: UTC -> EST
    }

    private int[] parseTime(String time) {
        int colonIndex = -1;
        int hours = 0;
        int minutes;

        for (int i = 0; i < time.length() - 1; i++) {
            if (time.substring(i, i + 2).equals("pm")) {
                hours = 12;
            }

            if (time.substring(i, i + 1).equals(":")) {
                colonIndex = i;
            }
        }

        int stringHrs = Integer.parseInt(time.substring(0, colonIndex));
        if (stringHrs != 12) {
            hours += stringHrs;
        }
       
        minutes = Integer.parseInt(time.substring(colonIndex + 1, colonIndex + 3));

        return new int[] {hours, minutes};
    }

    public String getName() {
        return this.name;
    }

    public String getTime() {
        String append = " am";
        int hrs = time[0];
        String min = time[1] + "";
        if (hrs >= 12) {
            hrs -= 12;
            append = " pm";
        }

        if (hrs == 0) {
            hrs = 12;
        }

        if (Integer.parseInt(min) < 10) {
            min = "0" + min;
        }
        return hrs + ":" + min + append;
    }

    public long getWaitTime() {
        int seconds = time[0] * 3600 + time[1] * 60;
        return seconds * 1000 - currentTime();
    }

    public boolean isReady() {
        return getWaitTime() < 0;
    }
}