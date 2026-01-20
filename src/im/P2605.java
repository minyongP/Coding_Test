package im;

import java.util.Scanner;

public class P2605 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		// 가위
		if (a == 1) {
			System.out.println(b == 2 ? "B" : "A");
		}
		//바위
		else if (a == 2) {
			System.out.println(b == 1 ? "A" : "B");
		}
		//보
		else if (a == 3) {
			System.out.println(b == 1 ? "B" : "A");
		}
	}

}
