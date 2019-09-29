import static javax.swing.JOptionPane.*;

class Valuta{

	private double kurs;

	public Valuta(double kurs){
		this.kurs = kurs;
	}
	public double tilNOK(double bel�p){
		return kurs*bel�p;
	}
	public double fraNOK(double bel�p){
		return bel�p/kurs;
	}
	public double getKurs(){
		return kurs;
	}
}

public class Oppgave5_9_2{
	public static void main(String[] args){
		Valuta pund = new Valuta(10.8);
		Valuta dollar = new Valuta(8.3);
		Valuta euro = new Valuta(9.3);

		while(true){
			String menyLest = showInputDialog("Velg valuta: \n1: Pund \n2: Dollar \n3: Euro \n4: Avslutt");
			int valgtValuta = Integer.parseInt(menyLest);

			if (valgtValuta == 1){

				String valgtUtregningLest = showInputDialog("Velg utregning: \n1: Pund til NOK \n2: NOK til Pund \n3: Avslutt");
				int valgtUtregning = Integer.parseInt(valgtUtregningLest);

				if(valgtUtregning == 1){
					String pundLest = showInputDialog("Skriv inn bel�p i Pund:");
					double pundBel�p = Double.parseDouble(pundLest);

					showMessageDialog(null, pundBel�p + " pund = " + pund.tilNOK(pundBel�p) + " NOK");

				}else if(valgtUtregning == 2){
					String NOKLest =

					showInputDialog("Skriv inn bel�p i NOK:");
					double NOKBel�p = Double.parseDouble(NOKLest);

					showMessageDialog(null, NOKBel�p + " NOK = " + pund.fraNOK(NOKBel�p) + " pund");

				}else{
					System.exit(0);
				}

			}else if(valgtValuta == 2){

				String valgtUtregningLest = showInputDialog("Velg utregning: \n1: Dollar til NOK \n2: NOK til Dollar \n3: Avslutt");
				int valgtUtregning = Integer.parseInt(valgtUtregningLest);

				if(valgtUtregning == 1){
					String dollarLest = showInputDialog("Skriv inn bel�p i Dollar:");
					double dollarBel�p = Double.parseDouble(dollarLest);

					showMessageDialog(null, dollarBel�p + " dollar = " + dollar.tilNOK(dollarBel�p) + " NOK");

				}else if(valgtUtregning == 2){
					String NOKLest = showInputDialog("Skriv inn bel�p i NOK:");
					double NOKBel�p = Double.parseDouble(NOKLest);

					showMessageDialog(null, NOKBel�p + " NOK = " + dollar.fraNOK(NOKBel�p) + " dollar");

				}else{
					System.exit(0);
				}

			}else if(valgtValuta == 3){

				String valgtUtregningLest = showInputDialog("Velg utregning: \n1: Euro til NOK \n2: NOK til Euro \n3: Avslutt");
				int valgtUtregning = Integer.parseInt(valgtUtregningLest);

				if(valgtUtregning == 1){
					String euroLest = showInputDialog("Skriv inn bel�p i Euro:");
					double euroBel�p = Double.parseDouble(euroLest);

					showMessageDialog(null, euroBel�p + " euro = " + euro.tilNOK(euroBel�p) + " NOK");

				}else if(valgtUtregning == 2){
					String NOKLest = showInputDialog("Skriv inn bel�p i NOK:");
					double NOKBel�p = Double.parseDouble(NOKLest);

					showMessageDialog(null, NOKBel�p + " NOK = " + euro.fraNOK(NOKBel�p) + " euro");

				}else{
					System.exit(0);
				}

			}else{
				System.exit(0);
			}
		}
	}
}