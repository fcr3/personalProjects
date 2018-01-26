import java.util.ArrayList;

public class Character extends Player{
    
    private String name;
    private int level;
    private int maxLife;
    private int life;
    private int attack;
    private int defense;
    private boolean alive;
    private String speech;
    private ArrayList<Item> inventory;
	private ArrayList<Healer> healers;
	private int x;
	private int y;
    
    public Character(String n){
        super(n);
		x = 0;
		y = 0;
        inventory = new ArrayList<Item>();
		healers = new ArrayList<Healer>();
    }

	public int getx(){
		return x;
	}

	public int gety(){
		return y;
	}

	public void changeXPosition(int v){
		x = v;
	}
	
	public void moveLeft(){
		x--;
	}
	
	public void moveRight(){
		x++;
	}
	
	public void changeYPosition(int v){
		y = v;
	}
	
	public void moveDown(){
		y--;
	}
	
	public void moveUp(){
		y++;
	}
	
    public void getInventory(){
        for (Item n : inventory){
            System.out.println(n + "\n");
        }
    }
	
	public void itemHeal(){
		if (healers.size() > 0){
			for (Healer n : healers){
				if (life < maxLife){
					life = life + n.getBoostHealth();
					if (life > maxLife){
						life = maxLife;
						break;
					}
					alive = true;
					healers.remove(0);
					break;
				}
			}
		}
	}
    
}