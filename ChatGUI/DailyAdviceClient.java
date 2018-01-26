import java.io.*;
import java.net.*;

public class DailyAdviceClient{

    public void go(){
        try{
            /**
             * Some addresses I can use: 
             * IPv4: 10.142.42.54
             * IPv6 (public): 2607:f140:400:a00a:b080:1d16:bdf7:4ff7
             */

            String someIP = "10.142.42.54";
            Socket s = new Socket(someIP, 4242);
            
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            String advice = reader.readLine();
            System.out.println("Today you should: " + advice);

            reader.close();

        } catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args){
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }

}