import static javax.swing.JOptionPane.*;

class Tidskonvertering{
	private int t;
	private int m;
	private int s;
	private int sekunder;

	public Tidskonvertering(int t, int m, int s){
		this.t = t;
		this.m = m;
		this.s = s;
	}

	public void konvertering(){
		sekunder = t*3600 + m*60 + s;
	}

	public String toString(){
		return t + " timer " + m + " minutter " + s + " sekunder er totalt " + sekunder + " sekunder.";
	}
}

public class Oppg2_13_2{
	public static void main(String[]args){
		int fortsett = YES_OPTION;
		while(fortsett == YES_OPTION){

			int t = Integer.parseInt(showInputDialog("Skriv inn antall timer: "));
			int m = Integer.parseInt(showInputDialog("Skriv inn antall minutter: "));
			int s = Integer.parseInt(showInputDialog("Skriv inn antall sekunder: "));

			Tidskonvertering konvertering = new Tidskonvertering(t,m,s);
			konvertering.konvertering();

			showMessageDialog(null, konvertering.toString());

			showConfirmDialog(null, "Vil du prøve igjen?", "Tidskonvertering", YES_NO_OPTION);
		}
	}
}