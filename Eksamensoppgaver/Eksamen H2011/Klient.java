import static javax.swing.JOptionPane.*;
public class Klient{
	public static void main (String[] args){
		String[] muligheter = {"Nytt dekkhotell", "Ny kunde", "Fjern kunde", "Oversikt over kunde", "Datosjekk for dekk", "Like dekk", "Ikke-godkjente dekk", "Avslutt"};
		final int REG_NY_HOT = 0;
		final int REG_NY_KUNDE = 1;
		final int AVSLUTT_KUNDE = 2;
		final int OVERSIKT_KUNDE = 3;
		final int IKKE_SKIFTET_DEKK = 4;
		final int SORTERT_LIKE_DEKK = 5;
		final int IKKE_GODKJENTE_DEKK = 6;
		final int AVSLUTT = 7;
		Dekkhotell dekkhotell = null;
		int valg = showOptionDialog(null, "Velg operasjon", "Dekkhotell", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
		while(valg != AVSLUTT){
			switch(valg){
				case REG_NY_HOT:						String hotellNavn = showInputDialog("Navn på dekkhotell: ");
														int plass = Integer.parseInt(showInputDialog("Maks plass på dekkhotell: "));
														dekkhotell = new Dekkhotell(hotellNavn, plass);
														showMessageDialog(null, "Dekkhotellet ble registrert");
														break;

				case REG_NY_KUNDE:						if(dekkhotell != null){
															String bilNr = showInputDialog("Bilnummer: ");
															String kundenavn = showInputDialog("Kundens navn: ");
															int dato = Integer.parseInt(showInputDialog("Dato på forrige dekkskift (ÅÅÅÅMMDD): "));
															String kDekknavn = showInputDialog("Navn på dekk: ");
															String kDimensjon = showInputDialog("Dimensjon på dekk: ");
															String kTypeDekk = showInputDialog("Dekktype (sommer, vinter, piggfri): ");
															int[] kMonsterdybde = new int[4];
															for(int i = 0; i<4; i++){
																kMonsterdybde[i] = Integer.parseInt(showInputDialog("Mål mønsterdybde for dekk " + (i+1) + " (sett 0 hvis ikke målt)"));
															}
															Dekk sDekkInfo = new Dekk(kDekknavn, kDimensjon, kTypeDekk, kMonsterdybde);
															Kunde kunde = new Kunde(bilNr, kundenavn, dato, sDekkInfo);
															if(dekkhotell.regKunde(kunde)) showMessageDialog(null, "Registrering av kunde gikk greit");
															else showMessageDialog(null, "Kunden er allerede registrert/Dekkhotellet er fullt/Feil inndata");
														}else showMessageDialog(null, "Du må først registrere et dekkhotell");
														break;

				case AVSLUTT_KUNDE:						if(dekkhotell != null){
															String bilNrSøk = showInputDialog("Skriv inn bilnummeret på personen du vil fjerne fra dekkhotellet");
															if(dekkhotell.avsluttKundeTobias(bilNrSøk)){
																showMessageDialog(null, "Personen er fjernet");
															}
															else showMessageDialog(null, "Fant ikke personen du søkte etter");
														}else showMessageDialog(null, "Du må først registrere et dekkhotell");
														break;

				case OVERSIKT_KUNDE:					if(dekkhotell != null){
															String bilNrSøk1 = showInputDialog("Skriv inn bilnummeret på personen du vil se oversikt for");
															showMessageDialog(null, dekkhotell.kundeOversikt(bilNrSøk1));
														}else showMessageDialog(null, "Du må først registrere et dekkhotell");
														break;

				case IKKE_SKIFTET_DEKK:					if(dekkhotell != null){
															int datoSjekk = Integer.parseInt(showInputDialog("Dato du vil sjekke for (ÅÅÅÅMMDD): "));
															showMessageDialog(null, dekkhotell.dekkSkift(datoSjekk));
														}else showMessageDialog(null, "Du må først registrere et dekkhotell");
														break;

				case SORTERT_LIKE_DEKK:					if(dekkhotell != null){
															Kunde[] kTabell = dekkhotell.sorter();
															String hjelpetekst = "";
															for(int i = 0; i<kTabell.length; i++){
																hjelpetekst += kTabell[i];
															}
															showMessageDialog(null, hjelpetekst);
														}else showMessageDialog(null, "Du må først registrere et dekkhotell");
														break;

				case IKKE_GODKJENTE_DEKK:				if(dekkhotell != null){
															int monsterVerdiSjekk = Integer.parseInt(showInputDialog("Sjekk for en mønsterdybde: "));
															showMessageDialog(null, dekkhotell.godkjenteDekk(monsterVerdiSjekk));
														}else showMessageDialog(null, "Du må først registrere et dekkhotell");
														break;

				default:								break;
			}
			valg = showOptionDialog(null, "Velg operasjon", "Dekkhotell", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
		}
	}
}