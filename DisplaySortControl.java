import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

// display sort control
public class DisplaySortControl {

    private DisplaySort dS;

    public DisplaySortControl(DisplaySort dS) {
        this.dS = dS;
        this.dS.addEventAction(new Page1Listener());
    }

    class Page1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {  

            if (e.getSource() == dS.getHome()) { // if home button is pressed
                dS.getPage1().getFrame().setVisible(true);
                dS.getPage1().getFrame().setBounds(30,30,1366,800);
                dS.getFrame().dispose();
            }
            if (e.getSource() == dS.getBack()) { // if button button is pressed
                dS.getPO().getFrame().setVisible(true);
                dS.getPO().getFrame().setBounds(30,30,1366,800);
                dS.getFrame().dispose();
            }
        }
    }
}