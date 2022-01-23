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
    private Card[] draw(int numOfCards) {
        shuffle();
        Card[] draws = new Card[numOfCards];
        for (int i = 0; i < numOfCards; i++) {
            draws[i] = deck[i];
        }
        return draws;
    }

    private void shuffle() {
        int randomIndex;
        for (int i = deck.length - 1; i > 0; i--) {
            randomIndex = (int) ((i + 1) * Math.random());
            Card temp = deck[i];

            if (Math.random() >= .5) {
                deck[randomIndex].flip();
            }

            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

    // ask question: future, relationship
    public void consult(Appointment app) {
        String goAgain = "y";

        while (goAgain.equals("y") || goAgain.equals("yes")) {
            // blurb
            say("You can pick from four spreads: Three Card Spread, Seven Card Ellipse, Calendar Spread, Celtic Cross Spread.\n" +
                Helpers.wrap("1. Three Card Spread is for a quick read. You can do a self-reflection (mind, body, spirit) view your relationship with someone (you, the person, the relationship), or look at your timeline (past, present, future).", 120, "      ", "         ") + "\n" +
                Helpers.wrap("2. Seven Card Ellipse will read the past, present, and future; give advice; examine your outer surroundings; reveal your hopes and fears; demonstrate your capabilities.", 120, "      ", "         ") + "\n" +
                Helpers.wrap("3. Celtic Cross Spread displays you, current challenges, basis of the situation, past, present, future, approach, outer surroundings, hopes, fears, capabilities.", 120, "      ", "         ") + "\n" +
                Helpers.wrap("4. Calendar Spread is to see how you are throughout the year. Each card represents a month of the year. The last card is how the year will be overall.", 120, "      ", "         "));

            // TODO: make sure this is a valid selection
            String spread = prompt("which spread do you want to do? [enter a number]");
            // figure out number of cards drawn for specfiic question

            prompt("what question is on your mind?");

            int numOfDraws = 0;
            if (spread.equals("1")) {
                numOfDraws = 3;
            } else if (spread.equals("2")) {
                numOfDraws = 7;
            } else if (spread.equals("3")) {
                numOfDraws = 10;
            } else if (spread.equals("4")) {
                numOfDraws = 13;
            }

            Card[] draws = draw(numOfDraws);

            for (int i = 0; i < numOfDraws; i++) {
                say(draws[i].toString());
                String wantDesc = prompt("Do you want the general description of the card? [yes/no]");
                if (wantDesc.equals("yes") || wantDesc.equals("y")) {
                    System.out.println(Helpers.wrap(draws[i].getDesc(), 120, "🃏: ", "    "));
                }
                if (i == numOfDraws-1) {
                    prompt("press enter to finish");
                }
                else {
                    prompt("press enter to view your next card");
                }
                TerminallyIll.clearAndReset();
            }

            goAgain = prompt("do you have another question? [yes/no]");
        }
    }
}
