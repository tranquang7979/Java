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

	public String getResult() {
		return result;
	}

	public void setResult(String newResult) {
		result = newResult;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int newCount) {
		count = newCount;
	}

	// logic to play game
	public String Play() {
		// random a word in arrResult
		Random r = new Random();
		int randomNumber = r.nextInt(arrResult.length);
		result = arrResult[randomNumber];
		return result;
	}

	private void EnterKeyword() {
		System.out.print("Please key in a character: ");
		Scanner sc = new Scanner(System.in);
		char input = Character.toUpperCase(sc.nextLine().charAt(0));
		int tempCount = 0;

		for (int i = 0; i < result.length(); i++) {
			if (input != result.charAt(i))
				continue;
			count++;
			tempCount++;
			inputResult[i] = input;
		}

		System.out.print("There " + (tempCount > 0 ? "are " : "is ") + tempCount + " character"
				+ (tempCount > 0 ? "s" : "") + input + ": ");

		for (int j = 0; j < inputResult.length; j++) {
			System.out.print(" " + inputResult[j]);
		}
		System.out.println("");
	}

}
