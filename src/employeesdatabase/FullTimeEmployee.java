/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesdatabase;

public class FullTimeEmployee extends Employee {

    public double getNetYearlySalary() {
        return ((1 - deductionsRate / 100) * yearlySalary);
    }
    private double yearlySalary, netYearlySalary;

    public FullTimeEmployee(int empNumber, boolean sex, String fName, String lName, double yearlySalary, double deductionsRate) {
        this.empNumber = empNumber;
        this.sex = sex;
        this.fName = fName;
        this.lName = lName;

        this.yearlySalary = yearlySalary;
        this.deductionsRate = deductionsRate;
        netYearlySalary = ((1 - deductionsRate / 100) * yearlySalary);
    }
    
    public FullTimeEmployee(int empNumber){
            this.empNumber = empNumber;
            this.sex = true;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }
}
