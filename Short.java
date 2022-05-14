import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;

public class Short {

    private JFrame frame;
    private ImageIcon background;
    private JLabel myLabel;
    private JLabel label1;
    private JLabel subLabel1;

    private JButton back;
    private JButton home;

    private Assets assets;

    private Page1 p1;
    private programOption pO;

    private DefaultListModel<String> l1 = new DefaultListModel<>();
    private JList<String> list; // = new JList<>(l1);

    private DefaultListModel<String> l2 = new DefaultListModel<>();
    private JList<String> list2; // = new JList<>(l1);

    public Short(Assets assets, Page1 p1, programOption pO) {
        
        this.assets = assets;
        this.p1 = p1;
        this.pO = pO;

        background = new ImageIcon(this.getClass().getResource("components/background1.png"));
        myLabel = new JLabel(background);

        label1 = new JLabel("SHORTEST ROUTE DISTANCE");
        label1.setBounds(200,50,1000,70);
        label1.setFont(new Font("Arial", Font.BOLD, 65));
        label1.setForeground(Color.WHITE);

        home = new JButton("HOME");
        home.setBounds(1150,710,80,30);
        home.setFont(new Font("Arial", Font.BOLD, 15));

        back = new JButton("BACK");
        back.setBounds(1250,710,80,30);
        back.setFont(new Font("Arial", Font.BOLD, 15));
        
        assets.setAdjacencyList();
        assets.dijkstra();

        for (int i=0; i<assets.getShortDisp().size(); i++) {
            l1.add(i, assets.getShortDisp().get(i));
        }

        list = new JList<>(l1);
        list.setBounds(100,200, 550,280);  
        list.setFont(new Font("Arial", Font.PLAIN, 20));

        for (int i=0; i<assets.getPathDisp().size(); i++) {
            l2.add(i, assets.getPathDisp().get(i));
        }

        list2 = new JList<>(l2);
        list2.setBounds(700,200, 550,280);  
        list2.setFont(new Font("Arial", Font.PLAIN, 20));

        subLabel1 = new JLabel("Shortest Path:");
        subLabel1.setBounds(110,165,1000,35);
        subLabel1.setFont(new Font("Arial", Font.BOLD, 20));
        subLabel1.setForeground(Color.WHITE);

        addCompToMyLabel();
        frame = new JFrame("Shortest Path");
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
        myLabel.add(list2);
        myLabel.add(subLabel1);
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