/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesdatabase;

public class PartTimeEmployee extends Employee {

    private double hourlyWage, hrsPerWeek, annualGrossPay, annualNetPay;
    private int weeksPerYear;

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public void setHrsPerWeek(double hrsPerWeek) {
        this.hrsPerWeek = hrsPerWeek;
    }

    public void setAnnualGrossPay(double annualGrossPay) {
        this.annualGrossPay = annualGrossPay;
    }

    public void setAnnualNetPay(double annualNetPay) {
        this.annualNetPay = annualNetPay;
    }

    public void setWeeksPerYear(int weeksPerYear) {
        this.weeksPerYear = weeksPerYear;
    }

    public double getAnnualGrossPay() {
        return hourlyWage * hrsPerWeek * weeksPerYear;
    }

    public double getAnnualNetPay() {
        return (1 - deductionsRate / 100) * (hourlyWage * hrsPerWeek * weeksPerYear);
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

    public PartTimeEmployee(int empNumber, boolean sex, String fName, String lName, double hourlyWage, double deductionsRate, double hrsPerWeek, int weeksPerYear) {
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
    public PartTimeEmployee(int empNumber){
            this.empNumber = empNumber;
            this.sex = true;
    }
}