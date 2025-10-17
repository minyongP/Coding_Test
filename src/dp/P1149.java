package dp;

import java.util.Arrays;
import java.util.Scanner;

public class P1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] rgb = new int[N][3];
        long[][] dp = new long[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = sc.nextInt();
                dp[i][j] = 999999999;
            }
        }

        for (int i = 0; i < 3; i++) {
            dp[0][i] = rgb[0][i];
        }

        for (int n = 1; n < N; n++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != j) {
                        dp[n][i] = Math.min(rgb[n][i] + dp[n-1][j], dp[n][i]);
                    }
                }
            }
        }
        System.out.println(Arrays.stream(dp[N-1]).min().orElse(0));
    }
}
