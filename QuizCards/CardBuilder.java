import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CardBuilder {
    JFrame frame;
    JTextArea question;
    JTextArea answer;
    JButton saveCard;
    ArrayList<QuizCard> quizCards;

    public static void main(String[] args){
        CardBuilder gui = new CardBuilder();
        gui.setUp();
    }

    public void setUp(){
        
        quizCards = new ArrayList<QuizCard>();
        
        frame = new JFrame("Quiz Card Builder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        saveCard = new JButton("Next");
        JPanel mainPanel = new JPanel();

        // New Stuff: Menus
        JMenuBar menu = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        newMenuItem.addActionListener(new NMListener());
        saveMenuItem.addActionListener(new SMListener());
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menu.add(fileMenu);
        frame.setJMenuBar(menu);

        mainPanel.add(new JLabel("Question:"));
        question = new JTextArea(6, 45);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        JScrollPane scr1 = new JScrollPane(question);
        scr1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scr1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.add(scr1);

        mainPanel.add(new JLabel("Answer:"));
        answer = new JTextArea(6, 45);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        JScrollPane scr2 = new JScrollPane(answer);
        scr2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scr2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.add(scr2);

        saveCard.addActionListener(new NCListener());
        mainPanel.add(saveCard);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    public class NCListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            addCard();
            clearCard();
        }
    }

    public class SMListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            if (question.getText() != null && answer.getText() != null){
                addCard();
                clearCard();
            }

            // opens a dialog box in the same frame
            // File dialog navigation and selecting files
            // are done by the JFileChooser (super easy stuff)
            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile());
        }
    }

    public class NMListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            quizCards.clear();
            clearCard();
        }
    }

    public void saveFile(File file){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (QuizCard card : quizCards) {
                writer.write(card.getQuestion() + "/");
                writer.write(card.getAnswer() + "\n");
            }
            writer.close();
        } catch (IOException ex){
            System.out.println("Couldn't write the cardList out");
            ex.printStackTrace();
        }
    }

    public void clearCard(){
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }

    public void addCard(){
        QuizCard card = new QuizCard(question.getText(), answer.getText());
        quizCards.add(card);
    }
}