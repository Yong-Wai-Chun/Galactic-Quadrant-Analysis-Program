import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Image;
import java.io.*;

// Page 1 class view.
public class Help {

    // Frame
    private JFrame frame;

    // Label for main title
    private JLabel label1 = new JLabel();	
    private JLabel label2 = new JLabel();
    
    // scrollable pane
    private JScrollPane pane1;
    
    // Background image
    private ImageIcon background;
    private JLabel myLabel;

    // Button for start, help and exit
    private JButton home;

    private Page1 p1;

	public Help(Page1 p1) {

        this.p1 = p1;

        // background image
        background = new ImageIcon(this.getClass().getResource("components/background1.png"));
        myLabel = new JLabel(background);

        // Main title component (label1 and label2)
        label1 = new JLabel("GENERAL INSTRUCTION");
        label1.setBounds(320,90,1200,70);
        label1.setFont(new Font("Arial", Font.BOLD, 65));
        label1.setForeground(Color.WHITE);

        String aa = "INSTRUCTION <br>";
        String bb = "!!! PLEASE MAKE SURE ALL THE FILES AND FOLDERS INCLUDING THE COMPONENTS FOLDER ARE INCLUDED IN THE SAME DIRECTORY !!!<br>";
        String cc = "1. Run only the Main.java file.<br>";
        String dd = "2. Please make sure all the other java files and the 'components' folder are in the same directory.<br>";
        String ee = "3. The first page has 3 buttons which are start, help and exit. <br>";
        String ff = "____a. Start will bring user to the next page.<br>";            
        String gg = "____b. Help will give user instructions.<br>";
        String hh = "____c. Exit will quit the whole program.<br>";
        String ii = "4. After pressing the start button, it will bring user to the next page where user can see some instruction on what to do. Then press next.<br>";
        String jj = "5. After that, the next page is where user choose one quadrant out of 4. (Alpha,Beta,Gamma and Delta)<br>";
        String kk = "6. After choosing a quadrant, the next page user can see the details of the planets, the quadrant map and the home planet's(Planet A) appearance. In addition, user will have 4 options:<br>";
        String ll = "____a. Randomize - randomize a new set of planets details.<br>";
        String mm = "____b. Quadrant Map's Detail - Adjacency list & matrix and the sorted edges and planets.<br>";
        String nn = "____c. Planet's Materials Mining - 0/1 Knapsack Problem (Dynamic Programming).<br>";
        String oo = "____d. Shortest Route Distance - Shortest Path from every planet to Planet A.<br>";
        String pp = "7. Every page, there is a home and back button. User can press home button to go back to the first page, back button to the previous page.<br>";

        label2 =  new JLabel("<html>" + aa + bb + cc + dd + ee + ff + gg + hh + ii + jj + kk + ll + mm + nn + oo + pp + "</html>");
        label2.setFont(new Font("Arial", Font.BOLD, 20));
        label2.setForeground(Color.BLACK);

        pane1 = new JScrollPane(label2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane1.setBounds(100,200, 1150,410);

        // Buttons components
        home = new JButton("HOME");
        home.setBounds(1250,710,80,30);
        home.setFont(new Font("Arial", Font.BOLD, 15));
        
        // Add all the component to the background image, overlapping background image
        addCompToMyLabel();
        
        // All frame component's setting and adjustment
        frame = new JFrame("Help");
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
    // get help button 
    public JButton getHomeButton() {
        return home;
    }

    // add component to background image
    public void addCompToMyLabel() {         
        myLabel.add(label1);
        myLabel.add(pane1);
        myLabel.add(home);
    }

    public Page1 getP1() {
        return p1;
    }

    // action even listener 
	public void addEventAction(ActionListener listenBtn) {
		home.addActionListener(listenBtn);
   	}

}

