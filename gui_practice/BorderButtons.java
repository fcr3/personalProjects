import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorderButtons{
    JFrame frame;
    JPanel middlePanel;
    JTextField field;
    JTextArea text;
    JCheckBox check;
    Boolean cannotAdd;

    public static void main(String[] args){
        BorderButtons gui = new BorderButtons();
        gui.go();
    }

    public void go(){
        cannotAdd = false;
        
        /**
         * Setting a component north or south gets preferred height
         * but not preferred width.
         * Setting a component east or west gets preferred width
         * but not preferred height.
         * Center component's dimensions get whatever is leftover.
         */
        
        frame = new JFrame();
        JButton button = new JButton();
        field = new JTextField();
        middlePanel = new JPanel();
        JPanel panel = new JPanel();
        JButton panelButton = new JButton("Inside");
        JButton panelButton2 = new JButton("What's up?");
        check = new JCheckBox("I'm down below");

        field.addActionListener(new fieldListener());
        check.addItemListener(new checkListener());

        Font bigFont = new Font("serif", Font.BOLD, 28);
        panelButton.setFont(bigFont);
        middlePanel.setBackground(Color.red);
        panel.setBackground(Color.blue);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        // y-axis setting gives us vertical stack
        // BoxLayout is a special layout
        // The other is FlowLayout
        // BorderLayout is the default

        middlePanel.add(new JLabel("Start Here:"));
        text = new JTextArea(middlePanel.getHeight(), middlePanel.getWidth());
        text.setLineWrap(true);
        JScrollPane scroller = new JScrollPane(text);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        middlePanel.add(scroller);

        panel.add(panelButton);
        panel.add(panelButton2);
        frame.getContentPane().add(BorderLayout.WEST, panel);
        frame.getContentPane().add(BorderLayout.CENTER, middlePanel);
        frame.getContentPane().add(BorderLayout.NORTH, field);
        frame.getContentPane().add(BorderLayout.EAST, button);
        frame.getContentPane().add(BorderLayout.SOUTH, check);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);

    }

    class fieldListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if (!cannotAdd) {
                text.append(field.getText() + "\n");
            }
            field.setText("");
        }

    }

    class checkListener implements ItemListener{
        public void itemStateChanged(ItemEvent ev){
            if (check.isSelected()){
                cannotAdd = true;
            } else {
                cannotAdd = false;
            }
        }
    }
    
}