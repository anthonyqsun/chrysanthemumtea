// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-21f
// time spent: 8.0 hours

public class TarotReader {
    private Card[] deck = new Card[78];

    // constructor
    public TarotReader() {
        this.deck = CardData.getDeck();
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
    public static void consult(Appointment app) {
      System.out.println("🔮: " + "hello");
    }
}
