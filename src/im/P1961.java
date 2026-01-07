package im;

import java.util.Scanner;

public class P1961 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test = 1; test < T+1; test++) {
			System.out.println("#" + test);
			int N = sc.nextInt();
			int[][] A = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					A[i][j] = sc.nextInt();
				}
			}

			int[][] r90 = new int[N][N];
			int[][] r180 = new int[N][N];
			int[][] r270 = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					r90[i][j] = A[N-1-j][i];
					r180[i][j] = A[N-1-i][N-1-j];
					r270[i][j] = A[j][N-1-i];
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(r90[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(r180[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(r270[i][j]);
				}
				System.out.println();
			}
 		}
	}
}
