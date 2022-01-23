// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-21f
// time spent: 5.5 hours

public class Woo {
    private static Receptionist jeff = new Receptionist();
    private static TarotReader taro = new TarotReader();

    public static void main(String[] args) {
        while (Appointment.currentTime() > 21_600_000) { // 6 hours
          Appointment checkInApp = jeff.recept();
          taro.consult(checkInApp);
        }
        jeff.say("sorry, we're closed for the night. please come visit anytime from 6 am to 11:59 pm!");
    }
}
