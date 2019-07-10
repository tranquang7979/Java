package activity05.TrucXanh;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;

public class TrucXanh {
	private String result;
	private char[] inputResult;
	private int count;
	private String[] arrResult = { "TEA", "GOOD", "HELLO", "RACE", "BOOK", "CANDY" };

	public void InitMenu() {
		System.out.println("1. Introduction");
		System.out.println("2. Play");
		System.out.println("3. Help");
		System.out.println("4. Exit");
		
		SelectMenu();
	}

	private void Introduction() {	
		System.out.println("---------------------------------------------");
		System.out.println("Introduction: This is game TRUC XANH. Player must guess a secret word.");
		System.out.println("---------------------------------------------");
		InitMenu();
	}

	private void Play() {
		count = 0;
		
		Random r = new Random();
		int randomNumber = r.nextInt(arrResult.length);

		result = arrResult[randomNumber];

		inputResult = new char[result.length()];
		for(int i = 0; i < inputResult.length; i++) {
			inputResult[i] = '_';
		}
		System.out.println("Guess a word has " + result.length() + " charaters: ");
		
		while(count != inputResult.length) {
			EnterKeyword();
		}

		System.out.println("---------------------------------------------");
		System.out.println("Congratulation! YOU WON!!!.");
		System.out.println("---------------------------------------------");
		
		InitMenu();
	}

	private void Help() {
		System.out.println("---------------------------------------------");
		System.out.println("How to play TRUC XANH.");
		System.out.println("---------------------------------------------");
		InitMenu();
	}

	private void Exit() {
		System.out.println("---------------------------------------------");
		System.out.println("Thank you for play game. SEE YOU AGAIN!");
		System.out.println("---------------------------------------------");
		System.exit(0);
	}

	private void SelectMenu() {
		System.out.print("Please make your choice: ");
		Scanner sc = new Scanner(System.in);
		int menuId = sc.nextInt();
		
		switch (menuId) {
		case 1:
		default:
			Introduction();
			break;
		case 2:
			Play();
			break;
		case 3:
			Help();
			break;
		case 4:
			Exit();
			break;
		}
	}
	
	private void EnterKeyword() {
		System.out.println("Please key in a character: ");
		Scanner sc = new Scanner(System.in);
		char input = sc.nextLine().charAt(0);
		int tempCount = 0;
		
		for(int i = 0; i < result.length(); i++) {
			if(input == result.charAt(i)){
				count++;
				tempCount++;
				inputResult[i] = input;
			}
		}
		
		System.out.print("There " + (tempCount > 0 ? "are " : "is ") + tempCount + " character" + (tempCount > 0 ? "s" : "") + input + ": ");
		
		for(int j = 0; j < inputResult.length; j++) {			
			System.out.print(inputResult[j]);
		}
		System.out.println("");
	}

}
