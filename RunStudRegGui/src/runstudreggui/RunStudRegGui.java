/** RunStudRegGui.java
 * This is the working class
 * Author: Bradley van der Westhuizen (217218903
 * Date: 18 April 2019
 */
package runstudreggui;

import javax.swing.*;

public class RunStudRegGui 
{
    public static void main(String[] args) 
    {
        StudRegGui gui = new StudRegGui();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(465, 345);
        gui.setLocationRelativeTo(null);
        gui.setTitle("STUDENT REGISTRATION");
        gui.setVisible(true);
    }
    
}
