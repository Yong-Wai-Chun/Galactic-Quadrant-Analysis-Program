import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

// Main program to run.
/* overall connection of every page:
** Page1 -> instruction1 -> Page2 -> programOption -> instruction2 -> displaySort/dynamicProgram/Short
*/
public class Main {   
    public static void main(String args[]) {

        // Instantiate the Page1 object, the very first page of the program.
        // Applies MVC. However, it does not necessarily need model here because it only has simple UI and control.
        Page1 p1 = new Page1();
        Page1Control p1Control = new Page1Control(p1);

	}
}   
