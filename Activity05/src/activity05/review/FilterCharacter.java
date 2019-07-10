package activity05.review;

import java.util.Scanner;

public class FilterCharacter {
	private char input;
	private String inputStr;
	private char[] nguyenAm = { 'a', 'i', 'o', 'u', 'e' };

	public void EnterCharacter() {
		System.out.print("Enter a character for checking: ");
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine().charAt(0);
	}

	public void EnterString() {
		System.out.print("Enter a string for checking: ");
		Scanner sc = new Scanner(System.in);
		inputStr = sc.nextLine();
	}

	public void Print() {
		System.out.println("===========Details==========");
		
		boolean isNguyenAm = false;
		for (int i = 0; i < nguyenAm.length; i++) {
			if (nguyenAm[i] == input) {
				isNguyenAm = true;
				break;
			}
		}

		System.out.print("Character " + input + " is " + (isNguyenAm ? "Fundamental" : "Consonant"));
	}

}
