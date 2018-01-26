import javax.swing.*;

public class SimpleGUI {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(button); // adds button to frame's content pane
        frame.setSize(300, 300); // gives frame size
        frame.setVisible(true); // makes frame visible
    }
}