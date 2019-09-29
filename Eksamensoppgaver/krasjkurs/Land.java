import java.io.*;
import java.util.Arrays;

public class Land implements Serializable{
	private String navn;
	private int antByer;
	private int øvreGrense;
	private String overhode;
	private By byer[];

	public Land(String navn, int øvreGrense, String overhode){
		if(antByer > øvreGrense){
			throw new IllegalArgumentException("Det kan ikke være flere byer i landet enn maks grense");
		}

		this.navn = navn;
		this.antByer = antByer;
		this.øvreGrense = øvreGrense;
		this.overhode = overhode;
		this.byer = new By[øvreGrense];
	}

	public By[] getByer(){
		return byer;
	}

	public String toString(){
		String ut = "Landets navn: " + navn + ", navn på statsoverhode: " + overhode + ", informasjon om registrerte byer:\n";
		for(int i = 0; i < byer.length; i++){
			if(byer[i] != null){
				ut +=  byer[i].toString();
			}
		}
		return ut;
	}

	public boolean regBy(By by){
		if(antByer >= øvreGrense) return false;
		if(by == null) return false;
		if(finnes(by)) return false;

		By kopi = new By(by.getByNavn(), by.getAntInnbyggere(), by.getMaksInnbyggere(), by.getOrdfører());
		byer[antByer] = kopi; //byen på siste plass = kopi
		antByer++;
		return true;
	}

	public boolean finnes(By by){
		for (int i = 0; i<antByer; i++){
			if(byer[i] == null) continue;
			if(byer[i].equals(by)) return true;
		}
		return false;
	}

	public int totaltInnbyggere(){
		int totalt = 0;
		for(int i = 0; i < byer.length; i++){
			if(byer[i] == null) continue;
			totalt += byer[i].getAntInnbyggere();
		}
		return totalt;
	}

	public By[] ledigPlass(int ledig){
		By[] resultat = new By[antByer]; //Oppretter ny tom array for å putte inn de som har ledige plasser
		int teller = 0;
		for(int i = 0; i<antByer; i++){
			if(byer[i] == null) continue; //Hvis tom, fortsett

			if(byer[i].harPlassTil(ledig)){ //True hvis den har plass, false hvis full
				resultat[teller] = new By(byer[i].getByNavn(), byer[i].getAntInnbyggere(), byer[i].getMaksInnbyggere(), byer[i].getOrdfører()); //Setter byen inn i arrayen på plass teller
				teller++;
			}
		}

		By[] temp = new By[teller]; //Oppretter ny array med lengde teller
		for(int i = 0; i<teller; i++){
			temp[i] = resultat[i]; //Kopierer inn resultatene
		}
		return temp;
	}

	public String[] getOrdførere(){
		String[] ordførere = new String[antByer];
		for(int i = 0; i<antByer; i++){
			if(byer[i] == null) continue;

			ordførere[i] = byer[i].getOrdfører();
		}
		Arrays.sort(ordførere);
		return ordførere;
	}
}