// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-21f
// time spent: 5.5 hours

import java.util.Scanner;

public class TarotReader implements Speaker {
    private Card[] deck = new Card[78];
    private String icon;
    private Scanner sc;

    // constructor
    public TarotReader() {
        this.deck = CardData.getDeck();
        this.icon = "🔮";
        this.sc = new Scanner(System.in);
    }

    public String prompt(String question) {
        System.out.println(icon + ": " + question);
        System.out.print("👤: ");
        return sc.nextLine();
    }

    public void say(String statement) {
        System.out.println(icon + ": " + statement);
    }

    // pick 3, 7, 10, 12
    public Card[] draw(int numOfCards) {
        shuffle();
        Card[] draws = new Card[numOfCards];
        for (int i = 0; i < numOfCards; i++) {
            draws[i] = deck[i];
        }
        return draws;
    }

    public void shuffle() {
        int randomIndex;
        for (int i = deck.length - 1; i > 0; i--) {
            randomIndex = (int) ((i + 1) * Math.random());
            Card temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

    // ask question: future, relationship
    public void consult(Appointment app) {
        String answer = prompt("what questions are on your mind?");
        // do stuff here
    }
}
