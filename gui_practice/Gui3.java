// this gui class uses inner classes
// inner classes represent different listeners
// these different listerns have different actionPerformed methods
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Gui3{
    JButton button;
    JButton labelButton;
    JFrame frame;
    JLabel label;
    int incrButton;
    int incrLabel;

    public static void main(String[] args){
        Gui3 gui = new Gui3();
        gui.go();
    }

    public void go(){
        frame = new JFrame();
        button = new JButton("Click Me");
        label = new JLabel("What's Up?");
        labelButton = new JButton("Click Me");
        MyDrawPanel drawPanel = new MyDrawPanel();

        button.addActionListener(new BCListener());
        labelButton.addActionListener(new LabelListener());

        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    // BC stands for Button-Color
    class BCListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            incrButton = incrButton + 1; 
            button.setText("I've been clicked " + incrButton + " times");
            frame.repaint();
        }
    }

    class LabelListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            incrLabel = incrLabel + 1;
            label.setText("What's Up? " + incrLabel + "x");
            labelButton.setText("Clicked: " + incrLabel);
        }
    }
}