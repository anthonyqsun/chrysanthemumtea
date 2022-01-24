// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-23m
// time spent: 18 hours

public class LateNight {
  public static void main(String[] args) {
      while (true) {
        new TarotReader().consult(new Receptionist().recept());
      }
  }
}