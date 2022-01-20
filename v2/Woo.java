// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-21f
// time spent: 5.5 hours

public class Woo {
    private static Receptionist jeff = new Receptionist();
    private static TarotReader taro = new TarotReader();

    public static void main(String[] args) {
        while (true) {
          Appointment checkInApp = jeff.recept();
          taro.consult(checkInApp);
        }
    }
}
