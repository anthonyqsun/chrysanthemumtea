public class LateNight {
  public static void main(String[] args) {
      while (true) {
        new TarotReader().consult(new Receptionist().recept());
      }
  }
}