import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

// Page 2 class view 
public class Page2 {

    private JFrame frame; // frame
    
    private JLabel label1 = new JLabel();// main title

    // background image 
    private ImageIcon background;
    private JLabel myLabel;
    // alpha map image
    private ImageIcon alpha;
    private JLabel aLabel;
    // beta map image
    private ImageIcon beta;
    private JLabel bLabel;
    // delta map image
    private ImageIcon delta;
    private JLabel dLabel;
    // gamma map image
    private ImageIcon gamma;
    private JLabel gLabel;
    // quadrants selections button 
    private JButton aButton;
    private JButton bButton;
    private JButton gButton;
    private JButton dButton;
    // back and home button
    private JButton back;
    private JButton home;
    // previous pages
    private instruction1 inst;
    private Page1 p1;

    public Page2(instruction1 inst, Page1 p1) {

        this.inst = inst;
        this.p1 = p1;

        // background image
        background = new ImageIcon(this.getClass().getResource("components/background1.png"));
        myLabel = new JLabel(background);

        // main title label
        label1 = new JLabel("CHOOSE A QUADRANT");
        label1.setBounds(330,50,1000,70);
        label1.setFont(new Font("Arial", Font.BOLD, 65));
        label1.setForeground(Color.WHITE);

        // alpha quadrant image
        alpha = new ImageIcon(this.getClass().getResource("components/alpha1.png"));
        aLabel = new JLabel(alpha);
        aLabel.setBounds(380,110,300,300);
        // beta quadrant image
        beta = new ImageIcon(this.getClass().getResource("components/beta1.png"));
        bLabel = new JLabel(beta);
        bLabel.setBounds(730,110,300,300);
        // delta quadrant image
        delta = new ImageIcon(this.getClass().getResource("components/delta1.png"));
        dLabel = new JLabel(delta);
        dLabel.setBounds(380,420,300,300);
        // gamma quadrant image
        gamma = new ImageIcon(this.getClass().getResource("components/gamma1.png"));
        gLabel = new JLabel(gamma);
        gLabel.setBounds(730,420,300,300);

        // alpha quad button
        aButton = new JButton("Alpha Quadrant");
        aButton.setBounds(460,400,150,30);
        aButton.setFont(new Font("Arial", Font.BOLD, 15));
        // beta quad button
        bButton = new JButton("Beta Quadrant");
        bButton.setBounds(810,400,150,30);
        bButton.setFont(new Font("Arial", Font.BOLD, 15));
        // gamma quad button
        gButton = new JButton("Gamma Quadrant");
        gButton.setBounds(790,710,180,30);
        gButton.setFont(new Font("Arial", Font.BOLD, 15));
        // delta quad button
        dButton = new JButton("Delta Quadrant");
        dButton.setBounds(445,710,180,30);
        dButton.setFont(new Font("Arial", Font.BOLD, 15));
        // Home button
        home = new JButton("HOME");
        home.setBounds(1250,650,80,30);
        home.setFont(new Font("Arial", Font.BOLD, 15));
        // back button
        back = new JButton("BACK");
        back.setBounds(1250,710,80,30);
        back.setFont(new Font("Arial", Font.BOLD, 15));

        addCompToMyLabel(); // add all components on background image
        // frame components
        frame = new JFrame("Quadrant Option");
        frame.add(myLabel);
        frame.setVisible(true);
        frame.setResizable(false); 
        frame.setBounds(30,30,1366,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAllLayout();
        
	}
    public Page1 getPage1() { // get first page object
        return p1;
    }
    public instruction1 getInst() { // get previous page object
        return inst;
    }
    public void setAllLayout(){ // set layout
		frame.setLayout(new FlowLayout());
	}

    public JFrame getFrame() { // get current frame
		return frame;
	}

    public JButton getAlpha() { // get alpha button
        return aButton;
    }

    public JButton getBeta() { // get beta button
        return bButton;
    }
    
    public JButton getGamma() { // get gamma button
        return gButton;
    }
    
    public JButton getDelta() { // get delta button
        return dButton;
    }

    public JButton getHome() { // get home button
        return home;
    }

    public JButton getBack() { // get back button
        return back;
    }
    
    public void addCompToMyLabel() {  // add all the components on background image
        myLabel.add(label1);
        myLabel.add(aLabel);
        myLabel.add(bLabel);
        myLabel.add(dLabel);
        myLabel.add(gLabel);
        myLabel.add(aButton);
        myLabel.add(bButton);
        myLabel.add(gButton);
        myLabel.add(dButton);
        myLabel.add(home);
        myLabel.add(back);
    }
    
    public void addEventAction(ActionListener listenBtn) { // action listener
		aButton.addActionListener(listenBtn);
		bButton.addActionListener(listenBtn);
        dButton.addActionListener(listenBtn);
        gButton.addActionListener(listenBtn);
        home.addActionListener(listenBtn);
        back.addActionListener(listenBtn);
   	}
}
