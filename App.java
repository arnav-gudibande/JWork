import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App
{
    JPanel captions;
    JPanel icon;
    JFrame frame;

    public App()
    {}

    public void createLayout()
    {
        frame = new JFrame("Logo Creator");

        //
        captions = new JPanel();
        captions.setLayout(new BorderLayout());

        JLabel captT = new JLabel("Captions", JLabel.CENTER);
        captT.setFont(new Font("Optima", Font.BOLD, 28));

        ////
        JPanel op1 = new JPanel();
        op1.setLayout(new BorderLayout());

        JPanel buttons1 = new JPanel(new FlowLayout());
        buttons1.add(new JButton("B"));
        buttons1.add(new JButton("i"));
        buttons1.add(new JButton("u"));
        buttons1.add(new JButton("Aa"));
        String[] COLORS = { "Red", "Blue", "Orange", "Black", "Green" };
        buttons1.add(new JComboBox(COLORS));

        op1.add(buttons1, BorderLayout.NORTH);

        String[] placement = {"Top", "Bottom", "Left", "Right"};
        
        JPanel text1 = new JPanel(new FlowLayout());
        JButton enter1 = new JButton("Enter");
        JTextField cap1 = new JTextField("Caption 1 goes here");
        JComboBox place1 = new JComboBox(placement);
        
        text1.add(cap1);
        text1.add(place1);
        text1.add(enter1);
        text1.setBorder(BorderFactory.createEmptyBorder(70,70,70,70));
        op1.add(text1, BorderLayout.CENTER);
        
        JPanel text2 = new JPanel(new FlowLayout());
        JButton enter2 = new JButton("Enter");
        JTextField cap2 = new JTextField("Caption 2 goes here");
        JComboBox place2 = new JComboBox(placement);
        text2.add(cap2);
        text2.add(place2);
        text2.add(enter2);
        text2.setBorder(BorderFactory.createEmptyBorder(75,75,75,75));
        op1.add(text2, BorderLayout.SOUTH);

        captions.add(op1, BorderLayout.CENTER);
        captions.add(captT, BorderLayout.NORTH);
        //
        JPanel icons = new JPanel();

        Component newContentPane = new RadIcons();
        icons.add(newContentPane);
        
        JLabel mainT = new JLabel("Logo Creator", JLabel.CENTER);
        mainT.setFont(new Font("Zapfino", Font.BOLD, 40));
        
        frame.add(mainT, BorderLayout.NORTH);
        frame.add(captions, BorderLayout.WEST);
        frame.add(icons, BorderLayout.CENTER);
        frame.setSize(1200,700);
        frame.setVisible(true);
    }

    static class RadIcons extends JPanel implements ActionListener {
        String birdString = "Kasich";
        String catString = "DTrump";
        String dogString = "Bernie";
        String rabbitString = "Cruz";
        String pigString = "Hillary";

        JLabel picture;

        public RadIcons() {
            super(new BorderLayout());

            JRadioButton birdButton = new JRadioButton(birdString);
            birdButton.setActionCommand(birdString);

            JRadioButton catButton = new JRadioButton(catString);
            catButton.setActionCommand(catString);

            JRadioButton dogButton = new JRadioButton(dogString);
            dogButton.setActionCommand(dogString);

            JRadioButton rabbitButton = new JRadioButton(rabbitString);
            rabbitButton.setActionCommand(rabbitString);

            JRadioButton pigButton = new JRadioButton(pigString);
            pigButton.setActionCommand(pigString);

            ButtonGroup group = new ButtonGroup();
            group.add(birdButton);
            group.add(catButton);
            group.add(dogButton);
            group.add(rabbitButton);
            group.add(pigButton);
            

            birdButton.addActionListener(this);
            catButton.addActionListener(this);
            dogButton.addActionListener(this);
            rabbitButton.addActionListener(this);
            pigButton.addActionListener(this);

            picture = new JLabel(createImageIcon("images/"
                    + birdString
                    + ".gif"));

            picture.setPreferredSize(new Dimension(350, 350));
            JPanel radioPanel = new JPanel(new GridLayout(0, 1));
            radioPanel.add(birdButton);
            radioPanel.add(catButton);
            radioPanel.add(dogButton);
            radioPanel.add(rabbitButton);
            radioPanel.add(pigButton);
            radioPanel.setBorder(BorderFactory.createEmptyBorder(75,75,75,75));
            JLabel iconT = new JLabel("Icons", JLabel.CENTER);
            iconT.setFont(new Font("Optima", Font.BOLD, 22));
            JPanel actual = new JPanel();
            actual.add(radioPanel, BorderLayout.CENTER);
            actual.add(iconT, BorderLayout.EAST);
            
            add(actual, BorderLayout.EAST);
            add(picture, BorderLayout.CENTER);
            setBorder(BorderFactory.createEmptyBorder(70,70,70,70));
        }

        public void actionPerformed(ActionEvent e) {
            picture.setIcon(createImageIcon("images/"
                    + e.getActionCommand()
                    + ".gif"));
        }

        public ImageIcon createImageIcon(String path) {
            java.net.URL imgURL = RadIcons.class.getResource(path);
            if (imgURL != null) {
                return new ImageIcon(imgURL);
            } else {
                System.err.println("Couldn't find file: " + path);
                return null;
            }
        }

    }

}

