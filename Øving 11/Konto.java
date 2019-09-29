import java.io.*;
import static javax.swing.JOptionPane.*;

class Konto{
    public static void main(String[]args) throws IOException{
        String saldoFil = "saldo.txt";
        String transaksjonsFil = "transaksjoner.txt";

        FileReader saldoLeser = new FileReader(saldoFil);
        BufferedReader leser = new BufferedReader(saldoLeser);
        FileWriter saldoSkriver = new FileWriter(saldoFil, false);
        PrintWriter skriver = new PrintWriter(new BufferedWriter(saldoSkriver));

        FileWriter transaksjonsSkriver = new FileWriter(transaksjonsFil, false);
        PrintWriter ts = new PrintWriter(new BufferedWriter(transaksjonsSkriver));

        skriver.print(showInputDialog("Skriv inn saldo"));
        skriver.close();
        int fortsett = YES_OPTION;

        double startSaldo = Double.parseDouble(leser.readLine());
        leser.close();

        while(fortsett == YES_OPTION){
            Object[] valg = {"Sette inn", "Ta ut", "Cancel"};
            int svar = showOptionDialog(null, "Vil du sette inn eller ta ut penger", "Transaksjon", 0, QUESTION_MESSAGE, null, valg, valg[0]);
            String[] dataString = new String[2];
            String input = showInputDialog("Skriv inn transaksjon");
            dataString[1] = input;
            double inputDouble = Double.parseDouble(input);

            if(svar == 0){
                dataString[0] = "I: ";
            }
            else if(svar == 1){
                dataString[0] = "U: ";
            }

            ts = new PrintWriter(new BufferedWriter(transaksjonsSkriver));
            transaksjonsSkriver = new FileWriter(transaksjonsFil, true);

            ts.println(dataString[0] + dataString[1]);
            ts.close();

            fortsett = showConfirmDialog(null, "Registrere flere transaksjoner", "Transaksjonsregister", YES_NO_OPTION);

        }

        FileReader transaksjonsLeser = new FileReader(transaksjonsFil);
        BufferedReader tr = new BufferedReader(transaksjonsLeser);

        String transaksjonLest = tr.readLine();
        double transaksjon = 0;

        while(transaksjonLest != null){
            if(transaksjonLest.split(" ")[0].equals("I:")){
                transaksjon += Double.parseDouble(transaksjonLest.split(" ")[1]);
            }
            else{
                transaksjon -= Double.parseDouble(transaksjonLest.split(" ")[1]);
            }
            transaksjonLest = tr.readLine();
        }
        if(startSaldo + transaksjon >= 0){
            double nySaldo = startSaldo + transaksjon;
            saldoSkriver = new FileWriter(saldoFil, false);
            skriver = new PrintWriter(new BufferedWriter(saldoSkriver));
            skriver.print(nySaldo);
            skriver.close();
            System.out.println("Saldo etter transaksjon " + nySaldo);
        }
        else{
            System.out.println("Du prøvde å trekke mer enn den originale saldoen");
            transaksjonsSkriver = new FileWriter(transaksjonsFil, false);
            ts.close();
        }
    }
}