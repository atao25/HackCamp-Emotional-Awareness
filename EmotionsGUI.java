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
    //private Dimension primaryDimension;

    private JButton happy;
    private JButton sad;
    private JButton disgust;
    private JButton fear;
    private JButton anger;
    private JButton surprise;



    // second layer emoji frame
    private JPanel moreSurprisePanel;
    private JButton startled;
    private JButton confused;
    private JButton amazed;
    private JButton excited;

    private JPanel moreDisgustPanel;
    private JButton disapproval;
    private JButton disappointed;
    private JButton awful;
    private JButton avoidance;


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

        profileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        profileFrame.setVisible(true);

        profileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public JPanel setUpProfilePanel() {
        profilePanel = new JPanel();
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
        JButton joyful = new JButton();
        JButton interested = new JButton();
        JButton proud = new JButton();
        JButton accepted = new JButton();
        JButton powerful = new JButton();
        JButton peaceful = new JButton();
        JButton intimate = new JButton();
        JButton optimistic = new JButton();



        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(2, 3, 20, 0));
        buttonsPanel.setVisible(true);

        buttonsPanel.add(designButtonLabel(joyful, "Joyful"));
        buttonsPanel.add(designButtonLabel(interested, "Interested"));
        buttonsPanel.add(designButtonLabel(proud, "Proud"));
        buttonsPanel.add(designButtonLabel(accepted, "Accepted"));
        buttonsPanel.add(designButtonLabel(powerful, "Powerful"));
        buttonsPanel.add(designButtonLabel(peaceful, "Peaceful"));
        buttonsPanel.add(designButtonLabel(intimate, "Intimate"));
        buttonsPanel.add(designButtonLabel(optimistic, "Optimistic"));

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

        if (buttonName.equals("Happy")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                happyFrame();
            }
        });

        } else if (buttonName.equals("Sad")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sadFrame();
            }
        });
        } else if (buttonName.equals("Fear")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fearFrame();
            }
        });
        } else if (buttonName.equals("Disgust")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disgustFrame();
            }
        });
        } else if (buttonName.equals("Anger")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angerFrame();
            }
        });
        } else if (buttonName.equals("Startled")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startledDialog();
            }
        });  
        }
        else {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                surpriseFrame();
            }
        });
        }
    }
       
        buttonLabel.add(button);
        buttonLabel.add(text);
        buttonLabel.setVisible(true);
    
        return buttonLabel;
 
    }

    public void startledDialog() {
        JFrame startledDialogFrame = new JFrame("Message!");
        startledDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(startledDialogFrame, "Take a deep breath", null, JOptionPane.INFORMATION_MESSAGE);
    }

<<<<<<< HEAD
    // private void deleteDialog() {
    //     int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this meal?",
    //             "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

    //     switch (result) {
    //         case JOptionPane.NO_OPTION:
    //             // don't do anything, close the dialog
    //             break;

    //         case JOptionPane.YES_OPTION:
    //             int selectedMeal = wishList.getSelectedIndex();
    //             wishListModel.remove(selectedMeal);
    //             mealWishList.removeMealByIndex(selectedMeal);
    //     }

    // }
=======
    public JFrame happySecondaryEmotionsFrame(JFrame frame) {
        frame.setVisible(true);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 0, -200,-100));
        panel.setBorder(BorderFactory.createEmptyBorder(100, 50, 50, 50));
        panel.setVisible(true);
        frame.add(panel);

        JLabel secondaryTitle = new JLabel();
        secondaryTitle.setText("Getting a little more specific, I am feeling...");
        secondaryTitle.setVerticalAlignment(JLabel.TOP);
        secondaryTitle.setFont(new Font("Monospaced Bold",Font.BOLD, 29));
        secondaryTitle.setHorizontalAlignment(JLabel.CENTER);

        panel.add(secondaryTitle);
        panel.add(setUpButtonsInHappySecondaryPanel());

        return frame;

    }

    public JPanel setUpButtonsInHappySecondaryPanel() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(2, 4, 20, 0));
        buttonsPanel.setVisible(true);

        buttonsPanel.add(designButtonLabel(happy, "Happy"));
        buttonsPanel.add(designButtonLabel(sad, "Sad"));
        buttonsPanel.add(designButtonLabel(anger, "Anger"));
        buttonsPanel.add(designButtonLabel(fear, "Fear"));
        buttonsPanel.add(designButtonLabel(disgust, "Disgust"));
        buttonsPanel.add(designButtonLabel(surprise, "Surprise"));

        return buttonsPanel;

    }



>>>>>>> d7b920b28727d4536b06936b8730f4e6ef082cbb



    public JFrame happyFrame() {
        JFrame happyFrame = new JFrame();
        happyFrame.setSize(1000,600);
        happyFrame.setTitle("More Happy Emotions!");

        return happySecondaryEmotionsFrame(happyFrame);
    }








      public JFrame sadFrame() {
        JFrame sadFrame = new JFrame();
        sadFrame.setSize(1000,600);
        sadFrame.setTitle("More Sad Emotions :(");

        JPanel sadPanel = new JPanel();
        sadPanel.setBorder(BorderFactory.createEmptyBorder(100, 50, 50, 50));

        sadFrame.add(sadPanel);

        sadFrame.setVisible(true);

        return sadFrame;
    }

     public JFrame disgustFrame() {
        JFrame disgustFrame = new JFrame();
        disgustFrame.setSize(1000,600);
        disgustFrame.setTitle("More Disgusted Emotions!");

        setUpMoreDisgustPanel();
        disgustFrame.add(moreDisgustPanel);
        disgustFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        disgustFrame.setVisible(true);

        return disgustFrame;
    }



     public JPanel setUpMoreDisgustPanel() {
        moreDisgustPanel = new JPanel();
        moreDisgustPanel.setLayout(new GridLayout(2,0,-200,-100));
        moreDisgustPanel.setBorder(BorderFactory.createEmptyBorder(100,50,50,50));
        moreDisgustPanel.setVisible(true);

        JLabel disgustTitle = new JLabel("Getting a little more specific, I am feeling...");
        disgustTitle.setVerticalAlignment(JLabel.TOP);
        disgustTitle.setHorizontalAlignment(JLabel.CENTER);
        disgustTitle.setFont(new Font("Monospaced Bold", Font.BOLD, 29));

        moreDisgustPanel.add(disgustTitle);
        moreDisgustPanel.add(setUpButtonsInDisgustPanel());

        return moreDisgustPanel;
    }

    public JPanel setUpButtonsInDisgustPanel() {
        JPanel disgustButtonsPanel = new JPanel();
        disgustButtonsPanel.setLayout(new GridLayout(1,4,0,10));
        disgustButtonsPanel.setVisible(true);

    
        disgustButtonsPanel.add(designButtonLabel(disapproval, "Disapproval"));
        disgustButtonsPanel.add(designButtonLabel(disappointed, "Disappointed"));
        disgustButtonsPanel.add(designButtonLabel(awful, "Awful"));
        disgustButtonsPanel.add(designButtonLabel(avoidance, "Avoidance"));


        return disgustButtonsPanel;
    }



    public JFrame angerFrame() {
        JFrame angerFrame = new JFrame();
        angerFrame.setSize(1000,600);
        angerFrame.setTitle("More Angry Emotions!");

        JPanel angerPanel = new JPanel();
        angerPanel.setBorder(BorderFactory.createEmptyBorder(100, 50, 50, 50));

        angerFrame.add(angerPanel);

        angerFrame.setVisible(true);

        return angerFrame;
    }



    public JFrame fearFrame() {
        JFrame fearFrame = new JFrame();
        fearFrame.setSize(1000,600);
        fearFrame.setTitle("More Fearful Emotions!");

        JPanel fearPanel = new JPanel();
        fearPanel.setBorder(BorderFactory.createEmptyBorder(100, 50, 50, 50));

        fearFrame.add(fearPanel);

        fearFrame.setVisible(true);

        return fearFrame;
    }

     public JFrame surpriseFrame() {
        JFrame surpriseFrame = new JFrame();
        surpriseFrame.setSize(1000,600);
        surpriseFrame.setTitle("More Surprised Emotions!");

        setUpMoreSurprisePanel();
        surpriseFrame.add(moreSurprisePanel);
        surpriseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        surpriseFrame.setVisible(true);

        return surpriseFrame;
    }

    public JPanel setUpMoreSurprisePanel() {
        moreSurprisePanel = new JPanel();
        moreSurprisePanel.setLayout(new GridLayout(2,0,-200,-100));
        moreSurprisePanel.setBorder(BorderFactory.createEmptyBorder(100,50,50,50));
        moreSurprisePanel.setVisible(true);

        JLabel surpriseTitle = new JLabel("Getting a little more specific, I am feeling...");
        surpriseTitle.setVerticalAlignment(JLabel.TOP);
        surpriseTitle.setHorizontalAlignment(JLabel.CENTER);
        surpriseTitle.setFont(new Font("Monospaced Bold", Font.BOLD, 29));

        moreSurprisePanel.add(surpriseTitle);
        moreSurprisePanel.add(setUpButtonsInSuprisePanel());

        return moreSurprisePanel;
    }

    public JPanel setUpButtonsInSuprisePanel() {
        JPanel surpriseButtonsPanel = new JPanel();
        surpriseButtonsPanel.setLayout(new GridLayout(1,4,0,10));
        surpriseButtonsPanel.setVisible(true);

    
        surpriseButtonsPanel.add(designButtonLabel(startled, "Startled"));
        surpriseButtonsPanel.add(designButtonLabel(amazed, "Amazed"));
        surpriseButtonsPanel.add(designButtonLabel(excited, "Excited"));
        surpriseButtonsPanel.add(designButtonLabel(confused, "Confused"));


        return surpriseButtonsPanel;
    }


    public JButton designButton(JButton button, String buttonName) {
        Icon icon = new ImageIcon("images/" + buttonName + ".PNG");
        button = new JButton(icon);

        button.setVisible(true);
        button.setSize(100, 400);
        return button;

    }
    

} 





