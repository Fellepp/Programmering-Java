import java.util.*;

public class Test{
public static void main(String[] args){
Scanner console = new Scanner(System.in);

int hours;
int mins;
int secs;

System.out.println("Enter Hours: ");
hours=console.nextInt();

System.out.println("Enter Minutes: ");
mins=console.nextInt();

System.out.println("Enter Seconds: ");
secs=console.nextInt();

int showSecs = (hours * 3600) + (mins * 60) + secs;

System.out.println(hours + ":" + mins+ ":" + secs + " in secs are " + showSecs);

}
}