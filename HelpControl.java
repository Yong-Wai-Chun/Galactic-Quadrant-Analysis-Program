import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

// Page 1 control
public class HelpControl {

    private Help hlp;

    // constructor. Take in Page1 object
    public HelpControl(Help hlp) {
        this.hlp = hlp;
        this.hlp.addEventAction(new Page1Listener());
    }

    // Event handling. Action listener
    class Page1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {  
            if (e.getSource() == hlp.getHomeButton()) { // home button is clicked
                hlp.getP1().getFrame().setVisible(true);
                hlp.getP1().getFrame().setBounds(30,30,1366,800);
                hlp.getFrame().dispose();
            }
        }
    }
}