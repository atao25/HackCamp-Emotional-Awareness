import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;


public class EmotionsGUI {

    // login frame
    private JFrame profileFrame;
    private Dimension profileDimension;
    private JPanel profilePanel;



    // first layer emoji frame
    private JFrame primary;
    private JButton happy;
    private JButton sad;
    private JButton disgust;
    private JButton fear;
    private JButton anger;
    private JButton surprise;



    // second layer emoji frame
    private JFrame secondary;



    public static void main (String[] args) {
        new EmotionsGUI();
        System.out.println("hi");
    }

    public EmotionsGUI() {
        profileFrame = new JFrame();
        profileDimension = new Dimension(600, 600);
       //profileFrame.setTitle("Emotional Awareness");
        profileFrame.setSize(profileDimension.width, profileDimension.height);
        profilePanel = setUpProfilePanel();
        profileFrame.setVisible(true);


        profileFrame.add(profilePanel);

    }

    public JPanel setUpProfilePanel() {
        profilePanel = new JPanel();
        profilePanel.setLayout(new GridLayout(0, 1, 0, 12));
        profilePanel.setBorder(BorderFactory.createEmptyBorder(50, 120, 50, 120));



        return profilePanel;
    }

   




} 