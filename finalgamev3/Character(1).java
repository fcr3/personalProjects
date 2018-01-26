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
	private int x;
	private int y;
    
    public Character(String n){
        super(n);
		x = 0;
		y = 0;
        inventory = new ArrayList<Item>();
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
	
	public void addToInventory(Item n){
		inventory.add(n);
	}
	
	public ArrayList<Item> accessInventory(){
		return inventory;
	}
	
	public void attributeCheck(){
		int m = maxLife;
		int a = attack;
		int d = defense;
		for (Item n : inventory){
			m += n.getBoostLife();
			a += n.getBoostAtt();
			d += n.getBoostDef();
		}
		maxLife = m;
		attack = a;
		defense = d;
		
	}
	
    public void getInventory(){
        for (Item n : inventory){
            System.out.println(n + "\n");
        }
    }
	
	public String toString(){
        return "Name: " + name +  
        "\nLife: " + maxLife +
        "\nAttack: " + attack + 
        "\nDefense: " + defense
		+ "\n";
    }
    
}