import javax.swing.*;
import java.io.*;
import static javax.swing.JOptionPane.*;

public class Klient{
	public static boolean skrivTilFil(Land land, String filnavn){
		if(land != null){
			FileOutputStream utstrøm;
			ObjectOutputStream ut;
			try{
				utstrøm = new FileOutputStream(filnavn);
				ut = new ObjectOutputStream(utstrøm);
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
		try(FileInputStream innstrøm = new FileInputStream(filnavn);
		ObjectInputStream inn = new ObjectInputStream(innstrøm)){
			return (Land) inn.readObject();
		}catch(Exception e){
			return null;
		}
	}

	public static void main (String[] args){
		String[] muligheter = {"Registrer nytt land","Registrer ny by","List ut alle ordførere","List ut alle byer", "Avslutt"};
		final int REG_LAND = 0;
		final int REG_BY = 1;
		final int LIST_ORDFØRERE = 2;
		final int LIST_BYER = 3;
		final int AVSLUTT = 4;
		int valg = showOptionDialog(null, "Velg operasjon", "Eksamen vår 2016", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
		Land land = null;
		final String filnavn = "landdata.ser";
		try{
			if(land == null){
				land = new Land("Norge", 10, "Kong Harald V");
				land.regBy(new By("Trondheim", 170000, 200000, "Otervik, Rita"));
				land.regBy(new By("Fredrikstad", 80000, 120000, "Nygård, Jon-Ivar"));
				land.regBy(new By("Oslo", 650000, 700000, "Borgen, Marianne"));
			}
		}catch(Exception e){
			System.out.println("Noe gikk galt ved lesing fra fil " + e.toString());
		}

		while(valg!=AVSLUTT){
				switch(valg){
					case REG_LAND:				String navn = showInputDialog("Landets navn: ");
												int øvreGrense = Integer.parseInt(showInputDialog("Maks byer landet har plass til: "));
												String overhode = showInputDialog("Landets overhode: ");
												int sikker = showConfirmDialog(null, "Sikker? - Du vil slette alle tidligere registrerte data");
												if(sikker == YES_OPTION) land = new Land(navn, øvreGrense, overhode);
												else showMessageDialog(null, "Avbryter");
												break;

					case REG_BY:				if(land!= null){
													String byNavn = showInputDialog("Navn på by: ");
													int innbyggertall = Integer.parseInt(showInputDialog("Innbyggertall: "));
													int maksInnbyggere = Integer.parseInt(showInputDialog("Maks antall innbyggere: "));
													String ordfører = showInputDialog("Navn på ordfører: ");
													try{
														boolean ok = land.regBy(new By(byNavn, innbyggertall, maksInnbyggere, ordfører));
														if(ok) showMessageDialog(null, "Byen er registrert");
														else showMessageDialog(null, "By er registrert fra før av/ikke plass til by/feil inndata");
													}catch(Exception e){
														showMessageDialog(null, "Antall innbyggere kan ikke være høyere enn maks antall innbyggere " + e.toString());
													}
												}else showMessageDialog(null, "Du må registrere et land først");
												break;

					case LIST_ORDFØRERE:		if(land!=null){
													String[] oListe = land.getOrdførere();
													if(oListe != null){
														String res = "";
														for(String s : oListe){
															res += s + "\n";
														}
														showMessageDialog(null, "Ordførere: \n---------------------------\n" + res);
													}
												}else showMessageDialog(null, "Du må registrere et land først");
												break;

					case LIST_BYER:				if(land!= null){
												String ut = "";
												for (int i = 0; i<land.getByer().length; i++){
													if(land.getByer()[i] == null) continue;
													ut += land.getByer()[i].getByNavn() + "\n";
												}
												showMessageDialog(null, ut);
												}
												else showMessageDialog(null, "Du må registrere et land først");

					default:					break;
			}
			valg = showOptionDialog(null, "Velg operasjon", "Eksamen vår 2016", DEFAULT_OPTION, PLAIN_MESSAGE, null, muligheter, muligheter[0]);
		}

		try{
			if(land!=null) skrivTilFil(land,filnavn);
			System.out.println("Skriv til fil\n---------------------------\n" + land);
		}catch(Exception e){
			System.out.println("Noe gikk galt ved skriving til fil " + e.toString());
		}
	}
}