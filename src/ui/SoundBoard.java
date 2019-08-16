package ui;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SoundBoard extends JFrame implements ActionListener{

    private JButton sound1, sound2, sound3, sound4, sound5, sound6, sound7, sound8, sound9;
    private String soundName1, soundName2, soundName3, soundName4, soundName5, soundName6, soundName7, soundName8, soundName9;
    private String dante;
    private ImageIcon danteImage;
    private JLabel icon;

    public SoundBoard(){
        super("Dante's Sound Board");
        setup();
    }

    private void setup(){

        soundName1 = "/audio/1_krabs.wav";
        soundName2 = "/audio/2_iya.wav";
        soundName3 = "/audio/3_stop_it.wav";
        soundName4 = "/audio/4_colonel.wav";
        soundName5 = "/audio/5_mou.wav";
        soundName6 = "/audio/6_pathetic.wav";
        soundName7 = "/audio/7_camel.wav";
        soundName8 = "/audio/8_yare.wav";
        soundName9 = "/audio/9_toes.wav";

        dante = "/picture/dante.jpg";
        danteImage = new ImageIcon(getClass().getResource(dante));
        icon = new JLabel(danteImage);
        add(icon);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(450,550));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13,13,13,13));
        setLayout(new FlowLayout());

        sound1 = new JButton("Mr. Krabs");
        sound2 = new JButton("IYA");
        sound3 = new JButton("Stop It");
        sound4 = new JButton("Colonel");
        sound5 = new JButton("Done?");
        sound6 = new JButton("Pathetic");
        sound7 = new JButton("Camel");
        sound8 = new JButton("Yare Yare");
        sound9 = new JButton("Toes");

        sound1.setActionCommand("1");
        sound1.addActionListener(this);

        sound2.setActionCommand("2");
        sound2.addActionListener(this);

        sound3.setActionCommand("3");
        sound3.addActionListener(this);

        sound4.setActionCommand("4");
        sound4.addActionListener(this);

        sound5.setActionCommand("5");
        sound5.addActionListener(this);

        sound6.setActionCommand("6");
        sound6.addActionListener(this);

        sound7.setActionCommand("7");
        sound7.addActionListener(this);

        sound8.setActionCommand("8");
        sound8.addActionListener(this);

        sound9.setActionCommand("9");
        sound9.addActionListener(this);

        add(sound1);
        add(sound2);
        add(sound3);
        add(sound4);
        add(sound5);
        add(sound6);
        add(sound7);
        add(sound8);
        add(sound9);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        String soundName = "";
        switch (command){
            case "1":
                soundName = soundName1;
                break;
            case "2":
                soundName = soundName2;
                break;
            case "3":
                soundName = soundName3;
                break;
            case "4":
                soundName = soundName4;
                break;
            case "5":
                soundName = soundName5;
                break;
            case "6":
                soundName = soundName6;
                break;
            case "7":
                soundName = soundName7;
                break;
            case "8":
                soundName = soundName8;
                break;
            case "9":
                soundName = soundName9;
                break;
        }
        playSound(soundName);
    }

    private void playSound(String sound){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource(sound));
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        }
        catch (Exception e){}
    }

    public static void main(String[] args) {
        generateUI();
    }

    private static void generateUI(){
        new SoundBoard();
    }
}
