import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleChatServerA {
    ArrayList clientOutputStreams;
    
    public static void main(String[] args) {
        new SimpleChatServerA().go();
    }

    public void go() {
        clientOutputStreams = new ArrayList();
        
        try {
            ServerSocket server = new ServerSocket(4242);
            
            while (true) {
                Socket sock = server.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                clientOutputStreams.add(writer);

                Thread t = new Thread(new ClientHandler(sock));
                t.start();
                System.out.println("Established Connection");
            }

        } catch (IOException ex) { ex.printStackTrace(); }
    }

    public void tellEveryone(String message) {
        Iterator it = clientOutputStreams.iterator();
        while (it.hasNext()) {
            try {
                Object markerClient = it.next(); 
                PrintWriter writer = (PrintWriter) markerClient;
                writer.println(markerClient + message);
                writer.flush();
            } catch (Exception ex) { ex.printStackTrace(); }
        }
    }

    public class ClientHandler implements Runnable {
        BufferedReader reader;
        Socket sock;
        
        public ClientHandler(Socket clientSocket) {
            try {
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
            } catch (Exception ex) { ex.printStackTrace(); }
        }

        public void run() {
            String message;
            try {
                message = reader.readLine();
                while (message != null) {
                    tellEveryone(message);
                    message = reader.readLine();
                }
            } catch (Exception ex) { ex.printStackTrace(); }
        }

    }

}