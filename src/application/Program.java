package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities_enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter department's name: ");
		String dept = sc.nextLine();
		Department depart = new Department(dept);
		System.out.println("Enter worker data: \n Name:");
		String name = sc.nextLine();
		System.out.println("Level: ");
		String level = sc.nextLine();
		WorkerLevel level1 = WorkerLevel.valueOf(level);
		System.out.println("Base salary: ");
		Double salary = sc.nextDouble();
		Worker worker = new Worker(name, level1, salary, depart);
		
		System.out.println("How many contracts to this worker? ");
		int q = sc.nextInt();
		
		for(int i = 1; i <= q; i++) {
			System.out.printf("Enter contract #%d data:\n", i);
			System.out.println("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.println("Value per hour: ");
			Double value = sc.nextDouble();
			System.out.println("Duration(hours): ");
			Integer hours = sc.nextInt();
			HourContract hc = new HourContract(contractDate, value, hours);	
			worker.addContract(hc);
		}
		
		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}

}
