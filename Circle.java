import java.util.*;
public class Circle {
	public static void main (String[] args){
    static double rad;

    public Circle() {
        rad = 0;
    }

    public static void setRad() {
        Scanner sc = new Scanner(System.in);

        do {
            while (!sc.hasNextDouble()) {
                sc.next();// this code is to skip the exception created
            }
            rad = sc.nextDouble();
        } while (rad < 0);

        System.out.println("radius value is:" + rad);

    }

    public static double getCirclearea() {
        return rad * rad * Math.PI;
    }

    public static double getCircumference() {
        return 2 * Math.PI * rad;
    }
}
}