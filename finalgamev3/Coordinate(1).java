public class Coordinate {
	private int x;
	private int y;

	public Coordinate(){
		x= 0;
		y = 0;
	}

	public Coordinate(int xco,int yco){
		x = xco;
		y = yco;
	}

	public int getx(){
		return x;
	}

	public int gety(){
		return y;
	}

	public String toString(){
		return "(" + x + ", " + y + ")";
	}

}