import static javax.swing.JOptionPane.*;
class Arealberegning2 {
	public static void main (String[] args) {
		String lengdeLest = showInputDialog("Lengde(meter):");
		String breddeLest = showInputDialog("Bredde(meter):");
		double lengde = Double.parseDouble(lengdeLest);
		double bredde = Double.parseDouble(breddeLest);

		if(lengde > 0.0 && bredde > 0.0) {
			double arealet = lengde*bredde;
			showMessageDialog(null, "Arealet av rektangelet er " + arealet + " m^2.");
		}else{
			showMessageDialog(null, "Feil inndata");
		}
	}
}
