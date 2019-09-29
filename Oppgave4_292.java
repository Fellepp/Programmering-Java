class Lengde{
	public static int[] addereTabeller(int[] tab1, int[] tab2){
		if(tab1.length == tab2.length){
			int[] sumTab = new int[tab1.length];
			for (int i=0; i<tab1.length; i++){
				sumTab[i] = tab1[i] + tab2[i];
			}
			return sumTab;
		}else{
			return null;
		}
	}
}

public class Oppgave4_292{
	public static void main (String[] args){

		int[] tab3 = {3,2,1};
		int[] tab4 = {1,2,3,4};
		int[] totalSum = Lengde.addereTabeller(tab3,tab4);

		if(totalSum!= null){
			for(int i = 0; i<totalSum.length; i++){
				System.out.print(totalSum[i]);
				System.out.print("   ");
			}
		}else{
			System.out.print("Nei nei   ");
		}
	}
}

