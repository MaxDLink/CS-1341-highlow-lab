import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;

public class MediaManager {
	private String folderName = "media/";

	public static void main(String[] args) {
		// code to test that MediaManager is working properly
		MediaManager mm = new MediaManager();
		ImageIcon i = mm.getIcon("card-back");
		JLabel lbl = new JLabel(i);
		JOptionPane.showMessageDialog(null, lbl, "ImageDialog", JOptionPane.PLAIN_MESSAGE, null);
	}

	public void play(String s) {
		try {
			String filename = folderName + s + ".wav";
			URL url = this.getClass().getClassLoader().getResource(filename);
			AudioInputStream audioin = AudioSystem.getAudioInputStream(url);
			Clip clip = AudioSystem.getClip();
			clip.open(audioin);
			clip.start();

		} catch (Exception e) {
			System.out.println("Sound file problem");
		}

	}

	public ImageIcon getIcon(String s) {//passes in Spades-12 or some other string name 
		ImageIcon icon = new ImageIcon();
		try {
			String filename = folderName + s + ".jpg";
			Image img1 = ImageIO.read(getClass().getResource(filename));

			icon = new ImageIcon(img1);
		} catch (Exception e) {
			System.out.println("Trouble reading image file" + e);
		}
		return icon;
	}// end getIcon

}// end of class MediaManager
