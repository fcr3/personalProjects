public class Item{
    private String name;
    private int boostAtt;
    private int boostDef;
    private int type; 
    // if 1, type is leg armor. if 2, type is upper body armor
    private boolean equipped;
    
    public Item(){
        name = "No Item";
        boostAtt = 0;
        boostDef = 0;
        type = 0;
        equipped = false;
    }
	
	public Item(String n){
		name = n;
		boostAtt = 0;
        boostDef = 0;
        type = 0;
        equipped = false;
	}
    
    public Item(String n, int b1, int b2, int t){
        name = n;
        boostAtt = b1;
        boostDef = b2;
        type = t;
        equipped = false;
    }
    
    public void equip(){
        equipped = true;
    }
    
    public void unequip(){
        equipped = false;
    }
    
    public void editBoostAtt(int v){
        boostAtt = v;
    }
    
    public void editBoostDef(int v){
        boostDef = v;
    }
    
	public String getName(){
		return name;
	}
	
    public int getBoostAtt(){
        return boostAtt;
    }
    
    public int getBoostDef(){
        return boostDef;
    }
    
    public String toString(){
        return "Name: " + name +
        "\nAttack Boost: " + boostAtt +
        "\nDefense Boost: " + boostDef +
        "\nEquipped: " + equipped;
    }
    
}