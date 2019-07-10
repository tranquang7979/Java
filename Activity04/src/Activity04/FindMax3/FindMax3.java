package Activity04.FindMax3;

import java.util.Scanner;

public class FindMax3 {
	public int a,b, c;
	
	public void EnterData() {
		System.out.print("Enter A: ");
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();

		System.out.print("Enter B: ");
		b = sc.nextInt();

		System.out.print("Enter C: ");
		c = sc.nextInt();
		
	}
	
	public int FindMaxNumber() {	
		if(IsMax(a,  b,  c))
			return a;
		if(IsMax(b, a, c))
			return b;
		//if(c > b && c > a)
			return c;
	}
	
	public boolean IsMax(int max, int x, int y) {
		return max > x && max > y;
	}

	public void Print() {
		System.out.println("===========Details==========");
		System.out.println("Number A: " + a);
		System.out.println("Number B: " + b);
		System.out.println("Number C: " + c);
		System.out.println("Max number: " + FindMaxNumber());
	}
}
