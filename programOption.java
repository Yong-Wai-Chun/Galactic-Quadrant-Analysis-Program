import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

// Program option view
public class programOption {
    
    private JFrame frame; // frame
    
    private JLabel label1 = new JLabel(); // main title label
    private JLabel label2 = new JLabel(); // Planets Details:
    private JLabel label3 = new JLabel(); // Map: Alha/Beta/Gamma/Delta Quadrant

    private JLabel subLabel1 = new JLabel(); // HOME PLANET:
    private JLabel subLabel2 = new JLabel(); // - PLANET_A
    // background image
    private ImageIcon background; 
    private JLabel myLabel;
    // planet A image
    private ImageIcon pA;
    private JLabel pALabel;
    // quadrant map image
    private ImageIcon map;
    private JLabel mapLabel;
    
    private int option; // option
    private Page2 p2; // page 2
    private Page1 p1; // page 1

    private DefaultListModel<String> l1 = new DefaultListModel<>();
    private JList<String> list; // = new JList<>(l1);

    private JButton randomize; // randomize button
    private JButton home; // home button
    private JButton back; // back button

    private JButton dynamic; // dynamicprog button
    private JButton display; // sortdisplay button
    private JButton shortest; // short button

    private Assets asset;
    private StringBuilder sb=new StringBuilder(""); 

    public programOption(int option, Page2 p2, Page1 p1) {

        this.option = option;
        this.p2 = p2;
        this.p1 = p1;

        // background image
        background = new ImageIcon(this.getClass().getResource("components/background1.png"));
        myLabel = new JLabel(background);
        
        // Main title label
        label1 = new JLabel("PROGRAM MENU");
        label1.setBounds(420,50,1000,70);
        label1.setFont(new Font("Arial", Font.BOLD, 65));
        label1.setForeground(Color.WHITE);

        // planet details label
        label2 = new JLabel(" Planets Details:");
        label2.setBounds(700,140,500,40);
        label2.setFont(new Font("Arial", Font.PLAIN, 30));
        label2.setForeground(Color.BLACK);
        label2.setBackground(Color.CYAN);
        label2.setOpaque(true);

        // home planet label
        subLabel1 = new JLabel(" HOME PLANET:");
        subLabel1.setBounds(950,495,270,40);
        subLabel1.setFont(new Font("Arial", Font.BOLD, 30));
        subLabel1.setForeground(Color.WHITE);
        subLabel1.setBackground(Color.BLUE);
        subLabel1.setOpaque(true);
        // home planet's name label
        subLabel2 = new JLabel(" - Planet_A");
        subLabel2.setBounds(950,530,270,40);
        subLabel2.setFont(new Font("Arial", Font.PLAIN, 20));
        subLabel2.setForeground(Color.WHITE);
        subLabel2.setBackground(Color.BLUE);
        subLabel2.setOpaque(true);
        
        if (option == 0) { // if alpha quad is chosen
            
            asset = new Assets(option);
            // home planet image gif
            pA = new ImageIcon(this.getClass().getResource("components/a1.gif"));
            pALabel = new JLabel(pA);
            pALabel.setBounds(665,495,300,250);
            // quadrant map image 
            map = new ImageIcon(this.getClass().getResource("components/alpha1.png"));
            mapLabel = new JLabel(map);
            mapLabel.setBounds(149,175,250,250);
            // map name label
            label3 = new JLabel(" Map: Alpha Quadrant");
            label3.setBounds(150,140,400,40);
            label3.setFont(new Font("Arial", Font.PLAIN, 30));
            label3.setForeground(Color.BLACK);
            label3.setBackground(Color.CYAN);
            label3.setOpaque(true);
        
        } else if (option == 1) { // if beta quad is chosen
            
            asset = new Assets(option);

            pA = new ImageIcon(this.getClass().getResource("components/b1.gif"));
            pALabel = new JLabel(pA);
            pALabel.setBounds(700,491,250,250);

            map = new ImageIcon(this.getClass().getResource("components/beta1.png"));
            mapLabel = new JLabel(map);
            mapLabel.setBounds(137,175,250,250);

            label3 = new JLabel(" Map: Beta Quadrant");
            label3.setBounds(150,140,400,40);
            label3.setFont(new Font("Arial", Font.PLAIN, 30));
            label3.setForeground(Color.BLACK);
            label3.setBackground(Color.CYAN);
            label3.setOpaque(true);

        } else if (option == 2) { // if gamma quad is chosen

            asset = new Assets(option);

            pA = new ImageIcon(this.getClass().getResource("components/g1.gif"));
            pALabel = new JLabel(pA);
            pALabel.setBounds(700,495,250,250);

            map = new ImageIcon(this.getClass().getResource("components/gamma1.png"));
            mapLabel = new JLabel(map);
            mapLabel.setBounds(148,179,250,250);

            label3 = new JLabel(" Map: Gamma Quadrant");
            label3.setBounds(150,140,400,40);
            label3.setFont(new Font("Arial", Font.PLAIN, 30));
            label3.setForeground(Color.BLACK);
            label3.setBackground(Color.CYAN);
            label3.setOpaque(true);

        } else if (option == 3) { // if delta quad is chosen

            asset = new Assets(option);

            pA = new ImageIcon(this.getClass().getResource("components/d1.gif"));
            pALabel = new JLabel(pA);
            pALabel.setBounds(700,495,250,150);

            map = new ImageIcon(this.getClass().getResource("components/delta1.png"));
            mapLabel = new JLabel(map);
            mapLabel.setBounds(149,174,250,250);

            label3 = new JLabel(" Map: Delta Quadrant");
            label3.setBounds(150,140,400,40);
            label3.setFont(new Font("Arial", Font.PLAIN, 30));
            label3.setForeground(Color.BLACK);
            label3.setBackground(Color.CYAN);
            label3.setOpaque(true);
        }

        // planets details
        for (int i=0; i<10; i++) {
            sb.append(asset.getPlanets(i).getP_name());
            
            sb.append(" (");
            sb.append(asset.getPlanets(i).getCoorX());
            sb.append(",");
            sb.append(asset.getPlanets(i).getCoorY());
            sb.append(",");
            sb.append(asset.getPlanets(i).getCoorZ());
            sb.append(") ");

            sb.append("Weight = ");
            sb.append(asset.getPlanets(i).getWeight());
            sb.append(" Profit = ");
            sb.append(asset.getPlanets(i).getProfit());

            l1.add(i, sb.toString());
            sb.setLength(0);
        }
        
        // list of planet's details
        list = new JList<>(l1);
        list.setBounds(700,180, 500,260);  
        list.setFont(new Font("Arial", Font.PLAIN, 20));

        // randomize button
        randomize = new JButton("RANDOMIZE");
        randomize.setBounds(700,450,150,30);
        randomize.setFont(new Font("Arial", Font.BOLD, 15));
        // home button
        home = new JButton("HOME");
        home.setBounds(1250,650,80,30);
        home.setFont(new Font("Arial", Font.BOLD, 15));
        // back button
        back = new JButton("BACK");
        back.setBounds(1250,710,80,30);
        back.setFont(new Font("Arial", Font.BOLD, 15));
        
        // sortdisplay button
        display = new JButton("QUADRANT MAP'S DETAIL");
        display.setBounds(150,480,350,40);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        // dynamicprog button
        dynamic = new JButton("PLANET'S MATERIALS MINING");
        dynamic.setBounds(150,550,350,40);
        dynamic.setFont(new Font("Arial", Font.BOLD, 20));
        // short  button
        shortest = new JButton("SHORTEST ROUTE DISTANCE");
        shortest.setBounds(150,620,350,40);
        shortest.setFont(new Font("Arial", Font.BOLD, 20));

        addCompToMyLabel();  // add components on background image

        frame = new JFrame("Prog Option");
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

    public void addCompToMyLabel() { // add components on background image
        myLabel.add(label1);
        myLabel.add(label2);
        myLabel.add(label3);
        myLabel.add(list);
        myLabel.add(randomize);
        myLabel.add(home);
        myLabel.add(back);
        myLabel.add(pALabel);
        myLabel.add(subLabel1);
        myLabel.add(subLabel2);
        myLabel.add(mapLabel);
        myLabel.add(display);
        myLabel.add(dynamic);
        myLabel.add(shortest);
    }
    
    public void addEventAction(ActionListener listenBtn) { // action listener
		randomize.addActionListener(listenBtn);
		display.addActionListener(listenBtn);
        dynamic.addActionListener(listenBtn);
        shortest.addActionListener(listenBtn);
        home.addActionListener(listenBtn);
        back.addActionListener(listenBtn);
   	}

    public JButton getRandom() { // get random button
        return randomize;
    }

    public JButton getDisplay() { // get sortdisplay button
        return display;
    }

    public JButton getDynamic() { // get dynamicprog button
        return dynamic;
    }

    public JButton getShortest() { // get short button
        return shortest;
    }

    public int getOption() { // get option
        return option;
    }
    
    public Page2 getPage2() { // get previous page object
        return p2;
    }

    public Page1 getPage1() { // get first page object
        return p1;
    }

    public void setAssets(Assets asset) { // set new assets after randomizing
        this.asset = asset;
        
        for (int i=0; i<10; i++) {
            sb.append(asset.getPlanets(i).getP_name());
            
            sb.append(" (");
            sb.append(asset.getPlanets(i).getCoorX());
            sb.append(",");
            sb.append(asset.getPlanets(i).getCoorY());
            sb.append(",");
            sb.append(asset.getPlanets(i).getCoorZ());
            sb.append(") ");

            sb.append("Weight = ");
            sb.append(asset.getPlanets(i).getWeight());
            sb.append(" Profit = ");
            sb.append(asset.getPlanets(i).getProfit());

            l1.add(i, sb.toString());
            sb.setLength(0);
        }
        
        list = new JList<>(l1);
        list.setBounds(700,180, 500,260);  
        list.setFont(new Font("Arial", Font.PLAIN, 20));
    }

    public Assets getAsset() { // get assets
        return asset;
    }

    public void updateFrame() { // update frame
        frame.validate();
        frame.repaint();
    }

    public JFrame getFrame() { // get current current
		return frame;
	}
    public JButton getHome() { // get home button
        return home;
    }

    public JButton getBack() { // get back button
        return back;
    }
}