import javax.swing.*;
import java.awt.*;

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

        JPanel title = new JPanel();
        title.add(new JLabel("Captions"));

        ////
        JPanel op1 = new JPanel();
        op1.setLayout(new BorderLayout());
        
        JPanel buttons1 = new JPanel(new FlowLayout());
        buttons1.add(new JButton("B"));
        buttons1.add(new JButton("i"));
        buttons1.add(new JButton("u"));
        buttons1.add(new JButton("Aa"));
        buttons1.add(new JButton("Colors"));
        //
        
        op1.add(buttons1, BorderLayout.NORTH);
        
        JPanel text1 = new JPanel(new FlowLayout());
        JButton enter1 = new JButton("Enter");
        JTextField cap1 = new JTextField("Caption 1 goes here");
        text1.add(cap1);
        text1.add(enter1);
        
        op1.add(text1, BorderLayout.CENTER);
        ////

        ////
        JPanel op2 = new JPanel();
        op2.setLayout(new BorderLayout());
        op2.add(new JLabel("Option 2"), BorderLayout.NORTH);
        op2.add(new JButton("Orange"), BorderLayout.CENTER);
        op2.add(new JButton("Green"), BorderLayout.SOUTH);
        ////

        captions.add(op1, BorderLayout.NORTH);
        captions.add(title, BorderLayout.CENTER);
        captions.add(op2, BorderLayout.SOUTH);
        //
        
        
        frame.add(captions, BorderLayout.WEST);
        frame.setSize(1500,800);
        frame.setVisible(true);
    }

}
