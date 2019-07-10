package Activity04.FindMaxN;

import java.util.Scanner;

public class FindMaxN {
	public int n;
	public int[] data;
	
	public void EnterData() {
		
		System.out.print("Enter N number to find max: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		data = new int[n];
		
		for(int i = 0; i < n; i++)
		{
			System.out.print("Enter number "+ (i+1) +": ");
			sc = new Scanner(System.in);
			data[i] = sc.nextInt();
		}
	}
	
	public int FindMaxNumber() {	
		int max = data[0];
		for(int j = 1; j < data.length; j++) {
			if(data[j] > max)
				max = data[j];
		}
		return max;
	}
	
	public void Print() {
		System.out.println("===========Details==========");
		for(int i = 0; i < data.length; i++) {
			System.out.println("Number "+ (i+1) +": " + data[i]);
		}
		System.out.println("Max number: " + FindMaxNumber());
	}
}
