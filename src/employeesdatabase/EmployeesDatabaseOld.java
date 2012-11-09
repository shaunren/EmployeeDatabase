/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesdatabase;

/**
 *
 * @author 544304
 */

import java.util.*;
import java.io.*;
public class EmployeesDatabaseOld {

	/**
	 * @param args
	 */

	public static void edit(HashTable<Integer, Employee> employees, Scanner stdIn){
		System.out.print("What is the employee number: ");
		int empNumber = Integer.parseInt(stdIn.nextLine());
		if(employees.contains(empNumber)){
			Employee e = employees.get(empNumber);
			Employee replaced;
			System.out.print("First name("+ e.getfName()+"): ");
			
			String newFName = stdIn.next();
			if(newFName.equals("")){
				newFName = e.getfName();
			}
			System.out.print("Last name("+ e.getlName()+"): ");
			String newLName = stdIn.next();
			if(newLName.equals("")){
				newLName = e.getlName();
			}
			System.out.print("Gender(m for male, f for female)("+ e.getSex()+"): ");
			String newSex = stdIn.next();
			if(newSex.equals("")){
				newSex = e.getSex();
			}
			System.out.print("Deductions rate(percentage)("+ e.getDeductionsRate()+"): ");
			String newStringDeductionsRate = stdIn.next();
			double newDeductionsRate;
			if(newStringDeductionsRate.equals("")){
				newDeductionsRate = e.getDeductionsRate();
			}
			else{
				newDeductionsRate = Double.parseDouble(newStringDeductionsRate);
			}
			
		}
	}
	public static void info(HashTable<Integer, Employee> employees, Scanner stdIn){
		System.out.print("What is the employee number: ");
		int empNumber = Integer.parseInt(stdIn.nextLine());
		if(employees.contains(empNumber)){
			Employee e = employees.get(empNumber);
			System.out.println("Employee is: ");
			if(e.getSex().equals("m"))
				System.out.println("Male");
			else System.out.println("Female");
			System.out.println("First Name: " + e.getfName());
			System.out.println("Last Name: " + e.getlName());
			System.out.println("Deductions rate is: %" + e.getDeductionsRate());
			if(employees.get(empNumber) instanceof FullTimeEmployee){
				FullTimeEmployee fte = (FullTimeEmployee)(e);
				System.out.println("Gross salary is: " + fte.getYearlySalary());
				System.out.println("Net salary is: " + fte.getNetYearlySalary());

			}
			else {
				PartTimeEmployee pte = (PartTimeEmployee)(e);
				System.out.println("Hourly wage: " + pte.getHourlyWage());
				System.out.println("Hours worked per week: " + pte.getHrsPerWeek());
				System.out.println("Weeks worked per year: " + pte.getWeeksPerYear());
				System.out.println("Annual gross pay is: $" + pte.getAnnualGrossPay());
				System.out.println("Annual net pay is: $" + pte.getAnnualNetPay());
			}
		}
		else System.out.println("Employee not found.");

	}
	public static void archive(HashTable<Integer, Employee> employees, PrintWriter out){
		for(int i = 0; i < 1000000; i++){
			if(employees.contains(i)){
				Employee e = employees.get(i);
				out.print(e.getEmpNumber() + " ");
				out.print(e.getSex() + " ");
				out.print(e.getfName() + " ");
				out.print(e.getlName() + " ");
				out.print(e.getDeductionsRate() + " ");
				if(e instanceof FullTimeEmployee){
					FullTimeEmployee fte = (FullTimeEmployee)(e);
					out.print("f");
					out.println();
					out.print(fte.getYearlySalary() );
				}    
				else if(e instanceof PartTimeEmployee) {

					PartTimeEmployee fte = (PartTimeEmployee)(e);
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
			System.out.print("What is the hourly wage?: ");
			hourlyWage = stdIn.nextDouble();
			System.out.print("How many hours are worked per week?: ");
			hoursPerWeek = stdIn.nextInt();
			System.out.print("How many weeks is worked per year?: ");
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
		} finally {

		}

		String inString;
		HashTable<Integer, Employee> employees = open(inFile);
		Random rand = new Random();

		while(true){
			System.out.println("Available commands: add, remove, info, exit");
			inString = stdIn.nextLine();
			if (inString.equals("add")) 
				employees = add(employees, stdIn, rand);
			else if(inString.equals("remove"))
				employees = remove(employees, stdIn);
			else if(inString.equals("info"))
				info(employees, stdIn);
			else if(inString.equals("exit")) break;

		}

		stdIn.close();
		inFile.close();
		PrintWriter out = new PrintWriter(new FileWriter(fileName), true);
		archive(employees, out);
		out.close();


	}


}
