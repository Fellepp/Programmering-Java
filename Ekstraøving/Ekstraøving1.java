import static javax.swing.JOptionPane.*;
import java.io.*;

class Gave{
	private final String navn;
	private final double pris;
	private final int aar;
	private final boolean etisk;

	public Gave(String navn, double pris, int aar, boolean etisk){
		this.navn = navn;
		this.pris = pris;
		this.aar = aar;
		this.etisk = etisk;
	}

	public String getNavn(){
		return navn;
	}

	public double getPris(){
		return pris;
	}

	public int getAar(){
		return aar;
	}

	public boolean getEtisk(){
		return etisk;
	}

	public String gaveSjekk(Gave g){ //Tidligere oppgave som ikke brukes
		if(g.getNavn().equals(navn)) return navn; //Sjekker om to gaver har samme navn
		return "";
	}

	public String toString(){
		String e = "Uetisk";
		if (etisk) e = "Etisk"; //Hvis etisk er true, er e = Etisk, hvis ikke, er e = Uetisk
		return navn + " " + aar + " " + pris + " " + e;
	}
}

class Gavemottaker{
	private String navn;
	private String adresse;
	private Gave[] gaver = new Gave[0]; //Oppretter en tom gavearray hver gang programmet kjører

	public Gavemottaker(String navn, String adresse){
		this.navn = navn;
		this.adresse = adresse;
	}

	public void setNavn(String navn){
		this.navn = navn;
	}

	public void setAdresse(String adresse){
		this.adresse = adresse;
	}

	public boolean registrerGave(Gave gave){ //Parameter gave som er av klassen Gave
		int antGaver = gaver.length;  //antall gaver = lengden til gavearrayen
		for(int i = 0; i<antGaver; i++){
			if(gaver[i] != null){ //Hvis det finnes en gave på plass i
				if(gaver[i].getNavn().equals(gave.getNavn())) return false; //returnerer false dersom det registreres to like gaver
			}
		}
		antGaver++; //en gave mer
		Gave[] hjelp = gaver; //oppretter hjelpearray for å lagre verdiene i gavearray
		gaver = new Gave[antGaver]; //setter gavearray til å bli ny lengde
		for(int i = 0; i<hjelp.length; i++){
			gaver[i] = hjelp[i]; //kopierer inn verdiene til gavearrayen
		}
		gaver[antGaver-1] = gave; //Setter den nye gaven inn bakerst i den nye arrayen
		return true;
	}

	public double getTotalSum(int aar){ //Sjekker på et år som parameter
		double totalSum = 0;
		for(int i = 0; i<gaver.length; i++){
			if(aar == gaver[i].getAar()){ //Hvis året er det samme som året til en annen gave i arrayen
				totalSum += gaver[i].getPris(); //så blir gave på plass i sin pris plusset på summen
			}
		}
		return totalSum;
	}

	public double prosentEtisk(){
		if(gaver.length == 0) return 0.0; //Returnerer 0 dersom ingen gaver er registrert
		double prosent = 0;
		double antEtisk = 0;
		for(int i = 0; i<gaver.length; i++){
			if(gaver[i].getEtisk()) antEtisk ++; //Sjekker om en gave er etisk, hvis den er, etisk++
		}
		return prosent = antEtisk/(double)gaver.length * 100; //antall etisk / totale gaver * 100
	}

	public String getNavn(){
		return navn;
	}

	public String getAdresse(){
		return adresse;
	}

	public Gave[] getGaver(){
		return gaver;
	}

	public String toString(){
		String ut = "Navn: " + navn + ". Adresse: " + adresse + ". Prosentandel etiske gaver: " + prosentEtisk() + "%. \nGaver: \n";
		for(int i = 0; i<gaver.length; i++){
			ut += "\t" + gaver[i].toString() + "\n"; //skriver ut alle gaver for en person
		}
		ut += "\n";
		return ut;
	}
}

class Gaveregister{
	private String navn;
	private Gavemottaker[] gavemottakere = new Gavemottaker[50]; //Ny tom array med 50 plasser

	public Gaveregister(String navn){
		this.navn = navn;
	}

	public boolean registrerGavemottaker(Gavemottaker gavemottaker){ //Tar imot en gavemottaker av klassen Gavemottaker
		if(gavemottakere[gavemottakere.length-1] != null) return false; //Returnerer false hvis arrayen er full
		for(int i = 0; i<gavemottakere.length; i++){
			if(gavemottakere[i] != null){ //Hvis det er registrert noe på plass i, hindrer null exception feilmelding
				if(gavemottakere[i].getNavn().equals(gavemottaker.getNavn())) return false; //Returnerer false dersom mottakeren sitt navn allerede er registrert
			}

			if(gavemottakere[i] == null){ //Leter etter første ledige plass i arrayen
				gavemottakere[i] = gavemottaker; //Setter inn på første ledige
				return true; //returnerer true og stopper
			}
		}return false;
	}

	public int hentGavemottaker(String navn){ //Tar inn parameter navn
		if((gavemottakere[0] != null) && (gavemottakere.length != 0)){ //Hvis første plass ikke er tom OG lengden til arrayen ikke er 0
			try{ //Prøver dette
				for(int i = 0; i<gavemottakere.length; i++){
					if (navn.equals(gavemottakere[i].getNavn())) return i; //Finner matchende navn og returnerer plassen til navnet
				}
			}catch(Exception e){ //Dette skjer dersom arrayen ikke er tom og ingen matchende navn finnes
				showMessageDialog(null,"Gavemottakeren er ikke registrert");
				return -1;
			}
		}
		return -2; //Dersom arrayen er tom
	}

	public boolean registrerGave(Gavemottaker gavemottaker, Gave gave){ //tar imot parameter gavemottaker av klasse Gavemottaker og gave av klasse Gave
		return gavemottakere[hentGavemottaker(gavemottaker.getNavn())].registrerGave(gave); //gavemottakerens navn sjekkes av hentGavemottaker (returnerer plass) og setter registrer gave for gavemottakern på denne plassen. Returnerer false hvis feil
	}

	public String registrerteGavemottakere(){
		String ut = "";
		for(int i = 0; i<gavemottakere.length; i++){
			ut += gavemottakere[i].toString(); //Skriver ut toString for hver gavemottaker
		}
		return ut;
	}

	public double totalSumAlt(int aar){
		double sum = 0;
		for(int i = 0; i<gavemottakere.length; i++){
				if(gavemottakere[i] == null) i = gavemottakere.length; //Dersom gavemottaker på plass i er tom, stopper løkka
				else sum += gavemottakere[i].getTotalSum(aar); //gavemottaker på plass i sin getTotalSum blir lagt til (for det året)
		}
		return sum;
	}

	public Gavemottaker[] getGavemottakere(){
		return gavemottakere; //returnerer arrayen gavemottakere
	}

	public String toString(){
		String ut = "";
		for(int i = 0; i<gavemottakere.length; i++){
			if(gavemottakere[i] != null) ut += "Gavemottaker nr " + (i+1) + ": " + gavemottakere[i].toString() + "\n"; //Den totale toStringen, skriver informasjon om gaver + gavemottakere
		}
		return ut;
	}
}

public class Ekstraøving1{

	public static boolean skrivTilFil(Gaveregister gaveregister, String filnavn){
		if(gaveregister != null){
			FileOutputStream utstrøm;
			ObjectOutputStream ut;
			try{
				utstrøm = new FileOutputStream(filnavn);
				ut = new ObjectOutputStream(utstrøm);
				ut.writeObject(gaveregister);
				ut.close();
				return true;
			}catch(FileNotFoundException e){
				System.out.println("Fil ikke funnet");
			}
			catch(Exception e){
				System.out.println("Noe gikk galt (Skriving til fil)");
			}
		}
		return false;
	}

	public static Gaveregister lesFraFil(String filnavn){
		try (FileInputStream innstrøm = new FileInputStream(filnavn);
			ObjectInputStream inn = new ObjectInputStream(innstrøm)){
				return (Gaveregister) inn.readObject();
		}catch(Exception e){
			return null;
		}
	}

	public static void main(String[]args){
		Gaveregister gaveregister = new Gaveregister("Min gaveliste"); //Navngir gaveregister
		final int REG_GAVEMOTTAKER = 0; //Valg 1
		final int REG_GAVE = 1; //valg 2
		final int VIS_ALLE = 2; //valg 3
		final int VIS_ANDEL_ETISKE_GAVER = 3; //valg 4
		final int VIS_TOTAL_SUM_AAR = 4; //valg 5
		final int AVSLUTT = 5; //valg 6
		final String filnavn = "gaveregister.txt";
		String[] valg = {"Registrer ny gavemottaker", "Registrer gave", "Vis alle", "Vis andel etiske gaver", "Vis årsforbruk", "Avslutt"}; //Valgene
		int svar = showOptionDialog(null, "Velg operasjon","Gaveregister", 0, QUESTION_MESSAGE, null, valg, valg[0]); //Svaret

		while(svar != AVSLUTT){
			switch(svar){
				case REG_GAVEMOTTAKER:			String navn = showInputDialog("Skriv inn navn");
												String adresse = showInputDialog("Skriv inn adresse");
												Gavemottaker gavemottaker = new Gavemottaker(navn,adresse); //Oppretter en gavemottaker med navn og adresse
												if(gaveregister.registrerGavemottaker(gavemottaker) == false) showMessageDialog(null, "Enten er personen du forsøker å registrere allerede blitt registrert, eller har du oppnådd maks kapasitet på 50 gavemottakere. Evt trykk Vis alt"); //Dersom det blir returnet false er personen allerede registrert eller så er arrayen full
												else gaveregister.registrerGavemottaker(gavemottaker); //Registrerer gavemottakeren
												break;

				case REG_GAVE:					String mottaker = showInputDialog("Hvem er gaven til?");
												String gaveNavn = showInputDialog("Skriv inn navn på gave");
												double pris = Double.parseDouble(showInputDialog("Skriv inn pris på gave"));
												int aar = Integer.parseInt(showInputDialog("Skriv inn hvilket år du kjøpte gaven"));
												boolean etisk = true;
												String[] etiskValg = {"Etisk", "Uetisk"}; //Valg
												int etiskSvar = showOptionDialog(null, "Er gaven etisk?", "Etisk?", 0, QUESTION_MESSAGE, null, etiskValg, etiskValg[0]); //Svar
												if(etiskSvar == 0) etisk = true; //hvis etisk, true
												else if (etiskSvar == 1) etisk = false; //hvis uetisk, false
												Gave gave = new Gave(gaveNavn,pris,aar,etisk); //oppretter ny gave med gitte parametere
												int sjekk = gaveregister.hentGavemottaker(mottaker); //sjekk er plassen til mottakeren
												if(sjekk == -2) showMessageDialog(null, "Det er ingen registrerte gavemottakere"); //Dersom arrayen er tom
												else if (sjekk != -1){ //Dersom personen finnes
													Gavemottaker g = gaveregister.getGavemottakere()[sjekk]; //oppretter Gavemottaker g, henter verdier fra getGavemottakere metoden
													gaveregister.registrerGave(g,gave); //Sender inn gavemottaker og gave til registrerGave metoden
												}
												break;

				case VIS_ALLE:					showMessageDialog(null, gaveregister.toString()); //skriver ut alt
												break;

				case VIS_ANDEL_ETISKE_GAVER:	String ut = "";
												for(int i = 0; i<gaveregister.getGavemottakere().length; i++){ //lengden er antall gavemottakere
													if(gaveregister.getGavemottakere()[i] == null) i=gaveregister.getGavemottakere().length; //Hvis gavemottaker på plass i er tom, stopp løkke
													else ut += gaveregister.getGavemottakere()[i].getNavn() + " " + gaveregister.getGavemottakere()[i].prosentEtisk() + "% \n\n"; //Skriver ut navn og prosent etisk for hver mottaker
												}
												showMessageDialog(null, ut);
												break;

				case VIS_TOTAL_SUM_AAR:			int aarSjekk = Integer.parseInt(showInputDialog("Skriv inn hvilket årstall du vil sjekke for"));
												showMessageDialog(null, gaveregister.totalSumAlt(aarSjekk)); //Viser budsjett for gitt år
												break;
			}
			svar = showOptionDialog(null, "Velg operasjon","Gaveregister", 0, QUESTION_MESSAGE, null, valg, valg[0]);
		}

		try{
			if(gaveregister != null) skrivTilFil(gaveregister, filnavn);
			System.out.println("Skriv til fil; " + gaveregister);
		}catch(Exception e){
			System.out.println("Noe gikk galt ved skriving til fil. " + e.toString());
		}
	}
}
