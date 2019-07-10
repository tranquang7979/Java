package Activity04.PrintNumberN;

import java.util.Scanner;

public class PrintNumberN {
	public int n;
	public boolean isEven = false;
	public int[] data;
	
	public void EnterData() {

		System.out.print("Do you want to print Odd(1) or Even(0): ");
		Scanner sc = new Scanner(System.in);
		isEven = (sc.nextInt() == 0);
		
		System.out.print("Enter N "+ (isEven ? "Even" : "Odd") +" number: ");
		sc = new Scanner(System.in);
		n = sc.nextInt();

		data = new int[n];
		
		for(int i = 0; i < n; i++)
		{
			System.out.print("Enter number "+ (i+1) +": ");
			sc = new Scanner(System.in);
			data[i] = sc.nextInt();
		}
	}
	
	public void Print() {
		System.out.println("===========Details==========");
		String result = "";
		int count = 0;
		for(int i = 0; i < data.length; i++) {
			if((isEven && data[i]%2==0) || (!isEven && data[i]%2!=0))
			{
				result += data[i] + ",";
				count++;
			}
		}
		System.out.print("Total " + count + (isEven ? " Even" : " Odd") +" numbers: ");
		System.out.print(result.substring(0, result.length() - 1));
	}
}
