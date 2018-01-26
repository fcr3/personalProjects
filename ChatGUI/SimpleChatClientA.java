import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.awt.event.*;
import java.util.*;

public class SimpleChatClientA{

    JTextField outgoing;
    PrintWriter writer;
    Socket sock;
    JTextArea incoming;
    BufferedReader reader;

    public void go(){
        JFrame frame = new JFrame("Simple Chat Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        
        incoming = new JTextArea(15, 30);
        incoming.setLineWrap(true);
        incoming.setLineWrap(true);
        incoming.setEditable(false);
        JScrollPane scroller = new JScrollPane(incoming);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        outgoing = new JTextField(20);
        JButton button = new JButton("Send");
        button.addActionListener(new SendButtonListener());

        mainPanel.add(scroller);
        mainPanel.add(outgoing);
        mainPanel.add(button);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        setUpNetwork();
        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();

        frame.setSize(400, 350);
        frame.setVisible(true);

    }

    public void setUpNetwork(){
        try {
            String someIP = "10.142.42.54";
            sock = new Socket(someIP, 4242);
            writer = new PrintWriter(sock.getOutputStream());

            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            try {
                String text = outgoing.getText();
                writer.println(text);
                writer.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }

    public static void main(String[] args){
        new SimpleChatClientA().go();
    }

    public class IncomingReader implements Runnable{
        public void run(){
            String message;
            try {
                message = reader.readLine();
                while (message != null){
                    incoming.append(message + "\n");
                    message = reader.readLine();
                }
            } catch (Exception ex) { ex.printStackTrace(); }
        }
    }

}