import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;

public class DynamicProg {

    private JFrame frame; // frame
    // background image 
    private ImageIcon background;
    private JLabel myLabel;
    // main title label
    private JLabel label1;

    private JLabel subLabel1;
    private JLabel subLabel2;
    private JLabel subLabel3;

    // back and home button
    private JButton back;
    private JButton home;

    private Assets assets;

    private Page1 p1;
    private programOption pO;

    private DefaultListModel<String> l1 = new DefaultListModel<>();
    private JList<String> list; // = new JList<>(l1);

    public DynamicProg(Assets assets, Page1 p1, programOption pO) {
        
        this.assets = assets;
        this.p1 = p1;
        this.pO = pO;

        background = new ImageIcon(this.getClass().getResource("components/background1.png"));
        myLabel = new JLabel(background);

        label1 = new JLabel("MATERIALS MINING");
        label1.setBounds(380,50,1000,70);
        label1.setFont(new Font("Arial", Font.BOLD, 65));
        label1.setForeground(Color.WHITE);

        home = new JButton("HOME");
        home.setBounds(1150,710,80,30);
        home.setFont(new Font("Arial", Font.BOLD, 15));

        back = new JButton("BACK");
        back.setBounds(1250,710,80,30);
        back.setFont(new Font("Arial", Font.BOLD, 15));

        for (int i=0; i<assets.getChosenDisp().size(); i++) {
            l1.add(i, assets.getChosenDisp().get(i));
        }

        subLabel1 = new JLabel("Chosen Planets' Materials to be Collected: (Matrix is generated to csv file - 'matrix.csv')");
        subLabel1.setBounds(65,190,1000,35);
        subLabel1.setFont(new Font("Arial", Font.BOLD, 20));
        subLabel1.setForeground(Color.WHITE);

        list = new JList<>(l1);
        list.setBounds(60,230, 800,250);
        list.setFont(new Font("Arial", Font.PLAIN, 20));

        subLabel2 = new JLabel("<html> Total Weight = " + assets.getTotalWeight() + "<html>");
        subLabel2.setBounds(65,500,200,35);
        subLabel2.setFont(new Font("Arial", Font.BOLD, 20));
        subLabel2.setForeground(Color.WHITE);
        subLabel2.setBackground(Color.BLACK);
        subLabel2.setOpaque(true);

        subLabel3 = new JLabel("<html> Total Profit = " + assets.getTotalProfit() + "<html>");
        subLabel3.setBounds(65,550,200,35);
        subLabel3.setFont(new Font("Arial", Font.BOLD, 20));
        subLabel3.setForeground(Color.WHITE);
        subLabel3.setBackground(Color.BLACK);
        subLabel3.setOpaque(true);

        addCompToMyLabel();
        frame = new JFrame("Material Mining");
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

    public void addCompToMyLabel() { 
        myLabel.add(label1);
        myLabel.add(home);
        myLabel.add(back);
        myLabel.add(list);
        myLabel.add(subLabel1);
        myLabel.add(subLabel2);
        myLabel.add(subLabel3);
    }
    
    public void addEventAction(ActionListener listenBtn) {
		home.addActionListener(listenBtn);
        back.addActionListener(listenBtn);
   	}

    public JButton getBack() {
        return back;
    }

    public JButton getHome() {
        return home;
    }

    public Page1 getPage1() {
        return p1;
    }
    
    public programOption getPO() {
        return pO;
    }

    public JFrame getFrame() {
        return frame;
    }
}