import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

// Page 1 control
public class Page1Control {

    private Page1 page1;

    // constructor. Take in Page1 object
    public Page1Control(Page1 page1) {
        this.page1 = page1;
        this.page1.addEventAction(new Page1Listener());
    }

    // Event handling. Action listener
    class Page1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {  
            if (e.getSource() == page1.getStartButton()) { // if start button is clicked
                
                // direct to next page
                instruction1 inst = new instruction1(page1);
                instructionControl1 instCon = new instructionControl1(inst);
                
                // set current page not visible, avoid using dispose because user might go back to the older page
                page1.getFrame().setVisible(false);
            }
            if (e.getSource() == page1.getHelpButton()) { // if help button is clicked
                Help hlp = new Help(page1);
                HelpControl hlpCon = new HelpControl(hlp);
                page1.getFrame().setVisible(false);
            }
            if (e.getSource() == page1.getExitButton()) { // if exit button is clicked
                page1.getFrame().dispose();
                page1.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                page1.getFrame().dispatchEvent(new WindowEvent(page1.getFrame(), WindowEvent.WINDOW_CLOSING));
            }
        }
    }
}