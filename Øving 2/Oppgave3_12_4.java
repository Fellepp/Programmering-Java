//Oppgave 3_12_4


import static javax.swing.JOptionPane.*;

class Oppgave3_12_4{
	public static void main (String[] args){
		String aPrisLest = showInputDialog("Hvor mye koster kj�ttdeig type A?");
		String aVektLest = showInputDialog("For hvor mange gram teller prisen til kj�ttdeig type A?");
		String bPrisLest = showInputDialog("Hvor mye koster kj�ttdeig type B?");
		String bVektLest = showInputDialog("For hvor mange gram teller prisen til kj�ttdeig type B?");

		double aPris = Double.parseDouble(aPrisLest);
		double aVekt = Double.parseDouble(aVektLest);
		double bPris = Double.parseDouble(bPrisLest);
		double bVekt = Double.parseDouble(bVektLest);

		double a = (aPris/aVekt);
		double b = (bPris/bVekt);

		if (a<b){
			showMessageDialog(null,"Kj�ttdeig A er billigst");
		}else{
			showMessageDialog(null,"Kj�ttdeig B er billigst");
		}
	}
}


/*
import static javax.swing.JOptionPane.*;

class Oppgave3_12_4{
	public static void main (String[] args){
		String aVektLest = showInputDialog("Hvor mange gram kj�ttdeig skal du ha?");

		double vektPris = Double.parseDouble(aVektLest);

		double a = (35.9/450);
		double b = (39.5/500);

		if (a<b){
			showMessageDialog(null,"Kj�ttdeig A er billigst");
		}else{
			showMessageDialog(null,"Kj�ttdeig B er billigst");
		}
	}
}
*/
