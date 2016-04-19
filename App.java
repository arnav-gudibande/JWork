import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//3 imports for necessary components

public class App
{
    JPanel captions;//create all neccessary main JPanels and JFrames
    JPanel icon;
    JFrame frame;
    static JLabel Caption1 = new JLabel("Caption 1", JLabel.CENTER);//creating first two Captions, need to be static to be accessed from both methods
    static JLabel Caption2 = new JLabel("Caption 2", JLabel.CENTER);//constructor takes in a name and its orientation
    static String stringcaption1;
    static JPanel dembuttons = new JPanel();//creating the panel that houses my radiobuttons
    String selectedFont = "";
    int defaultsize = 14;//creating all default values for bold, italics, size, et al.
    int b = Font.BOLD;//accessing the constant value BOLD
    int i = Font.ITALIC;
    int val = Font.PLAIN;
    int count =0;
    int count1=0;
    int und=2;
    Color Cr = Color.BLACK;//setting the default color to black

    public void createLayout()
    {
        frame = new JFrame("Logo Creator");//init frame
        GraphicsEnvironment x = GraphicsEnvironment.getLocalGraphicsEnvironment();//retreiving graphics environment using an accessor method
        String[] fonts = x.getAvailableFontFamilyNames();//getting all fonts available and storing to an array of strings
        JColorChooser mainColor = new JColorChooser(Color.BLACK);//the default color is black

        JComboBox Ft = new JComboBox(fonts);//creating the JComboBox to house the fonts (drop down)

        captions = new JPanel();
        captions.setLayout(new BorderLayout());//init the captions panel and setting it to be a borderlayout

        JLabel captT = new JLabel("Captions", JLabel.CENTER);
        captT.setFont(new Font("Optima", Font.BOLD, 28));//creating the captions header, specifiying the size,etc

        JPanel op1 = new JPanel();
        op1.setLayout(new BorderLayout());//init for panel 1 that houses the options

        JCheckBox Underline = new JCheckBox("Underline");
        ButtonGroup ss = new ButtonGroup();//new button group, i dont want the buttons to be clicked at the same time
        JPanel buttons1 = new JPanel(new FlowLayout());
        JCheckBox Bold = new JCheckBox("Bold");//the checkbox for bold
        buttons1.add(Bold);
        ss.add(Bold);//adding the buttons to the buttongroup and to the frame
        JCheckBox Italics = new JCheckBox("Italicize");//the check box for italics
        buttons1.add(Italics);//adding to the frame
        buttons1.add(Underline);
        buttons1.add(Ft);//adding the list of fonts (arranged in Flow Layout)
        ss.add(Italics);


        Ft.addActionListener(new ActionListener() //condensed action listener for when the fonts are selected
            {
                public void actionPerformed(ActionEvent e){
                    selectedFont = Ft.getSelectedItem().toString();//gets the selected font
                    Caption1.setFont(new Font(selectedFont, val, defaultsize));//sets it to be the font for the two captions
                    Caption2.setFont(new Font(selectedFont, val, defaultsize));
                }
            });

        Bold.addActionListener(new ActionListener() //when  bold it selected
            {
                public void actionPerformed(ActionEvent e){
                    Caption1.setFont(new Font(selectedFont, b, defaultsize));//sets the font to bold
                    Caption2.setFont(new Font(selectedFont, b, defaultsize));
                    val = b;//makes sure default changes
                }
            });

        Italics.addActionListener(new ActionListener() //when italics is selected
            {
                public void actionPerformed(ActionEvent e){
                    Caption1.setFont(new Font(selectedFont, i, defaultsize));//sets the font to italics
                    Caption2.setFont(new Font(selectedFont, i, defaultsize));
                    val = i;//changes default
                }
            });

        Underline.addActionListener(new ActionListener() //when the underline option is selected
            {
                public void actionPerformed(ActionEvent e){
                    if (Caption1.getText().contains("<U>")) {
                        Caption1.setText(Caption1.getText().replace("<U>","").replace("</U>",""));//remove the html <U> when the text contains it
                        Caption2.setText(Caption2.getText().replace("<U>","").replace("</U>",""));//uses the gettext to access the text and the replace to change the <U> tags
                    }
                    else {
                        Caption1.setText("<HTML><U>"+Caption1.getText()+"</U></HTML>");//basciallly adds html tags in order to underline the text
                        Caption2.setText("<HTML><U>"+Caption2.getText()+"</U></HTML>");
                    }
                }
            });

        op1.add(buttons1, BorderLayout.NORTH);//adds the row of buttons to the top of the options pane
        String[] placement = new String[24];//creates an array of font sizes, up til 43 ish
        int[] fontsizes = {};
        int num;

        for(int i=0; i<24; i++){//the for loop generates values for the array quickly
            num = i+20;
            placement[i] = Integer.toString(num);//has to convert it to integer
        }

        JPanel text1 = new JPanel(new FlowLayout());//creates a new flowlayout to position buttons from left to right
        JButton enter1 = new JButton("Enter");//sign says enter
        JTextField cap1 = new JTextField("Caption 1 goes here");//init the text field and the placement box
        JComboBox place1 = new JComboBox(placement);

        place1.addActionListener(new ActionListener() //adds the actionlistener to the dropdown holding the font sizes
            {
                public void actionPerformed(ActionEvent e){
                    defaultsize = Integer.parseInt(place1.getSelectedItem().toString());//necessary to parse an object to an int
                    Caption1.setFont(new Font(selectedFont, val, defaultsize));//you can set the size of caption 1 from here
                }
            });

        enter1.addActionListener(new ActionListener() //when the enterbutton is clicked
            {
                public void actionPerformed(ActionEvent e){//OVERRIDES the actionperformed method, 
                    String value = cap1.getText();
                    Caption1.setText(value);//sets the text to whatever the value is
                    Caption1.setForeground(mainColor.getColor());//gets whatever color is selected on the wheel as well
                }
            });

        text1.add(cap1);
        text1.add(place1);//adds the buttons to the text 1 panel
        text1.add(enter1);
        text1.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));//creating a border to wrap around the edges and seperate it

        JPanel text2 = new JPanel(new FlowLayout());//creates new flow layout for left to right (refer to above)
        JButton enter2 = new JButton("Enter");
        JTextField cap2 = new JTextField("Caption 2 goes here");
        JComboBox place2 = new JComboBox(placement);//new jcombobox

        place2.addActionListener(new ActionListener() //when the place2 drop down has a selected item
            {
                public void actionPerformed(ActionEvent e){
                    defaultsize = Integer.parseInt(place2.getSelectedItem().toString());
                    Caption2.setFont(new Font(selectedFont, val, defaultsize));//updates the selected font
                }
            });

        enter2.addActionListener(new ActionListener() //when the enter 2 is clicked
            {
                public void actionPerformed(ActionEvent e){
                    String value = cap2.getText();
                    Caption2.setText(value);//sets color and updates the text value
                    Caption2.setForeground(mainColor.getColor());
                }
            });

        text2.add(cap2);
        text2.add(place2);//adds the place 2 to the text2 frame
        text2.add(enter2);
        text2.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));//creates a default border using BorderFactory
        JPanel grouptext = new JPanel();
        grouptext.add(text1, BorderLayout.NORTH);//adds the text fields into one pane
        grouptext.add(text2, BorderLayout.SOUTH);
        op1.add(grouptext, BorderLayout.CENTER);//adds group text aligned to the left of the frame
        op1.add(mainColor, BorderLayout.SOUTH);
        captions.add(op1, BorderLayout.CENTER);//organization of panes/refactoring
        captions.add(captT, BorderLayout.NORTH);
        JPanel icons = new JPanel();
        Component newContentPane = new RadIcons();//new content pane full of radiobuttons
        icons.add(newContentPane);//adds the content of the pane to the icons
        JLabel mainT = new JLabel("Logo Creator", JLabel.CENTER);
        mainT.setFont(new Font("Zapfino", Font.BOLD, 30));//the title of the project

        frame.add(mainT, BorderLayout.NORTH);//adds the main title frame to the north of the frame
        frame.add(captions, BorderLayout.WEST);//captions to west
        frame.add(icons, BorderLayout.CENTER);//icons to center
        frame.add(dembuttons, BorderLayout.EAST);//dembuttons to the east
        frame.setSize(1350,710);//sets default frame size
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);//closes program upon exit
    }

    static class RadIcons extends JPanel implements ActionListener {//this is the class that deals with image selection, it has to override the actionperformed method and it extends jpanel (inheritance)
        String birdString = "Chech";
        String catString = "DTrump";
        String dogString = "Bernie";
        String rabbitString = "Cruz";
        String pigString = "Hillary";
        String chech = "Kasich";
        String trump = "Trump2";
        String bush = "GBush";
        String Chris = "Chris";
        //sets up the strings that contain the names of each candiate/chech

        JLabel picture;//sets up picture

        public RadIcons() {
            super(new BorderLayout());//calls the superclass constructor of the radIcons JPanel

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

            JRadioButton chechButton = new JRadioButton(chech);
            chechButton.setActionCommand(chech);

            JRadioButton trumpbutton = new JRadioButton(trump);
            trumpbutton.setActionCommand(trump);

            JRadioButton bushbutton = new JRadioButton(bush);
            bushbutton.setActionCommand(bush);
            
            JRadioButton ChrisB = new JRadioButton(Chris);
            ChrisB.setActionCommand(Chris);

            //for every button, it is initialiszed as a radio button and then an actioncommand is added to it
            ButtonGroup group = new ButtonGroup();//create a new buttongroup housing each radiobutton because i want only one image at a time
            group.add(birdButton);
            group.add(catButton);
            group.add(dogButton);
            group.add(rabbitButton);
            group.add(pigButton);
            group.add(chechButton);
            group.add(trumpbutton);
            group.add(bushbutton);
            group.add(ChrisB);

            birdButton.addActionListener(this);//adds a actionlistener to each button
            catButton.addActionListener(this);
            dogButton.addActionListener(this);
            rabbitButton.addActionListener(this);
            pigButton.addActionListener(this);
            chechButton.addActionListener(this);
            trumpbutton.addActionListener(this);
            bushbutton.addActionListener(this);
            ChrisB.addActionListener(this);

            picture = new JLabel(createImageIcon("images/"
                    + birdString
                    + ".gif"));//the images url navigates to the folder images directory, where it selects the corresoponding gif image

            picture.setPreferredSize(new Dimension(350, 350));//can crop the picture if its too large
            JPanel radioPanel = new JPanel(new GridLayout(0, 1));//setup a vertical radiopanel
            radioPanel.add(birdButton);
            radioPanel.add(catButton);
            radioPanel.add(dogButton);
            radioPanel.add(rabbitButton);
            radioPanel.add(pigButton);
            radioPanel.add(chechButton);
            radioPanel.add(trumpbutton);
            radioPanel.add(bushbutton);
            radioPanel.add(ChrisB);
            //adds each button the the radiopanel for better organization
            radioPanel.setBorder(BorderFactory.createEmptyBorder(180,0,75,75));//gives the radiopanel some space, and moves it to the right of the screen 

            JPanel actual = new JPanel();
            actual.add(radioPanel, BorderLayout.CENTER);
            JPanel picap = new JPanel(new BorderLayout());//this is just setting up panels for organization within the frame
            picap.add(picture, BorderLayout.CENTER);

            Caption1.setBorder(BorderFactory.createEmptyBorder(10,10,0,0));//sets the border for each caption, giving it space
            Caption2.setBorder(BorderFactory.createEmptyBorder(10,10,0,0));

            dembuttons.add(radioPanel, BorderLayout.SOUTH);//adds the radiopanel to the south
            add(picap, BorderLayout.WEST);
            add(Caption1, BorderLayout.NORTH);//adds the caption1 to the north
            add(Caption2, BorderLayout.SOUTH);//adds caption2 to the south
            setBorder(BorderFactory.createEmptyBorder(70,70,70,70));//creates padding on all sides
        }

        public void actionPerformed(ActionEvent e) {//when the button is selected, it fetches the image from the specified directory
            picture.setIcon(createImageIcon("images/"
                    + e.getActionCommand()//uses getactioncommand to fetch the specific image name in the directory
                    + ".gif"));
        }

        public ImageIcon createImageIcon(String path) {//if there it cannot find the file, it will return null 
            java.net.URL imgURL = RadIcons.class.getResource(path);
            if (imgURL != null) {
                return new ImageIcon(imgURL);//if it could detect the pathname, then it will return the new image icon
            } else {
                System.err.println("Couldn't find file: " + path);
                return null;//if it couldnot find the file, it returns null
            }
        }

    }

}

