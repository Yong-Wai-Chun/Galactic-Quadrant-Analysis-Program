import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Image;
import java.io.*;

// Page 1 class view.
public class Page1 {

    // Frame
    private JFrame frame;

    // Label for main title
    private JLabel label1 = new JLabel();	
    private JLabel label2 = new JLabel();

    // Background image
    private ImageIcon background;
    private JLabel myLabel;

    // Button for start, help and exit
    private JButton start;
    private JButton help;
    private JButton exit;

	public Page1() {

        // background image
        background = new ImageIcon(this.getClass().getResource("components/background1.png"));
        myLabel = new JLabel(background);

        // Main title component (label1 and label2)
        label1 = new JLabel("GALACTIC QUADRANT ANALYSIS");
        label1.setBounds(145,180,1200,70);
        label1.setFont(new Font("Arial", Font.BOLD, 65));
        label1.setForeground(Color.WHITE);

        label2 =  new JLabel("PROGRAM");
        label2.setBounds(500,250,500,70);
        label2.setFont(new Font("Arial", Font.BOLD, 65));
        label2.setForeground(Color.WHITE);

        // Buttons components
        start =  new JButton("START");
        start.setBounds(625,400,100,50);
        start.setFont(new Font("Arial", Font.BOLD, 20));

        help =  new JButton("HELP");
        help.setBounds(625,500,100,50);
        help.setFont(new Font("Arial", Font.BOLD, 20));

        exit =  new JButton("EXIT");
        exit.setBounds(625,600,100,50);
        exit.setFont(new Font("Arial", Font.BOLD, 20));
        
        // Add all the component to the background image, overlapping background image
        addCompToMyLabel();
        
        // All frame component's setting and adjustment
        frame = new JFrame("Homepage");
        frame.add(myLabel);
        frame.setVisible(true);
        frame.setResizable(false); 
        frame.setBounds(30,30,1366,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	

        // Set frame layout
        setAllLayout();
        
	}
    
    public void setAllLayout(){
		frame.setLayout(new FlowLayout());
	}

    // get frame
    public JFrame getFrame() {
		return frame;
	}

    // get start button
    public JButton getStartButton() {
        return start;
    }

    // get help button 
    public JButton getHelpButton() {
        return help;
    }

    // get exit button
    public JButton getExitButton() {
        return exit;
    }

    // add component to background image
    public void addCompToMyLabel() {         
        myLabel.add(label1);
        myLabel.add(label2);
        myLabel.add(start);
        myLabel.add(help);
        myLabel.add(exit);
    }

    // action even listener 
	public void addEventAction(ActionListener listenBtn) {
		start.addActionListener(listenBtn);
		help.addActionListener(listenBtn);
        exit.addActionListener(listenBtn);
   	}

}

