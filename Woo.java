// chrysanthemumtea: Ryan Lau, Melody Lew, Anthony Sun
// apcs pd6
// fp: tarot card readings
// 2022-01-21f
// time spent: 2.5 hours

public class Woo {
    public static void main(String[] args) {
        Receptionist jeff = new Receptionist();
        jeff.recept();
        TarotReader taro = new TarotReader();
        Card[] draws= taro.draw(3);
        for (Card draw : draws){
          System.out.println(draw);
        }
    }

}
