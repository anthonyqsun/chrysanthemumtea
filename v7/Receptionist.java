// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-23m
// time spent: 15 hours

import java.util.Scanner;
import java.util.ArrayList;

public class Receptionist implements Speaker {
    private Scanner sc;
    private ArrayList<Appointment> appointments;
    private boolean checkInStatus;
    private Appointment checkInApp;
    private String icon;
    private boolean firstTime = true;

    public Receptionist() {
        this.sc = new Scanner(System.in);
        this.icon = "🐧";
        this.appointments = new ArrayList<Appointment>();
    }

    public String prompt(String question) {
        say(question);
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
            if (firstTime) {
                firstTime=false;
                aboutPrompt();
            }
            answer = prompt("Hi, are you here to check in or schedule an appointment?");
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
            say("Please say something");
        } else if (contains(input, "check in")) {
            checkInPrompt();
        } else if (contains(input, "schedule")) {
            schedulePrompt();
        } else {
            say("Invalid choice");
        }
    }

    private String smartTime(long time) {
        long seconds = time/1000;
        long minutes = (long) seconds / 60;
        long hours = (long) seconds / 3600;
        String head = "Your appointment is not ready yet, please come back in ";

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
        String name = prompt("What is your name?");

        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i); 
            if (appointment.getName().equals(name)) {
                if (appointment.getWaitTime() < -300000) {
                    appointments.remove(i);
                    say(Helpers.wrap("It's been over five minutes since you were supposed to arrive. the reader is seeing someone else now, please reschedule", 120, "", "    "));
                    return;
                } else if (appointment.isReady()) {
                    say("Checking you in...");
                    TerminallyIll.wait(1000);
                    checkInStatus = true;
                    checkInApp = appointment;
                    appointments.remove(i);
                    return;
                } else {
                    say(smartTime(appointment.getWaitTime()));
                    return;
                }
            }
        }

        say("Couldn't find your appointment, please schedule one");
    }

    private void schedulePrompt() {
        String name = prompt("What is your name?").trim();

        for (Appointment appointment: appointments) {
            if (appointment.getName().equals(name)) {
                say("You may only schedule one appointment at a time so that everyone gets their turn.");
                say("You already have an appointment at " + appointment.getTime());
                return;
            }
        }

        String time = prompt("What time?");

        // screening for valid time
        if (new Appointment(name, time).getWaitTime() < -600000) {
            say("You cannot schedule an appointment in the past!");
            return;
        } else if (contains(time, ":") && time.length() > 2) {
            appointments.add(new Appointment(name, time));
        }
        else {
            say("Please provide a time in X:XX [am/pm] or XX:XX [am/pm] format");
            schedulePrompt();
            return; // makes sure say("Your appointment has been...") in this method is only run once
        }

        say("Your appointment has been created for " + time);
    }

    private void aboutPrompt() {
        String in = prompt("Hey there, I see that you're new here. do you want to learn about how our tarot readings work? [yes/no]");
        if (in.equals("yes") || in.equals("y")) {
            say(Helpers.wrap("Welcome! If you want to learn about your relationship with someone or perhaps what your future entails, you've come to the right place! Just schedule an appointment with us and show up within five minutes to find out what insight the universe has on your question.", 120, "", "    "));
            say("Our working hours are from 6:00 am to 11:59 pm.");
            prompt("Press enter to continue");
            TerminallyIll.clearAndReset();
        }
    }
}
