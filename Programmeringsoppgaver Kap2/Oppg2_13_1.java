import static javax.swing.JOptionPane.*;

class Regner{
	private final double FORSKJELL = 2.54;

	public double tommerTilCm(double tommer){
		double cm = tommer*FORSKJELL;
		return cm;
	}

	public double cmTilTommer(double cm){
		double tommer = cm/FORSKJELL;
		return tommer;
	}
}

public class Oppg2_13_1{
	public static void main(String[]args){
		Regner regner = new Regner();
		int fortsett = YES_OPTION;

		while(fortsett == YES_OPTION){
			Object[] valg = {"Tommer til cm","Cm til tommer","Avbryt"};
			int svar = showOptionDialog(null,"Velg din operasjon: ", "Regning mellom tommer og cm", 0, QUESTION_MESSAGE, null, valg, valg[0]);
			if(svar == 0){
				double tommer = Double.parseDouble(showInputDialog("Skriv inn tommer"));
				System.out.print(tommer + " tommer er ");
				System.out.printf("%.2f" , regner.tommerTilCm(tommer));
				System.out.println(" cm");
			}
			else if(svar == 1){
				double cm = Double.parseDouble(showInputDialog("Skriv inn cm"));
				System.out.print(cm + " cm er ");
				System.out.printf("%.2f" , regner.cmTilTommer(cm));
				System.out.println(" tommer");
			}
			fortsett = showConfirmDialog(null, "Vil du gjennomføre flere utregninger?", "Regning mellom tommer og cm", YES_NO_OPTION);
		}
	}
}