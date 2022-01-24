// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-23m
// time spent: 18 hours

public class Card {
    private String name, suit, desc, upright, reversed, direction;

    public Card(String name, String suit, String desc, String upright, String reversed) {
        this.name = name;
        this.suit = suit;
        this.desc = desc;
        this.upright = upright;
        this.reversed = reversed;
        this.direction = "Upright";
    }

    public void flip() {
      if (direction.equals("Upright")) {
        direction = "Reversed";
      } else {
        direction = "Upright";
      }
    }

    public String getDesc() {
        return desc;
    }

    public String toString() {
      if (direction.equals("Upright")) {
        return "You pull a " + name + " " + direction + "\n" + Util.wrap(upright, 80, "🃏: ", "    ");
      } else {
        return "You pull a " + name + " " + direction + "\n" + Util.wrap(reversed, 80, "🃏: ", "    ");
      }
    }
}
