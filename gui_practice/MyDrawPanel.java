import java.awt.*;
import javax.swing.*;

class MyDrawPanel extends JPanel{
    public void paintComponent(Graphics g){
        int x = (int) (Math.random() * 2);
        
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color randomColor = new Color(red, green, blue);
        
        if (x == 0){
            g.fillRect(0, 0, this.getWidth(), this.getHeight()); // fills the canvas with black
            g.setColor(randomColor);
            g.fillRect(red, blue, 100, 100);

        } else {
            Graphics2D g2d = (Graphics2D) g;
            
            red = (int) (Math.random() * 255);
            green = (int) (Math.random() * 255);
            blue = (int) (Math.random() * 255);
            Color endColor = new Color(red, green, blue);

            GradientPaint gradient = new GradientPaint(70, 70, randomColor, 150, 150, endColor);
            g2d.setPaint(gradient);
            g2d.fillOval(red, blue, 100, 100);
        }
    }    
}