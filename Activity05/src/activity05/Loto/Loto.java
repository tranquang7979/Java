package activity05.Loto;

import java.util.Random;
import java.util.Scanner;

public class Loto {
	private int input;
	private int result;

	public void Start() {

		Random r = new Random();
		result = r.nextInt(20);
		//System.out.println("Result ===> " + result);

		System.out.println("Enter your lucky number: ");
		Scanner sc = new Scanner(System.in);
		input = sc.nextInt();

		if (input == result) {
			System.out.println("---------------------------------------------");
			System.out.println("Congratulation! YOU WON!!! ===> " + result);
			System.out.println("---------------------------------------------");
		} else {
			System.out.println("---------------------------------------------");
			System.out.println("Good luck for the next time! The lucky number is " + result);
			System.out.println("---------------------------------------------");
		}

		System.out.println("Would you like to try again? (Y/N)");
		sc = new Scanner(System.in);
		char answer = sc.nextLine().charAt(0);
		if (answer == 'Y')
			Start();
		else {
			System.out.println("---------------------------------------------");
			System.out.println("Thank you for play game. SEE YOU AGAIN!");
			System.out.println("---------------------------------------------");
		}
	}

}
