/** Gui.java
 * 
 * Author: Bradley van der Westhuizen (217218903) 
 * Date: 11 April 2019
 */
package prac9;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gui extends JFrame implements ActionListener, ItemListener
{
    private JLabel label1 = new JLabel("RadioButton");
    private JRadioButton green = new JRadioButton("Green");
    private JRadioButton yellow = new JRadioButton("yellow");
    private ButtonGroup group = new ButtonGroup();
    private JLabel label2 = new JLabel("TextField");
    private JTextField text1 = new JTextField(5);
    private JLabel label3 = new JLabel("ComboBox");
    private String[] colors = {"Cyan", "Green", "Red"};
    private JComboBox comboBox = new JComboBox(colors);
    private JTextArea txtArea = new JTextArea(20, 50);
    private JButton redBtn = new JButton("Red");
    private JButton blueBtn = new JButton("Blue");
    private JButton readBtn = new JButton("Read");
    private JButton exitBtn = new JButton("Exit");
    private JPanel panel = new JPanel();
    private JPanel panelLeft = new JPanel();
    private JPanel panelRight = new JPanel();
    private JPanel panelBottm = new JPanel();
    
    public Gui()
    {
        this.setTitle("Fun With Colors");
        panel.setLayout(new BorderLayout(20, 20));
        panelLeft.add(label1);
        group.add(green);
        group.add(yellow);
        panelLeft.add(green);
        panelLeft.add(yellow);
        green.addActionListener(this);
        yellow.addActionListener(this);
        panelLeft.add(label2);
        panelLeft.add(text1);
        text1.addActionListener(this);
        panelLeft.add(label3);
        panelLeft.add(comboBox);
        panelRight.add(txtArea);
        panelBottm.add(redBtn);
        panelBottm.add(blueBtn);
        panelBottm.add(readBtn);
        panelBottm.add(exitBtn);
        redBtn.addActionListener(this);
        blueBtn.addActionListener(this);
        readBtn.addActionListener(this);
        exitBtn.addActionListener(this);
        comboBox.addItemListener(this);
        panel.add(panelLeft, BorderLayout.CENTER);
        panel.add(panelRight, BorderLayout.EAST);
        panel.add(panelBottm, BorderLayout.SOUTH);
        this.add(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == text1) 
        {
            txtArea.append(text1.getText() + "\n");
        }
        else if (e.getSource() == green)
        {
            txtArea.setBackground(Color.green);
            txtArea.append("Component used: Green Radio Button" + "\n");
        }
        else if (e.getSource() == yellow)
        {
            txtArea.setBackground(Color.yellow);
            txtArea.append("Component used: Yellow Radio Button" + "\n");
        }
        else if (e.getSource() == redBtn)
        {
            txtArea.setBackground(Color.red);
            txtArea.append("Component used: Red Button"+ "\n");
        }
        else if (e.getSource() == blueBtn)
        {
            txtArea.setBackground(Color.blue);
            txtArea.append("Component used: Blue Button" + "\n");
        }
        else if (e.getSource() == readBtn)
        {
            txtArea.append("Component used: Read Button " + "\n");
        }
        else if (e.getSource() == exitBtn)
        {
            txtArea.append("Component used: Exit Button" + "\n");
            this.dispose();
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) 
    {
        if (comboBox.getSelectedItem().equals("Cyan")) 
        {
            txtArea.append("Component used: Combo Box" + "\n");
            txtArea.setBackground(Color.cyan);
        }
        else if (comboBox.getSelectedItem().equals("Green")) 
        {
            txtArea.append("Component used: Combo Box" + "\n");
            txtArea.setBackground(Color.green);
        }
        else if (comboBox.getSelectedItem().equals("Red")) 
        {
            txtArea.append("Component used: Combo Box" + "\n");
            txtArea.setBackground(Color.red);
        }
    }
}
