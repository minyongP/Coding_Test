package math;

import java.util.Scanner;

public class P13458 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] A  = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		int C = sc.nextInt();

		long ans = 0;
		for (int a : A) {
			a -= B;
			ans++;

			if (a > 0) {
				ans += (a + (long)(C - 1)) / C;
			}
		}

		System.out.println(ans);
 	}
}
