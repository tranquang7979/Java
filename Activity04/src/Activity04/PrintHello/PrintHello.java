package Activity04.PrintHello;

import java.util.Scanner;

public class PrintHello {
	public int n;
	
	public void EnterData() {
		System.out.print("Enter N: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();		
	}
	
	public void Print() {
		System.out.println("===========Details==========");
		for(int i = 1 ; i <= n; i++) {
			System.out.println("Hello " + i);
		}
	}
}
