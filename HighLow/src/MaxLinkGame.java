import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MaxLinkGame extends JFrame {

	JButton deckButton, dealButton, card1Button, higherButton, lowerButton, card2Button; // JButtons
	JLabel scoreLabel; // score label
	Card card1;
	Card card2;
	int score = 0; // keeps track of the score
	MediaManager media = new MediaManager();
	Deck theDeck = new Deck();

	public static void main(String[] args) {
		MaxLinkGame theGame = new MaxLinkGame();
		theGame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		theGame.setSize(900, 270); // width by height
		theGame.setVisible(true);
	}// end main

	// constructor
	public MaxLinkGame() {
		super("High Low Game"); // title bar
		setLayout(new FlowLayout());
		TheInner myInner = new TheInner();

		deckButton = new JButton();// leave parameters blank for icon
		add(deckButton); // adds to frame
		ImageIcon icon = media.getIcon("shuffleback");
		deckButton.setIcon(icon);
		deckButton.addActionListener(myInner); // gives behavior to deckButton

		dealButton = new JButton("Deal");
		add(dealButton);
		dealButton.addActionListener(myInner);

		card1Button = new JButton();
		add(card1Button);
		card1Button.setIcon(media.getIcon("blank"));

		higherButton = new JButton("Higher?");
		add(higherButton);
		higherButton.addActionListener(myInner); // adds behavior

		lowerButton = new JButton("Lower?");
		add(lowerButton);
		lowerButton.addActionListener(myInner); // adds behavior

		card2Button = new JButton();
		add(card2Button);
		card2Button.setIcon(media.getIcon("blank"));

		add(new JLabel("Score: "));

		scoreLabel = new JLabel(" " + score);// use punt to turn int score into string score
		add(scoreLabel);

		dealButton.setEnabled(false);
		higherButton.setEnabled(false);
		lowerButton.setEnabled(false);
	}// end constructor

	private class TheInner implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == deckButton) {
				theDeck.shuffle(); // shuffles the deck
				deckButton.setIcon(media.getIcon("card-back")); // changes card image after shuffle
				deckButton.setEnabled(false); // disables shuffle button
				dealButton.setEnabled(true); // enables deal button
				media.play("shuffle"); // plays shuffle shound
			} // end if deckButton
			if (e.getSource() == dealButton) {
				card1 = theDeck.deal(); // returns one card
				String s = card1.getMediaName(); // calls MediaName
				card1Button.setIcon(media.getIcon(s)); // passes MediaName into card1Button
				card2Button.setIcon(media.getIcon("blank"));// makes card2 blank after deal is clicked
				dealButton.setEnabled(false); // disables dealButton
				higherButton.setEnabled(true);
				lowerButton.setEnabled(true);
				media.play("deal");
			} // end if dealButton
			if (e.getSource() == higherButton) {
				card2 = theDeck.deal();
				String s = card2.getMediaName();
				card2Button.setIcon(media.getIcon(s));
				higherButton.setEnabled(false);
				lowerButton.setEnabled(false);
				dealButton.setEnabled(true);
				if (card2.getValue() > card1.getValue()) {
					// scored a point
					score++;
					scoreLabel.setText("" + score); // overwrites previous score with new score
					media.play("ding");
				} // end if for score
				if (card2.getValue() < card1.getValue()) {
					// lose a point
					score--;
					scoreLabel.setText("" + score);
					media.play("buzzer");
				} // end if for not score

			} // end if higherButton
			if (e.getSource() == lowerButton) {
				card2 = theDeck.deal();
				String s = card2.getMediaName();
				card2Button.setIcon(media.getIcon(s));
				higherButton.setEnabled(false);
				lowerButton.setEnabled(false);
				dealButton.setEnabled(true);
				if (card2.getValue() < card1.getValue()) {
					// scored a point
					score++;
					scoreLabel.setText("" + score); // overwrites previous score with new score
					media.play("ding");
				} // end if for score
				if (card2.getValue() > card1.getValue()) {
					// lose a point
					score--;
					scoreLabel.setText("" + score);
					media.play("buzzer");
				} // end if for not score
			} // end if lowerButton
		}// end actionPerformed
	}// end of TheInner
}// end MaxLinkGame
