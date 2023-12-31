
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


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

    private JButton back;

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

    private JPanel moreAngerPanel;
    private JButton critical;
    private JButton distant;
    private JButton frustrated;
    private JButton aggressive;
    private JButton mad;
    private JButton hateful;
    private JButton threatened;
    private JButton hurt;

    private JPanel moreSadPanel;
    private JButton guilty;
    private JButton abandoned;
    private JButton despair;
    private JButton depressed;
    private JButton lonely;
    private JButton bored;

    private JPanel moreFearPanel;
    private JButton humiliated;
    private JButton rejected;
    private JButton submissive;
    private JButton insecure;
    private JButton anxious;
    private JButton scared;

    private JPanel moreHappyPanel;
    private JButton joyful;
    private JButton interested;
    private JButton proud;
    private JButton accepted;
    private JButton powerful;
    private JButton peaceful;
    private JButton intimate;
    private JButton optimistic;


    public static void main (String[] args) {
        new EmotionsGUI();

    }

    public EmotionsGUI() {
        profileFrame = new JFrame();
        profileDimension = new Dimension(1000, 600);
        profileFrame.setTitle("EMOTIONAL AWARENESS APP");
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
        //primaryFrame = setTitle("Emotional Awareness: Primary Emotions");
        primaryFrame.setSize(profileDimension.width, profileDimension.height);
        primaryPanel = setUpPrimaryPanel();
        primaryFrame.setVisible(true);
        primaryFrame.setResizable(false);
        primaryFrame.add(primaryPanel);
        primaryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        return primaryFrame;
    }


    public void makeProfileDetails() {
        title = new JLabel("HOW DO YOU FEEL?");
        title.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        message = new JLabel("Attributing specific words to our emotions can help us understand our feelings more clearly, avoid or resolve conflicts better, and move past difficult feelings more easily.");
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
                String enteredUser = user.getText();
                char[] enteredPassword = pw.getPassword();

                if (enteredUser.isEmpty() || enteredPassword.length == 0 ) {
                    JOptionPane.showMessageDialog(null, "Please enter both username and password");
                } else {
                    loadPrimaryFrame();
                }
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
        } else if (buttonName.equals("Confused")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confusedDialog();
            }
        });  
        } else if (buttonName.equals("Amazed")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amazedDialog();
            }
        });  
        } else if (buttonName.equals("Excited")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excitedDialog();
            }
        });  
        } else if (buttonName.equals("Disapproval")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disapprovalDialog();
            }
        });  
        } else if (buttonName.equals("Disappointed")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disappointedDialog();
            }
        });  
        } else if (buttonName.equals("Awful")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                awfulDialog();
            }
        });  
        } else if (buttonName.equals("Avoidance")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avoidanceDialog();
            }
        });  
        }
        else if (buttonName.equals("Distant")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                distantDialog();
            }
        });
        }  
        else if (buttonName.equals("Frustrated")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frustratedDialog();
            }
        });
        } 
        else if (buttonName.equals("Aggressive")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aggressiveDialog();
            }
        });
        } 
        else if (buttonName.equals("Mad")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                madDialog();
            }
        });
        } 
        else if (buttonName.equals("Hateful")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hatefulDialog();
            }
        });
        } 
        else if (buttonName.equals("Threatened")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                threatenedDialog();
            }
        });
        } 
        else if (buttonName.equals("Hurt")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hurtDialog();
            }
        });
        } 
        else if (buttonName.equals("Guilty")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiltyDialog();
            }
        });
        } 
        else if (buttonName.equals("Abandoned")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abandonedDialog();
            }
        });
        } 
        else if (buttonName.equals("Despair")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                despairDialog();
            }
        });
        } 
        else if (buttonName.equals("Depressed")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depressedDialog();
            }
        });
        } 
        else if (buttonName.equals("Lonely")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lonelyDialog();
            }
        });
        } 
        else if (buttonName.equals("Bored")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boredDialog();
            }
        });
        } 
        else if (buttonName.equals("Humiliated")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                humiliatedDialog();
            }
        });
        } 
        else if (buttonName.equals("Rejected")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rejectedDialog();
            }
        });
        } 
        else if (buttonName.equals("Submissive")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submissiveDialog();
            }
        });
        } 
        else if (buttonName.equals("Insecure")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insecureDialog();
            }
        });
        } 
        else if (buttonName.equals("Anxious")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anxiousDialog();
            }
        });
        } 
        else if (buttonName.equals("Scared")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scaredDialog();
            }
        });
        } 
        else if (buttonName.equals("Joyful")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                joyfulDialog();
            }
        });
        } 
        else if (buttonName.equals("Interested")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interestedDialog();
            }
        });
        } 
        else if (buttonName.equals("Proud")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proudDialog();
            }
        });
        } 

        else if (buttonName.equals("Accepted")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acceptedDialog();
            }
        });
        } 
        else if (buttonName.equals("Powerful")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                powerfulDialog();
            }
        });
        } 
        else if (buttonName.equals("Peaceful")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                peacefulDialog();
            }
        });
        } 
        else if (buttonName.equals("Intimate")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                intimateDialog();
            }
        });
        } 
        else if (buttonName.equals("Optimistic")) {
            button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optimisticDialog();
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

    public void confusedDialog() {
        JFrame confusedDialogFrame = new JFrame("Message!");
        confusedDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(confusedDialogFrame, "Take a moment and be present.", null, JOptionPane.INFORMATION_MESSAGE);
    }

    public void amazedDialog() {
        JFrame amazedDialogFrame = new JFrame("Message!");
        amazedDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(amazedDialogFrame, "Take a second, and keep on kicking on.", null, JOptionPane.INFORMATION_MESSAGE);
    }

    public void scaredDialog() {
        JFrame amazedDialogFrame = new JFrame("Message!");
        amazedDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(amazedDialogFrame, "Take a second, and reflect.", null, JOptionPane.INFORMATION_MESSAGE);
    }

    public void excitedDialog() {
        JFrame excitedDialogFrame = new JFrame("Message!");
        excitedDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(excitedDialogFrame, "WOW! I am excited for you!", null, JOptionPane.INFORMATION_MESSAGE);
    }

    public void disapprovalDialog() {
        JFrame disapprovalDialogFrame = new JFrame("Message!");
        disapprovalDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(disapprovalDialogFrame, "That must have been tough, keep your head high.", null, JOptionPane.INFORMATION_MESSAGE);

    }

    public void disappointedDialog() {
        JFrame disappointedDialogFrame = new JFrame("Message!");
        disappointedDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(disappointedDialogFrame, "I am sorry to hear that, it will get better soon, I promise!", null, JOptionPane.INFORMATION_MESSAGE);

    }

    public void awfulDialog() {
        JFrame awfulDialogFrame = new JFrame("Message!");
        awfulDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(awfulDialogFrame, "Take a moment to reflect and grow from this experience.", null, JOptionPane.INFORMATION_MESSAGE);

    }

    public void criticalDialog() {
        JFrame criticalDialogFrame = new JFrame("Message!");
        criticalDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(criticalDialogFrame, "Relax, take a breather. I am proud of you!", null, JOptionPane.INFORMATION_MESSAGE);

    }


    public void distantDialog() {
        JFrame distantDialogFrame = new JFrame("Message!");
        distantDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(distantDialogFrame, "Practice some meditation.", null, JOptionPane.INFORMATION_MESSAGE);

    }


    public void frustratedDialog() {
        JFrame frustratedDialogFrame = new JFrame("Message!");
        frustratedDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(frustratedDialogFrame, "Go for a walk and come back to your task.", null, JOptionPane.INFORMATION_MESSAGE);

    }


    public void aggressiveDialog() {
        JFrame aggressiveDialogFrame = new JFrame("Message!");
        aggressiveDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(aggressiveDialogFrame, "Stop and take a moment to reflect.", null, JOptionPane.INFORMATION_MESSAGE);

    }


    public void madDialog() {
        JFrame madDialogFrame = new JFrame("Message!");
        madDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(madDialogFrame, "Stop and reflect.", null, JOptionPane.INFORMATION_MESSAGE);

    }

    public void hatefulDialog() {
        JFrame hatefulDialogFrame = new JFrame("Message!");
        hatefulDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(hatefulDialogFrame, "Step away from the situation and come back when you feel ready.", null, JOptionPane.INFORMATION_MESSAGE);

    }


    public void threatenedDialog() {
        JFrame threatenedDialogFrame = new JFrame("Message!");
        threatenedDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(threatenedDialogFrame, "Reflect on the situation and assess different perspectives.", null, JOptionPane.INFORMATION_MESSAGE);

    }


    public void hurtDialog() {
        JFrame hurtDialogFrame = new JFrame("Message!");
        hurtDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(hurtDialogFrame, "Step away and come back after taking a moment to yourself.", null, JOptionPane.INFORMATION_MESSAGE);

    }

    public void avoidanceDialog() {
        JFrame avoidanceDialogFrame = new JFrame("Message!");
        avoidanceDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(avoidanceDialogFrame, "face your fears with your head held high!", null, JOptionPane.INFORMATION_MESSAGE);

    }

    public void guiltyDialog() {
        JFrame guiltyDialogFrame = new JFrame("Message!");
        guiltyDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(guiltyDialogFrame, "Reach out to those you may have negatively affected.", null, JOptionPane.INFORMATION_MESSAGE);

    }


    public void abandonedDialog() {
        JFrame abandonedDialogFrame = new JFrame("Message!");
        abandonedDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(abandonedDialogFrame, "I'm sorry to hear that, reflect on the situation and understand sometimes things are out of our control.", null, JOptionPane.INFORMATION_MESSAGE);

    }

    public void despairDialog() {
        JFrame despairDialogFrame = new JFrame("Message!");
        despairDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(despairDialogFrame, "Reach out to someone you trust.", null, JOptionPane.INFORMATION_MESSAGE);

    }

    public void depressedDialog() {
        JFrame depressedDialogFrame = new JFrame("Message!");
        depressedDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(depressedDialogFrame, "Reach out to someone you trust as soon as you can.", null, JOptionPane.INFORMATION_MESSAGE);

    }

    public void lonelyDialog() {
        JFrame lonelyDialogFrame = new JFrame("Message!");
        lonelyDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(lonelyDialogFrame, "Reach out to someone you trust as soon as you can.", null, JOptionPane.INFORMATION_MESSAGE);

    }


    public void humiliatedDialog() {
        JFrame humiliatedDialogFrame = new JFrame("Message!");
        humiliatedDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(humiliatedDialogFrame, "Don't worry, sleep it off", null, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void boredDialog() {
        JFrame boredDialogFrame = new JFrame("Message!");
        boredDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(boredDialogFrame, "Start a new hobby!", null, JOptionPane.INFORMATION_MESSAGE);
 
 
    }
 
    public void rejectedDialog() {
        JFrame rejectedDialogFrame = new JFrame("Message!");
        rejectedDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(rejectedDialogFrame, "There are plenty of fish in the sea", null, JOptionPane.INFORMATION_MESSAGE);
    }
 
 
    public void submissiveDialog() {
        JFrame submissivedDialogFrame = new JFrame("Message!");
        submissivedDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(submissivedDialogFrame, "Take a deep breath, maybe a few deep breaths", null, JOptionPane.INFORMATION_MESSAGE);
    }
 
 
    public void insecureDialog() {
        JFrame insecureDialogFrame = new JFrame("Message!");
        insecureDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(insecureDialogFrame, "Your feelings are valid, everyone is unique in their own way", null, JOptionPane.INFORMATION_MESSAGE);
    }
 
 
    public void anxiousDialog() {
        JFrame anxiousDialogFrame = new JFrame("Message!");
        anxiousDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(anxiousDialogFrame, "Take a breather and walk it off", null, JOptionPane.INFORMATION_MESSAGE);
    }
 
 
    public void joyfulDialog() {
        JFrame scaredDialogFrame = new JFrame("Message!");
        scaredDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(scaredDialogFrame, "That is so great!", null, JOptionPane.INFORMATION_MESSAGE);
 
    }

    public void interestedDialog() {
        JFrame scaredDialogFrame = new JFrame("Message!");
        scaredDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(scaredDialogFrame, "Keep on going!", null, JOptionPane.INFORMATION_MESSAGE);
 
    }

    public void proudDialog() {
        JFrame scaredDialogFrame = new JFrame("Message!");
        scaredDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(scaredDialogFrame, "You should be very proud!", null, JOptionPane.INFORMATION_MESSAGE);
 
    }

    public void acceptedDialog() {
        JFrame scaredDialogFrame = new JFrame("Message!");
        scaredDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(scaredDialogFrame, "Yes, you are on the right path!", null, JOptionPane.INFORMATION_MESSAGE);
 
    }

    public void powerfulDialog() {
        JFrame scaredDialogFrame = new JFrame("Message!");
        scaredDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(scaredDialogFrame, "YAY I am happy for you!", null, JOptionPane.INFORMATION_MESSAGE);
 
    }

    public void peacefulDialog() {
        JFrame scaredDialogFrame = new JFrame("Message!");
        scaredDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(scaredDialogFrame, "Keep on going!", null, JOptionPane.INFORMATION_MESSAGE);
 
    }

    public void intimateDialog() {
        JFrame scaredDialogFrame = new JFrame("Message!");
        scaredDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(scaredDialogFrame, "I'm glad!", null, JOptionPane.INFORMATION_MESSAGE);
 
    }

    public void optimisticDialog() {
        JFrame scaredDialogFrame = new JFrame("Message!");
        scaredDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(scaredDialogFrame, "YAY I am happy for you!", null, JOptionPane.INFORMATION_MESSAGE);
 
    }
 


    public JFrame sadFrame() {
        JFrame sadFrame = new JFrame();
        sadFrame.setSize(1000,600);
        sadFrame.setTitle("More Sad Emotions :(");

        setUpSadPanel();
        sadFrame.add(moreSadPanel);
        sadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sadFrame.setVisible(true);

        return sadFrame;
    }

    public JPanel setUpSadPanel() {
        moreSadPanel = new JPanel();
        moreSadPanel.setLayout(new GridLayout(2,0,-200,-100));
        moreSadPanel.setBorder(BorderFactory.createEmptyBorder(100,50,50,50));
        moreSadPanel.setVisible(true);

        JLabel sadTitle = new JLabel("Getting a little more specific, I am feeling...");
        sadTitle.setVerticalAlignment(JLabel.TOP);
        sadTitle.setHorizontalAlignment(JLabel.CENTER);
        sadTitle.setFont(new Font("Monospaced Bold", Font.BOLD, 29));

        moreSadPanel.add(sadTitle);
        moreSadPanel.add(setUpButtonsInSadPanel());

        return moreSadPanel;
    }

    public JPanel setUpButtonsInSadPanel() {
        JPanel sadButtonsPanel = new JPanel();
        sadButtonsPanel.setLayout(new GridLayout(1,4,0,10));
        sadButtonsPanel.setVisible(true);

    
        sadButtonsPanel.add(designButtonLabel(guilty, "Guilty"));
        sadButtonsPanel.add(designButtonLabel(abandoned, "Abandoned"));
        sadButtonsPanel.add(designButtonLabel(despair, "Despair"));
        sadButtonsPanel.add(designButtonLabel(depressed, "Depressed"));
        sadButtonsPanel.add(designButtonLabel(lonely, "Lonely"));
        sadButtonsPanel.add(designButtonLabel(bored, "Bored"));


        return sadButtonsPanel;
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

    public JFrame happyFrame() {
        JFrame happyFrame = new JFrame();
        happyFrame.setSize(1000,600);
        happyFrame.setTitle("More Happy Emotions!");
 
 
        setUpMoreHappyPanel();
        happyFrame.add(moreHappyPanel);
        happyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        happyFrame.setVisible(true);
 
 
        return happyFrame;
    }
 
 
    public JPanel setUpMoreHappyPanel() {
        moreHappyPanel = new JPanel();
        moreHappyPanel.setLayout(new GridLayout(2,0,-200,-100));
        moreHappyPanel.setBorder(BorderFactory.createEmptyBorder(100,50,50,50));
        moreHappyPanel.setVisible(true);
 
 
        JLabel happyTitle = new JLabel("Getting a little more specific, I am feeling...");
        happyTitle.setVerticalAlignment(JLabel.TOP);
        happyTitle.setHorizontalAlignment(JLabel.CENTER);
        happyTitle.setFont(new Font("Monospaced Bold", Font.BOLD, 29));
 
 
        moreHappyPanel.add(happyTitle);
        moreHappyPanel.add(setUpButtonsInHappyPanel());
 
 
 
 
        return moreHappyPanel;
    }
 
 
    public JPanel setUpButtonsInHappyPanel() {
        JPanel happyButtonsPanel = new JPanel();
        happyButtonsPanel.setLayout(new GridLayout(2,4,0,10));
        happyButtonsPanel.setVisible(true);
 
 
        happyButtonsPanel.add(designButtonLabel(joyful, "Joyful"));
        happyButtonsPanel.add(designButtonLabel(interested, "Interested"));
        happyButtonsPanel.add(designButtonLabel(proud, "Proud"));
        happyButtonsPanel.add(designButtonLabel(accepted, "Accepted"));
        happyButtonsPanel.add(designButtonLabel(powerful, "Powerful"));
        happyButtonsPanel.add(designButtonLabel(peaceful, "Peaceful"));
        happyButtonsPanel.add(designButtonLabel(intimate, "Intimate"));
        happyButtonsPanel.add(designButtonLabel(optimistic, "Optimistic"));
 
 
        return happyButtonsPanel;
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
        angerFrame.setTitle("More Anger Emotions!");

        setUpMoreAngerPanel();
        angerFrame.add(moreAngerPanel);
        angerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        angerFrame.setVisible(true);

        return angerFrame;
    }



     public JPanel setUpMoreAngerPanel() {
        moreAngerPanel = new JPanel();
        moreAngerPanel.setLayout(new GridLayout(2,0,-200,-100));
        moreAngerPanel.setBorder(BorderFactory.createEmptyBorder(100,50,50,50));
        moreAngerPanel.setVisible(true);

        JLabel angerTitle = new JLabel("Getting a little more specific, I am feeling...");
        angerTitle.setVerticalAlignment(JLabel.TOP);
        angerTitle.setHorizontalAlignment(JLabel.CENTER);
        angerTitle.setFont(new Font("Monospaced Bold", Font.BOLD, 29));

        moreAngerPanel.add(angerTitle);
        moreAngerPanel.add(setUpButtonsInMoreAngerPanel());

        return moreDisgustPanel;
    }


    public JPanel setUpButtonsInMoreAngerPanel() {
        JPanel angerButtonsPanel = new JPanel();
        angerButtonsPanel.setLayout(new GridLayout(2,4,0,10));
        angerButtonsPanel.setVisible(true);

    
        angerButtonsPanel.add(designButtonLabel(critical, "Critical"));
        angerButtonsPanel.add(designButtonLabel(distant, "Distant"));
        angerButtonsPanel.add(designButtonLabel(frustrated, "Frustrated"));
        angerButtonsPanel.add(designButtonLabel(aggressive, "Aggressive"));
        angerButtonsPanel.add(designButtonLabel(mad, "Mad"));
        angerButtonsPanel.add(designButtonLabel(hateful, "Hateful"));
        angerButtonsPanel.add(designButtonLabel(threatened, "Threatened"));
        angerButtonsPanel.add(designButtonLabel(hurt, "Hurt"));


        return angerButtonsPanel;
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

    public JFrame fearFrame() {
        JFrame fearFrame = new JFrame();
        fearFrame.setSize(1000,600);
        fearFrame.setTitle("More Fearful Emotions!");
 
 
        setUpMoreFearPanel();
        fearFrame.add(moreFearPanel);
        fearFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fearFrame.setVisible(true);
 
 
        return fearFrame;
    }
 
 
    public JPanel setUpMoreFearPanel() {
        moreFearPanel = new JPanel();
        moreFearPanel.setLayout(new GridLayout(2,0,-200,-100));
        moreFearPanel.setBorder(BorderFactory.createEmptyBorder(100,50,50,50));
        moreFearPanel.setVisible(true);
 
 
        JLabel fearTitle = new JLabel("Getting a little more specific, I am feeling...");
        fearTitle.setVerticalAlignment(JLabel.TOP);
        fearTitle.setHorizontalAlignment(JLabel.CENTER);
        fearTitle.setFont(new Font("Monospaced Bold", Font.BOLD, 29));
 
 
        moreFearPanel.add(fearTitle);
        moreFearPanel.add(setUpButtonsInFearPanel());
 
 
        return moreFearPanel;
    }
 
 
    public JPanel setUpButtonsInFearPanel() {
        JPanel fearButtonsPanel = new JPanel();
        fearButtonsPanel.setLayout(new GridLayout(2,4,0,10));
        fearButtonsPanel.setVisible(true);
 
 
        fearButtonsPanel.add(designButtonLabel(humiliated, "Humiliated"));
        fearButtonsPanel.add(designButtonLabel(rejected, "Rejected"));
        fearButtonsPanel.add(designButtonLabel(submissive, "Submissive"));
        fearButtonsPanel.add(designButtonLabel(insecure, "Insecure"));
        fearButtonsPanel.add(designButtonLabel(anxious, "Anxious"));
        fearButtonsPanel.add(designButtonLabel(scared, "Scared"));
 
 
        return fearButtonsPanel;
    }
 



    

} 







