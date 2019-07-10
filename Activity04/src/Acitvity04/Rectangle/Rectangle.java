package Acitvity04.Rectangle;

import java.util.Scanner;

public class Rectangle {
	private int w, h;
	
	public void EnterData() {
		System.out.print("Enter width: ");
		Scanner sc = new Scanner(System.in);
		w = sc.nextInt();

		System.out.print("Enter height: ");
		h = sc.nextInt();
	}
	
	public int TinhChuVi() {
		return (w + h)*2;
	}

	public int TinhDienTich() {
		return w * h;
	}
	
	public void Print() {
		System.out.println("===========Details==========");
		System.out.println("Width: " + w);
		System.out.println("Height: " + h);
		System.out.println("Chu Vi: " + TinhChuVi());
		System.out.println("Dien Tich: " + TinhDienTich());
	}
}