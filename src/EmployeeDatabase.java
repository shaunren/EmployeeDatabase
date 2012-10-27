import java.util.*;
import java.io.*;
public class EmployeeDatabase {

        /**
         * @param args
         */
        public static HashTable<Integer, Employee> open (Scanner in) {
                HashTable<Integer, Employee> employees = new HashTable<Integer, Employee>();
                int empNumber;
                String sex, fName, lName, type;
                double deductionsRate;
                while(in.hasNext()){
                        empNumber = in.nextInt();
                        sex = in.next();
                        fName = in.next();
                        lName = in.next();
                        System.out.println(lName);
                        deductionsRate = in.nextDouble();
                        type = in.next();
                        if (type.equals("f")){
                                double annualSalary;
                                annualSalary = in.nextDouble();

                                FullTimeEmployee employee = new FullTimeEmployee(empNumber, sex, fName, lName, annualSalary, deductionsRate);
                                employees.add(empNumber, employee);
                        }
                        else if (type.equals("p")){
                                double hourlyWage, hoursWorkedPerWeek;
                                int weeksPerYear;
                                hourlyWage = in.nextDouble();
                                hoursWorkedPerWeek = in.nextDouble();
                                weeksPerYear = in.nextInt();
                                PartTimeEmployee employee = new PartTimeEmployee(empNumber,sex, fName, lName, hourlyWage, deductionsRate, hoursWorkedPerWeek, weeksPerYear);
                                employees.add(empNumber, employee);
                        }


                }
                return employees;
        }

        public static HashTable<Integer, Employee> add(HashTable<Integer, Employee> employees, Scanner stdIn, Random rand){
                int empNumber;
                String sex, fName, lName;
                String type;
                double deductionsRate;
                do {
                        empNumber = rand.nextInt(999999);

                } while(employees.contains(empNumber));
                System.out.print("What is the employee's gender (m for male, f for female): ");
                sex = stdIn.nextLine();
                System.out.print("What is the first name: ");
                fName = stdIn.nextLine();
                System.out.print("What is the last name: ");
                lName = stdIn.nextLine();
                System.out.print("Fulltime(f) or parttime(p): ");
                type = stdIn.nextLine();
                System.out.print("Employee's deductions rate (percentage): ");
                deductionsRate = stdIn.nextDouble();               
                if (type.equals("f")){
                        double yearlySalary;
                        System.out.print("What is the yearly salary?: ");
                        yearlySalary = stdIn.nextDouble();
                        FullTimeEmployee employee = new FullTimeEmployee(empNumber, sex, fName, lName, yearlySalary, deductionsRate);
                        employees.add(empNumber, employee);
                }
                else if (type.equals("p")){
                        double hourlyWage;
                        int hoursPerWeek, weeksPerYear;
                        System.out.print("What is the hourly wage?");
                        hourlyWage = stdIn.nextDouble();
                        System.out.print("What is the hours per week?");
                        hoursPerWeek = stdIn.nextInt();
                        System.out.print("How many weeks is worked per year?");
                        weeksPerYear = stdIn.nextInt();
                        PartTimeEmployee employee = new PartTimeEmployee(empNumber, sex, fName, lName, hourlyWage, deductionsRate, hoursPerWeek, weeksPerYear);
                        employees.add(empNumber, employee);

                }
                System.out.println("The randomly generated employee number was " + empNumber);
                return employees;


        }

        public static HashTable<Integer, Employee> remove(HashTable<Integer, Employee> employees, Scanner stdIn){
            System.out.print("What is the employee's number to be removed?: ");
            int empNumber = stdIn.nextInt();
            if(employees.contains(empNumber)){
                employees.remove(empNumber);
                System.out.println("Employee found and removed.");
            }
            else System.out.println("Key not found");
            return employees;
            
        }
        public static void main(String[] args) throws IOException  {
                Scanner stdIn = new Scanner(System.in);
                System.out.println("What is the filename to opened and archived to?");
                String fileName = stdIn.nextLine();
                Scanner inFile;
                try {
                        inFile = new Scanner(new FileReader (fileName));

                } catch (FileNotFoundException e) {
                        File newFile = new File(fileName);
                        newFile.createNewFile();
                        inFile = new Scanner(new FileReader (newFile));
                }

                String inString;
                HashTable<Integer, Employee> employees = open(inFile);
                Random rand = new Random();

                while(true){
                        inString = stdIn.nextLine();
                        if (inString.equals("add")) 
                            employees = add(employees, stdIn, rand);
                        else if(inString.equals("remove"))
                            employees = remove(employees, stdIn);
                        
                }
        }


}

abstract class Employee{
        protected int empNumber;
        protected String sex, fName, lName;
        protected double deductionsRate;

}
class FullTimeEmployee extends Employee{
        private double yearlySalary, netYearlySalary;
        public FullTimeEmployee(int empNumber, String sex, String fName, String lName, double yearlySalary, double deductionsRate){
                this.empNumber = empNumber;
                this.sex = sex;
                this.fName = fName;
                this.lName = lName;
                this.yearlySalary = yearlySalary;
                this.deductionsRate = deductionsRate;
                netYearlySalary = ((1-deductionsRate/100)*yearlySalary);
        }


}
class PartTimeEmployee extends Employee{
        private double hourlyWage, hrsPerWeek, weeksPerYear, annualGrossPay, annualNetPay;
        public PartTimeEmployee(int empNumber, String sex, String fName, String lName, double hourlyWage, double deductionsRate, double hrsPerWeek, int weeksPerYear){
                this.empNumber = empNumber;
                this.sex = sex;
                this.fName = fName;
                this.lName = lName;
                this.hourlyWage = hourlyWage;
                this.deductionsRate = deductionsRate;
                this.hrsPerWeek = hrsPerWeek;
                this.weeksPerYear = weeksPerYear;
                annualGrossPay = hourlyWage*hrsPerWeek*weeksPerYear;
                annualNetPay = (1-deductionsRate/100)*annualGrossPay;


        }

}