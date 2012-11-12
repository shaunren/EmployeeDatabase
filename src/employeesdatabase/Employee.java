/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesdatabase;

public abstract class Employee {

    protected int empNumber;
    protected boolean sex; // false is male
    protected String fName, lName;
    protected double deductionsRate;

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setfName(String fName) {
        this.fName = fName.length()>0 ? fName : "null";
    }

    public void setlName(String lName) {
        this.lName = lName.length()>0 ? lName : "null";
    }

    public void setDeductionsRate(double deductionsRate) {
        this.deductionsRate = deductionsRate;
    }

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

    public boolean getSex() {
        return sex;
    }
}
