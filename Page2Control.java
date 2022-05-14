import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

// Page 2 control
public class Page2Control {

    private Page2 page2;

    public Page2Control(Page2 page2) {
        this.page2 = page2;
        this.page2.addEventAction(new Page1Listener());
    }

    // event handling
    class Page1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {  
            if (e.getSource() == page2.getAlpha()) { // alpha button is clicked
                programOption prog = new programOption(0,page2, page2.getPage1());
                programOptionControl progCon = new programOptionControl(prog);
                page2.getFrame().setVisible(false);
            } 
            if (e.getSource() == page2.getBeta()) { // beta button is clicked
                programOption prog = new programOption(1, page2,page2.getPage1());
                programOptionControl progCon = new programOptionControl(prog);
                page2.getFrame().setVisible(false);
            }
            if (e.getSource() == page2.getGamma()) { // gamma button is clicked
                programOption prog = new programOption(2, page2,page2.getPage1());
                programOptionControl progCon = new programOptionControl(prog);
                page2.getFrame().setVisible(false);
            }
            if (e.getSource() == page2.getDelta()) { // delta button is clicked
                programOption prog = new programOption(3,page2, page2.getPage1());
                programOptionControl progCon = new programOptionControl(prog);
                page2.getFrame().setVisible(false);
            }
            if (e.getSource() == page2.getHome()) { // home button is clicked
                page2.getPage1().getFrame().setVisible(true);
                page2.getPage1().getFrame().setBounds(30,30,1366,800);
                page2.getFrame().dispose();
            }
            if (e.getSource() == page2.getBack()) { // back button is clicked
                page2.getInst().getFrame().setVisible(true);
                page2.getInst().getFrame().setBounds(30,30,1366,800);
                page2.getFrame().dispose();
                
            }
        }
    }
}