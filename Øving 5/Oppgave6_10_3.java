import java.util.Random;
import static javax.swing.JOptionPane.*;

class NesteTall{

	Random r = new Random();

	public int nesteHeltall(int nedre, int ovre){   // intervallet [nedre, ovre]
		return r.nextInt(ovre-nedre+1)+nedre;
	}

	public double nesteDesimaltall(double nedre, double ovre){ // intervallet <nedre, ovre>
		return r.nextDouble() * (ovre-nedre) + nedre;
	}
}

public class Oppgave6_10_3{
	public static void main (String[] args){

		int meny = Integer.parseInt(showInputDialog("Skriv 1 for heltall: \nSkriv 2 for desimaltall:"));

		int ovreHel = 0;
		int nedreHel = 0;
		double ovreDesi = 0;
		double nedreDesi = 0;

		NesteTall n = new NesteTall();
		String ut = "";

		if (meny == 1){
			ovreHel = Integer.parseInt(showInputDialog("Skriv inn øvre grense:"));
			nedreHel = Integer.parseInt(showInputDialog("Skriv inn nedre grense:"));
			ut += "Et tilfeldig tall mellom " + ovreHel + " og " + nedreHel + " er: " + n.nesteHeltall(nedreHel,ovreHel);
		}else{
			ovreDesi = Double.parseDouble(showInputDialog("Skriv inn øvre grense:"));
			nedreDesi = Double.parseDouble(showInputDialog("Skriv inn nedre grense:"));
			ut += "Et tilfeldig tall mellom " + ovreDesi + " og " + nedreDesi + " er: " + n.nesteDesimaltall(nedreDesi,ovreDesi);
		}

		showMessageDialog(null,ut);
	}
}