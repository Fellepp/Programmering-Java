import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Vindu extends JFrame {
	public Vindu(String tittel) {
		setTitle(tittel);
		setSize(1000, 600); // bredde, høyde
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Smiley smiley = new Smiley();
		add(smiley);

	}
}

class Smiley extends JPanel {
	public void paintComponent(Graphics smiley) {
		super.paintComponent(smiley); // husk denne!

		setBackground(Color.yellow);

		smiley.setColor(Color.blue); //hode
		smiley.fillOval(300, 75, 400, 400);

		smiley.setColor(Color.white); //Øyne
		smiley.fillOval(380, 200, 90, 70);
		smiley.fillOval(530, 200, 90, 70);

		smiley.setColor(Color.black); //Pupiller
		smiley.fillOval(410, 220, 30, 30);
		smiley.fillOval(560, 220, 30, 30);

		smiley.setColor(Color.black);
		smiley.fillArc(375,250,250,170,0,-180);
		smiley.setColor(Color.red);
		smiley.fillArc(385,265,230,150,0,-180);
	}
}

public class SmileyApplikasjon {
	public static void main(String[] args) {
	Vindu etVindu = new Vindu("Smiley");
	etVindu.setVisible(true);
	}
}