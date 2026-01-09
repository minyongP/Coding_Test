package im;

import java.util.Scanner;

public class P1859 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] A = new int[N];
		long ans = 0;

		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		// // 2일 뒤까지 예상하여 차이가 더 큰것을 값에 더한다
		// for (int i = 0; i < N-2; i++) {
		// 	ans += Math.max(Math.max(A[i+2] - A[i], A[i+1] - A[i]), 0);
		// }
		// // 마지막 하루 [메모리 아웃]
		// ans += Math.max(A[N-1]- A[N-2], 0);

		// 뒤에서 부터

		System.out.println(ans);
	}
}
