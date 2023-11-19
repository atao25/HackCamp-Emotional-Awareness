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
    private JLabel title;
    private JLabel message;



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
    private JButton back1;



    // second layer emoji frame
    private JFrame secondary;
    private JButton back2;



    public static void main (String[] args) {
        new EmotionsGUI();

    }

    public EmotionsGUI() {
        profileFrame = new JFrame();
        profileDimension = new Dimension(600, 600);
        profileFrame.setTitle("Emotional Awareness App");
        profileFrame.setSize(profileDimension.width, profileDimension.height);
        profilePanel = setUpProfilePanel();
        profileFrame.setVisible(true);
        profileFrame.add(profilePanel);
        makeProfileDetails();
        profileFrame.pack();

        profileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // profileFrame.setResizable(false);

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
        profilePanel.setLayout(new GridLayout(0, 1, 0, 1));
        profilePanel.setBorder(BorderFactory.createEmptyBorder(50, 120, 50, 120));



        return profilePanel;
    }

<<<<<<< HEAD
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
        
=======
    public void makeProfileDetails() {
        title = new JLabel("EMOTIONAL AWARENESS");
        title.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        title.setVerticalAlignment(JLabel.TOP);
        title.setHorizontalAlignment(JLabel.CENTER);
        message = new JLabel("The ability to understand feelings ...");
        message.setHorizontalAlignment(JLabel.CENTER);




        profilePanel.add(title);
        profilePanel.add(message);
>>>>>>> f93841a8ee04206502a0d39d3876ceb247c7945d
    }

   




} 