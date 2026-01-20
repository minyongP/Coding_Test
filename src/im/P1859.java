package im;

import java.util.Scanner;

public class P1859 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#" + test_case + " ");
			int N = sc.nextInt();
			int[] A = new int[N];

			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}

			long ans = 0;
			int max = 0;
			// 뒤에서 부터
			for (int i = N - 1; i >= 0; i--) {
				if (A[i] > max) {
					max = A[i];
				}
				else ans += max - A[i];
			}

			System.out.println(ans);
		}
	}
}
