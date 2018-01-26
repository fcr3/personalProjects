public class Player {
    
    private String name;
    private int level;
    private int maxLife;
    private int life;
    private int attack;
    private int defense;
    private boolean alive;
    private String speech;
    
    public Player(){
        name = "Nobody";
        maxLife = 0;
        life = 0;
        level = 0;
        attack = 0;
        defense = 0;
        alive = false;
        speech = "";
    }
    
    public Player(String n){
        name= n;
        maxLife = 100;
        life = maxLife;
        level = 0;
        attack = 10;
        defense = 10;
        alive = true;
        speech = "";
    }
    
    public void editName(String n){
        name = n;
    }
    
    public void upLev(int v){
        level+=v;
    }

    public void downLev(int v) {level-=v;}
    
    public void upMaxLife(int v){
        maxLife+=v;
    }
    
    public void downLife(int v){
        life-=v;
    }
    
    public void upDef(int v){
        defense+=v;
    }
    
    public void downDef(int v){
        defense-=v;
    }
    
    public void upAtt(int v){
        attack+=v;
    }
    
    public void downAtt(int v){
        attack-=v;
    }
    
    public void lives(){
        alive = true;
    }
    
    public void dies(){
        alive = false;
    }
    
    public String getName(){
        return name;
    }
    
    public int getMaxLife(){
        return maxLife;
    }
    
    public int getLife(){
        return life;
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
    
    public String getSpeech(){
        return speech;
    }
    
    // Methods I think will be used mostly in-game
    
    public void talk(String s){
        speech = s;
        System.out.println(s);
    }
    
    public void heal(){
        life = getMaxLife();
    }
    
    public void upgrade(){
        upLev(1);
        upMaxLife(10);
        upDef(10);
        upAtt(20);
    }
    
    public String toString(){
        return "Name: " + name + 
        "\nLevel: " + level + 
        "\nLife: " + maxLife +
        "\nAttack: " + attack + 
        "\nDefense" + defense;
    }
    
}