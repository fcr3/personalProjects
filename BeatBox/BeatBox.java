import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

public class BeatBox{

    JPanel mainPanel;
    ArrayList<JCheckBox> checkboxList;
    Sequencer sequencer;
    Sequence sequence;
    Track track;
    JFrame theFrame;
    boolean stopped;

    String[] instrumentNames = {
        "Bass Drum",
        "Closed Hi-Hat",
        "Open Hi-Hat",
        "Acounstic Snare",
        "Crash Cymbal",
        "Hand Clap",
        "High Tom",
        "Hi Bongo",
        "Maracas",
        "Whistle",
        "Low Conga",
        "Cowbell",
        "Vibraslap",
        "Low-mid Tom",
        "High Agogo",
        "Open Hi Conga"
    };

    int[] instruments = {
        35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63
    };

    public static void main(String[] args){
        new BeatBox().buildGUI();
    }

    public void buildGUI(){
        theFrame = new JFrame("Cyber BeatBox");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // The Buttons
        checkboxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(new startListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new stopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo +");
        upTempo.addActionListener(new upTempoListener());
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo -");
        downTempo.addActionListener(new downTempoListener());
        buttonBox.add(downTempo);

        JButton clear = new JButton("Clear");
        clear.addActionListener(new clearListener());
        buttonBox.add(clear);

        JButton rand = new JButton("Random");
        rand.addActionListener(new randListener());
        buttonBox.add(rand);

        JButton save = new JButton("Save Beat");
        save.addActionListener(new sbListener());
        buttonBox.add(save);

        JButton open = new JButton("Open Beat");
        open.addActionListener(new obListener());
        buttonBox.add(open);

        // More Setup
        Box intrBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < instrumentNames.length; i++){
            intrBox.add(new Label(instrumentNames[i]));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, intrBox);
        theFrame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        for (int i = 0; i < 256; i++){
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);
        }

        setUpMidi();

        theFrame.setBounds(50, 50, 1000, 1000);
        theFrame.pack();
        theFrame.setVisible(true);
    }

    public void setUpMidi(){
        try{
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            sequencer.setTempoInBPM(120);
            stopped = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildTrackAndStart(){
        int[] trackList = null;
        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (int i = 0; i < 16; i++){
            trackList = new int[16];
            int instr = instruments[i];

            for (int in = 0; in < 16; in++){
                JCheckBox check = (JCheckBox) checkboxList.get(in + (16*i));
                if (check.isSelected()){
                    trackList[in] = instr;
                } else{
                    trackList[in] = 0;
                }
            }
            makeTracks(trackList);
            track.add(makeEvent(176, 1, 127, 0, 16));
        }

        track.add(makeEvent(192, 9, 1, 0, 15));
        try{
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            stopped = false;
            sequencer.setTempoInBPM(120);
        } catch (Exception e) { e.printStackTrace(); }
    }

    //Listeners

    public class startListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            buildTrackAndStart();
        }
    }

    public class stopListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            sequencer.stop();
            stopped = true;
        }
    }

    public class upTempoListener implements ActionListener {
        public void actionPerformed(ActionEvent a){
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * 1.03));
        }
    }

    public class downTempoListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            float tempoFactor = sequencer. getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * .97));
        }
    }

    public class clearListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            if (stopped){
                for (int i = 0; i < checkboxList.size(); i++){
                    checkboxList.get(i).setSelected(false);
                }
            }
        }
    }

    public class randListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            if (stopped) {
                for (int i = 0; i < checkboxList.size(); i++){
                    int r = (int) (Math.random() * 15);
                    if (r == 1){
                        checkboxList.get(i).setSelected(true);
                    } else {
                        checkboxList.get(i).setSelected(false);
                    }
                }
            }
        }
    }

    // classes for saving and restoring

    public class sbListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (stopped) {
                JFileChooser fileSave = new JFileChooser();
                fileSave.showSaveDialog(theFrame);
                saveFile(fileSave.getSelectedFile());
            }
        }
    }

    public void saveFile(File file){
        try{
            boolean[] checkboxState = new boolean[256];
            for (int i = 0; i < 256; i++){
                JCheckBox check = (JCheckBox) checkboxList.get(i);
                if (check.isSelected()){
                    checkboxState[i] = true;
                }
            }
            FileOutputStream fileStream = new FileOutputStream(file);
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(checkboxState);
        } catch (IOException e) {
            System.out.println("Wasn't able to save");
            e.printStackTrace();
        }
    }

    public class obListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(theFrame);
            openFile(fileOpen.getSelectedFile());
        }
    }

    public void openFile(File file){
        boolean[] checkboxState = null;
        try {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream is = new ObjectInputStream(fileIn);
            checkboxState = (boolean[]) is.readObject();
        } catch (Exception e){
            System.out.println("Couldn't read file");
            e.printStackTrace();
        }

        for (int i = 0; i < 256; i++){
            JCheckBox check = checkboxList.get(i);
            if (checkboxState[i]){
                check.setSelected(true);
            } else {
                check.setSelected(false);
            }
        }
        sequencer.stop();
    }

    // making tracks
    public void makeTracks(int[] list){
        for (int i = 0; i < 16; i++){
            int key = list[i];
            if (key != 0){
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i + 1));
            }
        }
    }

    // making Midi events
    public MidiEvent makeEvent(int cmd, int chan, int note, int vel, int tick){
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(cmd, chan, note, vel);
            event = new MidiEvent(a, tick);
        } catch (Exception e) { e.printStackTrace();}
        return event;
    }

}