// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-21f
// time spent: 5.5 hours

public class Appointment {
    private String name;
    private long seconds;
    private String time;
    private final long MILLIS_IN_DAY = 86_400_000;

    public Appointment(String name) {
      this.name = name;
      this.seconds = System.currentTimeMillis() + (1000 * 60 * 1);

    }

    public Appointment(String name, String time) {
        this.time=time;
        this.seconds = System.currentTimeMillis() + (1000 * 60 * parseTime(time));
        this.name = name;
    }


    // public Appointment(long time, String name) {
    //     this.time = time;
    //     this.name = name;
    // }

    public long parseTime(String time){
      int seconds = 0;
      int colonIndex=-1; // TODO: make sure only HH:MM is taken in;
      for (int i = 0; i < time.length()-1; i++){
        if (time.substring(i,i+2).equals("pm")){
          seconds+= 12*3600;
        }
        if (time.substring(i,i+1).equals(":")){
          colonIndex = i;
        }
      }

      int hours = Integer.parseInt(time.substring(0,colonIndex));
      int minutes = Integer.parseInt(time.substring(colonIndex+1, colonIndex+3));

      seconds += hours * 3600 + minutes * 60;

      System.out.println("asdf"+seconds);
      System.out.println((System.currentTimeMillis() % MILLIS_IN_DAY) / 1000);
      return seconds - (System.currentTimeMillis() % MILLIS_IN_DAY) / 1000; // can only handle current day scheduling

    }

    public String getName() {
        return this.name;
    }

    public boolean isReady() {
        return Math.abs(this.seconds * 1000 - System.currentTimeMillis()) < (1000 * 60 * 5);
    }

    // TODO: make it return something a human would understand
    public long getWaitTime() {
        return this.seconds * 1000 - System.currentTimeMillis();
    }

    public String toString() {
        return name + " has an appt @ " + time;
    }
}
