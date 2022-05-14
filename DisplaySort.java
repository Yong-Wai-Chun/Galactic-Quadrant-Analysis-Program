import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;

// displaysort view
public class DisplaySort {

    private JFrame frame; // frame
    // background
    private ImageIcon background; 
    private JLabel myLabel;
    
    private JLabel label1; // main title label
    private JLabel subLabel1; // Adjacency List:
    private JLabel subLabel2; // Adjacency Matrix:

    private JLabel subLabel3; // Sorted Edges(Asc):
    private JLabel subLabel4; // Sorted Planets(Desc):
    // scrollable pane
    private JScrollPane pane; 
    private JScrollPane pane1;
    // home and back buttons
    private JButton back;
    private JButton home;

    private DefaultListModel<String> l1 = new DefaultListModel<>(); // adjlist
    private JList<String> list; // = new JList<>(l1);

    private DefaultListModel<String> l2 = new DefaultListModel<>(); // sortEdges
    private JList<String> list2; // = new JList<>(l1);

    private DefaultListModel<String> l3 = new DefaultListModel<>(); // sortedPlanents
    private JList<String> list3; // = new JList<>(l1);
    
    private String[][] data = {{"Planet_A","∞","∞","∞","∞","∞","∞","∞","∞","∞","∞"},
                               {"Planet_B","∞","∞","∞","∞","∞","∞","∞","∞","∞","∞"},
                               {"Planet_C","∞","∞","∞","∞","∞","∞","∞","∞","∞","∞"},
                               {"Planet_D","∞","∞","∞","∞","∞","∞","∞","∞","∞","∞"},
                               {"Planet_E","∞","∞","∞","∞","∞","∞","∞","∞","∞","∞"},
                               {"Planet_F","∞","∞","∞","∞","∞","∞","∞","∞","∞","∞"},
                               {"Planet_G","∞","∞","∞","∞","∞","∞","∞","∞","∞","∞"},
                               {"Planet_H","∞","∞","∞","∞","∞","∞","∞","∞","∞","∞"},
                               {"Planet_I","∞","∞","∞","∞","∞","∞","∞","∞","∞","∞"},
                               {"Planet_J","∞","∞","∞","∞","∞","∞","∞","∞","∞","∞"}}; // adj matrix
    private String[] column={"","Planet_A","Planet_B","Planet_C","Planet_D","Planet_E","Planet_F","Planet_G","Planet_H","Planet_I","Planet_J"}; 
    private JTable adjMatrix; 

    private Assets assets;

    private Page1 p1;
    private programOption pO;

    public DisplaySort(Assets assets, Page1 p1, programOption pO) {
        
        this.assets = assets;
        this.p1 = p1;
        this.pO = pO;
        // background image
        background = new ImageIcon(this.getClass().getResource("components/background1.png"));
        myLabel = new JLabel(background);
        // main title label
        label1 = new JLabel("QUADRANT MAP'S DETAIL");
        label1.setBounds(285,50,1000,70);
        label1.setFont(new Font("Arial", Font.BOLD, 65));
        label1.setForeground(Color.WHITE);

        assets.setAdjacencyList();
        
        // adjacency list
        for (int i=0; i<assets.getAdjList().size(); i++) {
            l1.add(i, assets.getAdjList().get(i));
        }

        subLabel1 = new JLabel("Adjacency List:");
        subLabel1.setBounds(65,190,200,35);
        subLabel1.setFont(new Font("Arial", Font.BOLD, 20));
        subLabel1.setForeground(Color.WHITE);

        list = new JList<>(l1);
        list.setBounds(60,230, 800,180);
        list.setFont(new Font("Arial", Font.BOLD, 13));
        
        // adjacency matrix assigning
        DecimalFormat f = new DecimalFormat("##.00");  
        for (int i=0; i<assets.getRealAdjList().size(); i++) {
            for (int j=0; j<assets.getRealAdjList().get(i).size(); j++) {
                if (assets.getRealAdjList().get(i).get(j).getPlanet1().getP_name().compareTo(data[i][0]) != 0 ) {
                    if (assets.getRealAdjList().get(i).get(j).getPlanet1().getP_name().compareTo("Planet_A") == 0) {
                        data[i][1] = String.valueOf(f.format(assets.getRealAdjList().get(i).get(j).getDistance()));
                    } else if (assets.getRealAdjList().get(i).get(j).getPlanet1().getP_name().compareTo("Planet_B") == 0) {
                        data[i][2] = String.valueOf(f.format(assets.getRealAdjList().get(i).get(j).getDistance()));
                    } else if (assets.getRealAdjList().get(i).get(j).getPlanet1().getP_name().compareTo("Planet_C") == 0) {
                        data[i][3] = String.valueOf(f.format(assets.getRealAdjList().get(i).get(j).getDistance()));
                    } else if (assets.getRealAdjList().get(i).get(j).getPlanet1().getP_name().compareTo("Planet_D") == 0) {
                        data[i][4] = String.valueOf(f.format(assets.getRealAdjList().get(i).get(j).getDistance()));
                    } else if (assets.getRealAdjList().get(i).get(j).getPlanet1().getP_name().compareTo("Planet_E") == 0) {
                        data[i][5] = String.valueOf(f.format(assets.getRealAdjList().get(i).get(j).getDistance()));
                    } else if (assets.getRealAdjList().get(i).get(j).getPlanet1().getP_name().compareTo("Planet_F") == 0) {
                        data[i][6] = String.valueOf(f.format(assets.getRealAdjList().get(i).get(j).getDistance()));
                    } else if (assets.getRealAdjList().get(i).get(j).getPlanet1().getP_name().compareTo("Planet_G") == 0) {
                        data[i][7] = String.valueOf(f.format(assets.getRealAdjList().get(i).get(j).getDistance()));
                    } else if (assets.getRealAdjList().get(i).get(j).getPlanet1().getP_name().compareTo("Planet_H") == 0) {
                        data[i][8] = String.valueOf(f.format(assets.getRealAdjList().get(i).get(j).getDistance()));
                    } else if (assets.getRealAdjList().get(i).get(j).getPlanet1().getP_name().compareTo("Planet_I") == 0) {
                        data[i][9] = String.valueOf(f.format(assets.getRealAdjList().get(i).get(j).getDistance()));
                    } else if (assets.getRealAdjList().get(i).get(j).getPlanet1().getP_name().compareTo("Planet_J") == 0) {
                        data[i][10] = String.valueOf(f.format(assets.getRealAdjList().get(i).get(j).getDistance()));
                    }
                } else {
                    if (assets.getRealAdjList().get(i).get(j).getPlanet2().getP_name().compareTo("Planet_A") == 0) {
                        data[i][1] = String.valueOf(f.format(assets.getRealAdjList().get(i).get(j).getDistance()));
                    } else if (assets.getRealAdjList().get(i).get(j).getPlanet2().getP_name().compareTo("Planet_B") == 0) {
                        data[i][2] = String.valueOf(f.format(assets.getRealAdjList().get(i).get(j).getDistance()));
                    } else if (assets.getRealAdjList().get(i).get(j).getPlanet2().getP_name().compareTo("Planet_C") == 0) {
                        data[i][3] = String.valueOf(f.format(assets.getRealAdjList().get(i).get(j).getDistance()));
                    } else if (assets.getRealAdjList().get(i).get(j).getPlanet2().getP_name().compareTo("Planet_D") == 0) {
                        data[i][4] = String.valueOf(f.format(assets.getRealAdjList().get(i).get(j).getDistance()));
                    } else if (assets.getRealAdjList().get(i).get(j).getPlanet2().getP_name().compareTo("Planet_E") == 0) {
                        data[i][5] = String.valueOf(f.format(assets.getRealAdjList().get(i).get(j).getDistance()));
                    } else if (assets.getRealAdjList().get(i).get(j).getPlanet2().getP_name().compareTo("Planet_F") == 0) {
                        data[i][6] = String.valueOf(f.format(assets.getRealAdjList().get(i).get(j).getDistance()));
                    } else if (assets.getRealAdjList().get(i).get(j).getPlanet2().getP_name().compareTo("Planet_G") == 0) {
                        data[i][7] = String.valueOf(f.format(assets.getRealAdjList().get(i).get(j).getDistance()));
                    } else if (assets.getRealAdjList().get(i).get(j).getPlanet2().getP_name().compareTo("Planet_H") == 0) {
                        data[i][8] = String.valueOf(f.format(assets.getRealAdjList().get(i).get(j).getDistance()));
                    } else if (assets.getRealAdjList().get(i).get(j).getPlanet2().getP_name().compareTo("Planet_I") == 0) {
                        data[i][9] = String.valueOf(f.format(assets.getRealAdjList().get(i).get(j).getDistance()));
                    } else if (assets.getRealAdjList().get(i).get(j).getPlanet2().getP_name().compareTo("Planet_J") == 0) {
                        data[i][10] = String.valueOf(f.format(assets.getRealAdjList().get(i).get(j).getDistance())); 
                    }
                }
            }
        }
        subLabel2 = new JLabel("Adjacency Matrix:");
        subLabel2.setBounds(65,430,200,35);
        subLabel2.setFont(new Font("Arial", Font.BOLD, 20));
        subLabel2.setForeground(Color.WHITE);

        adjMatrix = new JTable(data,column);
        adjMatrix.setBounds(60,500,800,160);
        adjMatrix.setFont(new Font("Arial", Font.PLAIN, 15));
        adjMatrix.getTableHeader().setBounds(60,470,800,30);
        adjMatrix.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        
        // sorted edges
        subLabel3 = new JLabel("Sorted Edges(Asc):");
        subLabel3.setBounds(1005,190,200,35);
        subLabel3.setFont(new Font("Arial", Font.BOLD, 20));
        subLabel3.setForeground(Color.WHITE);

        assets.initSort();
        for (int i=0; i<assets.getSortedEdges().size(); i++) {
            l2.add(i, assets.getSortedEdges().get(i));
        }
        list2 = new JList<>(l2);
        pane = new JScrollPane(list2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setBounds(1000,230, 300,180);
        
        // sorted planets
        subLabel4 = new JLabel("Sorted Planets(Desc):");
        subLabel4.setBounds(1005,430,250,35);
        subLabel4.setFont(new Font("Arial", Font.BOLD, 20));
        subLabel4.setForeground(Color.WHITE);

        for (int i=0; i<assets.getSortedPlanets().size(); i++) {
            l3.add(i, assets.getSortedPlanets().get(i));
        }
        list3 = new JList<>(l3);
        pane1 = new JScrollPane(list3,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane1.setBounds(1000,470, 320,190);

        // home button
        home = new JButton("HOME");
        home.setBounds(1150,710,80,30);
        home.setFont(new Font("Arial", Font.BOLD, 15));
        // back button
        back = new JButton("BACK");
        back.setBounds(1250,710,80,30);
        back.setFont(new Font("Arial", Font.BOLD, 15));

        addCompToMyLabel(); // add all components on background image
        frame = new JFrame("Display Sort");
        //frame.add(pane);
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

    public void addCompToMyLabel() {  // add all components on background image
        myLabel.add(label1);
        myLabel.add(list);
        myLabel.add(adjMatrix);
        myLabel.add(adjMatrix.getTableHeader());
        myLabel.add(subLabel1);
        myLabel.add(subLabel2);
        myLabel.add(subLabel3);
        myLabel.add(subLabel4);
        myLabel.add(pane);
        myLabel.add(pane1);
        myLabel.add(home);
        myLabel.add(back);
    }
    
    public void addEventAction(ActionListener listenBtn) { // action listner
		home.addActionListener(listenBtn);
        back.addActionListener(listenBtn);
   	}

    public JButton getBack() { // get back button
        return back;
    }

    public JButton getHome() { // get home button
        return home;
    }

    public Page1 getPage1() { // get first page object
        return p1;
    }
    
    public programOption getPO() { // get previous page object
        return pO;
    }

    public JFrame getFrame() { // get current frame
        return frame;
    }
}