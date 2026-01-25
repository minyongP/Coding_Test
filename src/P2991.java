import java.util.Scanner;

public class P2991 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A =  sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();

		int P = sc.nextInt();
		int M = sc.nextInt();
		int N = sc.nextInt();

		int ans = 0;
		if (P % (A + B + 1) <= A) ans++;
		if (P % (C + D + 1) <= C) ans++;
		System.out.println(ans);

		ans = 0;
		if (M % (A + B + 1) <= A) ans++;
		if (M % (C + D + 1) <= C) ans++;
		System.out.println(ans);

		ans = 0;
		if (N % (A + B + 1) <= A) ans++;
		if (N % (C + D + 1) <= C) ans++;
		System.out.println(ans);
	}
}
