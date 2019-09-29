//Oppgave 3_12_3

import static javax.swing.JOptionPane.*;

class Oppgave3_12_3{
	public static void main (String[] args){
		String årstallLest = showInputDialog("Skriv inn et årstall: ");
		int årstall = Integer.parseInt(årstallLest);

		if ((årstall % 4 == 0) && (årstall % 100 !=0)){
			showMessageDialog(null, årstall + " er et skuddår!");
		}

		else if (årstall % 400 == 0){
			showMessageDialog(null, årstall + " er et skuddår!");
		}

		else{
			showMessageDialog(null, årstall + " er ikke et skuddår!");
		}
	}
}
