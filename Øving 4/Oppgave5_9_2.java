import static javax.swing.JOptionPane.*;

class Valuta{

	private double kurs;

	public Valuta(double kurs){
		this.kurs = kurs;
	}
	public double tilNOK(double beløp){
		return kurs*beløp;
	}
	public double fraNOK(double beløp){
		return beløp/kurs;
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
					String pundLest = showInputDialog("Skriv inn beløp i Pund:");
					double pundBeløp = Double.parseDouble(pundLest);

					showMessageDialog(null, pundBeløp + " pund = " + pund.tilNOK(pundBeløp) + " NOK");

				}else if(valgtUtregning == 2){
					String NOKLest =

					showInputDialog("Skriv inn beløp i NOK:");
					double NOKBeløp = Double.parseDouble(NOKLest);

					showMessageDialog(null, NOKBeløp + " NOK = " + pund.fraNOK(NOKBeløp) + " pund");

				}else{
					System.exit(0);
				}

			}else if(valgtValuta == 2){

				String valgtUtregningLest = showInputDialog("Velg utregning: \n1: Dollar til NOK \n2: NOK til Dollar \n3: Avslutt");
				int valgtUtregning = Integer.parseInt(valgtUtregningLest);

				if(valgtUtregning == 1){
					String dollarLest = showInputDialog("Skriv inn beløp i Dollar:");
					double dollarBeløp = Double.parseDouble(dollarLest);

					showMessageDialog(null, dollarBeløp + " dollar = " + dollar.tilNOK(dollarBeløp) + " NOK");

				}else if(valgtUtregning == 2){
					String NOKLest = showInputDialog("Skriv inn beløp i NOK:");
					double NOKBeløp = Double.parseDouble(NOKLest);

					showMessageDialog(null, NOKBeløp + " NOK = " + dollar.fraNOK(NOKBeløp) + " dollar");

				}else{
					System.exit(0);
				}

			}else if(valgtValuta == 3){

				String valgtUtregningLest = showInputDialog("Velg utregning: \n1: Euro til NOK \n2: NOK til Euro \n3: Avslutt");
				int valgtUtregning = Integer.parseInt(valgtUtregningLest);

				if(valgtUtregning == 1){
					String euroLest = showInputDialog("Skriv inn beløp i Euro:");
					double euroBeløp = Double.parseDouble(euroLest);

					showMessageDialog(null, euroBeløp + " euro = " + euro.tilNOK(euroBeløp) + " NOK");

				}else if(valgtUtregning == 2){
					String NOKLest = showInputDialog("Skriv inn beløp i NOK:");
					double NOKBeløp = Double.parseDouble(NOKLest);

					showMessageDialog(null, NOKBeløp + " NOK = " + euro.fraNOK(NOKBeløp) + " euro");

				}else{
					System.exit(0);
				}

			}else{
				System.exit(0);
			}
		}
	}
}