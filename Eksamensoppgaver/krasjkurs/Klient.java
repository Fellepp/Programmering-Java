import javax.swing.*;
import java.io.*;
import static javax.swing.JOptionPane.*;

public class Klient{
	public static boolean skrivTilFil(Land land, String filnavn){
		if(land != null){
			FileOutputStream utstr�m;
			ObjectOutputStream ut;
			try{
				utstr�m = new FileOutputStream(filnavn);
				ut = new ObjectOutputStream(utstr�m);
				ut.writeObject(land);
				ut.close();
				return true;
			}catch(FileNotFoundException e){
				System.out.println("Fil ikke funnet " + e.toString());
			}catch(Exception e){
				System.out.println("Noe gikk galt ved skriving til fil " + e.toString());
			}
		}
		return false;
	}

	public static Land lesFraFil(String filnavn){
		try(FileInputStream innstr�m = new FileInputStream(filnavn);
		ObjectInputStream inn = new ObjectInputStream(innstr�m)){
			return (Land) inn.readObject();
		}catch(Exception e){
			return null;
		}
	}

	public static void main (String[] args){
		String[] muligheter = {"Registrer nytt land","Registrer ny by","List ut alle ordf�rere","List ut alle byer", "Avslutt"};
		final int REG_LAND = 0;
		final int REG_BY = 1;
		final int LIST_ORDF�RERE = 2;
		final int LIST_BYER = 3;
		final int AVSLUTT = 4;
		int valg = showOptionDialog(null, "Velg operasjon", "Eksamen v�r 2016", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
		Land land = null;
		final String filnavn = "landdata.ser";
		try{
			if(land == null){
				land = new Land("Norge", 10, "Kong Harald V");
				land.regBy(new By("Trondheim", 170000, 200000, "Otervik, Rita"));
				land.regBy(new By("Fredrikstad", 80000, 120000, "Nyg�rd, Jon-Ivar"));
				land.regBy(new By("Oslo", 650000, 700000, "Borgen, Marianne"));
			}
		}catch(Exception e){
			System.out.println("Noe gikk galt ved lesing fra fil " + e.toString());
		}

		while(valg!=AVSLUTT){
				switch(valg){
					case REG_LAND:				String navn = showInputDialog("Landets navn: ");
												int �vreGrense = Integer.parseInt(showInputDialog("Maks byer landet har plass til: "));
												String overhode = showInputDialog("Landets overhode: ");
												int sikker = showConfirmDialog(null, "Sikker? - Du vil slette alle tidligere registrerte data");
												if(sikker == YES_OPTION) land = new Land(navn, �vreGrense, overhode);
												else showMessageDialog(null, "Avbryter");
												break;

					case REG_BY:				if(land!= null){
													String byNavn = showInputDialog("Navn p� by: ");
													int innbyggertall = Integer.parseInt(showInputDialog("Innbyggertall: "));
													int maksInnbyggere = Integer.parseInt(showInputDialog("Maks antall innbyggere: "));
													String ordf�rer = showInputDialog("Navn p� ordf�rer: ");
													try{
														boolean ok = land.regBy(new By(byNavn, innbyggertall, maksInnbyggere, ordf�rer));
														if(ok) showMessageDialog(null, "Byen er registrert");
														else showMessageDialog(null, "By er registrert fra f�r av/ikke plass til by/feil inndata");
													}catch(Exception e){
														showMessageDialog(null, "Antall innbyggere kan ikke v�re h�yere enn maks antall innbyggere " + e.toString());
													}
												}else showMessageDialog(null, "Du m� registrere et land f�rst");
												break;

					case LIST_ORDF�RERE:		if(land!=null){
													String[] oListe = land.getOrdf�rere();
													if(oListe != null){
														String res = "";
														for(String s : oListe){
															res += s + "\n";
														}
														showMessageDialog(null, "Ordf�rere: \n---------------------------\n" + res);
													}
												}else showMessageDialog(null, "Du m� registrere et land f�rst");
												break;

					case LIST_BYER:				if(land!= null){
												String ut = "";
												for (int i = 0; i<land.getByer().length; i++){
													if(land.getByer()[i] == null) continue;
													ut += land.getByer()[i].getByNavn() + "\n";
												}
												showMessageDialog(null, ut);
												}
												else showMessageDialog(null, "Du m� registrere et land f�rst");

					default:					break;
			}
			valg = showOptionDialog(null, "Velg operasjon", "Eksamen v�r 2016", DEFAULT_OPTION, PLAIN_MESSAGE, null, muligheter, muligheter[0]);
		}

		try{
			if(land!=null) skrivTilFil(land,filnavn);
			System.out.println("Skriv til fil\n---------------------------\n" + land);
		}catch(Exception e){
			System.out.println("Noe gikk galt ved skriving til fil " + e.toString());
		}
	}
}