// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-21f
// time spent: 8.0 hours

public class Card {
    private String name, suit, desc, upright, reversed;

    public Card(String name, String suit, String desc, String upright, String reversed) {
        this.name = name;
        this.suit = suit;
        this.desc = desc;
        this.upright = upright;
        this.reversed = reversed;
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
        return name + " " + suit + " " + desc + " " + upright + " " + reversed;
    }
}
