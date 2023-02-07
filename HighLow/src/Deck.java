import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private int location;
	private ArrayList<Card> cards = new ArrayList<Card>();

	// constructor
	public Deck() {
		location = 0;
		createCards();
	}// end constructor

	// getters&Setters
	public void setLocation(int x) {
		location = x;
	}

	public int getLocation() {
		return location;
	}

	public void createCards() {
		// Card c = new Card("Spades", 1); //creates ace of spades
		// cards.add(c); //adds Spades to array list
		for (int i = 1; i <= 13; i++) // using i as number not array index so start at 1
			cards.add(new Card("Spades", i));
		// end for that adds 1-13 of spades to deck
		for (int i = 1; i <= 13; i++) // using i as number not array index so start at 1
			cards.add(new Card("Clubs", i));
		// end for that adds 1-13 of clubs to deck
		for (int i = 1; i <= 13; i++) // using i as number not array index so start at 1
			cards.add(new Card("Hearts", i));
		// end for that adds 1-13 of hearts to deck
		for (int i = 1; i <= 13; i++) // using i as number not array index so start at 1
			cards.add(new Card("Diamonds", i));
		// end for that adds 1-13 of diamonds to deck
	}// end createCards

	public Card deal() {
		Card c = cards.get(location); 
		location++; //increments location 
		return c; //returns c
	}//end deal method 
	public void shuffle() {
		Random rand = new Random();
		for (int a = 1; a <= 1000; a++) {
			for (int i = 0; i < cards.size(); i++) {
				Card c1 = cards.get(i);
				int num = rand.nextInt(52); // gives random number in range of 0-51
				Card c2 = cards.get(num);
				cards.set(i, c2); // moves card 2 to card 1 spot
				cards.set(num, c1); // moves card 1 to card 2 spot
			} // end for loop for all cards in deck
		} // end shuffle method
	}// end outer for loop

	public String toString() {
		String s = "Deck contents: \n";
		for (int i = 0; i < cards.size(); i++) {
			s = s + cards.get(i) + "\n";
		} // end for
		return s;
	}// end toString method
}// end class Deck
