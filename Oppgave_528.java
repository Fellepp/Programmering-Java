import java.io.*;
import static javax.swing.JOptionPane.*;

class Oppgave_528{
	public static void main (String[] args) throws IOException{
		String filnavn = "antallLinjer.txt";

		FileReader leseforbTilFil = new FileReader(filnavn);
		BufferedReader leser = new BufferedReader(leseforbTilFil);

		String enLinje = leser.readLine();
		int totaltLinjer = 0;
		while(enLinje != null){
			totaltLinjer++;
			enLinje = leser.readLine();
		}
		leser.close();
		showMessageDialog(null, totaltLinjer);
	}
}