package im;

import java.util.Scanner;

/*
배열 전체를 bool로 잡고 true로 수정후에 true의 개수를 세어보자
 */
public class P2669 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] A = new boolean[101][101];

		for (int k = 0; k < 4; k++) {
			int a = 0; int b = 0; int c = 0; int d = 0;
				a = sc.nextInt();
				b = sc.nextInt();
				c = sc.nextInt();
				d = sc.nextInt();

			// 사각형 영역
			for (int i = a; i < c; i++) {
				for (int j = b; j < d; j++) {
					A[i][j] = true;
				}
			}

		}
		int ans = 0;
		for (boolean[] a : A) {
			for (boolean b : a) {
				if (b == true) ans++;
			}
		}
		System.out.println(ans);
	}
}
