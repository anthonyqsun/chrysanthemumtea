public class TarotReader{
  //pick 3
  //pick 7
  //pick 10
  //pick 12
  private Card[] cards = new Card[78];
  //constructor
  public TarotReader(){
      for (int i = 0; i < 78; i++){
        cards[i] = new Card(i+"","suit", "desc", "upright", "reversed");
      }
  }
  public Card[] draw(int numOfCards){
    shuffle();
    Card[] draws = new Card[numOfCards];
    for (int i = 0; i < numOfCards; i++){
      draws[i] = cards[i];
    }
    return draws;
  }
  //shuffle
  public void shuffle()
  {
    int randomIndex;
    //setup for traversal fr right to left
    for( int i = cards.length-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      Card temp = cards[i];
      cards[i] = cards[randomIndex];
      cards[randomIndex] = temp;
    }
  }
  //ask question: future, relationship
}
