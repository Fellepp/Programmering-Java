import static javax.swing.JOptionPane.*;

class TabellOppgave{
	public static void main (String[] args){


		for (int i = 0; i < args.length; i++){
			System.out.println(args[i]);
		}

		int[] alleMnd = {31,28,31,30,31,30,31};
		int svar = showConfirmDialog(null, "Er det skuddår?", "Skuddår", YES_NO_OPTION);
		if (svar == YES_OPTION){ //skuddår
			alleMnd[1] = 29;
		}

		for (int i = 0; i<alleMnd.length; i++){
			System.out.print(alleMnd[i] + " " );
		}

		char[] tegnTab = {'A', 'N', 'N', 'E'};
		for (int i = tegnTab.length-1; i>=0; i--){
			System.out.print(tegnTab[i]);
		}

		int[] tab = {3,8,-5,5,6,0,3,-2,8,9};
			tab[2] = tab [6] + 5;
			int a = tab[8];
			tab[7] = a + tab[0] * tab[0];
			tab[4] = tab[4] + 1;
			tab[5] = tab[3] + tab[9];
			tab[3] = tab[2 * tab[0]];

			for (int i = 0; i<tab.length; i++){
				System.out.println(tab[i]);
			}
	}
}