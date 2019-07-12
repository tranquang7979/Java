package Activity06.SumInt;

import java.util.Scanner;

public class SumInt {

	int arrInt[];

	public void EnterInput() {
		System.out.print("Enter an interger: ");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arrInt = new int[N];
		
		for(int i = 0; i < N; i++) {
			 sc = new Scanner(System.in);
			 arrInt[i] = sc.nextInt();
		}
	}

	public void Print() {		
		int sumInt = 0;
		int sumIntEven = 0;
		int sumIntOdd = 0;
		String resultInt = "";
		String resultIntEven = "";
		String resultIntOdd = "";

		for (int i = 0; i < arrInt.length; i++) {
			int number = arrInt[i];
			resultInt = number + ",";
			sumInt += number;

			if (number % 2 == 0) {
				resultIntEven = number + ",";
				sumIntEven += number;
			}
			else {
				resultIntOdd = number + ",";
				sumIntOdd += number;
			}
		}
		resultInt = resultInt.substring(0, resultInt.length() - 2);
		resultIntEven = resultIntEven.substring(0, resultIntEven.length() - 2);
		resultIntOdd = resultIntOdd.substring(0, resultIntOdd.length() - 2);
		
		System.out.println("Summary of interger TOTAL: " + resultInt + " = " + sumInt);
		System.out.println("Summary of interger EVEN: " + resultIntEven + " = " + sumIntEven);
		System.out.println("Summary of interger ODD: " + resultIntOdd + " = " + sumIntOdd);
	}
}
