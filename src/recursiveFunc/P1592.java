package recursiveFunc;

import java.util.Scanner;

public class P1592 {
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int M = sc.nextInt();
	static int L = sc.nextInt();
	static int[] A = new  int[N];
	static int ans = 0;

	public static void main(String[] args) {
		play(0);
		System.out.println(ans);
	}

	private static void play(int i) {
		A[i] += 1;
		if (A[i] == M) { return; }
		ans++;
		if (A[i] % 2 != 0) {
			play((i + L) % N);
		}
		else {
			play((N + i - L) % N);
		}
	}

}
