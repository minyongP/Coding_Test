package dp;

import java.util.Scanner;

public class P9095 {
    public static void main(String[] args) {
        int[] dp = new int[12];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for (int i = 4; i < 12; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}