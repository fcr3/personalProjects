import javax.sound.midi.*;
import javax.swing.*;
import java.io.*;
import java.awt.*;

public class MiniMusicPlayer1 {
    static JFrame f = new JFrame("Music Video");
    static MyDrawPanel ml;
    
    public static void main(String[] args){
        MiniMusicPlayer1 mini = new MiniMusicPlayer1();
        mini.go();
    }
    
    public void setUpGui(){
        ml = new MyDrawPanel();
        f.setContentPane(ml);
        f.setBounds(30, 30, 300, 300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void go() {
        setUpGui();
        try{
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            int[] eventsWanted = {127};
            sequencer.addControllerEventListener(ml, eventsWanted);

            for (int i = 0; i < 60; i+=4){
                int r = (int) ((Math.random() * 50) + 1);
                track.add(makeEvent(144, 1, r, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                // cmd 176 says this event is a controller listener
                track.add(makeEvent(128, 1, r, 100, i + 2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(120);
            sequencer.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static MidiEvent makeEvent(int cmd, int chan, int note, int vel, int tick){
        MidiEvent event = null;
        try{
            ShortMessage a = new ShortMessage();
            a.setMessage(cmd, chan, note, vel);
            event = new MidiEvent(a, tick);
        } catch (Exception ex){
            // Nothing
        }
        return event;
    }

    public static int makeRandomNum(int x){
        int rand = (int) (Math.random() * x);
        return rand;
    }

    class MyDrawPanel extends JPanel implements ControllerEventListener{
        boolean msg = false;

        public void controlChange(ShortMessage event){
            msg = true;
            repaint();
        }

        public void paintComponent(Graphics g){
            if (msg) {
                Graphics2D g2 = (Graphics2D) g;
                int r = makeRandomNum(250);
                int gr = makeRandomNum(250);
                int b = makeRandomNum(250);

                g.setColor(new Color(r, gr, b));
                int ht = makeRandomNum(120) + 10;
                int width = makeRandomNum(120) + 10;
                int x = makeRandomNum(40) + 10;
                int y = makeRandomNum(40) + 10;
                g.fillRect(x, y, ht, width);

                msg = false;
            }
        }
        
    }
}