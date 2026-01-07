package im;

import java.util.Scanner;

public class P1959 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int max = Integer.MIN_VALUE;

			int[] A = new int[N];
			int[] B = new int[M];
			for (int i = 0; i < N; i++) A[i] = sc.nextInt();
			for (int i = 0; i < M; i++) B[i] = sc.nextInt();

			if (N > M) {
				int[] tmpArr = A; A = B; B = tmpArr;
				int tmp = N; N = M; M = tmp;
			}

			int gap = M-N;

			for (int i = 0; i < gap+1; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += A[j] * B[j+i];
				}
				max = Math.max(max, sum);
			}

			System.out.println("#"+ test_case + " " + max);
		}
	}
}
