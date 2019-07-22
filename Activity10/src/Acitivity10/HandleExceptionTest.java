package Acitivity10;

import java.util.Scanner;

public class HandleExceptionTest {
	
	public void ex1() {
		int a = 8; 
		int b = 10;
		int c = a / b;
		
		System.out.println("RESULT: " + c);
		
		a = 8; 
		b = 0;
		c = a / b;
	}

	public void ex2() {
		int numbers[] = {1, 6, 4};
		System.out.println(numbers[3]);
	}

	public void ex3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int n = sc.nextInt();
	}
	public void ex4() {
		Employee e = null;
		e.show();
	}
	public void ex5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number 1: ");
		String a = sc.nextLine();
		System.out.print("Enter number 2: ");
		String b = sc.nextLine();
		
		int i_a = Integer.parseInt(a);
		int i_b = Integer.parseInt(b);
		System.out.print("Result: " + (i_a + i_b));
	}
	public void ex6() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter username: ");
		String username = sc.nextLine();
		System.out.print("Enter password: ");
		String password = sc.nextLine();
		
		if(password.length() < 6)
			throw new Exception("Password must be greater than 6 characters.");
	}
	public static void main (String[] args) {		
		try
		{
			//new HandleExceptionTest().ex1();
			//new HandleExceptionTest().ex2();
			//new HandleExceptionTest().ex3();
			//new HandleExceptionTest().ex4();
			//new HandleExceptionTest().ex5();
			new HandleExceptionTest().ex6();
		}
		catch(Exception ex)
		{
			System.out.println("EXCEPTION: " + ex.getMessage());
		}
	}
}
