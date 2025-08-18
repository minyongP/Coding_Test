package dp;

import java.util.Scanner;

public class P12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] items = new int[N][2];
        int[][] dp = new int[N][2];

        for (int i = 0; i < N; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();

            for (int j = K; j >=weight; j--) {
//                dp[j] = Math.max(dp[j], dp[j-weight] + value);
            }
        }

        System.out.println(dp[K]);
        // dp(n) = Max(dp(n-1),  dp(n) + dp(n-1))

    }
}