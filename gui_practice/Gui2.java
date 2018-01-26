import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Gui2 implements ActionListener{
    JButton button;
    JFrame frame;
    int incr;

    public static void main(String[] args){
        Gui2 gui = new Gui2();
        gui.go();
    }

    public void go(){
        frame = new JFrame();
        button = new JButton("Click Me");

        MyDrawPanel drawPanel = new MyDrawPanel();

        button.addActionListener(this);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event){
        incr = incr + 1; 
        button.setText("I've been clicked " + incr + " times");
        frame.repaint();
    }
}