package Abstraction;

import java.text.NumberFormat;

public abstract class Employee {

	private double hourlyWage;
	protected double hoursWorked;

	public Employee(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public abstract void primaryResponsibility();

	public abstract void secondaryResponsibility();

	public void getPaid() {
		double pay = this.hoursWorked * this.hourlyWage;
		directDepositCheck(pay);
	}

	private void directDepositCheck(double amount) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String moneyString = formatter.format(amount);
		System.out.println(String.format("Deposited %s", moneyString));
	}

}

public class Salary extends Employee{

	Employee[] employees = new Employee[3];
	employees[0] = new Employee();
	employees[1] = new John();
	employees[2] = new Joe();

	@Override
	public String primaryResponsibility();{
		return "talk to each other";
	}

	@Override
	public String secondaryResponsibility();{
		return "help each other";
	}

	for(int i = 0; i < employees.length; i++) {
		System.out.println(employees[i].primaryResponsibility() + secondaryResponsibility());
	}

}
