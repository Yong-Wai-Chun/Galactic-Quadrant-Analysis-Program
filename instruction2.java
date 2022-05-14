import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class instruction2 {
    
    private JFrame frame; // frame
    
    private JLabel label1 = new JLabel();	 // main title
    private JLabel name = new JLabel();	// lena's name label
    private JLabel dial = new JLabel();	// lena's message labels
    // background image
    private ImageIcon background; 
    private JLabel myLabel;
    // message panel back image
    private ImageIcon dialouge;
    private JLabel dLabel;
    // lena image
    private ImageIcon lena;
    private JLabel lLabel;
    // buttons
    private JButton nextBtn;
    private JButton back;
    private JButton home;
    // previous pages
    private Page1 p1;
    private programOption pO;
    private int option;

    public instruction2(Page1 p1, programOption pO, int option) {

        this.p1 = p1;
        this.pO = pO;
        this.option = option;
        // background image
        background = new ImageIcon(this.getClass().getResource("components/background1.png"));
        myLabel = new JLabel(background);
        // lena message panel box image
        dialouge = new ImageIcon(this.getClass().getResource("components/hud.jpg"));
        dLabel = new JLabel(dialouge);
        dLabel.setBounds(30,25,1300,700);
        // lena image gif
        lena = new ImageIcon(this.getClass().getResource("components/lena.gif"));
        lLabel = new JLabel(lena);
        lLabel.setBounds(160,100,350,300);
        // lena name label
        name = new JLabel("Colonel Lena");
        name.setBounds(185,390,300,70);
        name.setFont(new Font("Arial", Font.ITALIC, 50));
        name.setForeground(Color.WHITE);
        name.setBackground(Color.BLACK);
        name.setOpaque(true);
        // next button
        nextBtn = new JButton("NEXT");
        nextBtn.setBounds(604,600,90,40);
        nextBtn.setFont(new Font("Arial", Font.BOLD, 20));
        // home button
        home = new JButton("HOME");
        home.setBounds(1250,650,80,30);
        home.setFont(new Font("Arial", Font.BOLD, 15));
        // back button
        back = new JButton("BACK");
        back.setBounds(1250,710,80,30);
        back.setFont(new Font("Arial", Font.BOLD, 15));

        if (option == 0) { // if displaysort is chosen
            String aa = "In this section, it mainly tells you the overall quadrant's  ";
            String cc = "details and its planets' association through the visualization ";
            String dd = "of adjacency list and adjacency matrix. Besides, a list of edges  ";
            String ee = "are displayed in ascending order of distance and a list of planets ";
            String ff = "are displayed in descending order of profit value. ";
            
            dial = new JLabel("<html>" + aa + cc + dd + ee + ff + "</html>");
            dial.setBounds(510,90,600,300);
            dial.setFont(new Font("Arial", Font.PLAIN, 20));
            dial.setForeground(Color.WHITE);
        } else if (option == 1) { // if dynamicprog is chosen
            String aa = "In this section, it mainly tells you the details of optimum ";
            String cc = "planets that you have to visit in order to mine and collect ";
            String dd = "their minerals / materials given your spaceship has limited ";
            String ee = "capacity of 80 tons. Every planet materials have their designated ";
            String ff = "weight and profit. So with the limited capacity, this program ";
            String gg = "will show you what planets that you should visit in order to ";
            String hh = "collect the optimum materials with the optimum profit. The ";
            String ii = "total weight should not be more than 80 tons. Assume that if you ";
            String jj = "reach a planet, you have to take all the materials/minerals ";
            String kk = "and you have to visit all the planets without returning to ";
            String ll = "your home planet, Planet A. ";
            
            dial = new JLabel("<html>" + aa + cc + dd + ee + ff + gg + hh + ii + jj + kk + ll +"</html>");
            dial.setBounds(510,130,600,300);
            dial.setFont(new Font("Arial", Font.PLAIN, 20));
            dial.setForeground(Color.WHITE);

        } else if (option == 2) { // if short is chosen
            String aa = "In this section, it mainly tells you every planet's shortest path ";
            String cc = "from Planet A. Study the information given carefully and it will  ";
            String dd = "guide you with the best and optimum path to every planet. ";
            
            dial = new JLabel("<html>" + aa + cc + dd + "</html>");
            dial.setBounds(510,130,600,300);
            dial.setFont(new Font("Arial", Font.PLAIN, 20));
            dial.setForeground(Color.WHITE);
        }

        addCompToDLabel(); // add all components on lena message panel box image
        addCompToMyLabel(); // add the rest of the components on the background image

        frame = new JFrame("Instruction 2");
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
    public void addCompToDLabel() { // add all components on lena message panel box image
        dLabel.add(lLabel);
        dLabel.add(nextBtn);
        dLabel.add(name);
        dLabel.add(dial);
    }

    public void addCompToMyLabel() {  // add the rest of the components on the background image
        myLabel.add(label1);
        myLabel.add(dLabel);
        myLabel.add(home);
        myLabel.add(back);
    }
    
    public void addEventAction(ActionListener listenBtn) { // action listener
		nextBtn.addActionListener(listenBtn);
        home.addActionListener(listenBtn);
        back.addActionListener(listenBtn);
   	}

    public int getOption() { // get option
        return option;
    }

    public JButton getNext() { // get next button
        return nextBtn;
    }

    public JButton getHome() { // get home button
        return home;
    }

    public JButton getBack() { // get back button
        return back;
    }

    public JFrame getFrame() { // get current frame
        return frame;
    }

    public Page1 getPage1() { // get first page object
        return p1;
    }
    public programOption getPO() { // get previous page object
        return pO;
    }
}