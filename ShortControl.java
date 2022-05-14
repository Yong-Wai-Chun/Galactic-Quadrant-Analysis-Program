import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class ShortControl {

    private Short s;

    public ShortControl(Short s) {
        this.s = s;
        this.s.addEventAction(new Page1Listener());
    }

    class Page1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {  

            if (e.getSource() == s.getHome()) {
                s.getPage1().getFrame().setVisible(true);
                s.getPage1().getFrame().setBounds(30,30,1366,800);
                s.getFrame().dispose();
            }
            if (e.getSource() == s.getBack()) {
                s.getPO().getFrame().setVisible(true);
                s.getPO().getFrame().setBounds(30,30,1366,800);
                s.getFrame().dispose();
            }
        }
    }
}