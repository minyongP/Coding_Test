package dp;

import java.util.Scanner;

public class P14501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] A = new int[N][2];

		for (int i = 0; i < N; i++) {
			A[i][0] = sc.nextInt();
			A[i][1] = sc.nextInt();
		}

		long[] dp = new long[N+1];
		dp[N] = 0;

		for (int i = N-1; i >= 0; i--) {
			int day = A[i][0];
			if (day <= N - i) {
				// dp[i] = Math.max(dp[i-day][1])
			}
		}
	}
}
