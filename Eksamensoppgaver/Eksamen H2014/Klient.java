import static javax.swing.JOptionPane.*;
import java.io.*;

public class Klient{
	public static boolean skrivTilFil(ContainerSkip lasteskip, String filnavn){
		if(lasteskip != null){
			FileOutputStream utstrøm;
			ObjectOutputStream ut;
			try{
				utstrøm = new FileOutputStream(filnavn);
				ut = new ObjectOutputStream(utstrøm);
				ut.writeObject(lasteskip);
				ut.close();
				return true;
			}catch(FileNotFoundException e){
				System.out.println("Fil ikke funnet!");
			}catch(Exception e){
				System.out.println("Noe gikk galt ved skriving til fil " + e.toString());
			}
		}
		return false;
	}

	public static ContainerSkip lesFraFil(String filnavn){
		try{
			FileInputStream innstrøm = new FileInputStream(filnavn);
			ObjectInputStream inn = new ObjectInputStream(innstrøm);
			return (ContainerSkip) inn.readObject();
		}catch(Exception e){
			System.out.println("Noe gikk galt ved lesing fra fil");
		}
		return null;
	}

	public static void main(String[]args){
		final String filnavn = "cargoskip.ser";
		String[] muligheter = {"Registrer Lasteskip", "Registrer Container", "Gjenstående lastekapasitet", "Vis alle containere", "Loss av containere", "Avslutt"};
		final int REG_SKIP = 0;
		final int REG_CONT = 1;
		final int LEDIG_KAP = 2;
		final int VIS_ALLE = 3;
		final int LOSS = 4;
		final int AVSLUTT = 5;
		ContainerSkip lasteskip = null;
		int valg = showOptionDialog(null, "Velg operasjon", "Eksamen Desember 2014", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);

		try{
			lasteskip = lesFraFil(filnavn);
		}catch(Exception e){
			System.out.println("Noe gikk galt ved lesing fra fil " + e.toString());
		}

		while(valg != AVSLUTT){
			switch(valg){
				case REG_SKIP:										String skipsnavn = showInputDialog("Navn på lasteskip: ");
																	int maksVekt = Integer.parseInt(showInputDialog("Maks lagringskapasitet i tonn: "));
																	int maksAntall = Integer.parseInt(showInputDialog("Maks antall containere: "));
																	int sikker = showConfirmDialog(null, "Sikker? - Du vil slette all tidligere registrerte data");
																	if(sikker == YES_OPTION) lasteskip = new ContainerSkip(skipsnavn, maksVekt, maksAntall);
																	else showMessageDialog(null, "Avbryter");
																	showMessageDialog(null, "Lasteskipet er registrert");
																	break;

				case REG_CONT:										if(lasteskip != null){
																		String innhold = showInputDialog("Innhold: ");
																		int vekt = Integer.parseInt(showInputDialog("Vekt i tonn: "));
																		String destinasjon = showInputDialog("Destinasjon: ");
																		if(lasteskip.regContainer(new Container(innhold, vekt, destinasjon))) showMessageDialog(null, "Containeren er ombord");
																		else showMessageDialog(null, "Feil ved inndata/Containeren er for tung/Skipet er fullastet/Allerede registrert container");
																	}else showMessageDialog(null, "Du må registrere et lasteskip først");
																	break;

				case LEDIG_KAP:										if(lasteskip != null){
																		showMessageDialog(null, "Ledig lastekapasitet er: " + lasteskip.ledigKapasitet() + " tonn.");
																	}else showMessageDialog(null, "Du må registrere et lasteskip først");
																	break;

				case VIS_ALLE:										if(lasteskip != null){
																		showMessageDialog(null, lasteskip.toString());
																	}else showMessageDialog(null, "Du må registrere et lasteskip først");
																	break;

				case LOSS:											if(lasteskip != null){
																		String nåddDest = showInputDialog("Nådd destinasjon: ");
																		String ut = "";
																		for(int i = 0; i<lasteskip.getAntallContainere(); i++){
																			if(lasteskip.containerLoss(nåddDest)[i] == null) continue;
																			ut += lasteskip.containerLoss(nåddDest)[i].toString() + "\n";
																		}
																		showMessageDialog(null, ut);
																	}else showMessageDialog(null, "Du må registrere et lasteskip først");
																	break;

				default:											break;
			}
			valg = showOptionDialog(null, "Velg operasjon", "Eksamen Desember 2014", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
		}
		try{
			if(lasteskip != null){
				skrivTilFil(lasteskip, filnavn);
			}
			System.out.println("Skriv til fil " + lasteskip);
		}catch(Exception e){
			System.out.println("Noe gikk galt ved skriving til fil " + e.toString());
		}
	}
}