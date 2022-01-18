// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-21f
// time spent: 2.5 hours

public class Appointment {
    private String name;
    private int seconds;

    public Appointment(String name, String time) {
        this.seconds = System.currentTimeMillis() + (1000 * 60 * 5);
        this.name = name;
    }


    // public Appointment(long time, String name) {
    //     this.time = time;
    //     this.name = name;
    // }

    public int parseTime(String time){
      int seconds = 0;
      int colonIndex;
      for (int i = 0; i < time.length()-1; i++){
        if (time.substring(i,i+2).equals("pm"))){
          seconds+= 12*3600;
        }
        if (time.substring(i,i+1).equals(":")){
          colonIndex = i;
        }
      }

    }

    public String getName() {
        return this.name;
    }

    public boolean isReady() {
        return Math.abs(this.time - System.currentTimeMillis()) < (1000 * 60 * 5);
    }

    // TODO: make it return something a human would understand
    public long waitTime() {
        return this.time - System.currentTimeMillis();
    }

    public String toString() {
        return name + " has an appt @ " + time;
    }
}
