public class Healer extends Item{
	private String name;
	private int boostHealth;
	
	public Healer(){
		super("Healer");
		boostHealth = 50;
	}
	
	public int getBoostHealth(){
		return boostHealth;
	}
	
	public String toString(){
		return "Name: " + name +
		"\nHealing Boost: " + boostHealth;
	}
	
}