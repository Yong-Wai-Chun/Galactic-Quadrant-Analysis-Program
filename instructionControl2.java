import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

// instruction 2 control
public class instructionControl2 {

    private instruction2 inst;

    public instructionControl2(instruction2 inst) {
        this.inst = inst;
        this.inst.addEventAction(new Page1Listener());
    }

    class Page1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {  
            if (e.getSource() == inst.getNext()) { // if next button is clicked
                
                if (inst.getOption() == 0) { // if sortdisplay is chosen
                    DisplaySort dS = new DisplaySort(inst.getPO().getAsset(),inst.getPage1(),inst.getPO());
                    DisplaySortControl dSCon = new DisplaySortControl(dS);
                } else if (inst.getOption() == 1) { // if dynamicprog is chosen
                    DynamicProg dP = new DynamicProg(inst.getPO().getAsset(),inst.getPage1(),inst.getPO());
                    DynamicProgControl dPCon  = new DynamicProgControl(dP);
                } else if (inst.getOption() == 2) { // if short is chosen
                    Short s = new Short(inst.getPO().getAsset(),inst.getPage1(),inst.getPO());
                    ShortControl sCon = new ShortControl(s);
                }
                
                inst.getFrame().dispose();
            }
            if (e.getSource() == inst.getHome()) { // home button is clicked
                inst.getPage1().getFrame().setVisible(true);
                inst.getPage1().getFrame().setBounds(30,30,1366,800);
                inst.getFrame().dispose();
            }
            if (e.getSource() == inst.getBack()) { // back button is clicked
                inst.getPO().getFrame().setVisible(true);
                inst.getPO().getFrame().setBounds(30,30,1366,800);
                inst.getFrame().dispose();
            }
        }
    }
}