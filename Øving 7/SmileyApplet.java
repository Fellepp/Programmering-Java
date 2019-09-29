import java.awt.*;
import javax.swing.*;

class Smiley extends JPanel {
	public void paintComponent(Graphics smiley) {
		super.paintComponent(smiley);

		setBackground(Color.yellow);

		smiley.setColor(Color.blue); //hode
		smiley.fillOval(300, 75, 400, 400);

		smiley.setColor(Color.white); //Øyne
		smiley.fillOval(380, 200, 90, 70);
		smiley.fillOval(530, 200, 90, 70);

		smiley.setColor(Color.black); //Pupiller
		smiley.fillOval(410, 220, 30, 30);
		smiley.fillOval(560, 220, 30, 30);

		smiley.setColor(Color.black); //Smil
		smiley.fillArc(375,250,250,170,0,-180);
		smiley.setColor(Color.red);
		smiley.fillArc(385,265,230,150,0,-180);

		Graphics2D smiley2 = (Graphics2D) smiley; //Øyenbryn
		smiley2.setStroke(new BasicStroke(6));
		smiley.setColor(Color.black);
		smiley.drawArc(360,170,125,40,0,180);
		smiley.drawArc(510,170,125,40,0,180);
	}
}

public class SmileyApplet extends JApplet{
	public void init(){
		add(new Smiley());
	}
}
