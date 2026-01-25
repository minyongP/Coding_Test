import java.util.Scanner;

public class P2991 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A =  sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int[] P = new int[3];
		for (int i = 0; i < 3; i++) {
			P[i] = sc.nextInt();
		}

		for (int i = 0; i < 3; i++) {
			int ans = 0;
			int t = P[i] % (A + B);
			if (0 < t && t <= A) ans++;

			t = P[i] % (C + D);
			if (0 < t && t <= C) ans++;

			System.out.println(ans);
		}
	}
}
