import java.util.*;


class ArealBeregning {
	public static void main (String[] args) {
		Scanner console = new Scanner(System.in);

		double lengde;
		double bredde;
		double h�yde;

		System.out.println("Skriv inn lengde (m)");
		lengde=console.nextInt();

		System.out.println("Skriv inn bredde (m)");
		bredde=console.nextInt();

		System.out.println("Skriv inn h�yde (m)");
		h�yde=console.nextInt();

		double volum = lengde*bredde*h�yde;

		System.out.println("Volumet av rektangelet er " + volum + " kubikkmeter.");
	}
}