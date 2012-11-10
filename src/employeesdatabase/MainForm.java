/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesdatabase;

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

    public static void archive(HashTable<Integer, Employee> employees, HashSet<Integer> usedEmployeeNums, PrintWriter out) {
        for (int i : usedEmployeeNums) {
            if (employees.contains(i)) {
                Employee e = employees.get(i);
                out.print(e.getEmpNumber() + " ");
                out.print(e.getSex() + "  ");
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

    public static HashTable<Integer, Employee> open(Scanner in, HashSet<Integer> usedEmployeeNums, JList listEmployees, DefaultListModel listModel) {
        
        HashTable<Integer, Employee> employees = new HashTable<>();
        int empNumber;
        String sex, fName, lName, type;
        double deductionsRate;
        int i=0;
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

                FullTimeEmployee employee = new FullTimeEmployee(empNumber, sex, fName, lName, annualSalary, deductionsRate);
                employees.add(empNumber, employee);
            } else if (type.equals("p")) {
                double hourlyWage, hoursWorkedPerWeek;
                int weeksPerYear;
                hourlyWage = in.nextDouble();
                hoursWorkedPerWeek = in.nextDouble();
                weeksPerYear = in.nextInt();
                PartTimeEmployee employee = new PartTimeEmployee(empNumber, sex, fName, lName, hourlyWage, deductionsRate, hoursWorkedPerWeek, weeksPerYear);
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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listEmployees = new javax.swing.JList();
        maleRadio = new javax.swing.JRadioButton();
        femaleRadio = new javax.swing.JRadioButton();
        firstNameBox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        partTimeRadio = new javax.swing.JRadioButton();
        fullTimeRadio = new javax.swing.JRadioButton();
        lastNameBox = new javax.swing.JTextField();
        deductionsRateBox = new javax.swing.JTextField();
        hourlyWageLabel = new javax.swing.JLabel();
        hoursWorkedLabel = new javax.swing.JLabel();
        weeksWorkedLabel = new javax.swing.JLabel();
        grossAnnualSalaryLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        hourlyWageBox = new javax.swing.JTextField();
        hoursWorkedBox = new javax.swing.JTextField();
        weeksWorkedBox = new javax.swing.JTextField();
        grossSalaryBox = new javax.swing.JTextField();
        netSalaryBox = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newFile = new javax.swing.JMenuItem();
        openFile = new javax.swing.JMenuItem();
        saveFile = new javax.swing.JMenuItem();
        exitForm = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EmployeeDatabase");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButton1.setText("Set");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        listEmployees.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listEmployeesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listEmployees);

        sexGroup.add(maleRadio);
        maleRadio.setText("Male");

        sexGroup.add(femaleRadio);
        femaleRadio.setText("Female");
        femaleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioActionPerformed(evt);
            }
        });

        firstNameBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("First Name:");

        jLabel2.setText("Last Name:");

        jLabel3.setText("Deductions Rate:");

        typeGroup.add(partTimeRadio);
        partTimeRadio.setText("Part Time");

        typeGroup.add(fullTimeRadio);
        fullTimeRadio.setText("Full Time");

        hourlyWageLabel.setText("Hourly Wage: ");

        hoursWorkedLabel.setText("Hours per Week: ");

        weeksWorkedLabel.setText("Weeks per Year: ");

        grossAnnualSalaryLabel.setText("Gross Annual Salary:");

        jLabel8.setText("Net Annual Salary:");

        hourlyWageBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hourlyWageBoxActionPerformed(evt);
            }
        });

        hoursWorkedBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoursWorkedBoxActionPerformed(evt);
            }
        });

        weeksWorkedBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weeksWorkedBoxActionPerformed(evt);
            }
        });

        grossSalaryBox.setEditable(false);
        grossSalaryBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grossSalaryBoxActionPerformed(evt);
            }
        });

        netSalaryBox.setEditable(false);
        netSalaryBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netSalaryBoxActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        newFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newFile.setText("New");
        newFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileActionPerformed(evt);
            }
        });
        jMenu1.add(newFile);

        openFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openFile.setText("Open");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        jMenu1.add(openFile);

        saveFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveFile.setText("Save As");
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
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(grossAnnualSalaryLabel)
                            .addComponent(weeksWorkedLabel)
                            .addComponent(hoursWorkedLabel)
                            .addComponent(hourlyWageLabel)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(femaleRadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maleRadio))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lastNameBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(hoursWorkedBox, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(weeksWorkedBox, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(grossSalaryBox, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(netSalaryBox, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(deductionsRateBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hourlyWageBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(partTimeRadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fullTimeRadio))
                            .addComponent(firstNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(108, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(163, 163, 163))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(firstNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lastNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(deductionsRateBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maleRadio)
                            .addComponent(femaleRadio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(partTimeRadio)
                            .addComponent(fullTimeRadio))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hourlyWageLabel)
                            .addComponent(hourlyWageBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hoursWorkedLabel)
                            .addComponent(hoursWorkedBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(weeksWorkedLabel)
                            .addComponent(weeksWorkedBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(grossAnnualSalaryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grossSalaryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(netSalaryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        femaleRadio.getAccessibleContext().setAccessibleName("Onna");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileActionPerformed
        jButton1.setText("av");        // TODO add your handling code here:
    }//GEN-LAST:event_newFileActionPerformed
    DefaultListModel listModel = new DefaultListModel();
    HashSet<Integer> usedEmployeeNums = new HashSet<>(); 
    Scanner fileIn = null;
    String fileName = null;
    File file = null;
    PrintWriter fileOut = null;
    HashTable<Integer, Employee> employees = null;
    DefaultButtonModel sexButtonModel = new DefaultButtonModel(); 

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            setTitle("EmployeeDatabase (" + file.getName() + ")");
            try {
                fileIn = new Scanner(file);
                employees = open(fileIn, usedEmployeeNums, listEmployees, listModel);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (fileIn != null) {
                    fileIn.close();
                }
            }

            System.out.println(file.getPath());
        } else {
            // TODO remove av    
            System.out.println("AV");
        }

    }//GEN-LAST:event_openFileActionPerformed

    private void exitFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitFormActionPerformed

    }//GEN-LAST:event_exitFormActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
                if (file != null) {
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();

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

                System.out.println(file.getPath());
            } else {
                System.out.println("AV");
            }
        }
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (file != null) {
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();

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

                System.out.println(file.getPath());
            } else {
                System.out.println("AV");
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void femaleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleRadioActionPerformed

    private void listEmployeesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listEmployeesValueChanged
        Employee used = employees.get((Integer)listEmployees.getSelectedValue());
        firstNameBox.setText(used.getfName());
        lastNameBox.setText(used.getlName());
    
        deductionsRateBox.setText(Double.toString(used.getDeductionsRate()));
        
        String sex = used.getSex();
        if(sex.charAt(0) == 'm'){
            femaleRadio.setSelected(false);
            maleRadio.setSelected(true);
        }
        else {
            femaleRadio.setSelected(true);
            maleRadio.setSelected(false);
        }
        if(used instanceof PartTimeEmployee){
            partTimeRadio.setSelected(true);
            fullTimeRadio.setSelected(false);
            hourlyWageLabel.setText("Hourly Wage: ");
            hoursWorkedLabel.setText("Hours per Week: ");
            weeksWorkedLabel.setText("Weeks per Year: ");
            hourlyWageBox.setVisible(true);
            hoursWorkedBox.setVisible(true);
            weeksWorkedBox.setVisible(true);
            grossSalaryBox.setEditable(true);
            hourlyWageBox.setText(Double.toString(((PartTimeEmployee)used).getHourlyWage()));
            hoursWorkedBox.setText(Double.toString(((PartTimeEmployee)used).getHrsPerWeek()));
            weeksWorkedBox.setText(Integer.toString(((PartTimeEmployee)used).getWeeksPerYear()));
            grossSalaryBox.setText(Double.toString(((PartTimeEmployee)used).getAnnualGrossPay()));
            netSalaryBox.setText(Double.toString(((PartTimeEmployee)used).getAnnualNetPay()));
        }
        else {
            
            partTimeRadio.setSelected(false);
            fullTimeRadio.setSelected(true);
            hourlyWageLabel.setText("");
            hoursWorkedLabel.setText("");
            weeksWorkedLabel.setText("");
            hourlyWageBox.setVisible(false);
            hoursWorkedBox.setVisible(false);
            weeksWorkedBox.setVisible(false);
            grossSalaryBox.setEditable(true);
            grossSalaryBox.setText(Double.toString(((FullTimeEmployee)used).getYearlySalary()));
            netSalaryBox.setText(Double.toString(((FullTimeEmployee)used).getNetYearlySalary()));
            
        }
        
            
        
        
    }//GEN-LAST:event_listEmployeesValueChanged

    private void firstNameBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameBoxActionPerformed

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
                if (file != null) {
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();

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

                System.out.println(file.getPath());
            } else {
                System.out.println("AV");
            }
        }


    }//GEN-LAST:event_saveFileActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void hourlyWageBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hourlyWageBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hourlyWageBoxActionPerformed

    private void hoursWorkedBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoursWorkedBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hoursWorkedBoxActionPerformed

    private void weeksWorkedBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weeksWorkedBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_weeksWorkedBoxActionPerformed

    private void grossSalaryBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grossSalaryBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grossSalaryBoxActionPerformed

    private void netSalaryBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netSalaryBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_netSalaryBoxActionPerformed

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
    private javax.swing.JTextField deductionsRateBox;
    private javax.swing.JMenuItem exitForm;
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField lastNameBox;
    private javax.swing.JList listEmployees;
    private javax.swing.JRadioButton maleRadio;
    private javax.swing.JTextField netSalaryBox;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JRadioButton partTimeRadio;
    private javax.swing.JMenuItem saveFile;
    private javax.swing.ButtonGroup sexGroup;
    private javax.swing.ButtonGroup typeGroup;
    private javax.swing.JTextField weeksWorkedBox;
    private javax.swing.JLabel weeksWorkedLabel;
    // End of variables declaration//GEN-END:variables
}
abstract class Employee {

    protected int empNumber;
    protected String sex, fName, lName;
    protected double deductionsRate;

    public double getDeductionsRate() {
        return deductionsRate;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getSex() {
        return sex;
    }
}

class FullTimeEmployee extends Employee {

    public double getNetYearlySalary() {
        return netYearlySalary;
    }
    private double yearlySalary, netYearlySalary;

    public FullTimeEmployee(int empNumber, String sex, String fName, String lName, double yearlySalary, double deductionsRate) {
        this.empNumber = empNumber;
        this.sex = sex;
        this.fName = fName;
        this.lName = lName;

        this.yearlySalary = yearlySalary;
        this.deductionsRate = deductionsRate;
        netYearlySalary = ((1 - deductionsRate / 100) * yearlySalary);
    }

    public double getYearlySalary() {
        return yearlySalary;
    }
}

class PartTimeEmployee extends Employee {

    private double hourlyWage, hrsPerWeek, annualGrossPay, annualNetPay;
    private int weeksPerYear;

    public double getAnnualGrossPay() {
        return annualGrossPay;
    }

    public double getAnnualNetPay() {
        return annualNetPay;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public double getHrsPerWeek() {
        return hrsPerWeek;
    }

    public int getWeeksPerYear() {
        return weeksPerYear;
    }

    public PartTimeEmployee(int empNumber, String sex, String fName, String lName, double hourlyWage, double deductionsRate, double hrsPerWeek, int weeksPerYear) {
        this.empNumber = empNumber;
        this.sex = sex;
        this.fName = fName;
        this.lName = lName;

        this.hourlyWage = hourlyWage;
        this.deductionsRate = deductionsRate;
        this.hrsPerWeek = hrsPerWeek;
        this.weeksPerYear = weeksPerYear;
        annualGrossPay = hourlyWage * hrsPerWeek * weeksPerYear;
        annualNetPay = (1 - deductionsRate / 100) * annualGrossPay;

    }
}