package Activity04.FindMax;

import java.util.Scanner;

public class FindMax {
	public int a,b;
	
	public void EnterData() {
		System.out.print("Enter A: ");
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();

		System.out.print("Enter B: ");
		b = sc.nextInt();
	}
	
	public int FindMaxNumber() {
		return a > b ? a : b;
	}

	public void Print() {
		System.out.println("===========Details==========");
		System.out.println("Number A: " + a);
		System.out.println("Number B: " + b);
		System.out.println("Max number: " + FindMaxNumber());
	}
}
