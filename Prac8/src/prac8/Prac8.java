/**
 *
 * Author: Bradley van der Westhuizen (217218903)\
 * Date: 11 April 2019
 */
package prac8;

import javax.swing.*;

public class Prac8
{
    public static void main(String[] args) 
    {
        GUI myGui = new GUI();
        myGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGui.setSize(350,300);
        myGui.setTitle("Calculator");
        myGui.setVisible(true);
    }   
}
