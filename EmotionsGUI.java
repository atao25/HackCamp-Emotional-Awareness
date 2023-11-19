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
    private JFrame primaryFrame;
    private JPanel primaryPanel;
    private Dimension primaryDimension;

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

    }

    public EmotionsGUI() {
        profileFrame = new JFrame();
        profileDimension = new Dimension(600, 600);
       //profileFrame.setTitle("Emotional Awareness");
        profileFrame.setSize(profileDimension.width, profileDimension.height);
        profilePanel = setUpProfilePanel();
        profileFrame.setVisible(true);
        profileFrame.add(profilePanel);

        primaryFrame = new JFrame();
        //primaryFrame = setTitle("Emotional Awareness: primary emotions");
        primaryFrame.setSize(profileDimension.width, profileDimension.height);
        primaryPanel = setUpPrimaryPanel();
        primaryFrame.setVisible(true);
        primaryFrame.add(primaryPanel);
        primaryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public JPanel setUpProfilePanel() {
        profilePanel = new JPanel();
        profilePanel.setLayout(new GridLayout(0, 1, 0, 12));
        profilePanel.setBorder(BorderFactory.createEmptyBorder(50, 120, 50, 120));



        return profilePanel;
    }

    public JPanel setUpPrimaryPanel() {
        primaryPanel = new JPanel();
        primaryPanel.setLayout(new GridLayout(2, 0, 0, 12));
        primaryPanel.setBorder(BorderFactory.createEmptyBorder(50, 120, 50, 120));

        JLabel title = new JLabel();
        title.setText("I am feeling...");
        title.setVerticalAlignment(JLabel.TOP);
        title.setFont(new Font("Monospaced Bold",Font.BOLD, 29));
        title.setHorizontalAlignment(JLabel.CENTER);
        primaryPanel.add(title);

        return primaryPanel;
        
    }

   




} 