// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-21f
// time spent: 5.5 hours

import java.util.Scanner;
import java.util.ArrayList;

public class Receptionist implements Speaker {
    private Scanner sc;
    private ArrayList<Appointment> appointments;
    private boolean checkInStatus;
    private Appointment checkInApp;
    private String icon;

    public Receptionist() {
        this.sc = new Scanner(System.in);
        this.icon = "🐧";
        this.appointments = new ArrayList<Appointment>();
    }

    public String prompt(String question) {
        System.out.println(icon + ": " + question);
        System.out.print("👤: ");
        return sc.nextLine();
    }

    public void say(String statement) {
        System.out.println(icon + ": " + statement);
    }

    public Appointment recept() {
        String answer;

        // do-while was covered in summer homework; alternatively, this can be built by initializing checkInStatus as true and checking !checkInStatus in a while loop
        do {
            answer = prompt("hi, are you here to check in or schedule an appointment?");
            handleResponse(answer);

        } while (!checkInStatus);
        checkInStatus = false;
        return checkInApp;

        // String answer = prompt("hi, are you here to check in or schedule an appointment?");

        // while (true) {
            
        //     handleResponse(answer);
        //     if (checkInStatus == true) {
        //       break;
        //     }
        //     answer = prompt("hi, are you here to check in or schedule an appointment?");
        // }
    }

    private boolean contains(String input, String target) {
        for (int i = 0; i < input.length()-target.length()+1; i++) {
            if (input.substring(i, i+target.length()).equals(target)) {
                return true;
            }
        }
        return false;
    }

    private void handleResponse(String input) {
        input = input.trim();
        if (input.length() == 0) {
            say("please say something");
        } else if (contains(input, "check in")) {
            checkInPrompt();
        } else if (contains(input, "schedule")) {
            schedulePrompt();
        } else {
            say("invalid choice");
        }
    }

    private String smartTime(long time) {
        long seconds = time/1000;
        long minutes = (long) seconds / 60;
        long hours = (long) seconds / 3600;
        String head = "your appointment is not ready yet, please come back in ";

        if (seconds == 1) {
            return head + seconds + " second";
        }
        else if (seconds < 120) {
            return head + seconds + " seconds";
        }
        else if (minutes == 1) {
            return head + "1 minute (" + seconds + " seconds)";
        }
        else if (seconds / 60 < 60) {
            return head + minutes + " minutes (" + seconds + " seconds)";
        }
        else if (hours == 1) {
            return head + "1 hour (" + minutes + " minutes)";
        }
        return head + hours + " hours (" + minutes + " minutes)";
    }

    private void checkInPrompt() {
        String name = prompt("what is your name?");

        for (Appointment appointment : appointments) {
            if (appointment.getName().equals(name)) {
                if (appointment.getWaitTime() < -600000) {
                    say("it's been ten minutes since you were supposed to arrive. the reader is seeing someone else now, please reschedule");
                    return;
                } else if (appointment.isReady()) {
                    say("checking you in");
                    TerminallyIll.wait(1000);
                    TerminallyIll.clearAndReset();
                    checkInStatus = true;
                    checkInApp = appointment;
                    // TODO: delete the appointment
                    return;
                } else {
                    say(smartTime(appointment.getWaitTime()));
                    return;
                }
            }
        }

        say("couldn't find your appointment, please schedule one");
    }

    private void schedulePrompt() {
        String name = prompt("what is your name?");

        String time = prompt("what time?");

        // screening for valid time
        if (contains(time, ":") && time.length() > 2) {
            appointments.add(new Appointment(name, time));
        }
        else {
            System.out.println("please provide a time in X:XX [am/pm] or XX:XX [am/pm] format");
            schedulePrompt();
            return; // makes sure say() in this method is only run once
        }

        say("your appointment has been created for " + time);
    }
}
