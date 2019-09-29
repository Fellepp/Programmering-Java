import static javax.swing.JOptionPane.*;

class Person{
	private String fornavn;
	private String etternavn;
	private int fødselsår;

	public Person(String fornavn, String etternavn, int fødselsår){
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.fødselsår = fødselsår;
	}

	public String getFornavn(){
		return fornavn;
	}
	public String getEtternavn(){
		return etternavn;
	}
	public int getFødselsår(){
		return fødselsår;
	}
}

class ArbTaker{
	private int år = 2016;
	private Person personalia;
	private int arbtakernr;
	private int ansettelsesår;
	private double månedslønn;
	private double skatteprosent;

	public ArbTaker(Person personalia, int arbtakernr, int ansettelsesår, double månedslønn, double skatteprosent){
		this.personalia = personalia;
		this.arbtakernr = arbtakernr;
		this.ansettelsesår = ansettelsesår;
		this.månedslønn = månedslønn;
		this.skatteprosent = skatteprosent;
	}

	public void setMånedslønn(double månedslønn){
		this.månedslønn = månedslønn;
	}
	public void setSkatteProsent(double skatteprosent){
		this.skatteprosent = skatteprosent;
	}

	public double skatteTrekk(){
		double skatteTrekk = skatteprosent/100*månedslønn;
		return skatteTrekk;
	}
	public double bruttoPrÅr(){
		double bruttoPrÅr = månedslønn*12;
		return bruttoPrÅr;
	}
	public double skatteTrekkPrÅr(){
		double skatteTrekk = skatteprosent/100*månedslønn;
		double skatteTrekkPrÅr = skatteTrekk * 10 + skatteTrekk/2;
		return skatteTrekkPrÅr;
	}
	public String arbTakersNavn(){
		String arbTakersnavn = personalia.getEtternavn() + ", " + personalia.getFornavn();
		return arbTakersnavn;
	}
	public int arbTakersAlder(){
		int arbTakersAlder = år - personalia.getFødselsår();
		return arbTakersAlder;
	}
	public int antallÅrAnsatt(){
		int antallÅrAnsatt = år-ansettelsesår;
		return antallÅrAnsatt;
	}
	public String merEllerMindre(int grense){
		int antallÅrAnsatt = år-ansettelsesår;
		String returnString = "";
		if (antallÅrAnsatt > grense){
			returnString = "Personen har jobbet mer enn " + grense + " år i bedriften";
		}else{
			returnString = "Personen har jobbet mindre enn " + grense + " år i bedriften";
		}
		return returnString;
	}


	public Person getPersonalia(){
		return personalia;
	}
	public int getArbTakerNr(){
		return arbtakernr;
	}
	public int getAnsettelsesÅr(){
		return ansettelsesår;
	}
	public double getMånedslønn(){
		return månedslønn;
	}
	public double getSkatteProsent(){
		return skatteprosent;
	}
}

public class Oppgave11_10_1{
	public static void main (String[]args){
		String s = "";
		String fornavn = showInputDialog("Skriv inn fornavn");
		String etternavn = showInputDialog("Skriv inn etternavn");
		int fødselsår = Integer.parseInt(showInputDialog("Skriv inn fødselsår"));
		Person person = new Person(fornavn,etternavn,fødselsår);

		int arbtakernr = Integer.parseInt(showInputDialog("Skriv inn arbeidstakernummer"));
		int ansettelsesår = Integer.parseInt(showInputDialog("Skriv inn året du ble ansatt"));
		int månedslønn = Integer.parseInt(showInputDialog("Skriv inn månedslønn"));
		int skatteprosent = Integer.parseInt(showInputDialog("Skriv inn skatteprosent"));
		ArbTaker arbtaker = new ArbTaker(person,arbtakernr,ansettelsesår,månedslønn,skatteprosent);

		int valg = Integer.parseInt(showInputDialog("Oversikt over datainnhold som kan forandres: \nMånedslønn: " + arbtaker.getMånedslønn() + " kr \nSkatteprosent: " + arbtaker.getSkatteProsent() + "% \n\nVelg operasjon: \n1 - Se skattetrekk per måned\n2 - Se bruttolønn per år \n3 - Se skattetrekk per år \n4 - Se navn på person \n5 - Se alder på person \n6 - Se antall år ansatt i bedriften \n7 - Se om personen har vært antall i mer enn x antall år \n8 - Forandre månedslønn \n9 - Forandre skatteprosent"));

		while(true){
			switch(valg){
				case 1: showMessageDialog(null, "Beløpet som blir trukket månedlig pga skatt er: " + arbtaker.skatteTrekk() + " kr");
						break;

				case 2: showMessageDialog(null, "Bruttolønnen per år er: " + arbtaker.bruttoPrÅr() + " kr");
						break;

				case 3: showMessageDialog(null, "Beløper som blir trukket årlig pga skatt er: " + arbtaker.skatteTrekkPrÅr() + " kr");
						break;

				case 4: showMessageDialog(null, "Navn på person: " + arbtaker.arbTakersNavn());
						break;

				case 5: showMessageDialog(null, "Alder på person: " + arbtaker.arbTakersAlder() + " år");
						break;

				case 6: showMessageDialog(null, "Antall år personen har vært ansatt i denne bedriften er: " + arbtaker.antallÅrAnsatt() + " år");
						break;

				case 7: int x = Integer.parseInt(showInputDialog("Skriv inn antall år du vil sjekke: "));
						showMessageDialog(null, arbtaker.merEllerMindre(x));
						break;

				case 8: int nyMånedslønn = Integer.parseInt(showInputDialog("Skriv inn ny månedslønn"));
						arbtaker.setMånedslønn(nyMånedslønn);
						break;

				case 9: int nySkatteprosent = Integer.parseInt(showInputDialog("Skriv inn ny skatteprosent"));
						arbtaker.setSkatteProsent(nySkatteprosent);
						break;

				default: System.exit(0);
			}
			valg = Integer.parseInt(showInputDialog("Oversikt over datainnhold som kan forandres: \nMånedslønn: " + arbtaker.getMånedslønn() + "\nSkatteprosent: " + arbtaker.getSkatteProsent() + "\nVelg operasjon: \n1 - Se skattetrekk per måned\n2 - Se bruttolønn per år \n3 - Se skattetrekk per år \n4 - Se navn på person \n5 - Se alder på person \n6 - Se antall år ansatt i bedriften \n7 - Se om personen har vært antall i mer enn x antall år \n8 - Forandre månedslønn \n9 - Forandre skatteprosent"));
		}
	}
}


