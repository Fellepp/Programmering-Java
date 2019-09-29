import static javax.swing.JOptionPane.*;

class Person{
	private String fornavn;
	private String etternavn;
	private int f�dsels�r;

	public Person(String fornavn, String etternavn, int f�dsels�r){
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.f�dsels�r = f�dsels�r;
	}

	public String getFornavn(){
		return fornavn;
	}
	public String getEtternavn(){
		return etternavn;
	}
	public int getF�dsels�r(){
		return f�dsels�r;
	}
}

class ArbTaker{
	private int �r = 2016;
	private Person personalia;
	private int arbtakernr;
	private int ansettelses�r;
	private double m�nedsl�nn;
	private double skatteprosent;

	public ArbTaker(Person personalia, int arbtakernr, int ansettelses�r, double m�nedsl�nn, double skatteprosent){
		this.personalia = personalia;
		this.arbtakernr = arbtakernr;
		this.ansettelses�r = ansettelses�r;
		this.m�nedsl�nn = m�nedsl�nn;
		this.skatteprosent = skatteprosent;
	}

	public void setM�nedsl�nn(double m�nedsl�nn){
		this.m�nedsl�nn = m�nedsl�nn;
	}
	public void setSkatteProsent(double skatteprosent){
		this.skatteprosent = skatteprosent;
	}

	public double skatteTrekk(){
		double skatteTrekk = skatteprosent/100*m�nedsl�nn;
		return skatteTrekk;
	}
	public double bruttoPr�r(){
		double bruttoPr�r = m�nedsl�nn*12;
		return bruttoPr�r;
	}
	public double skatteTrekkPr�r(){
		double skatteTrekk = skatteprosent/100*m�nedsl�nn;
		double skatteTrekkPr�r = skatteTrekk * 10 + skatteTrekk/2;
		return skatteTrekkPr�r;
	}
	public String arbTakersNavn(){
		String arbTakersnavn = personalia.getEtternavn() + ", " + personalia.getFornavn();
		return arbTakersnavn;
	}
	public int arbTakersAlder(){
		int arbTakersAlder = �r - personalia.getF�dsels�r();
		return arbTakersAlder;
	}
	public int antall�rAnsatt(){
		int antall�rAnsatt = �r-ansettelses�r;
		return antall�rAnsatt;
	}
	public String merEllerMindre(int grense){
		int antall�rAnsatt = �r-ansettelses�r;
		String returnString = "";
		if (antall�rAnsatt > grense){
			returnString = "Personen har jobbet mer enn " + grense + " �r i bedriften";
		}else{
			returnString = "Personen har jobbet mindre enn " + grense + " �r i bedriften";
		}
		return returnString;
	}


	public Person getPersonalia(){
		return personalia;
	}
	public int getArbTakerNr(){
		return arbtakernr;
	}
	public int getAnsettelses�r(){
		return ansettelses�r;
	}
	public double getM�nedsl�nn(){
		return m�nedsl�nn;
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
		int f�dsels�r = Integer.parseInt(showInputDialog("Skriv inn f�dsels�r"));
		Person person = new Person(fornavn,etternavn,f�dsels�r);

		int arbtakernr = Integer.parseInt(showInputDialog("Skriv inn arbeidstakernummer"));
		int ansettelses�r = Integer.parseInt(showInputDialog("Skriv inn �ret du ble ansatt"));
		int m�nedsl�nn = Integer.parseInt(showInputDialog("Skriv inn m�nedsl�nn"));
		int skatteprosent = Integer.parseInt(showInputDialog("Skriv inn skatteprosent"));
		ArbTaker arbtaker = new ArbTaker(person,arbtakernr,ansettelses�r,m�nedsl�nn,skatteprosent);

		int valg = Integer.parseInt(showInputDialog("Oversikt over datainnhold som kan forandres: \nM�nedsl�nn: " + arbtaker.getM�nedsl�nn() + " kr \nSkatteprosent: " + arbtaker.getSkatteProsent() + "% \n\nVelg operasjon: \n1 - Se skattetrekk per m�ned\n2 - Se bruttol�nn per �r \n3 - Se skattetrekk per �r \n4 - Se navn p� person \n5 - Se alder p� person \n6 - Se antall �r ansatt i bedriften \n7 - Se om personen har v�rt antall i mer enn x antall �r \n8 - Forandre m�nedsl�nn \n9 - Forandre skatteprosent"));

		while(true){
			switch(valg){
				case 1: showMessageDialog(null, "Bel�pet som blir trukket m�nedlig pga skatt er: " + arbtaker.skatteTrekk() + " kr");
						break;

				case 2: showMessageDialog(null, "Bruttol�nnen per �r er: " + arbtaker.bruttoPr�r() + " kr");
						break;

				case 3: showMessageDialog(null, "Bel�per som blir trukket �rlig pga skatt er: " + arbtaker.skatteTrekkPr�r() + " kr");
						break;

				case 4: showMessageDialog(null, "Navn p� person: " + arbtaker.arbTakersNavn());
						break;

				case 5: showMessageDialog(null, "Alder p� person: " + arbtaker.arbTakersAlder() + " �r");
						break;

				case 6: showMessageDialog(null, "Antall �r personen har v�rt ansatt i denne bedriften er: " + arbtaker.antall�rAnsatt() + " �r");
						break;

				case 7: int x = Integer.parseInt(showInputDialog("Skriv inn antall �r du vil sjekke: "));
						showMessageDialog(null, arbtaker.merEllerMindre(x));
						break;

				case 8: int nyM�nedsl�nn = Integer.parseInt(showInputDialog("Skriv inn ny m�nedsl�nn"));
						arbtaker.setM�nedsl�nn(nyM�nedsl�nn);
						break;

				case 9: int nySkatteprosent = Integer.parseInt(showInputDialog("Skriv inn ny skatteprosent"));
						arbtaker.setSkatteProsent(nySkatteprosent);
						break;

				default: System.exit(0);
			}
			valg = Integer.parseInt(showInputDialog("Oversikt over datainnhold som kan forandres: \nM�nedsl�nn: " + arbtaker.getM�nedsl�nn() + "\nSkatteprosent: " + arbtaker.getSkatteProsent() + "\nVelg operasjon: \n1 - Se skattetrekk per m�ned\n2 - Se bruttol�nn per �r \n3 - Se skattetrekk per �r \n4 - Se navn p� person \n5 - Se alder p� person \n6 - Se antall �r ansatt i bedriften \n7 - Se om personen har v�rt antall i mer enn x antall �r \n8 - Forandre m�nedsl�nn \n9 - Forandre skatteprosent"));
		}
	}
}


