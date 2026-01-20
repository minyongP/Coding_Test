package im;

import java.util.Scanner;

public class P1206 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] A = new int[N][255];
		int ans = 0;

		for (int i = 0; i < N; i++) {
			int H = sc.nextInt();

			for (int j = 0; j < H; j++) {
				A[i][j] = 1;
			}
		}

		/**
		 * A[i]의 크기 만큼 반복 자신의 좌우 두칸 확인하기
		 */
		for (int i = 2; i < N-2; i++) {
			for (int j = 0; j < 255; j++) {
				if (A[i][j] == 0) break;
				// 좌우 두칸이 시야 확인
				if (A[i-1][j] == 0 && A[i-2][j] == 0 && A[i+1][j] == 0 && A[i+2][j] == 0) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
