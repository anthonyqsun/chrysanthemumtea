public class LateNight {
  private static Receptionist jeff = new Receptionist();
  private static TarotReader taro = new TarotReader();

  public static void main(String[] args) {
      while (true) { // 6 hours
        Appointment checkInApp = jeff.recept();
        taro.consult(checkInApp);
      }
  }
}