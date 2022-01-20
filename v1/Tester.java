public class Tester {
    public static void main(String[] args) {
        Appointment app = new Appointment("a", "8:40 pm");
        System.out.println("waittime: " + app.getWaitTime());
    }
}
