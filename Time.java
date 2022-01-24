// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-23m
// time spent: 18 hours

import java.util.ArrayList;

public class Time {
    private int hour;
    private int minute;
    private int colonIndex;
    private String suffix;

    public Time(String time) {
        hour=-1;
        minute=-1;
        suffix="error";
        parseTime(time);

    }

    private void parseTime(String time) {
        this.colonIndex = time.indexOf(":");
        if (this.colonIndex == -1) {
            return;
        }

        try {
            this.suffix = time.substring(colonIndex + 3).toLowerCase().trim();

            if (this.suffix.equals("") || this.suffix.equals("am")) {
                this.hour = 0;
            }
            if (this.suffix.equals("pm")) {
                this.hour = 12;
            }

            if (hour != -1) {
                int stringHrs = Integer.parseInt(time.substring(0, colonIndex));
                if (stringHrs != 12) {
                    this.hour += stringHrs;
                }
            }

            this.minute = Integer.parseInt(time.substring(colonIndex + 1, colonIndex + 3));
        }
        catch (Exception e) {
            return;
        }
    }

    public String toString() {
        String minString  = minute + "";
        if (minute < 10) {
            minString = "0" + minute;
        }

        if (hour > 12) {
            return hour - 12 + ":" + minString + " pm";
        } else if (hour < 12) {
            return hour + ":" + minString + " am";
        } else {
            return "12:" + minString + " pm";
        }
    }

    // implements boolean short-circuiting
    public ArrayList<String> checkErrors() {
        ArrayList<String> errors = new ArrayList<String>();
        if (this.colonIndex == -1) {
            errors.add("missing colon");
        }

        if (!(this.hour < 24 && this.hour > 0) || !(this.minute < 60 && this.minute >= 0)) {
            errors.add("invalid time");
        }

        if (!(this.suffix.equals("") || this.suffix.equals("am") || this.suffix.equals("pm"))) {
            errors.add("invalid suffix");
        }

        return errors;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public long getWaitTime() {
        int seconds = hour * 3600 + minute * 60;
        return seconds * 1000 - Util.currentTimeEST();
    }
}
