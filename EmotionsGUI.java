import javax.imageio.ImageIO;
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
        //profileFrame.setResizable(false);
        profileFrame.add(profilePanel);
        makeProfileDetails();

        profileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       loadPrimaryFrame();

    }

    public JPanel setUpProfilePanel() {
        profilePanel = new JPanel();
        profilePanel.setLayout(new GridLayout(0, 1, 0, 1));
        profilePanel.setBorder(BorderFactory.createEmptyBorder(50, 120, 50, 120));



        return profilePanel;
    }


    public JFrame loadPrimaryFrame() { 
        primaryFrame = new JFrame();
        //primaryFrame = setTitle("Emotional Awareness: primary emotions");
        primaryFrame.setSize(profileDimension.width, profileDimension.height);
        primaryPanel = setUpPrimaryPanel();
        primaryFrame.setVisible(true);
        //primaryFrame.setResizable(false);
        primaryFrame.add(primaryPanel);
        primaryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return primaryFrame;
    }


    public void makeProfileDetails() {
        title = new JLabel("EMOTIONAL AWARENESS");
        title.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        title.setVerticalAlignment(JLabel.TOP);
        title.setHorizontalAlignment(JLabel.CENTER);
        message = new JLabel("The ability to understand feelings ...");
        message.setHorizontalAlignment(JLabel.CENTER);


        profilePanel.add(title);
        profilePanel.add(message);
    }

    

    public JPanel setUpPrimaryPanel() {
        primaryPanel = new JPanel();
        primaryPanel.setLayout(new GridLayout(2, 0, -30,-100));
        primaryPanel.setBorder(BorderFactory.createEmptyBorder(50, 120, 50, 120));
        primaryPanel.setVisible(true);

        JLabel primaryTitle = new JLabel();
        primaryTitle.setText("I am feeling...");
        primaryTitle.setVerticalAlignment(JLabel.TOP);
        primaryTitle.setFont(new Font("Monospaced Bold",Font.BOLD, 29));
        primaryTitle.setHorizontalAlignment(JLabel.CENTER);
        primaryPanel.add(primaryTitle);

        primaryPanel.add(setUpButtonsInPrimaryPanel());



        return primaryPanel;

    }


    public JPanel setUpButtonsInPrimaryPanel() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(2, 3));
        buttonsPanel.setVisible(true);

        buttonsPanel.add(designButtonLabel(happy, "Happy"));
        buttonsPanel.add(designButtonLabel(sad, "Sad"));
        buttonsPanel.add(designButtonLabel(anger, "Anger"));
        buttonsPanel.add(designButtonLabel(fear, "Fear"));
        buttonsPanel.add(designButtonLabel(disgust, "Disgust"));
        buttonsPanel.add(designButtonLabel(surprise, "Suprise"));

        return buttonsPanel;

    }


    public JLabel designButtonLabel(JButton button, String buttonName) {
        JLabel buttonLabel = new JLabel();
        button = designButton(button);

        buttonLabel.add(button);
        buttonLabel.setText(buttonName);
        buttonLabel.setVisible(true);
        
    
        return buttonLabel;
    }


    public JButton designButton(JButton button) {
        Icon icon = new ImageIcon("images/fear.PNG");
        button = new JButton(icon);

        button.setVisible(true);
        button.setFocusable(false); 
        button.setSize(100,100);
        return button;

    }



} 