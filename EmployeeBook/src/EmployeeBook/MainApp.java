package EmployeeBook;

import java.util.Date;

public class MainApp {
	public static void Main(String args[]) 
	{
		Date dateOfBirth = new Date();
		dateOfBirth.setYear(-25);
		Date dateOfMarriage = new Date();
		dateOfMarriage.setYear(-3);
		Manager m = new Manager("M001", "M", "IT", "designation", "address", new Date(), dateOfBirth, "", true, dateOfMarriage);
	}
}
