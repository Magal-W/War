public class Submoment{
    private Card[] cards = new Card[2];
    public Submoment (Card[] cards) {
        if(cards.length != 2){
            throw new IllegalArgumentException("wrong amount of cards");
        }
        this.cards = cards;
    }
    public Submoment (Card card0, Card card1) {
        this.cards[0] = card0;
        this.cards[1] = card1;
    }
    public Card[] getCards () {
        return this.cards;
    }
}