/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesdatabase;

import java.awt.Component;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author 544304
 */
public class MainForm extends javax.swing.JFrame {

    DefaultListModel listModel = new DefaultListModel();
    HashSet<Integer> usedEmployeeNums = new HashSet<>();
    File file = new File("database.txt");
    HashTable<Integer, Employee> employees = new HashTable<>();
    Random r = new Random();
        
    public static void archive(HashTable<Integer, Employee> employees, HashSet<Integer> usedEmployeeNums, PrintWriter out) {
        for (int i : usedEmployeeNums) {
            if (employees.contains(i)) {
                Employee e = employees.get(i);
                out.print(e.getEmpNumber() + " ");
                out.print(e.getSex() ? "f " : "m ");
                out.print(e.getfName() + " ");
                out.print(e.getlName() + " ");
                out.print(e.getDeductionsRate() + " ");
                if (e instanceof FullTimeEmployee) {
                    FullTimeEmployee fte = (FullTimeEmployee) (e);
                    out.print("f");
                    out.println();
                    out.print(fte.getYearlySalary());
                } else if (e instanceof PartTimeEmployee) {

                    PartTimeEmployee fte = (PartTimeEmployee) (e);
                    out.print("p");
                    out.println();
                    out.print(fte.getHourlyWage() + " ");
                    out.print(fte.getHrsPerWeek() + " ");
                    out.print(fte.getWeeksPerYear() + " ");
                }
                out.println();
                out.println();
            }
        }

    }

    public HashTable<Integer, Employee> open(Scanner in) {

        HashTable<Integer, Employee> employees = new HashTable<>();
        int empNumber;
        String sex, fName, lName, type;
        double deductionsRate;
        int i = 0;
        while (in.hasNext()) {

            empNumber = in.nextInt();

            usedEmployeeNums.add(empNumber);
            listModel.add(i++, empNumber);
            sex = in.next();
            fName = in.next();

            lName = in.next();
            deductionsRate = in.nextDouble();
            type = in.next();
            if (type.equals("f")) {
                double annualSalary;
                annualSalary = in.nextDouble();

                FullTimeEmployee employee = new FullTimeEmployee(empNumber, sex.equals("f"), fName, lName, annualSalary, deductionsRate);
                employees.add(empNumber, employee);
            } else if (type.equals("p")) {
                double hourlyWage, hoursWorkedPerWeek;
                int weeksPerYear;
                hourlyWage = in.nextDouble();
                hoursWorkedPerWeek = in.nextDouble();
                weeksPerYear = in.nextInt();
                PartTimeEmployee employee = new PartTimeEmployee(empNumber, sex.equals("f"), fName, lName, hourlyWage, deductionsRate, hoursWorkedPerWeek, weeksPerYear);
                employees.add(empNumber, employee);
            }


        }
        listEmployees.setModel(listModel);
        return employees;
    }

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jSplitPane1 = new javax.swing.JSplitPane();
        sexGroup = new javax.swing.ButtonGroup();
        typeGroup = new javax.swing.ButtonGroup();
        applyButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listEmployees = new javax.swing.JList();
        maleRadio = new javax.swing.JRadioButton();
        femaleRadio = new javax.swing.JRadioButton();
        firstNameBox = new javax.swing.JTextField();
        fNameLabel = new javax.swing.JLabel();
        lNameLabel = new javax.swing.JLabel();
        deductionsRateLabel = new javax.swing.JLabel();
        partTimeRadio = new javax.swing.JRadioButton();
        fullTimeRadio = new javax.swing.JRadioButton();
        lastNameBox = new javax.swing.JTextField();
        deductionsRateBox = new javax.swing.JTextField();
        hourlyWageLabel = new javax.swing.JLabel();
        hoursWorkedLabel = new javax.swing.JLabel();
        weeksWorkedLabel = new javax.swing.JLabel();
        grossAnnualSalaryLabel = new javax.swing.JLabel();
        netAnnualSalaryLabel = new javax.swing.JLabel();
        hourlyWageBox = new javax.swing.JTextField();
        hoursWorkedBox = new javax.swing.JTextField();
        weeksWorkedBox = new javax.swing.JTextField();
        grossSalaryBox = new javax.swing.JTextField();
        netSalaryBox = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newFile = new javax.swing.JMenuItem();
        saveFile = new javax.swing.JMenuItem();
        exitForm = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        addItem = new javax.swing.JMenuItem();
        removeItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EmployeeDatabase");
        setMinimumSize(new java.awt.Dimension(470, 430));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        applyButton.setText("Apply");
        applyButton.setEnabled(false);
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(applyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 336, -1, -1));

        listEmployees.setModel(listModel);
        listEmployees.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listEmployeesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listEmployees);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 22, 64, 337));

        sexGroup.add(maleRadio);
        maleRadio.setText("Male");
        maleRadio.setEnabled(false);
        getContentPane().add(maleRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 111, -1, -1));

        sexGroup.add(femaleRadio);
        femaleRadio.setText("Female");
        femaleRadio.setEnabled(false);
        getContentPane().add(femaleRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 111, -1, -1));
        femaleRadio.getAccessibleContext().setAccessibleName("Onna");

        firstNameBox.setEnabled(false);
        getContentPane().add(firstNameBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 22, 80, -1));

        fNameLabel.setText("First Name:");
        fNameLabel.setEnabled(false);
        getContentPane().add(fNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 25, -1, -1));

        lNameLabel.setText("Last Name:");
        lNameLabel.setEnabled(false);
        getContentPane().add(lNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 49, -1, -1));

        deductionsRateLabel.setText("Deductions Rate:");
        deductionsRateLabel.setEnabled(false);
        getContentPane().add(deductionsRateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 75, -1, -1));

        typeGroup.add(partTimeRadio);
        partTimeRadio.setText("Part Time");
        partTimeRadio.setEnabled(false);
        partTimeRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partTimeRadioActionPerformed(evt);
            }
        });
        getContentPane().add(partTimeRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));

        typeGroup.add(fullTimeRadio);
        fullTimeRadio.setText("Full Time");
        fullTimeRadio.setEnabled(false);
        fullTimeRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullTimeRadioActionPerformed(evt);
            }
        });
        getContentPane().add(fullTimeRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, -1, -1));

        lastNameBox.setEnabled(false);
        getContentPane().add(lastNameBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 46, 80, -1));

        deductionsRateBox.setEnabled(false);
        getContentPane().add(deductionsRateBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 72, 80, -1));

        hourlyWageLabel.setText("Hourly Wage: ");
        hourlyWageLabel.setEnabled(false);
        getContentPane().add(hourlyWageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        hoursWorkedLabel.setText("Hours per Week: ");
        hoursWorkedLabel.setEnabled(false);
        getContentPane().add(hoursWorkedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, -1, -1));

        weeksWorkedLabel.setText("Weeks per Year: ");
        weeksWorkedLabel.setEnabled(false);
        getContentPane().add(weeksWorkedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 222, -1, -1));

        grossAnnualSalaryLabel.setText("Gross Annual Salary:");
        grossAnnualSalaryLabel.setEnabled(false);
        getContentPane().add(grossAnnualSalaryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        netAnnualSalaryLabel.setText("Net Annual Salary:");
        netAnnualSalaryLabel.setEnabled(false);
        getContentPane().add(netAnnualSalaryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        hourlyWageBox.setEnabled(false);
        getContentPane().add(hourlyWageBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 80, -1));

        hoursWorkedBox.setEnabled(false);
        getContentPane().add(hoursWorkedBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 80, -1));

        weeksWorkedBox.setEnabled(false);
        getContentPane().add(weeksWorkedBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 222, 80, -1));

        grossSalaryBox.setEnabled(false);
        getContentPane().add(grossSalaryBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 80, -1));

        netSalaryBox.setEnabled(false);
        getContentPane().add(netSalaryBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 80, -1));

        jMenu1.setText("File");

        newFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employeesdatabase/page.png"))); // NOI18N
        newFile.setText("New");
        newFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileActionPerformed(evt);
            }
        });
        jMenu1.add(newFile);

        saveFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employeesdatabase/page_save.png"))); // NOI18N
        saveFile.setText("Save");
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });
        jMenu1.add(saveFile);

        exitForm.setText("Exit");
        exitForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitFormActionPerformed(evt);
            }
        });
        jMenu1.add(exitForm);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        addItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_INSERT, 0));
        addItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employeesdatabase/add.png"))); // NOI18N
        addItem.setText("Add");
        addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemActionPerformed(evt);
            }
        });
        jMenu2.add(addItem);

        removeItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        removeItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employeesdatabase/delete.png"))); // NOI18N
        removeItem.setText("Delete");
        removeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemActionPerformed(evt);
            }
        });
        jMenu2.add(removeItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileActionPerformed
        employees = new HashTable<>();
        usedEmployeeNums = new HashSet<>();
    }//GEN-LAST:event_newFileActionPerformed

    private void saveFile() {
        PrintWriter fileOut = null;
        try {
            fileOut = new PrintWriter(new FileWriter(file));

            archive(employees, usedEmployeeNums, fileOut);
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fileOut != null) {
                fileOut.close();
            }
        }
    }
    private void exitFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitFormActionPerformed
        saveFile();
        System.exit(0);
    }//GEN-LAST:event_exitFormActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        saveFile();
    }//GEN-LAST:event_formWindowClosing

    private void listEmployeesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listEmployeesValueChanged
        for (Component i : getContentPane().getComponents()) {
            if (i != listEmployees) {
                i.setEnabled(listEmployees.getSelectedValue() != null);
            }
        }

        if (listEmployees.getSelectedValue() != null) {
            partTimeRadio.setSelected(false);
            fullTimeRadio.setSelected(false);
            Employee used = employees.get((Integer) listEmployees.getSelectedValue());
            firstNameBox.setText(used.getfName());
            lastNameBox.setText(used.getlName());

            deductionsRateBox.setText(String.format("%.2f", used.getDeductionsRate()));

            femaleRadio.setSelected(used.getSex());
            maleRadio.setSelected(!used.getSex());

            if (used instanceof PartTimeEmployee) {
                partTimeRadio.setSelected(true);
                fullTimeRadio.setSelected(false);
                hourlyWageLabel.setText("Hourly Wage: ");
                hoursWorkedLabel.setText("Hours per Week: ");
                weeksWorkedLabel.setText("Weeks per Year: ");
                hourlyWageBox.setVisible(true);
                hoursWorkedBox.setVisible(true);
                weeksWorkedBox.setVisible(true);
                grossSalaryBox.setEditable(false);
                hourlyWageBox.setText(String.format("%.2f", ((PartTimeEmployee) used).getHourlyWage()));
                hoursWorkedBox.setText(Double.toString(((PartTimeEmployee) used).getHrsPerWeek()));
                weeksWorkedBox.setText(Integer.toString(((PartTimeEmployee) used).getWeeksPerYear()));
                grossSalaryBox.setText(String.format("%.2f", ((PartTimeEmployee) used).getAnnualGrossPay()));
                netSalaryBox.setText(String.format("%.2f", ((PartTimeEmployee) used).getAnnualNetPay()));
            } else {
                partTimeRadio.setSelected(false);
                fullTimeRadio.setSelected(true);
                hourlyWageLabel.setText("");
                hoursWorkedLabel.setText("");
                weeksWorkedLabel.setText("");
                hourlyWageBox.setVisible(false);
                hoursWorkedBox.setVisible(false);
                weeksWorkedBox.setVisible(false);
                grossSalaryBox.setEditable(true);
                grossSalaryBox.setText(String.format("%.2f", ((FullTimeEmployee) used).getYearlySalary()));
                netSalaryBox.setText(String.format("%.2f", ((FullTimeEmployee) used).getNetYearlySalary()));
            }
        } else {
        }




    }//GEN-LAST:event_listEmployeesValueChanged

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
        saveFile();
    }//GEN-LAST:event_saveFileActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        Employee used = employees.get((Integer) listEmployees.getSelectedValue());
        used.setfName(firstNameBox.getText());
        used.setlName(lastNameBox.getText());
        used.setSex(femaleRadio.isSelected());
        used.setDeductionsRate(Double.parseDouble(deductionsRateBox.getText()));
        if (used instanceof PartTimeEmployee) {
            ((PartTimeEmployee) used).setHourlyWage(Double.parseDouble(hourlyWageBox.getText()));
            ((PartTimeEmployee) used).setHrsPerWeek(Double.parseDouble(hoursWorkedBox.getText()));
            ((PartTimeEmployee) used).setWeeksPerYear(Integer.parseInt(weeksWorkedBox.getText()));
        } else {

            ((FullTimeEmployee) used).setYearlySalary(Double.parseDouble(grossSalaryBox.getText()));
        }
        int tempIndex = listEmployees.getSelectedIndex();
        listEmployees.clearSelection();
        listEmployees.setSelectedIndex(tempIndex);

    }//GEN-LAST:event_applyButtonActionPerformed

    @SuppressWarnings("empty-statement")
    private void addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemActionPerformed
        int i;
        while (usedEmployeeNums.contains(i = r.nextInt(1000000)));
        usedEmployeeNums.add(i);
        PartTimeEmployee emp = new PartTimeEmployee(i);
        emp.setSex(r.nextBoolean()); // to avoid sexist constructor
        employees.add(i, emp);
        listModel.add(usedEmployeeNums.size() - 1, i);
        listEmployees.setSelectedIndex(usedEmployeeNums.size() - 1);
    }//GEN-LAST:event_addItemActionPerformed

    private void removeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemActionPerformed

        System.out.println(listEmployees.getSelectedValue());
        employees.remove((Integer) listEmployees.getSelectedValue());
        listModel.removeElement(listEmployees.getSelectedValue());

    }//GEN-LAST:event_removeItemActionPerformed

    private void fullTimeRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullTimeRadioActionPerformed
        hourlyWageLabel.setText("");
        hoursWorkedLabel.setText("");
        weeksWorkedLabel.setText("");
        hourlyWageBox.setVisible(false);
        hoursWorkedBox.setVisible(false);
        weeksWorkedBox.setVisible(false);
        grossSalaryBox.setEditable(true);
        grossSalaryBox.setText("0.00");
        netSalaryBox.setText("0.00");
        int key = (int) listEmployees.getSelectedValue();
        employees.replace(key, new FullTimeEmployee(key));
    }//GEN-LAST:event_fullTimeRadioActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Scanner fileIn = null;
        try {
            fileIn = new Scanner(file);
            employees = open(fileIn);
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fileIn != null) {
                fileIn.close();
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void partTimeRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partTimeRadioActionPerformed
        hourlyWageLabel.setText("Hourly Wage: ");
        hoursWorkedLabel.setText("Hours per Week: ");
        weeksWorkedLabel.setText("Weeks per Year: ");
        hourlyWageBox.setVisible(true);
        hoursWorkedBox.setVisible(true);
        weeksWorkedBox.setVisible(true);
        grossSalaryBox.setEditable(false);
        hourlyWageBox.setText("0.00");
        hoursWorkedBox.setText("0");
        weeksWorkedBox.setText("0");
        grossSalaryBox.setText("0.00");
        netSalaryBox.setText("0.00");
        int key = (int) listEmployees.getSelectedValue();
        employees.replace(key, new PartTimeEmployee(key));
    }//GEN-LAST:event_partTimeRadioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new MainForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addItem;
    private javax.swing.JButton applyButton;
    private javax.swing.JTextField deductionsRateBox;
    private javax.swing.JLabel deductionsRateLabel;
    private javax.swing.JMenuItem exitForm;
    private javax.swing.JLabel fNameLabel;
    private javax.swing.JRadioButton femaleRadio;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JTextField firstNameBox;
    private javax.swing.JRadioButton fullTimeRadio;
    private javax.swing.JLabel grossAnnualSalaryLabel;
    private javax.swing.JTextField grossSalaryBox;
    private javax.swing.JTextField hourlyWageBox;
    private javax.swing.JLabel hourlyWageLabel;
    private javax.swing.JTextField hoursWorkedBox;
    private javax.swing.JLabel hoursWorkedLabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lNameLabel;
    private javax.swing.JTextField lastNameBox;
    private javax.swing.JList listEmployees;
    private javax.swing.JRadioButton maleRadio;
    private javax.swing.JLabel netAnnualSalaryLabel;
    private javax.swing.JTextField netSalaryBox;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JRadioButton partTimeRadio;
    private javax.swing.JMenuItem removeItem;
    private javax.swing.JMenuItem saveFile;
    private javax.swing.ButtonGroup sexGroup;
    private javax.swing.ButtonGroup typeGroup;
    private javax.swing.JTextField weeksWorkedBox;
    private javax.swing.JLabel weeksWorkedLabel;
    // End of variables declaration//GEN-END:variables
}
