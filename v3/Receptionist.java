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
        System.out.print("🐧: hi, are you here to check in or schedule an appointment?\n👤: ");
        String input = sc.nextLine();

        while (true) {
            handleResponse(input);

            if (checkInStatus == true) {
              break;
            }

            System.out.print("🐧: hi, are you here to check in or schedule an appointment?\n👤: ");
            input = sc.nextLine();
        }

        checkInStatus = false;
        return checkInApp;
    }


    public void handleResponse(String input) {
        input = input.trim();
        if (input.length() == 0) {
            System.out.print("🐧: please say something\n👤: ");
        } else if (input.equals("check in")) {
            checkInPrompt();
        } else if (input.equals("schedule")) {
            schedulePrompt();
        } else {
            System.out.print("🐧: invalid choice\n👤: ");
        }
    }

    public void checkInPrompt() {
        System.out.print("🐧: what is your name?\n👤: ");
        String name = sc.nextLine();

        for (Appointment appointment : appointments) {
            if (appointment.getName().equals(name)) {
                if (appointment.isReady()) {
                    System.out.println("🐧: checking you in");
                    checkInStatus = true;
                    checkInApp = appointment;
                    return;
                } else {
                  // MAKE SURE TO REVERT THIS LINE
                    System.out.print("🐧: your appointment is not ready yet, please come back later\n👤: ");
                    return;
                }
            }
        }

        System.out.print("🐧: couldn't find your appointment, please make one\n👤: ");
    }

    public void schedulePrompt() {
        System.out.print("🐧: what is your name?\n👤: ");
        String name = sc.nextLine();

        // TODO: check if time input is valid
        System.out.print("🐧: what time?\n👤: ");
        String time = sc.nextLine();
        appointments.add(new Appointment(name));

        System.out.println("🐧: your appointment has been created for " + time);
    }
}
