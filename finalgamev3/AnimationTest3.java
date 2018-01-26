import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class AnimationTest3 extends JPanel {
	
	private int x = 270;
	private int y = 270;

	//determines door image
	private static int l = -1;

	//determines text appearance
	private static int t = -1;
	private static int t1 = -1;
	private static int t2 = -1;

	//determines floor image
	private static int f = 0;

	//private int x = 0;
	//private int y = 0;
	private static GameShow gs1;

	public static void main(String[] args) {

		JFrame frame = new JFrame("Game Draft");
		frame.setLayout(new BorderLayout());
		AnimationTest3 a_test = new AnimationTest3();
		a_test.setSize(200, 200);
		frame.add(a_test, BorderLayout.CENTER);
		frame.setLocation(100, 100);
		frame.setSize(500, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		Scanner kb = new Scanner(System.in);

		gs1 = new GameShow();

		gs1.movement();
		gs1.advance();
		gs1.atExitNow();
		gs1.atEntranceNow();
		gs1.faceBoss();
		gs1.atEnemyNow();

		// Gives Exit Option Appearance
		if (gs1.checkAdvance() == true) {
			l = 0;
			if ((gs1.getAtExit() == true)) {
				t = 0;
			} else {
				t = -1;
			}
		}
		//Add other options here
		else {
			t = -1;
			l = -1;
		}
		a_test.repaint();

	}
	
	public AnimationTest3() {
		GameKeyListener listener = new GameKeyListener();
		listener.setPanel(this);
		addKeyListener(listener);
		setFocusable(true);
	}

	public int getx(){
		return x;
	}

	public int gety(){
		return y;
	}

	public void paint(Graphics g) {

		super.paint(g);
		Image mc = Toolkit.getDefaultToolkit().getImage("main.png");
		Image bg = Toolkit.getDefaultToolkit().getImage("d1.jpg");
		Image boss = Toolkit.getDefaultToolkit().getImage("b1.png");
		if (f == 1) {
			bg = Toolkit.getDefaultToolkit().getImage("d2.jpg");
			boss = Toolkit.getDefaultToolkit().getImage("b2.png");
		}
		else if (f == 2){
			bg = Toolkit.getDefaultToolkit().getImage("d3.jpg");
			boss = Toolkit.getDefaultToolkit().getImage("b3.png");
			
		}
		else if (f == 3){
			bg = Toolkit.getDefaultToolkit().getImage("d4.jpg");
			boss = Toolkit.getDefaultToolkit().getImage("b4.png");
		}
		else if (f == 4){
			bg = Toolkit.getDefaultToolkit().getImage("d5.jpg");
			boss = Toolkit.getDefaultToolkit().getImage("b5.png");
		}
		Image stair = Toolkit.getDefaultToolkit().getImage("stairs.png");
		Image stair1 = Toolkit.getDefaultToolkit().getImage("stair1.png");
		Image block = Toolkit.getDefaultToolkit().getImage("block.png");
		// Between level changes, set an arbitrary number value to change background image
		g.setFont(new Font("Arial", Font.BOLD, 16));
		g.drawImage(bg, 0, 0, this);
		if (l == 0 && f != 4){
			// Gives Exit Option Appearance
			g.drawImage(stair, -162, -90, this);
			if (t == 0) {
				g.drawString("Exit? Y", 10, 480);
			}
		}
		else if( l == -1 && f != 4) {
			g.drawImage(block, -164, -90, this);

		}

		if (f != 0) {
			g.drawImage(stair1, 238, 300, this);
			if (t1 == 0) {
				g.drawString("Exit? Y", 10, 480);
			}
		}
		g.drawImage(boss,-200, -120, this );
		g.drawImage(mc, x, y, this);

		if (t2 == 0){
			g.drawString("Face " + gs1.getBoss().getName() + "? Y", 10, 480);
		}

	}
	
	public class GameKeyListener implements KeyListener {
	
		private AnimationTest3 gamePanel;

	
		public void setPanel(AnimationTest3 gamePanel) {
			this.gamePanel = gamePanel;
		}
	
		public void keyTyped(KeyEvent e) {
		
		}
		
		public void keyPressed(KeyEvent e) {
			int x = gamePanel.x;
			int y = gamePanel.y;
			if (e.getKeyCode() == KeyEvent.VK_RIGHT){
				gamePanel.x += 20;
				gamePanel.gs1.getHero().moveRight();

			}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT){
				gamePanel.x -=20;
				gamePanel.gs1.getHero().moveLeft();

			}
			else if (e.getKeyCode() == KeyEvent.VK_UP){
				gamePanel.y -= 20;
				gamePanel.gs1.getHero().moveUp();

			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN){
				gamePanel.y+=20;
				gamePanel.gs1.getHero().moveDown();

			}
			if (e.getKeyCode() == KeyEvent.VK_E){
				System.out.println("Exiting");
				System.exit(0);
			}
			if (e.getKeyCode() == KeyEvent.VK_A){
				
			}
			
			
			//System.out.println("("+ gamePanel.gs1.getHero().getx() +", " +gamePanel.gs1.getHero().gety() + ")");
			//System.out.println("("+ gamePanel.getx() + ", " + gamePanel.gety() + ")");

			gs1.movement();
			gs1.advance();
			gs1.atExitNow();
			gs1.atEntranceNow();
			gs1.faceBoss();
			gs1.atEnemyNow();



			if (gs1.checkMove() == true){
				gamePanel.repaint();
			}
			else {
				gamePanel.x = x;
				gamePanel.y = y;
				gamePanel.repaint();
			}
			// Gives Exit Option Appearance

			if (gs1.checkAdvance() == true){
				l = 0;
				if (gs1.getAtExit() == true ) {
					t = 0;
				}
				else {
					t = -1;
				}
				if(gs1.getAtEntrance() == true){
					t1 = 0;
				}
				else {
					t1 = -1;
				}
			}
			else {
				t = -1;
				l = -1;
			}

			if (gs1.getAtEnemy() == true && gs1.getDefLev() == false){
				t2 = 0;
			}
			else {
				t2 = -1;
			}

			if (e.getKeyCode() == KeyEvent.VK_Y){
				if(gs1.moveOn() == true){
					if (gs1.getAtExit() == true) {
						f++;
						if (f > 4){
							f = 4;
							gamePanel.repaint();
						}
						else {
							gamePanel.x = 270;
							gamePanel.y = 270;
							gs1.resetLocation();
							gs1.upLevHero();
							gamePanel.repaint();
							//sets the proper entrance
							battleCheckup();
							gamePanel.repaint();
						}
					}
					else if (gs1.getAtEntrance() == true){
						f--;
						if (f < 0){
							f = 0;
							gamePanel.repaint();
						}
						else {
							gamePanel.x = -150;
							gamePanel.y = -70;
							gs1.resetLocation();
							gs1.downLevHero();
							gamePanel.repaint();
							// sets the proper entrance
							battleCheckup();
							gamePanel.repaint();
						}

					}
				}
				
				if (gs1.getAtEnemy() == true && gs1.getDefLev() == false){
					Battle nowBattle = new Battle();
					nowBattle.check(gs1);
					battleCheckup();
					gamePanel.repaint();
				}
				
			}

		}
		
		public void battleCheckup(){
			gs1.faceBoss();
			gs1.advance();
			
			if (gs1.checkAdvance() == true){
				l = 0;
				if (gs1.getAtExit() == true ) {
					t = 0;
				}
				else {
					t = -1;
				}
				if(gs1.getAtEntrance() == true){
					t1 = 0;
				}
				else {
					t1 = -1;
				}
			}
			else {
				t = -1;
				l = -1;
			}

			if (gs1.getAtEnemy() == true && gs1.getDefLev() == false){
				t2 = 0;
			}
			else {
				t2 = -1;
			}
		}
		
		public void keyReleased(KeyEvent e) {
		
		}
		
	}



}// Java Document