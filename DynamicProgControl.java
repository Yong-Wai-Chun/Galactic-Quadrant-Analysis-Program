import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class DynamicProgControl {

    private DynamicProg dP;

    public DynamicProgControl(DynamicProg dP) {
        this.dP = dP;
        this.dP.addEventAction(new Page1Listener());
    }

    class Page1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {  

            if (e.getSource() == dP.getHome()) {
                dP.getPage1().getFrame().setVisible(true);
                dP.getPage1().getFrame().setBounds(30,30,1366,800);
                dP.getFrame().dispose();
            }
            if (e.getSource() == dP.getBack()) {
                dP.getPO().getFrame().setVisible(true);
                dP.getPO().getFrame().setBounds(30,30,1366,800);
                dP.getFrame().dispose();
            }
        }
    }
}