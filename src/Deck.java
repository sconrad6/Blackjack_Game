public class Deck {

    private Card[] theDeck;
    private int top;


    public Deck(){

        Suit[] allSuits = Suit.values();
        Rank[] allRanks = Rank.values();

        top = 0;
        theDeck = new Card[52]; //allocate memory

        int  count = 0; //position in the deck
        for (int i = 0; i < allSuits.length; i++){
            for (int j = 0; j < allRanks.length; j++){
                theDeck[count] = new Card(allSuits[i], allRanks[j]);
                count++;
            }
        }
    }

    public Card draw(){
        if (top < 52) {
            Card theCard = theDeck[top];
            top++;
            return theCard;
        } else {
            shuffle();
            top = 0;
            Card theCard = theDeck[top];
            top++;
            return theCard;
        }
    }

    public void shuffle(){
        int n = theDeck.length;
        for (int i = 0; i < n; i++){
            // swap card i with a randomly chosen card that appears after card i in the deck
            int r = i + (int)(Math.random() * (n - i));
            Card temp = theDeck[i];
            theDeck[i] = theDeck[r];
            theDeck[r] = temp;
        }
    }
}

