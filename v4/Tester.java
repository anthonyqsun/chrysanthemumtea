public class Tester {
    public static void main(String[] args) {
        Appointment app = new Appointment("a", "11:00 am");
        System.out.println(app.getName()+": "+app.getWaitTime());

        app = new Appointment("b", "11:00");
        System.out.println(app.getName()+": "+app.getWaitTime());

        app = new Appointment("c", "3:00 am");
        System.out.println(app.getName()+": "+app.getWaitTime());

        app = new Appointment("d", "03:00");
        System.out.println(app.getName()+": "+app.getWaitTime());

        app = new Appointment("e", "7:00");
        System.out.println(app.getName()+": "+app.getWaitTime());

        app = new Appointment("f", "10:00 pm");
        System.out.println(app.getName()+": "+app.getWaitTime());

        app = new Appointment("g", "12:00 pm");
        System.out.println(app.getName()+": "+app.getWaitTime());

        app = new Appointment("h", "20:00 pm");
        System.out.println(app.getName()+": "+app.getWaitTime());

    }
}
