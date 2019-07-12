package Activity06;

import java.util.Scanner;

public class ArrayDemo {

	public void LearnArray() {

		// declare array
		int arrayInt[] = new int[6];
		boolean arrayBool[] = new boolean[3];
		float arrayFloat[] = new float[6];

		// assign value to array
		arrayInt[2] = 6;
		arrayBool[2] = true;
		arrayFloat[2] = 66.6f;

		for (int i = 0; i < arrayInt.length; i++) {
			System.out.println("Array INT: " + arrayInt[i]);

			if (i < arrayBool.length)
				System.out.println("Array BOOLEAN: " + arrayBool[i]);

			if (i < arrayFloat.length)
				System.out.println("Array FLOAT: " + arrayFloat[i]);
		}

		// declare and init value
		String days[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

	}

	public static void main(String[] args) {
		int numbers[];

		System.out.print("Enter N: ");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		numbers = new int[N];

		for (int i = 0; i < numbers.length; i++) {
			System.out.print("Element at " + i + ":");
			sc = new Scanner(System.in);
			numbers[i] = sc.nextInt();
		}
		
		System.out.println("---------- RESULT-----------");

		for (int i = 0; i < numbers.length; i++) {
			System.out.println("Element at " + i + ":" + numbers[i]);
		}
	}
}
