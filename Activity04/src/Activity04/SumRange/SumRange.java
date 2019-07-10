package Activity04.SumRange;

import java.util.Scanner;

public class SumRange {
	public int n, total = 0;
	
	public void EnterData() {
		System.out.print("Enter N: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();		
	}
	
	public void SumTotalNumber() {
		if(n > 0)
		{
			for(int i = 0; i <= n; i++) {
				total += i;
			}	
		}
		else
		{
			for(int i = n; i <= 0; i++) {
				total += i;
			}	
		}
	}

	public void Print() {
		System.out.println("===========Details==========");
		System.out.println("Number N: " + n);		
		System.out.println("Total: " + total);
	}
}
