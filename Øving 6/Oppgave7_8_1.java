public class Oppgave7_8_1{
	public static void main (String[] args){

		java.util.Random random = new java.util.Random();
		int antall[] = new int[10];

		for (int i = 0; i<50000; i++){
			antall[random.nextInt(10)]++;
		}
		System.out.println("Tall	Antall");

		for (int tall = 0; tall < antall.length; tall++){
			System.out.println(tall + "	" + antall[tall]);
		}
	}
}


