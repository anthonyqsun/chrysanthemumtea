// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-23m
// time spent: 18 hours

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
        say(question);
        System.out.print("👤: ");
        return sc.nextLine().toLowerCase().trim();
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
        TerminallyIll.clearAndReset();
        say("Hi, " + app.getName() + "!");

        String goAgain = "y";

        while (goAgain.equals("y") || goAgain.equals("yes")) {
            // blurb
            say(Util.wrap("You can pick from four spreads: Three Card Spread, Seven Card Ellipse, Calendar Spread, Celtic Cross Spread.", 80, "", "    ") + "\n" +
                Util.wrap("1. Three Card Spread is for a quick read. You can do a self-reflection (mind, body, spirit) view your relationship with someone (you, the person, the relationship), or look at your timeline (past, present, future).", 80, "      ", "         ") + "\n" +
                Util.wrap("2. Seven Card Ellipse will read the past, present, and future; give advice; examine your outer surroundings; reveal your hopes and fears; demonstrate your capabilities.", 80, "      ", "         ") + "\n" +
                Util.wrap("3. Celtic Cross Spread displays you, current challenges, basis of the situation, past, present, future, approach, outer surroundings, hopes, fears, capabilities.", 80, "      ", "         ") + "\n" +
                Util.wrap("4. Calendar Spread is to see how you are throughout the year. Each card represents a month of the year. The last card is how the year will be overall.", 80, "      ", "         "));

            String spread = prompt("Which spread do you want to do? [enter a number]");
            // figure out number of cards drawn for specfiic question

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
            else {
                prompt("Please provide a valid choice. [press enter to continue]");
                TerminallyIll.clearAndReset();
                consult(app);
                return;
            }

            prompt("What question is on your mind?");
            TerminallyIll.clearAndReset();

            Card[] draws = draw(numOfDraws);

            for (int i = 0; i < numOfDraws; i++) {
                say(draws[i].toString());
                String wantDesc = prompt("Do you want the general description of the card? [yes/no]");
                if (wantDesc.equals("yes") || wantDesc.equals("y")) {
                    System.out.println(Util.wrap(draws[i].getDesc(), 80, "🃏: ", "    "));
                }
                if (i == numOfDraws-1) {
                    prompt("Press enter to finish");
                }
                else {
                    prompt("Press enter to view your next card");
                }
                TerminallyIll.clearAndReset();
            }

            goAgain = prompt("Do you have another question? [yes/no]");
            TerminallyIll.clearAndReset();
        }
        say("Thanks for coming by " + app.getName() + "! See you next time!");
        TerminallyIll.wait(1000);
        TerminallyIll.clearAndReset();
    }
}
