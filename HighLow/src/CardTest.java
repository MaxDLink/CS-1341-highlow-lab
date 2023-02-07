
public class CardTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deck d = new Deck(); // creates 52 cards & adds to array list (no parameters in Deck constructor)
		System.out.println(d); // calls toString
		System.out.println("shuffling..."); //alerts to shuffling 
		d.shuffle(); //shuffles deck 
		System.out.println(d); //prints shuffle deck 
		System.out.println("Dealing...."); 
		Card c1 = d.deal(); 
		System.out.println(c1); 
		Card c2 = d.deal(); 
		System.out.println(c2); 
		Card c3 = d.deal(); 
		System.out.println(c3); 
	}// end main

}// end class CardTest
