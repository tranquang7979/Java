package Activity06.TrucXanhUI;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;

public class TrucXanhLib {
	
	// declare variables
	private String result;
	private char[] inputResult;
	private int count;
	private String[] arrResult = { "TEA", "GOOD", "HELLO", "RACE", "BOOK", "CANDY" };

	public String getResult() { return result; }
	public void setResult(String newResult) { result = newResult; }

	public int getCount() { return count; }
	public void setCount(int newCount) { count = newCount; }
//	
//	// logic to play game
//	private void Play() {
//		count = 0;
//		
//		// random a word in arrResult
//		Random r = new Random();
//		int randomNumber = r.nextInt(arrResult.length);
//		result = arrResult[randomNumber];
//
//		// init array inputResult
//		inputResult = new char[result.length()];
//		String template = "";
//		for(int i = 0; i < inputResult.length; i++) {
//			inputResult[i] = '_';
//			template += "_" + " ";
//		}
//		System.out.println("Guess a word has " + result.length() + " charaters: " + template);
//		
//		// enter character
//		while(count != inputResult.length) {
//			EnterKeyword();
//		}
//
//		System.out.println("---------------------------------------------");
//		System.out.println("Congratulation! YOU WON!!!.");
//		System.out.println("---------------------------------------------");
//		
//		InitMenu();
//	}
//
//	private void Help() {
//		System.out.println("---------------------------------------------");
//		System.out.println("How to play TRUC XANH.");
//		System.out.println("---------------------------------------------");
//		InitMenu();
//	}
//
//	private void Exit() {
//		System.out.println("---------------------------------------------");
//		System.out.println("Thank you for play game. SEE YOU AGAIN!");
//		System.out.println("---------------------------------------------");
//		System.exit(0);
//	}
//
//	private void SelectMenu() {
//		System.out.print("Please make your choice: ");
//		Scanner sc = new Scanner(System.in);
//		int menuId = sc.nextInt();
//		
//		switch (menuId) {
//		case 1:
//		default:
//			Introduction();
//			break;
//		case 2:
//			Play();
//			break;
//		case 3:
//			Help();
//			break;
//		case 4:
//			Exit();
//			break;
//		}
//	}
//	
//	private void EnterKeyword() {
//		System.out.print("Please key in a character: ");
//		Scanner sc = new Scanner(System.in);
//		char input = Character.toUpperCase(sc.nextLine().charAt(0));
//		int tempCount = 0;
//				
//		for(int i = 0; i < result.length(); i++) {			
//			if(input != result.charAt(i)) continue;			
//			count++;
//			tempCount++;
//			inputResult[i] = input;
//		}
//		
//		System.out.print("There " + (tempCount > 0 ? "are " : "is ") + tempCount + " character" + (tempCount > 0 ? "s" : "") + input + ": ");
//		
//		for(int j = 0; j < inputResult.length; j++) {			
//			System.out.print(" " + inputResult[j]);
//		}
//		System.out.println("");
//	}

}
