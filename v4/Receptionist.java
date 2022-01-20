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
        String answer = prompt("hi, are you here to check in or schedule an appointment?");

        while (true) {
            handleResponse(answer);
            if (checkInStatus == true) {
              break;
            }
            answer = prompt("hi, are you here to check in or schedule an appointment?");
        }

        checkInStatus = false;
        return checkInApp;
    }


    public void handleResponse(String input) {
        input = input.trim();
        if (input.length() == 0) {
            say("please say something");
        } else if (input.equals("check in")) {
            checkInPrompt();
        } else if (input.equals("schedule")) {
            schedulePrompt();
        } else {
            say("invalid choice");
        }
    }

    public void checkInPrompt() {
        String name = prompt("what is your name?");

        for (Appointment appointment : appointments) {
            if (appointment.getName().equals(name)) {
                if (appointment.isReady()) {
                    say("checking you in");
                    checkInStatus = true;
                    checkInApp = appointment;
                    return;
                } else {
                    say("your appointment is not ready yet, please come back in "
                            + appointment.getWaitTime() / 1000 + " seconds");
                    return;
                }
            }
        }

        say("couldn't find your appointment, please make one");
    }

    public void schedulePrompt() {
        String name = prompt("what is your name?");

        // TODO: check if time input is valid
        String time = prompt("what time?");
        appointments.add(new Appointment(name, time));

        say("your appointment has been created for " + time);
    }
}
