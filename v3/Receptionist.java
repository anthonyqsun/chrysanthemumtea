// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-21f
// time spent: 8.0 hours

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
        System.out.print("š§: hi, are you here to check in or schedule an appointment?\nš¤: ");
        String input = sc.nextLine();

        while (true) {
            handleResponse(input);

            if (checkInStatus == true) {
              break;
            }

            System.out.print("š§: hi, are you here to check in or schedule an appointment?\nš¤: ");
            input = sc.nextLine();
        }

        checkInStatus = false;
        return checkInApp;
    }


    public void handleResponse(String input) {
        input = input.trim();
        if (input.length() == 0) {
            System.out.print("š§: please say something\nš¤: ");
        } else if (input.equals("check in")) {
            checkInPrompt();
        } else if (input.equals("schedule")) {
            schedulePrompt();
        } else {
            System.out.print("š§: invalid choice");
        }
    }

    public void checkInPrompt() {
        System.out.print("š§: what is your name?\nš¤: ");
        String name = sc.nextLine();

        for (Appointment appointment : appointments) {
            if (appointment.getName().equals(name)) {
                if (appointment.isReady()) {
                    System.out.println("š§: checking you in");
                    checkInStatus = true;
                    checkInApp = appointment;
                    return;
                } else {
                    System.out.println("š§: your appointment is not ready yet, please come back in "
                            + appointment.getWaitTime() + " milliseconds");
                    return;
                }
            }
        }

        System.out.print("š§: couldn't find your appointment, please make one\nš¤: ");
    }

    public void schedulePrompt() {
        System.out.print("š§: what is your name?\nš¤: ");
        String name = sc.nextLine();

        // TODO: check if time input is valid
        System.out.print("š§: what time?\nš¤: ");
        String time = sc.nextLine();
        appointments.add(new Appointment(name, time));

        System.out.println("š§: your appointment has been created for " + time);
    }
}
