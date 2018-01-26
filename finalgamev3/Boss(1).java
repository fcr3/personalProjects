public class Boss {
    private String name;
    private int level;
    private int maxLife;
    private int life;
    private int attack;
    private int defense;
    private boolean alive;
    private String speech;
    
    public Boss(){
        name = "Nothing";
        level = 0;
        maxLife = 0;
        life = 0;
        attack = 0;
        defense = 0;
        alive = false;
        speech = "";
    }

    public Boss(String n, int l, int ml, int li, int att, int def){
        name = n;
        level = l;
        maxLife = ml;
        life = l;
        attack = att;
        defense = def;
        alive = true;
        speech = "";
    }
    
    // to change name: editName(String n)
    // to talk: talk(String s)
    
    public void editLevel(int v){
        level = v;
    }

    public String getName(){
        return name;
    }

    public int getLev(){
        return level;
    }
    public int getAtt(){
        return attack;
    }

    public int getDef(){
        return defense;
    }

    public boolean getAlive(){
        return alive;
    }

    public void lives(){
        alive = true;
    }

    public void dies(){
        alive = false;
    }

    public void downLife(int v){
        life-=v;
    }

    public void editAttack(int v){
        attack = v;
    }
    
    public void editDefense(int v){
        defense = v;
    }

    public String toString(){
        return name;
    }
    
}