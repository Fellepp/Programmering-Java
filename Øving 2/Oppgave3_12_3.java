//Oppgave 3_12_3

import static javax.swing.JOptionPane.*;

class Oppgave3_12_3{
	public static void main (String[] args){
		String �rstallLest = showInputDialog("Skriv inn et �rstall: ");
		int �rstall = Integer.parseInt(�rstallLest);

		if ((�rstall % 4 == 0) && (�rstall % 100 !=0)){
			showMessageDialog(null, �rstall + " er et skudd�r!");
		}

		else if (�rstall % 400 == 0){
			showMessageDialog(null, �rstall + " er et skudd�r!");
		}

		else{
			showMessageDialog(null, �rstall + " er ikke et skudd�r!");
		}
	}
}
