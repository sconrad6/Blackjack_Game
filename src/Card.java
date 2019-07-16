public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit s, Rank r){
        suit = s;
        rank = r;
    }

    public Suit getSuit(){

        return suit;
    }

    public Rank getRank(){

        return rank;
    }

    public String toString(){

        return rank + " of " + suit;
    }

    public int getBJValue(){

        Rank[] allRanks = Rank.values();
        int value = 0;

        for (int i = 0; i < allRanks.length; i++) {
            value = rank.ordinal() + 1;
            if (rank == Rank.ACE) {
                value = 11;
            } if ((rank == Rank.JACK) || (rank == Rank.QUEEN) || (rank == Rank.KING)){
                value = 10;
            }
        }
        return value;
    }
    public int getValue(){

        return rank.ordinal() + 1;
    }
}


