import java.io.*;
import static javax.swing.JOptionPane.*;

class Oppgave16_13_3{
	public static void main(String[]args) throws IOException{
		String saldoFil = "saldo.txt";
		String transaksjonsFil = "transaksjoner.txt";

		//Lager leser og skriver til saldoFil.txt
		FileReader saldoLeser = new FileReader(saldoFil); //lager fil leser
		BufferedReader leser = new BufferedReader(saldoLeser);//buffer
		FileWriter saldoSkriver = new FileWriter(saldoFil, false); //lager skriver, false fjerner alt som stod der før
		PrintWriter skriver = new PrintWriter(new BufferedWriter(saldoSkriver));

		//Lager skriver til transaksjoner.txt
		FileWriter transaksjonsSkriver = new FileWriter(transaksjonsFil, false);
		PrintWriter ts = new PrintWriter(new BufferedWriter(transaksjonsSkriver));

		skriver.print(showInputDialog("Skriv inn saldo:")); //Saldo skrives inn i saldo.txt
		skriver.close();
		int fortsett = YES_OPTION;

		double startSaldo = Double.parseDouble(leser.readLine());
		leser.close();

		while(fortsett == YES_OPTION){
			Object[] valg = {"Sette inn", "Ta ut", "Avbryt"};
			int svar = showOptionDialog(null, "Vil du sette inn eller ta ut penger?" , "Transaksjon", 0, QUESTION_MESSAGE, null, valg, valg[0]);
			String[] transaksjonsString = new String[2];
			String input = showInputDialog("Skriv inn transaksjon: ");
			transaksjonsString[1] = input;

			if(svar == 0){
				transaksjonsString[0] = "I: ";
			}
			else if(svar == 1){
				transaksjonsString[0] = "U: ";
			}

			ts = new PrintWriter(new BufferedWriter(transaksjonsSkriver));
			transaksjonsSkriver = new FileWriter(transaksjonsFil, true);

			ts.println(transaksjonsString[0] + transaksjonsString[1]);
			ts.close();

			fortsett = showConfirmDialog(null, "Vil du gjennomføre flere transaksjoner?", "Transaksjonsregister", YES_NO_OPTION);
		}

		FileReader transaksjonsLeser = new FileReader(transaksjonsFil);
		BufferedReader tr = new BufferedReader(transaksjonsLeser);

		String transaksjonLest = tr.readLine();
		double transaksjon = 0;

		while(transaksjonLest != null){
			if(transaksjonLest.split(" ")[0].equals("I:")){
				transaksjon += Double.parseDouble(transaksjonLest.split(" ")[1]);
			}
			else if(transaksjonLest.split(" ")[0].equals("U:")){
				transaksjon -= Double.parseDouble(transaksjonLest.split(" ")[1]);
			}
			transaksjonLest = tr.readLine();
		}

		if(startSaldo + transaksjon >= 0){
			double nySaldo = startSaldo + transaksjon;
			saldoSkriver = new FileWriter(saldoFil,false);
			skriver = new PrintWriter(new BufferedWriter(saldoSkriver));
			skriver.print(nySaldo);
			skriver.close();
			System.out.println("Saldo etter transaksjon: " + nySaldo);
		}else{
			showMessageDialog(null,"Du prøvde å trekke mer enn det som var på kontoen.");
			transaksjonsSkriver = new FileWriter(transaksjonsFil, false);
			ts.close();
		}
	}
}