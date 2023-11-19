import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    private JLabel userName;
    private JLabel password;

    private JTextField user;
    private JPasswordField pw;

    private JButton submit;


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
        profileDimension = new Dimension(1000, 600);
        profileFrame.setTitle("Emotional Awareness App");
        profileFrame.setSize(profileDimension.width, profileDimension.height);
        profilePanel = setUpProfilePanel();
        profileFrame.add(profilePanel);
        makeProfileDetails();
        profileFrame.setVisible(true);

        profileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public JPanel setUpProfilePanel() {
        profilePanel = new JPanel();
       // profilePanel.setLayout(new GridLayout(0, 1, 0, 1));
        profilePanel.setBorder(BorderFactory.createEmptyBorder(50, 120, 50, 120));
        profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));



        return profilePanel;
    }


    public JFrame loadPrimaryFrame() { 
        primaryFrame = new JFrame();
        //primaryFrame = setTitle("Emotional Awareness: primary emotions");
        primaryFrame.setSize(profileDimension.width, profileDimension.height);
        primaryPanel = setUpPrimaryPanel();
        primaryFrame.setVisible(true);
        primaryFrame.setResizable(false);
        primaryFrame.add(primaryPanel);
        primaryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return primaryFrame;
    }


public void makeProfileDetails() {
        title = new JLabel("EMOTIONAL AWARENESS");
        title.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        message = new JLabel("The ability to understand feelings ...");
        message.setAlignmentX(Component.CENTER_ALIGNMENT);

        userName = new JLabel("Enter Username: ");
        userName.setAlignmentX(Component.RIGHT_ALIGNMENT);
        password = new JLabel("Enter Password: ");
        password.setAlignmentX(Component.RIGHT_ALIGNMENT);

        user = new JTextField(15);
        user.setAlignmentX(Component.LEFT_ALIGNMENT);
        user.setMaximumSize(new Dimension(100,30));
        pw = new JPasswordField(15);
        pw.setAlignmentX(Component.LEFT_ALIGNMENT);
        pw.setMaximumSize(new Dimension(100,30));

        submit = new JButton("Submit");


        profilePanel.add(title);
        profilePanel.add(message);


        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.X_AXIS));
        userPanel.add(userName);
        userPanel.add(Box.createRigidArea(new Dimension(10,0)));
        userPanel.add(user);
        profilePanel.add(userPanel);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
        passwordPanel.add(password);
        passwordPanel.add(Box.createRigidArea(new Dimension(10,0)));
        passwordPanel.add(pw);
        profilePanel.add(passwordPanel);

        profilePanel.add(createSubmitButton());
        

    }

    public JButton createSubmitButton() {
        submit = new JButton("Submit");
        submit.setFocusable(false);
        submit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadPrimaryFrame();
            }
        });
        return submit;
    }

    

    public JPanel setUpPrimaryPanel() {
        primaryPanel = new JPanel();
        primaryPanel.setLayout(new GridLayout(2, 0, -200,-100));
        primaryPanel.setBorder(BorderFactory.createEmptyBorder(100, 50, 50, 50));
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
        buttonsPanel.setLayout(new GridLayout(2, 3, 20, 0));
        buttonsPanel.setVisible(true);

        buttonsPanel.add(designButtonLabel(happy, "Happy"));
        buttonsPanel.add(designButtonLabel(sad, "Sad"));
        buttonsPanel.add(designButtonLabel(anger, "Anger"));
        buttonsPanel.add(designButtonLabel(fear, "Fear"));
        buttonsPanel.add(designButtonLabel(disgust, "Disgust"));
        buttonsPanel.add(designButtonLabel(surprise, "Surprise"));

        return buttonsPanel;

    }


    public JLabel designButtonLabel(JButton button, String buttonName) {
        JLabel text = new JLabel();
        text.setText(buttonName);
        text.setFont(new Font("Monospaced Bold",Font.BOLD, 18));
        text.setHorizontalAlignment(JLabel.CENTER);

        JLabel buttonLabel = new JLabel();
        buttonLabel.setLayout(new GridLayout(2,3,0,-30));
        button = designButton(button, buttonName);

        buttonLabel.add(button);
        buttonLabel.add(text);
        buttonLabel.setVisible(true);
        
    
        return buttonLabel;
    }


    public JButton designButton(JButton button, String buttonName) {
        Icon icon = new ImageIcon("images/" + buttonName + ".PNG");
        button = new JButton(icon);

        button.setVisible(true);
        button.setSize(100, 400);
        return button;

    }



} 