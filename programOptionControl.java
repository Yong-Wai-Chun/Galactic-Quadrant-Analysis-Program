import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

// Program option control
public class programOptionControl {

    private programOption pO;

    public programOptionControl(programOption pO) {
        this.pO = pO;
        this.pO.addEventAction(new Page1Listener());
    }

    class Page1Listener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {  
            if (e.getSource() == pO.getRandom()) { // randomize button is clicked
                pO.setAssets(new Assets(pO.getOption())); 
                pO.updateFrame();       
            } 
            if (e.getSource() == pO.getDisplay()) { // 0, sortdisplay button is clicked
                instruction2 inst = new instruction2(pO.getPage1(), pO, 0);
                instructionControl2 instControl = new instructionControl2(inst);
                pO.getFrame().setVisible(false);
            }   
            if (e.getSource() == pO.getDynamic()) { // 1, dynamicporg button is clicked
                instruction2 inst = new instruction2(pO.getPage1(), pO, 1);
                instructionControl2 instControl = new instructionControl2(inst);
                pO.getFrame().setVisible(false);
            } 
            if (e.getSource() == pO.getShortest()) { // 2, short button is clicked
                instruction2 inst = new instruction2(pO.getPage1(), pO, 2);
                instructionControl2 instControl = new instructionControl2(inst);
                pO.getFrame().setVisible(false);
            } 
            if (e.getSource() == pO.getHome()) { // home button is clicked
                pO.getPage1().getFrame().setVisible(true);
                pO.getPage1().getFrame().setBounds(30,30,1366,800);
                pO.getFrame().dispose();
            }
            if (e.getSource() == pO.getBack()) { // back button is clicked
                pO.getPage2().getFrame().setVisible(true);
                pO.getPage2().getFrame().setBounds(30,30,1366,800);
                pO.getFrame().dispose();
                
            }
        }
    }
}