/**
 *
 * Author: Bradley van der Westhuizen (217218903)
 * Date: 11 April 2019
 */
package prac8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;
import javafx.scene.layout.Pane;
import javax.swing.*;


public class GUI extends JFrame implements ActionListener
{
    private JTextField text1 = new JTextField(10);
    private JLabel lable1 = new JLabel("Enter the First number: ");
    private JTextField text2 = new JTextField(10);
    private JLabel lable2 = new JLabel("Enter the second number: ");
    private JTextField text3 = new JTextField(10);
    private JLabel lable3 = new JLabel("Result: ");
    private JButton sumBtn = new JButton("Add");
    private JButton subtractBtn = new JButton("Subtract");
    private JButton multiplyBtn = new JButton("Multiply");
    private JButton redBtn = new JButton("Red");
    private JButton blueBtn = new JButton("Blue");
    private JButton greenBtn = new JButton("Green");
    private JButton resetBtn = new JButton("Reset");
    private JPanel panel = new JPanel(new BorderLayout());
    private JPanel panelNum1 = new JPanel(new BorderLayout());
    private JPanel panelNum2 = new JPanel(new BorderLayout());
    private JPanel panelTop = new JPanel();
    private JPanel panelCenter = new JPanel();
    private JPanel panelBottom = new JPanel();
    private JPanel panelSum = new JPanel(new BorderLayout());
    private JPanel panelBtn = new JPanel();
    private int num1, num2, ans;
    
    public GUI()
    {
        panelNum1.add(lable1, BorderLayout.CENTER);
        panelNum1.add(text1, BorderLayout.SOUTH);
        panelTop.add(panelNum1);
        
        
        panelNum2.add(lable2, BorderLayout.CENTER);
        panelNum2.add(text2, BorderLayout.SOUTH);
        panelTop.add(panelNum2);
        panel.add(panelTop, BorderLayout.NORTH);
        
        panelSum.add(lable3, BorderLayout.CENTER);
        panelSum.add(text3, BorderLayout.SOUTH);
        text3.setEnabled(false);
        panelCenter.add(panelSum);
        
        panelBtn.add(sumBtn, BorderLayout.NORTH);
        panelBtn.add(subtractBtn, BorderLayout.CENTER);
        panelBtn.add(multiplyBtn, BorderLayout.SOUTH);
        panelCenter.add(panelBtn);
        panel.add(panelCenter, BorderLayout.CENTER);
        
        
        panelBottom.add(redBtn);
        panelBottom.add(blueBtn);
        panelBottom.add(greenBtn);
        panelBottom.add(resetBtn);
        panel.add(panelBottom, BorderLayout.SOUTH);
        
        this.add(panel);
        sumBtn.addActionListener(this);
        subtractBtn.addActionListener(this);
        multiplyBtn.addActionListener(this);
        redBtn.addActionListener(this);
        blueBtn.addActionListener(this);
        greenBtn.addActionListener(this);
        resetBtn.addActionListener(this);
    }
    public void convertToInt()
    {
        num1 = Integer.parseInt(text1.getText());
        num2 = Integer.parseInt(text2.getText());
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == sumBtn) 
        {
            convertToInt();
            int addition = num1 + num2;
            text3.setText(Integer.toString(addition));
        }
        else if (e.getSource() == subtractBtn) 
        {
            convertToInt();
            int subtraction = num1 - num2;
            text3.setText(Integer.toString(subtraction));
        }
        else if (e.getSource() == multiplyBtn) 
        {
            convertToInt();
            int product = num1 * num2;
            text3.setText(Integer.toString(product));
        }
        else if (e.getSource() == redBtn) 
        {
            JOptionPane.showMessageDialog(GUI.this, "The Red button was clicked", "Message", JOptionPane.INFORMATION_MESSAGE);
            text3.setBackground(Color.red);
        }
        else if (e.getSource() == blueBtn) 
        {
            JOptionPane.showMessageDialog(GUI.this, "The Blue button was clicked", "Message", JOptionPane.INFORMATION_MESSAGE);
            text3.setBackground(Color.blue);
            text3.setForeground(Color.white);
        }
        else if (e.getSource() == greenBtn) 
        {
            JOptionPane.showMessageDialog(GUI.this, "The Green button was clicked", "Message", JOptionPane.INFORMATION_MESSAGE);
            text3.setBackground(Color.green);
        }
        else if (e.getSource() == resetBtn) 
        {
            text1.setText("");
            text2.setText("");
            text3.setText("");
            text3.setBackground(Color.white);
        }
    }
}
