import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

// Instruction page view, page where it tells users information on what to do next
// It is the page where users can see Colonel Lena giving infos.
public class instruction1 {
    
    // frame
    private JFrame frame;
    
    // Labels
    private JLabel label1 = new JLabel();	// main title 
    private JLabel name = new JLabel();	// colonel lena's name label
    private JLabel dial = new JLabel();	// colonel lena's message text.

    // background image
    private ImageIcon background;
    private JLabel myLabel;

    // message panel image
    private ImageIcon dialouge;
    private JLabel dLabel;

    // colonel lena image
    private ImageIcon lena;
    private JLabel lLabel;

    // buttons
    private JButton nextBtn;
    private JButton back;
    private JButton home;

    private Page1 p1;

    public instruction1(Page1 p1) {

        this.p1 = p1;

        // background image
        background = new ImageIcon(this.getClass().getResource("components/background1.png"));
        myLabel = new JLabel(background);
        
        // lena message panel image
        dialouge = new ImageIcon(this.getClass().getResource("components/hud.jpg"));
        dLabel = new JLabel(dialouge);
        dLabel.setBounds(30,25,1300,700);

        // lena's picture
        lena = new ImageIcon(this.getClass().getResource("components/lena.gif"));
        lLabel = new JLabel(lena);
        lLabel.setBounds(160,100,350,300);

        // next button
        nextBtn = new JButton("NEXT");
        nextBtn.setBounds(604,600,90,40);
        nextBtn.setFont(new Font("Arial", Font.BOLD, 20));
        
        // lena's name label
        name = new JLabel("Colonel Lena");
        name.setBounds(185,390,300,70);
        name.setFont(new Font("Arial", Font.ITALIC, 50));
        name.setForeground(Color.WHITE);
        name.setBackground(Color.BLACK);
        name.setOpaque(true);

        // home button
        home = new JButton("HOME");
        home.setBounds(1250,650,80,30);
        home.setFont(new Font("Arial", Font.BOLD, 15));

        // lena's message and infos
        String aa = "Good day soldier, I'm here to inform that you have been assigned ";
        String cc = "to carry out an investigation on our galaxy's quadrants' details. As ";
        String dd = "we know, our main home planet is located at the center of our galaxy known ";
        String ee = "as Epsilon. This galaxy consists of 4 quadrants which are Alpha, Beta, ";
        String ff = "Gamma and Delta quadrants. Each quadrant consists of 10 planets from planet A ";
        String gg = "to planet J. We have a headquarters at every planet A, which is also our home ";
        String hh = "planet at every quadrant. Your main task is to choose a quadrant to ";
        String ii = "scout and explore the area, study the minerals, resources and atmosphere. ";
        String jj = "In the end, report everything to us for research purposes. In order to " ;
        String kk = "carry out your task with ease, our team's top programmers have developed ";
        String ll = "this application for you. This application tells you the details of ";
        String mm = "every quadrant and planets, infos like distance, route, planets' association etc. ";
        String nn = "Besides, this application can also tell you the details on materials' ";
        String oo = "mining through the use of dynamic programming with knapsack algorithm. ";
        String pp = "That is all from me, with that you can proceed to carry out your task.<br>";
        String qq = "Godspeed soldier... ";
        
        dial = new JLabel("<html>" + aa + cc + dd + ee + ff + gg + hh + ii + jj + kk + ll + mm + nn + oo + pp + qq + "</html>");
        dial.setBounds(510,100,600,500);
        dial.setFont(new Font("Arial", Font.PLAIN, 20));
        dial.setForeground(Color.WHITE);

        // back button
        back = new JButton("BACK");
        back.setBounds(1250,710,80,30);
        back.setFont(new Font("Arial", Font.BOLD, 15));
        
        addCompToDLabel(); // add components on the message panel's image. overlapping the blue box
        addCompToMyLabel(); // add the rest of the component on the background image

        frame = new JFrame("Instruction 1");
        frame.add(myLabel);
        frame.setVisible(true);
        frame.setResizable(false); 
        frame.setBounds(30,30,1366,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAllLayout();
    }

    public void setAllLayout(){
		frame.setLayout(new FlowLayout());
	}
    // add components on the message panel's image. overlapping the blue box
    public void addCompToDLabel() {
        dLabel.add(lLabel);
        dLabel.add(nextBtn);
        dLabel.add(name);
        dLabel.add(dial);
    }
    // add the rest of the component on the background image
    public void addCompToMyLabel() { 
        myLabel.add(label1);
        myLabel.add(dLabel);
        myLabel.add(home);
        myLabel.add(back);
    }
    // action listener
    public void addEventAction(ActionListener listenBtn) {
		nextBtn.addActionListener(listenBtn);
        home.addActionListener(listenBtn);
        back.addActionListener(listenBtn);
   	}
    // get next button
    public JButton getNext() {
        return nextBtn;
    }
    // get home button
    public JButton getHome() {
        return home;
    }
    // get back button
    public JButton getBack() {
        return back;
    }
    // get frame 
    public JFrame getFrame() {
        return frame;
    }
    // get older page object
    public Page1 getPage1() {
        return p1;
    }
}