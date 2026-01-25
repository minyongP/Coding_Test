import java.util.Scanner;

public class P8320 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();
		int ans = 0;
		for (int j = 1; j <= n; j++) {
			for (int i = 1; i <= (int)Math.sqrt(j); i++) {
				if (j % i == 0) ans++;
			}
		}
		System.out.println(ans);
	}
}
