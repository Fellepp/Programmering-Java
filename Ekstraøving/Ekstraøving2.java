import java.util.Arrays;
import java.util.Comparator;
import static javax.swing.JOptionPane.*;
import java.io.*;

class Art implements Serializable{
	private String latinNavn;
	private String type;

	public Art(String latinNavn, String type){
		this.latinNavn = latinNavn;
		this.type = type;
	}

	public String getLatinNavn(){
		return latinNavn;
	}

	public String getType(){
		return type;
	}

	public String toString(){
		return latinNavn + ": " + type;
	}
}

class Dyr{
	private String navn;
	private int fAar;
	private char kjonn;
	private Art art;

	public Dyr(String navn, int fAar, char kjonn, Art art){
		this.navn = navn;
		this.fAar = fAar;
		this.kjonn = kjonn;
		this.art = art;
	}

	public String getNavn(){
		return navn;
	}

	public int getfAar(){
			return fAar;
	}

	public char getKjonn(){
			return kjonn;
	}

	public Art getArt(){
		return art;
	}

	public boolean equals(Object obj){
		if(obj == this) return true; //Sjekker om objektet er likt seg selv. Isåfall er de like, return true
		if(obj == null) return false; //Sjekker om objektet er tomt, isåfall false
		if(!(obj instanceof Dyr)) return false; //Sjekker om objektet er av klassen dyr, hvis ikke, return false
		Dyr objDyr = (Dyr)obj; //Vet til nå at obj er av klassen dyr, forteller java at obj ER et dyr. Lagrer objDyr som et nytt Dyr
		return (this.art.equals(objDyr.art) && this.kjonn == objDyr.kjonn); //Sjekker om art og kjønn er like
	}

	public String toString(){
		return navn + ", fødselsår: " + fAar + ", Alder i menneskeår: " + (2016-fAar) + ", Kjønn: " + Character.toUpperCase(kjonn) + ", " + art.toString();
	}
}

class Dyrehage implements Serializable{
	private String navn;
	private int antDyr;
	private int maksDyr;
	private Dyr[] dyrene;

	public Dyrehage(String navn, int maksDyr){
		this.navn = navn;
		this.maksDyr = maksDyr;
		this.dyrene = new Dyr[maksDyr];
	}

	public String getNavn(){
		return navn;
	}

	public int getAntDyr(){
		return antDyr;
	}

	public int registrerDyr(Dyr dyr){
		if(antDyr >= maksDyr) return -1; //Fullt
		if(dyr == null) return -2; //dyr er tom
		if(finnes(dyr)) return -3; //Dyret finnes allerede

		Dyr kopi = new Dyr(dyr.getNavn(), dyr.getfAar(), dyr.getKjonn(), dyr.getArt());
		dyrene[antDyr] = kopi;
		antDyr++;

		return 1;
	}

	public boolean finnes(Dyr dyr){
		for(int i = 0; i<antDyr; i++){
			if(dyrene[i] == null) continue;

			if(dyrene[i].getArt().equals(dyr.getArt()) && dyrene[i].getKjonn() == dyr.getKjonn()) return true;
		}
		return false;
	}

	public String dyrAvArt(String artsNavn){
		String ut = "";
		for(int i = 0; i<dyrene.length; i++){
			if(artsNavn == null) ut = "Arten er tom";
			if(dyrene[i] == null) continue;
			if(dyrene[i].getArt().getLatinNavn().equals(artsNavn)) ut += dyrene[i].toString() + "\n";
		}
		return ut;
	}

	public String getDyr(){
	        Object[][] dyr = new Object[antDyr][2];
	        for(int i = 0; i<antDyr; i++){
	            if(dyrene[i] == null) continue;
	            dyr[i][0] = dyrene[i].toString();
	            dyr[i][1] = dyrene[i].getfAar();
	        }
	        Arrays.sort(dyr, new Comparator<Object[]>(){ //Comparator på objekt pga objekt[]
	            @Override
	            public int compare(Object[] o1, Object[] o2){ //Hvilke to objekter som skal sammenliknes
	                Integer alder1 = (Integer)(o1[1]); //Caster til integer, plass 1 i arrayen
	                Integer alder2 = (Integer)(o2[1]);
	                return -alder1.compareTo(alder2);
	            }
	        });
	        String ut = "";
	        for(int i = 0; i<antDyr; i++){
	                ut += dyr[i][0] + "\n";
	        }
	        return ut;
    }

	public String toString(){
		String ut = navn + "\n\n";
		for(int i = 0; i<dyrene.length; i++){
			ut += dyrene[i].toString() + "\n";
		}
		return ut;
	}
}

public class Ekstraøving2{
	public static boolean skrivTilFil(Dyrehage dyrehage, String filnavn){
		if(dyrehage != null){
			FileOutputStream utstrom;
			ObjectOutputStream ut;
			try{
				utstrom = new FileOutputStream(filnavn);
				ut = new ObjectOutputStream(utstrom);
				ut.writeObject(dyrehage);
				ut.close();
				return true;
			}catch(FileNotFoundException e){
				System.out.println("Fil ikke funnet!");
			}catch(Exception e){
				System.out.println("Noe gikk galt ved skriving til fil");
			}
		}
		return false;
	}

	public static Dyrehage lesFraFil(String filnavn){
		try (FileInputStream innstrom = new FileInputStream(filnavn);
			ObjectInputStream inn = new ObjectInputStream(innstrom)){
				return (Dyrehage) inn.readObject();
		}catch(Exception e){
			return null;
		}
	}

	public static void main (String[] args){
		String[] muligheter = {"Ny dyrehage","Registrer dyr","Liste over alle dyr av en art","Liste over alle dyr sortert på alder", "Avslutt"};
		final int NY_DYREHAGE = 0;
		final int REG_DYR = 1;
		final int DYR_AV_ART = 2;
		final int DYR_ETTER_ALDER = 3;
		final int AVSLUTT = 4;
		int valg = showOptionDialog(null,"Velg operasjon", "Ekstraøving 2", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
		Dyrehage dyrehage = null;
		final String filnavn = "dyrehage.ser";

		try{
			dyrehage = lesFraFil(filnavn);
			if (dyrehage == null){
				dyrehage = new Dyrehage("Noas Ark", 20);
				dyrehage.registrerDyr(new Dyr("Fido", 2013, 'f', (new Art("Hund", "Pattedyr"))));
				dyrehage.registrerDyr(new Dyr("Tussi", 2015, 'm', (new Art("Katt", "Pattedyr"))));
				dyrehage.registrerDyr(new Dyr("Dumbo", 1998, 'm', (new Art("Elefant", "Pattedyr"))));
			}
		}catch(Exception e){
			System.out.println("Noe gikk galt ved lesing fra fil" + e.toString());
		}

		while(valg != AVSLUTT){
			switch(valg){
				case NY_DYREHAGE: 	String dyrehageNavn = showInputDialog("Navn på dyrehage: ");
									int maksDyr = Integer.parseInt(showInputDialog("Maks kapasistet for antall dyr i dyrehagen: "));
									int sikker = showConfirmDialog(null, "Sikker? - Du vil slette alle tidligere registrerte data");
									if(sikker == YES_OPTION) dyrehage = new Dyrehage(dyrehageNavn, maksDyr);
									else showMessageDialog(null, "Avbryter");
									break;

				case REG_DYR:		if(dyrehage != null){
										String navn = showInputDialog("Dyrets navn: ");
										int fødselsår = Integer.parseInt(showInputDialog(navn + "s fødselsdato: "));
										String[] kjønnValg = {"F", "M"};
										char kjønn = 'X';
										int kjønnSvar = showOptionDialog(null, navn + "s kjønn?", "Kjønn", 0, QUESTION_MESSAGE, null, kjønnValg, kjønnValg[0]);
										if(kjønnSvar == 0) kjønn = 'F';
										else if(kjønnSvar == 1) kjønn = 'M';
										String artsnavn = showInputDialog(navn + "s art: ");
										String artstype = showInputDialog(navn+ "s type: ");
										try {
											int ok = dyrehage.registrerDyr(new Dyr(navn, fødselsår, kjønn, new Art(artsnavn, artstype)));
											if (ok == 1) showMessageDialog(null, "Dyr registrert");
											else if (ok == -1) showMessageDialog(null, "Dyrehagen er allerede full");
											else if (ok == -2) showMessageDialog(null, "Feil ved innskrivning av nytt dyr");
											else if (ok == -3) showMessageDialog(null, "Dyret er allerede registrert");
										}catch(Exception e){
											showMessageDialog(null, "Noe gikk galt " + e.toString());
										}
									}else showMessageDialog(null, "Du må registrere en dyrehage først");
									break;

				case DYR_AV_ART:	if(dyrehage != null){
										String artSjekk = showInputDialog("Søk på art: ");
										showMessageDialog(null, dyrehage.dyrAvArt(artSjekk));
									}
									else showMessageDialog(null, "Du må registrere en dyrehage først");
									break;

				case DYR_ETTER_ALDER:	if(dyrehage != null){
											showMessageDialog(null, dyrehage.getDyr());
										}
										else showMessageDialog(null, "Du må registrere en dyrehage først");
										break;

				case AVSLUTT:		showMessageDialog(null, "Avslutter");
									System.exit(0);
									break;
			}
			valg = showOptionDialog(null,"Velg operasjon", "Ekstraøving 2", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
		}

		try {
			if(dyrehage != null) skrivTilFil(dyrehage, filnavn);
			System.out.println("Skriv til fil; " + dyrehage);
		}catch(Exception e){
			System.out.println("Noe gikk galt ved skriving til fil. " + e.toString());
		}
	}
}
