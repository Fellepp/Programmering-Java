
import java.util.*;

public class Sirkel{

	private final double PI = 3.14159;
	private double radius;

	public Sirkel(){
		radius = 0;
	}
	public Sirkel(double r){
		radius = r;
	}
	public void setRadius(double r){
		radius = r;
	}
	public double getRadius(){
		return radius;
	}
	public double getAreal(){
		return PI*radius*radius;
	}
}

class
public static void main(String[] args){

	Scanner keyboard = new Scanner(System.in);

	System.out.println("Skriv inn radius:");
	double radius = keyboard.nextDouble();

	keyboard.close();


	//SirkelClass sirkelClass = new SirkelClass();
	//Sirkel sirkel = sirkelKlass.new Sirkel(radius);

	System.out.println("Arealet er " + getAreal());
}



