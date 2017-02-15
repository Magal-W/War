import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	private static Deck deck1 = new Deck();
	private static Deck deck2 = new Deck();
	
	private static Stack<card> player1Deck = deck1.make_deck();
	private static Stack<card> player2Deck = deck2.make_deck();
	
	public static void main (String[] args){
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Enter player1 name: \n");
		String player1 = reader.next();
		
		System.out.println("Enter player2 name: \n");
		String player2 = reader.next();
		
		reader.close();
		
		int p1 = 0;
		int p2 = 0;
		
		int b = 0; // what does b do?
		for(int i = 0; i<20; i++) { // why 20 iterations?
			if (IsWin(player1Deck.pop(), player2Deck.pop()) == 1) {
				p1++;
            } else if (IsWin(player1Deck.pop(), player2Deck.pop()) == 2) {
				p2++;
            } else if (IsWin(player1Deck.pop(), player2Deck.pop()) == 3) {
                System.out.println("War");
            } else if (IsWin(player1Deck.pop(), player2Deck.pop()) == 0) {
                System.out.println("problem");
            }
            // b is never changed. perhaps b is the result of War?
			if (b == 1) p1++; 
			if(b == 2) p2++;
        }
		if (p1 > p2) System.out.println(player1);
		if (p2 > p1) System.out.println(player2);
		
        //War doesn't work, at all
    }
	
	// true -> p1 false -> p2
	private static int War() {
		player1Deck.pop();
		player1Deck.pop();
		player1Deck.pop();
        // should be put in for loop for easier counting
		player2Deck.pop();
		player2Deck.pop();
		player2Deck.pop();
		
		return IsWin(player1Deck.pop(),player2Deck.pop());
		
		
	}

	private static int IsWin(card pop, card pop2) {
		System.out.println("player 1 put: " + pop.getNumber() + " player 2 put: " + pop2.getNumber());
		if (pop.getNumber()>pop2.getNumber()) return 1;
		else if (pop.getNumber()<pop2.getNumber()) return 2;
		else if  (pop.getNumber()==pop2.getNumber()) return 3;
		else return 0;
	}
	
	
	

}
