public class Card {
    private Suit suit;
    private int rank;
    public Card (Suit suit, int rank) {
        if(rank<2||rank>14){
            throw new IllegalArgumentException("card rank is not within range 2 ... 14");
        }
        this.suit = suit;
        this.rank = rank;
    }
    public Suit getSuit () {
        return this.suit;
    }
    public int getRank () {
        return this.rank;
    }
}