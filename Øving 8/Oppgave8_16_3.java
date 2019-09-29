import static javax.swing.JOptionPane.*;

class tekstAnalyse{

	String tekst;

	public tekstAnalyse(String tekst){
		this.tekst = tekst;
	}

	public int getAntallOrd(){
		String [] ord = tekst.split(" ");
		return ord.length;
	}

	public double getSnittOrdLengde(){
		String [] ord = tekst.toUpperCase().split(" ");
		double antallOrd = ord.length;
		double sum = 0;
		for (int i = 0; i<ord.length; i++){
			for (int j = 0; j<ord[i].length(); j++){
				if(Character.isLetterOrDigit(ord[i].charAt(j))) sum++; //sjekker hver plass for hvert ord om det er bokstav eller tall, isåfall, sum++
			}
		}
		return sum/antallOrd;
	}

	public double getSnittOrdLengdePrPeriode(){
		String tegn = "[.?!:]";
		String [] perioder = tekst.split(tegn);
		double antallPerioder = perioder.length;
		double sum = 0;
		for (int i = 0; i<perioder.length; i++){
			String[] a = perioder[i].split(" ");
			sum += a.length;
			if(a[0].equals("")){
				sum--;
			}
		}
		return sum/antallPerioder;
	}

	public String byttUtOrd(String ord, String nyttOrd){
		return tekst.replaceAll(ord,nyttOrd);
	}

	public String getTekst(){
		return tekst;
	}

	public String getTekstToUpper(){
		return tekst.toUpperCase();
	}

}

public class Oppgave8_16_3{
	public static void main (String[] args){
		String s = "";
		tekstAnalyse t = new tekstAnalyse(s);
		int valg = Integer.parseInt(showInputDialog("Velg operasjon: \n1 - Skriv inn tekst \n2 - Se antall ord i teksten \n3 - Se gjennomsnittlig ordlengde \n4 - Se gjennomsnittlig ordlengde per periode \n5 - Bytt ut et ord i teksten med et annet ord \n6 - Se teksten \n7 - Se teksten i store bokstaver"));

		while(true){
			System.out.println("Din tekst er: " + t.getTekst());
			switch(valg){
				case 1:	s = showInputDialog(null, "Skriv inn din tekst her: ");
						t = new tekstAnalyse(s);
						break;

				case 2: showMessageDialog(null,"Du har totalt : " + t.getAntallOrd() + " ord i teksten");
						break;

				case 3: showMessageDialog(null,"Gjennomsnittlig ordlengde er: " + t.getSnittOrdLengde());
						break;

				case 4: showMessageDialog(null,"Gjennomsnittlig ordlengde per periode er: " + t.getSnittOrdLengdePrPeriode());
						break;

				case 5:	String gammelt = showInputDialog("Hvilket ord skal byttes ut?");
						String nytt = showInputDialog("Skriv inn det nye ordet");
						showMessageDialog(null, "Du valgte å bytte ut alle forekomster av:  " + gammelt + "  med  " + nytt + ". Din tekst er nå: " + t.byttUtOrd(gammelt,nytt));
						break;

				case 6: showMessageDialog(null, "Din tekst er: \n" + t.getTekst());
						break;

				case 7: showMessageDialog(null, "Din tekst med store bokstaver er: \n" + t.getTekstToUpper());
						break;

				default: System.exit(0);
			}
			valg = Integer.parseInt(showInputDialog("Velg operasjon: \n1 - Skriv inn tekst \n2 - Se antall ord i teksten \n3 - Se gjennomsnittlig ordlengde \n4 - Se gjennomsnittlig ordlengde per periode \n5 - Bytt ut et ord i teksten med et annet ord \n6 - Se teksten \n7 - Se teksten i store bokstaver"));
		}
	}
}