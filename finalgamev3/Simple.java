import java.util.ArrayList;

public class Simple{

public static void main(String[] args){
	ArrayList<Boss> bosses = new ArrayList<Boss>();

	Boss boss1 = new Boss("Keith", 1, 100, 100, 20, 20);
        bosses.add(boss1);
        Boss boss2 = new Boss("Goat", 2, 200, 200, 40, 40);
        bosses.add(boss2);
        Boss boss3 = new Boss("Muck", 3, 300, 300, 60, 60);
        bosses.add(boss3);
        Boss boss4 = new Boss("Angel", 4, 400, 400, 80, 80);
        bosses.add(boss4);
        Boss boss5 = new Boss("???", 5, 500, 500, 100, 100);
        bosses.add(boss5);

	System.out.println(bosses);

	System.out.println(new Coordinate(3,4));
}

}