import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CardGame{
    JFrame frame;
    ArrayList<QuizCard> quizCards;
    JTextArea display;
    boolean isShowAnswer;
    JButton nextButton;
    QuizCard currentCard;
    int currentCardIndex;
    
    public static void main(String[] args){
        CardGame gui = new CardGame();
        gui.setUp();
    }

    public void setUp() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nextButton = new JButton("Show Question");
        display = new JTextArea(6, 45);
        display.setLineWrap(true);
        display.setEditable(false);
        JPanel mainPanel = new JPanel();

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(new OpenMenuListener());
        file.add(open);
        menuBar.add(file);
        frame.setJMenuBar(menuBar);

        mainPanel.add(new Label("Question:"));

        JScrollPane scr1 = new JScrollPane(display);
        scr1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scr1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.add(scr1);

        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500, 300);
        frame.setVisible(true);

    }

    public class NextCardListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (isShowAnswer){
                display.setText(currentCard.getAnswer());
                nextButton.setText("Next Card");
                isShowAnswer = false;
            } else {
                if (currentCardIndex < quizCards.size()){
                    showNextCard();
                } else {
                    display.setText("That was the last card.");
                    nextButton.setEnabled(false);
                }
            }
        }
    }
    
    public class OpenMenuListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            loadFile(fileOpen.getSelectedFile());
        }
    }

    public void loadFile(File file){
        quizCards = new ArrayList<QuizCard>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null){
                makeCard(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception ex){
            System.out.println("Couldn't read file");
            ex.printStackTrace();
        }
        showNextCard();
    }

    private void makeCard(String line){
        String[] result = line.split("/");
        QuizCard card = new QuizCard(result[0], result[1]);
        quizCards.add(card);
        // System.out.println("Made a Card");
    }

    private void showNextCard(){
        currentCard = quizCards.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion());
        nextButton.setText("Show Answer");
        isShowAnswer = true;
    }
}