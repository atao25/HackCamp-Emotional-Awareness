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
    private JTextField user;
    private JPasswordField pw;
    private JButton login;

    private JPanel userNamePanel;
    private JPanel passwordPanel;



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
       // profileFrame.setResizable(false);
        profileFrame.add(profilePanel);
        makeProfileDetails();

        profileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loadPrimaryFrame();

    }

    public JFrame loadPrimaryFrame() { 
        primaryFrame = new JFrame();
        //primaryFrame = setTitle("Emotional Awareness: primary emotions");
        primaryFrame.setSize(profileDimension.width, profileDimension.height);
        primaryPanel = setUpPrimaryPanel();
        primaryFrame.setVisible(true);
        primaryFrame.add(primaryPanel);
        primaryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return primaryFrame;
    }

    public JPanel setUpProfilePanel() {
        profilePanel = new JPanel();
        profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));
        profilePanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));



        return profilePanel;

    }
    public void makeProfileDetails() {
        title = new JLabel("EMOTIONAL AWARENESS");
        title.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        message = new JLabel("The ability to understand feelings ...");
        message.setAlignmentX(Component.CENTER_ALIGNMENT);



        JLabel userName = new JLabel("Enter Username");
        userName.setAlignmentX(Component.RIGHT_ALIGNMENT);
        JLabel password = new JLabel("Enter Password");
        password.setAlignmentX(Component.RIGHT_ALIGNMENT);

        user = new JTextField();
       // user.setBorder(BorderFactory.createEmptyBorder(200, 100, 200, 100));
       // user.setPreferredSize(new Dimension(30,30));
       // user.setAlignmentX(Component.LEFT_ALIGNMENT);
        pw = new JPasswordField();
       // pw.setBorder(BorderFactory.createEmptyBorder(200, 100, 200, 100));

       // pw.setAlignmentX(Component.LEFT_ALIGNMENT);

        profilePanel.add(title);
        profilePanel.add(message);
        profilePanel.add(user);
        profilePanel.add(pw);
        profilePanel.add(userName);
        profilePanel.add(password);
        

    }

    












    public JPanel setUpPrimaryPanel() {
        primaryPanel = new JPanel();
        primaryPanel.setLayout(new GridLayout(2, 0, 0, 12));
        primaryPanel.setBorder(BorderFactory.createEmptyBorder(50, 120, 50, 120));

        JLabel primaryTitle = new JLabel();
        primaryTitle.setText("I am feeling...");
        primaryTitle.setVerticalAlignment(JLabel.TOP);
        primaryTitle.setFont(new Font("Monospaced Bold",Font.BOLD, 29));
        primaryTitle.setHorizontalAlignment(JLabel.CENTER);
        primaryPanel.add(primaryTitle);

        return primaryPanel;
        
    
   




    }
} 