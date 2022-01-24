// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-23m
// time spent: 18 hours

public class Woo {
    private static Receptionist jeff = new Receptionist();
    private static TarotReader taro = new TarotReader();

    public static void main(String[] args) {
        TerminallyIll.clearAndReset();
        while (Util.currentTimeEST() > 21_600_000) { // 6 hours
          Appointment checkInApp = jeff.recept();
          taro.consult(checkInApp);
        }
        jeff.say("Sorry, we're closed for the night. Please visit anytime from 6 am to 11:59 pm!");
        jeff.say("Run LateNight.java if you want to enter through the back door...");
    }
}
