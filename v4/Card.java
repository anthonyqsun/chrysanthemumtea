// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-21f
// time spent: 5.5 hours

public class Card {
    private String name, suit, desc, upright, reversed, direction;

    public Card(String name, String suit, String desc, String upright, String reversed) {
        this.name = name;
        this.suit = suit;
        this.desc = desc;
        this.upright = upright;
        this.reversed = reversed;
        this.direction = "upright";
    }

    public void flip() {
      if (direction.equals("upright")) {
        direction = "reversed";
      } else {
        direction = "upright";
      }
    }

    /*
    public String getName() {
        return name;
    }

    public String getSuit() {
        return suit;
    }

    public String getDesc() {
        return desc;
    }

    public String getUpright() {
        return upright;
    }

    public String getReversed() {
        return reversed;
    }
    */

    public String toString() {
      if (direction.equals("upright")) {
        return name + "\n" + direction + ": " + upright;
      } else {
        return name + "\n" + direction + ": " + reversed;
      }
    }
}
