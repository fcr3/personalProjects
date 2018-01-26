import javax.sound.midi.*;

public class MiniMiniMusicApp{
    public static void main(String[] args){
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }

    public void play(){
        try {
           /**
           * A Track holds all the MidiEven objects.
           * The Sequence organizes them according to when 
           * event is supposed to happen.
           * The Sequencer plays them back in that order. 
           **/
           
            // Create a sequencer and open it
            Sequencer player = MidiSystem.getSequencer(); 
            player.open();

            // Create a sequence (disc) with timing (1st arg)
            // Create a track on that sequence
            Sequence seq = new Sequence(Sequence.PPQ, 4); 
            Track t = seq.createTrack();
            
            // Create midi-events (notes, instructions)
            // Message says what to; MidiEvent says when to do it
            // Set Message: 
            // (1) message type (2) channel (3) note to play (4) velocity
            // (1) 144 or 128 (2) ### (3) 0 - 127 (4) ###
            ShortMessage c = new ShortMessage();
            c.setMessage(192, 1, 102, 0); // 192 means CHANGE INSTRUMENT
            MidiEvent first = new MidiEvent(c, 1);
            
            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 20, 100); // 144 means NOTE ON
            MidiEvent noteOn = new MidiEvent(a, 3); // play "a" on beat 3

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100); // 128 means NOTE OFF
            MidiEvent noteOff = new MidiEvent(b, 5);

            // Add midi-events to track
            // Put the sequence into the sequencer
            t.add(first);
            t.add(noteOn);
            t.add(noteOff);
            player.setSequence(seq);
            player.start(); // start playing
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}