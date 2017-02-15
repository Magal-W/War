import java.util.Stack;

public class Deck {
	public Stack<card> make_deck() {
        Stack<card> DECK = new Stack<card>();

        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        int[] ranks = {14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] deck = new int[52];

        // Initialize cards
        for (int i = 0; i < deck.length; i++) {
          deck[i] = i;
        }
        int temp;
        int index;
        // Shuffle the cards
        for (int i = 0; i < deck.length; i++) {
          index = (int)(Math.random() * deck.length);
          temp = deck[i];
          deck[i] = deck[index];
          deck[index] = temp;
        }

        // Display the all the cards
        for (int i = 0; i < 26; i++) {
          String suit = suits[(int)(deck[i] / 13)];
          int rank = deck[i] % 13;
          card Card = new card(suit, rank);
          DECK.add(Card);
        }
        return DECK;
    }
}
				

	
		    
		    	
		
