
public class Card {
	private int value; // 1-13
	private String suit;

	// constructor
	public Card(String s, int x) {
		suit = s;
		value = x;
	}// end constructor Card

	public void setValue(int x) {
		value = x;
	}

	public int getValue() {
		return value;
	}

	public void setSuit(String s) {
		suit = s;
	}

	public String getSuit() {
		return suit;
	}

	public String getMediaName() {
		return suit + "-" + value;
	}// end getMediaName methods

	// toString
	public String toString() {
		return value + " of " + suit;
	}
} // end class Card
