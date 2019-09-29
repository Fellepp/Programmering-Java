//Oppgave 3_12_4


import static javax.swing.JOptionPane.*;

class Oppgave3_12_4{
	public static void main (String[] args){
		String aPrisLest = showInputDialog("Hvor mye koster kjøttdeig type A?");
		String aVektLest = showInputDialog("For hvor mange gram teller prisen til kjøttdeig type A?");
		String bPrisLest = showInputDialog("Hvor mye koster kjøttdeig type B?");
		String bVektLest = showInputDialog("For hvor mange gram teller prisen til kjøttdeig type B?");

		double aPris = Double.parseDouble(aPrisLest);
		double aVekt = Double.parseDouble(aVektLest);
		double bPris = Double.parseDouble(bPrisLest);
		double bVekt = Double.parseDouble(bVektLest);

		double a = (aPris/aVekt);
		double b = (bPris/bVekt);

		if (a<b){
			showMessageDialog(null,"Kjøttdeig A er billigst");
		}else{
			showMessageDialog(null,"Kjøttdeig B er billigst");
		}
	}
}


/*
import static javax.swing.JOptionPane.*;

class Oppgave3_12_4{
	public static void main (String[] args){
		String aVektLest = showInputDialog("Hvor mange gram kjøttdeig skal du ha?");

		double vektPris = Double.parseDouble(aVektLest);

		double a = (35.9/450);
		double b = (39.5/500);

		if (a<b){
			showMessageDialog(null,"Kjøttdeig A er billigst");
		}else{
			showMessageDialog(null,"Kjøttdeig B er billigst");
		}
	}
}
*/
