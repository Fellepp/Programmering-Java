import static javax.swing.JOptionPane.*;

class Tidskonvertering{
	private int sekunder;
	private int t;
	private int m;
	private int s;

	public Tidskonvertering(int sekunder){
		this.sekunder = sekunder;
	}
	public void konvertering(){ //Eksempel 5231
		t = sekunder/3600; //Antall timer vil være 5231/3600 = 1
		m = (sekunder%3600)/60; //Antall minutter vil være 5231%3600 = 1631 -> 1631/60 = 27 	 	((5231 - 1 * 3600)/60)
		s = sekunder%60; //Antall sekunder vil være 5231%60 = 11									(5231 - 60*80)
	}
	public String toString(){
		return sekunder + " sekunder er det samme som " + t + " timer " + m + " minutter " + s + " sekunder";
	}
}

class Oppg2_13_3{
	public static void main(String[]args){
		int fortsett = YES_OPTION;
		while(fortsett == YES_OPTION){
			int sekunder = Integer.parseInt(showInputDialog("Skriv inn antall sekunder"));
			Tidskonvertering konvertering = new Tidskonvertering(sekunder);
			konvertering.konvertering();
			System.out.println(konvertering.toString());
			fortsett = showConfirmDialog(null, "Vil du prøve igjen?", "Tidskonvertering", YES_NO_OPTION);
		}
	}
}