/** RunStudRegGui.java
 * This is the GUI interface
 * Author: Bradley van der Westhuizen (217218903
 * Date: 18 April 2019
 */
package runstudreggui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.html.parser.DTDConstants;

public class StudRegGui extends JFrame implements ActionListener, ItemListener
{
    private JMenuBar menuBar = new JMenuBar();
    private JMenu file = new JMenu("File");
    private JMenuItem add = new JMenuItem("Add");
    private JMenuItem sort = new JMenuItem("Sort");
    private JMenuItem display = new JMenuItem("Display");
    
    private JLabel iDLabel = new JLabel("ID:");
    private JTextField iDTextField = new JTextField(10);
    private JLabel surnameLabel = new JLabel("Surname:");
    private JTextField surnameTextField = new JTextField(10);
    
    private JLabel qualificationLabel = new JLabel("Qualification:");
    private String[] qualifications = {"NDIPIT", "NCINT", "NDINFT", "None"};
    private JComboBox qualificationComboBox = new JComboBox(qualifications);
    private JLabel feeLabel = new JLabel("Fee:");
    private JTextField feeTextField = new JTextField(10);
    
    private JButton addBtn = new JButton("ADD");
    private JButton sortBtn = new JButton("SORT");
    private JButton displayBtn = new JButton("DISPLAY");
    
    private JPanel mainPanel = new JPanel(new BorderLayout());
    private JPanel mainMiddlePanel = new JPanel(new BorderLayout());
    
    private JPanel studentPanel = new JPanel(new BorderLayout());
    private JPanel studentLeftPanel = new JPanel(new BorderLayout(50, 0));
    private JPanel studentRightPanel = new JPanel(new BorderLayout(20, 0));
    
    private JPanel graduatePanel = new JPanel(new BorderLayout());
    private JPanel graduateLeftPanel = new JPanel(new BorderLayout(20, 0));
    private JPanel graduateRightPanel = new JPanel(new BorderLayout(35, 0));
    
    private JPanel operationsPanel = new JPanel();
    
    private ArrayList graduateArrayList = new ArrayList();
    
    private DefaultListModel<String> listModel = new DefaultListModel();
    
    private JList<String> graduates = new JList(listModel);
    
    
    public StudRegGui()
    {
        this.setJMenuBar(menuBar);
        menuBar.add(file);
        file.add(add);
        file.add(sort);
        file.add(display);
        
        studentLeftPanel.add(iDLabel, BorderLayout.WEST);
        studentLeftPanel.add(iDTextField, BorderLayout.EAST);
        studentPanel.add(studentLeftPanel, BorderLayout.WEST);
        
        studentRightPanel.add(surnameLabel, BorderLayout.WEST);
        studentRightPanel.add(surnameTextField, BorderLayout.EAST);
        studentPanel.add(studentRightPanel, BorderLayout.EAST);
        
        studentPanel.setBorder(BorderFactory.createTitledBorder("STUDENT"));
        mainPanel.add(studentPanel, BorderLayout.NORTH);
        
        graduateLeftPanel.add(qualificationLabel, BorderLayout.WEST);
        graduateLeftPanel.add(qualificationComboBox, BorderLayout.EAST);
        graduatePanel.add(graduateLeftPanel, BorderLayout.WEST);
        
        graduateRightPanel.add(feeLabel, BorderLayout.WEST);
        graduateRightPanel.add(feeTextField, BorderLayout.EAST);
        graduatePanel.add(graduateRightPanel, BorderLayout.EAST);
        
        graduatePanel.setBorder(BorderFactory.createTitledBorder("GRADUATE"));
        mainMiddlePanel.add(graduatePanel, BorderLayout.CENTER);       
        
        addBtn.setPreferredSize(new Dimension(140, 30));
        sortBtn.setPreferredSize(new Dimension(140, 30));
        displayBtn.setPreferredSize(new Dimension(140, 30));
        
        operationsPanel.add(addBtn);
        operationsPanel.add(sortBtn);
        operationsPanel.add(displayBtn);
        
        operationsPanel.setBorder(BorderFactory.createTitledBorder("OPERATIONS"));
        mainMiddlePanel.add(operationsPanel, BorderLayout.SOUTH);
        
        mainPanel.add(mainMiddlePanel, BorderLayout.CENTER);
        
        
        mainPanel.add(new JScrollPane(graduates), BorderLayout.SOUTH);
        
        addBtn.addActionListener(this);
        sortBtn.addActionListener(this);
        displayBtn.addActionListener(this);
        qualificationComboBox.addItemListener(this);
        add.addActionListener(this);
        sort.addActionListener(this);
        display.addActionListener(this);
        
        this.add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == addBtn) 
        {
            graduateArrayList.add(new Graduate(iDTextField.getText(), surnameTextField.getText(), 100, qualificationComboBox.getSelectedItem().toString(), Integer.parseInt(feeTextField.getText()))); 
        }
        else if (e.getSource() == sortBtn)
        {
            Collections.sort(graduateArrayList, new SortList());
        }
        else if (e.getSource() == displayBtn)
        {
            listModel.removeAllElements();
            for (int i = 0; i < graduateArrayList.size(); i++) 
            {
                listModel.addElement(graduateArrayList.get(i).toString());
            }
        }
        else if (e.getSource() == add)
        {
            graduateArrayList.add(new Graduate(iDTextField.getText(), surnameTextField.getText(), 100, qualificationComboBox.getSelectedItem().toString(), Integer.parseInt(feeTextField.getText())));
        }
        else if (e.getSource() == sort)
        {
            Collections.sort(graduateArrayList, new SortList());
        }
        else if (e.getSource() == display)
        {
            listModel.removeAllElements();
            for (int i = 0; i < graduateArrayList.size(); i++) 
            {
                listModel.addElement(graduateArrayList.get(i).toString());
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) 
    {
        if (e.getStateChange() == ItemEvent.SELECTED) 
        {
            if (qualificationComboBox.getSelectedItem().equals("NDIPIT"))
            {
                JOptionPane.showMessageDialog(this, "National Diploma in Information Technology", "Qualification", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (qualificationComboBox.getSelectedItem().equals("NCINT"))
            {
                JOptionPane.showMessageDialog(this, "National Certificate in Information Technology", "Qualification", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (qualificationComboBox.getSelectedItem().equals("NDINFT"))
            {
                JOptionPane.showMessageDialog(this, "National Diploma in Information Technology", "Qualification", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (qualificationComboBox.getSelectedItem().equals("None"))
            {
                JOptionPane.showMessageDialog(this, "No qualification was selected", "Qualification", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    private static class SortList implements Comparator<Graduate>
    {
        @Override
        public int compare(Graduate graduate1, Graduate graduate2) 
        {
            return graduate1.getName().compareTo(graduate2.getName());
        }
    }
}
