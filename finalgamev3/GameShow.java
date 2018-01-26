import java.util.Arrays;
import java.util.ArrayList;

public class GameShow{

    private static Character hero;
    private Boss boss1;
    private Boss boss2;
    private Boss boss3;
    private Boss boss4;
    private Boss boss5;
    private Boss currentBoss;
    Coordinate[][] location;
    private boolean canMove;
    private boolean canAdvance;
    private boolean atExit;
    private boolean atEntrance;
    private boolean atEnemy;
    private boolean defeatedLevel;
    ArrayList<Boss> bosses;
	private int numberOfLevelsDefeated;

    // when you beat them, you can remove them  from the list

    public GameShow(){
        hero = new Character("Tim");


        defeatedLevel = false;
		numberOfLevelsDefeated = 0;

        // boss make up
        // Boss(String n, int l, int ml, int li, int att, int def)

        bosses = new ArrayList<Boss>();

        boss1 = new Boss("Keith", 1, 100, 100, 20, 20);
        bosses.add(boss1);
        boss2 = new Boss("Goat", 2, 200, 200, 40, 40);
        bosses.add(boss2);
        boss3 = new Boss("Muck", 3, 300, 300, 60, 60);
        bosses.add(boss3);
        boss4 = new Boss("Angel", 4, 400, 400, 80, 80);
        bosses.add(boss4);
        boss5 = new Boss("???", 5, 500, 500, 100, 100);
        bosses.add(boss5);


        canMove = true;
        int columns = 22;
        int rows = 18;

        hero.changeXPosition(21);
        hero.changeYPosition(0);


        location = new Coordinate[rows][columns];
        int ya = 0;
        for (int y = rows - 1; y > -1; y--){
            for (int x = columns - 1; x > -1; x--){
                location[ya][x] = new Coordinate(x,y);
            }
            ya++;
        }
        // Location[17-b][x] -> (x,y) <- 17 - b = y <- put b into first bracket
        // Location[15][4] -> (4,3)
    }

    public void movement(){

        if ((hero.getx() < 0 || hero.getx() > 21) || (hero.gety() < 0 || hero.gety() > 17)){
            if (hero.getx() < 0) {
                hero.changeXPosition(0);
            }
            else if (hero.getx() > 21){
                hero.changeXPosition(21);
            }
            if (hero.gety() < 0) {
                hero.changeYPosition(0);
            }
            else if (hero.gety() > 17){
                hero.changeYPosition(17);
            }
            canMove = false;
        }
        else if (hero.getx() == location[17 - hero.gety()][hero.getx()].getx()
                && hero.gety() == location[17 - hero.gety()][hero.getx()].gety()) {
            System.out.println(location[17-hero.gety()][hero.getx()]);
            canMove = true;
        }
        /*if (hero.getx() == location[17][21].getx() && hero.gety() == location[17][21].gety()){
            System.out.println("Reached");
        }*/

    }

    public void faceBoss(){
		
        for (Boss n : bosses){
            if (n.getLev() == (hero.getLev() + 1)){
                currentBoss = n;
                break;
            }
        }
        if (currentBoss.getAlive() == false){
            defeatedLevel = true;
        }
        else {
            defeatedLevel = false;
        }

    }
	
	public void defeatedBoss(){
		currentBoss.dies();
		for (int x = 0; x < bosses.size(); x++){
			if(currentBoss.getName().equals(bosses.get(x).getName())){
				bosses.remove(x);
				bosses.add(currentBoss);
			}
		}
	
	}
	
    public void advance(){
        // if battle is won, canAdvance() = true
        // if battle is lost, start over

        // canAdvance = false;
		
		if (defeatedLevel == true){
        	canAdvance = true;
		}
		else {
			canAdvance = false;
		}
    }

    public void atEnemyNow(){
        if ((hero.getx() >= 7 && hero.getx() <= 14) && (hero.gety() >= 7 && hero.gety() <= 13)){
             atEnemy = true;
        }
        else {
            atEnemy = false;
        }

    }

    public void atExitNow(){

        if ((hero.getx() == 0 || hero.getx() == 1 || hero.getx() == 2) && hero.gety() == 17 ) {
             atExit = true;
        }
        else {
            atExit = false;
        }



    }

    public void atEntranceNow(){
        if ((hero.getx() == 21 || hero.getx() == 20 || hero.getx() == 19) && (hero.gety() == 0 )){
            atEntrance =  true;
        }
        else {
            atEntrance = false;
        }
    }

    public void resetLocation(){
        if (atExit == true) {
            hero.changeXPosition(21);
            hero.changeYPosition(0);
        }
        else if (atEntrance == true){
            hero.changeXPosition(0);
            hero.changeYPosition(17);
        }
    }
	
	public void resetLevel(){
		defeatedLevel = false;
		canAdvance = false;
	}

    public boolean getAtExit(){
        return atExit;
    }

    public boolean getAtEntrance(){
        return atEntrance;
    }

    public boolean getAtEnemy(){
        return atEnemy;
    }

    public boolean moveOn(){
        if (canAdvance == true && (atExit == true|| atEntrance == true)){
            return true;
        }
        return false;
    }

    public Character getHero(){
        return hero;
    }

    public Boss getBoss(){
        return currentBoss;
    }

    public boolean getDefLev(){
        return defeatedLevel;
    }

    public boolean checkAdvance(){
        return canAdvance;
    }

    public boolean checkMove(){
        return canMove;
    }

    // Test Stuff

    public void upLevHero(){
        hero.upLev(1);
    }

    public void downLevHero(){
        hero.downLev(1);
    }

}