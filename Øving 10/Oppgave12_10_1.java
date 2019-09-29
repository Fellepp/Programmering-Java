import static javax.swing.JOptionPane.*;

class Student{
	private final String NAVN;
	private int antOppg;

	public Student(String navn, int antOppg){
		NAVN = navn;
		this.antOppg = antOppg;
	}

	public String getNavn(){
		return NAVN;
	}

	public int getAntOppg(){
		return antOppg;
	}

	public void �kAntOppg(int �kning){
		antOppg += �kning;
	}

	public String toString(){
		return "Studenten " + NAVN + " har " + antOppg + " godkjente leveringer";
	}

}


class Oppgaveoversikt{
	private int antStud = 0;
	private Student[] studenter = new Student[antStud];

	public int getAntallStudenter(){
		return antStud;
	}

	public int getAntallOppgaver(String navn){
		for (int i = 0; i < antStud; i++){
			if (navn.equals(studenter[i].getNavn())) return studenter[i].getAntOppg(); //Kun hvis studenten finnes
		}
		return -1;
	}

	public boolean registrerNyStudent(String navn, int antOppg){
		for (int i = 0; i<antStud; i++){
			if (navn.equals(studenter[i].getNavn())) return false; //Hvis studenten allerede er registrert
		}
		antStud++;
		Student[] hjelp = studenter; //Lager hjelpearray for � lagre verdiene til studenter
		studenter = new Student[antStud];
		for (int i = 0; i<hjelp.length; i++){
			studenter[i] = hjelp[i]; //Kopierer elementene tilbake til studenter igjen. Vil ha en ledig plass
		}
		Student s = new Student(navn, antOppg);
		studenter[antStud-1] = s; //Fyller den ledige plassen p� slutten
		return true;
	}

	public boolean �kAntOppgStud(String navn, int �kning){
		for (int i = 0; i<antStud; i++){
			if (navn.equals(studenter[i].getNavn())){ //Kun hvis studenten finnes
				studenter[i].�kAntOppg(�kning);
				return true;
			}
		}
		return false;
	}

	public String toString(){
		String ut = "";
		for (int i = 0; i<antStud; i++){
			ut += studenter[i].toString() + "\n";
		}
		return ut;
	}

}

public class Oppgave12_10_1{
	public static void main (String[] args){
		String s = "";
		Oppgaveoversikt o = new Oppgaveoversikt();
		int valg = Integer.parseInt(showInputDialog("Velg mellom f�lgende operasjoner: \n1 - Registrer ny student \n2 - �k antall godkjente leveringer for en bestemt student \n3 - Finn antall godkjente leveringer for en bestemt student \n4 - Finn antall registrerte studenter \n5 - Liste over registrerte studenter og godkjente leveringer"));

		while(true){
			switch(valg){
				case 1:	String n = showInputDialog("Skriv inn navn p� ny student");
						int a = Integer.parseInt(showInputDialog("Skriv inn antall godkjente leveringer"));
						if (o.registrerNyStudent(n,a) == false) showMessageDialog(null,"Studenten " + n + " er allerede registrert");
						else showMessageDialog(null,"Studenten " + n + " er registrert med " + a + " godkjente leveringer");
						break;

				case 2: n = showInputDialog("Skriv inn navnet p� studenten du vil �ke godkjente leveringer for");
						int � = Integer.parseInt(showInputDialog("Skriv inn �kningen i antall godkjente leveringer"));
						if (o.�kAntOppgStud(n,�) == false) showMessageDialog(null, "Studenten " + n + " finnes ikke");
						else showMessageDialog(null, "Studenten " + n + " har �kt sine godkjente leveringer med " + �);
						break;

				case 3:	n = showInputDialog("Skriv inn navnet p� studenten du vil se godkjente leveringer for");
						if (o.getAntallOppgaver(n) == -1) showMessageDialog(null, "Studenten " + n + " finnes ikke");
						else showMessageDialog(null, "Studenten " + n + " har antall godkjente leveringer: " + o.getAntallOppgaver(n));
						break;

				case 4: showMessageDialog(null, "Antall registrerte studenter: " + o.getAntallStudenter());
						break;

				case 5: showMessageDialog(null, o.toString());
						break;


				default: System.exit(0);
			}
			valg = Integer.parseInt(showInputDialog("Velg mellom f�lgende operasjoner: \n1 - Registrer ny student \n2 - �k antall godkjente leveringer for en bestemt student \n3 - Finn antall godkjente leveringer for en bestemt student \n4 - Finn antall registrerte studenter \n5 - Liste over registrerte studenter og godkjente leveringer"));
		}

	}
}