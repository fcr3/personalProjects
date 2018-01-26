import java.util.Arrays;

public class Battle{
	private String[] combo;
	private String input;
	
	// outcome = true => won battle
	// outcome = false => lost battle
	private boolean outcome;
	
	public Battle(){
		
		combo = new String[4];
		for (int x = 0; x < 4; x++){
			int n = (int)(Math.random()*4);
			if ( n == 0 ){
				combo[x] = "a";
			}
			else if (n == 1){
				combo[x] ="s";
			}
			else if (n == 2){
				combo[x] = "d'";
			}
			else if (n == 3){
				combo[x] = "f";
			}
		}
		
	}
	
	public void setInput(String s){
		input = s;
	}
	
	public boolean inputMatch1(String s){
		return s.equals(combo[0]);
	}
	
	public boolean inputMatch2(String s){
		return s.equals(combo[1]);
	}
	
	public boolean inputMatch3(String s){
		return s.equals(combo[2]);
	}
	
	public boolean inputMatch4(String s){
		return s.equals(combo[3]);
	}
	
	public void newCombo(){
		for (int x = 0; x < 4; x++){
			int n = (int)(Math.random()*4);
			if ( n == 0 ){
				combo[x] = "a";
			}
			else if (n == 1){
				combo[x] ="s";
			}
			else if (n == 2){
				combo[x] = "d'";
			}
			else if (n == 3){
				combo[x] = "f";
			}
		}
	}
	
	public void check(GameShow gs){
		// find way to make each boss get defeated once battle is won
		// each boss has to stay dfeated one battle is done and won
		gs.defeatedBoss();
	}
	
	public boolean getOutcome(){
		return outcome;
	}
	
	/*public void battleCommence(Character h, Boss v){
		while (true){
			for (int x = 0; x<4; x++){
				setInput(
			}
		}
	}*/
	
}