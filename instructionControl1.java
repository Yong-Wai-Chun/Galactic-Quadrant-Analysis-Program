import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

// instruction1 control
public class instructionControl1 {

    private instruction1 inst;

    public instructionControl1(instruction1 inst) {
        this.inst = inst;
        this.inst.addEventAction(new Page1Listener());
    }

    class Page1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {  
            // if button next is clicked
            if (e.getSource() == inst.getNext()) {
                
                Page2 p2 = new Page2(inst,inst.getPage1());
                Page2Control p2Control = new Page2Control(p2);

                inst.getFrame().setVisible(false);
            }
            // if button home is clicked
            if (e.getSource() == inst.getHome()) {
                inst.getPage1().getFrame().setVisible(true);
                inst.getPage1().getFrame().setBounds(30,30,1366,800);
                inst.getFrame().dispose();
            }
            // if button back is clicked
            if (e.getSource() == inst.getBack()) {
                inst.getPage1().getFrame().setVisible(true);
                inst.getPage1().getFrame().setBounds(30,30,1366,800);
                inst.getFrame().dispose();
            }
        }
    }
}