// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-21f
// time spent: 5.5 hours

import java.util.Scanner;
import java.util.ArrayList;

public class Receptionist {
    private Scanner sc;
    private ArrayList<Appointment> appointments;
    private boolean checkInStatus;
    private Appointment checkInApp;

    public Receptionist() {
        this.sc = new Scanner(System.in);
        this.appointments = new ArrayList<Appointment>();
    }

    public Appointment recept() {
        System.out.println("hi, are you here to check in or schedule an appointment?");
        String input = sc.nextLine();

        while (true) {
            handleResponse(input);

            if (checkInStatus == true) {
              break;
            }

            System.out.println("hi, are you here to check in or schedule an appointment?");
            input = sc.nextLine();
        }

        checkInStatus = false;
        return checkInApp;
    }


    public void handleResponse(String input) {
        input = input.trim();
        if (input.length() == 0) {
            System.out.println("please say something");
        } else if (input.equals("check in")) {
            checkInPrompt();
        } else if (input.equals("schedule")) {
            schedulePrompt();
        } else {
            System.out.println("invalid choice");
        }
    }

    public void checkInPrompt() {
        System.out.println("what is your name?");
        String name = sc.nextLine();

        for (Appointment appointment : appointments) {
            if (appointment.getName().equals(name)) {
                if (appointment.isReady()) {
                    System.out.println("checking you in");
                    checkInStatus = true;
                    checkInApp = appointment;
                    return;
                } else {
                  // MAKE SURE TO REVERT THIS LINE
                    System.out.println("your appointment is not ready yet, please come back later");
                    return;
                }
            }
        }

        System.out.println("couldn't find your appointment, please make one");
    }

    public void schedulePrompt() {
        System.out.println("what is your name?");
        String name = sc.nextLine();

        // TODO: check if time input is valid
        System.out.println("what time?");
        String time = sc.nextLine();
        appointments.add(new Appointment(name, time));

        System.out.println("your appointment has been created for " + time);
    }
}
