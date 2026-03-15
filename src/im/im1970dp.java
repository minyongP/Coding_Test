package im;

import java.util.Scanner;

public class im1970dp {
    static int[] change = {
            50000,
            10000,
            5000,
            1000,
            500,
            100,
            50,
            10
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt() / 10;
            int[][] choice = new int[N+1][8];
            int[] dp = new int[N+1];

            dp[0] = 0;
            dp[1] = 1;
            choice[1][7] = 1;

            for (int i = 2; i <= N; i++) {
                dp[i] = dp[i-1] + 1;
                choice[i] = choice[i-1].clone();
                choice[i][7]++;
                if (i >= 5) {
                    if (dp[i] > dp[i-5] + 1) {
                        dp[i] = dp[i - 5] + 1;
                        choice[i] = choice[i - 5].clone();
                        choice[i][6]++;
                    }
                }
                if (i >= 10) {
                    if (dp[i] > dp[i-10] + 1) {
                        dp[i] = dp[i - 10] + 1;
                        choice[i] = choice[i - 10].clone();
                        choice[i][5]++;
                    }
                }
                if (i >= 50) {
                    if (dp[i] > dp[i - 50] + 1) {
                        dp[i] = dp[i - 50] + 1;
                        choice[i] = choice[i - 50].clone();
                        choice[i][4]++;
                    }
                }
                if (i >= 100) {
                    if (dp[i] > dp[i - 100] + 1) {
                        dp[i] = dp[i - 100] + 1;
                        choice[i] = choice[i - 100].clone();
                        choice[i][3]++;
                    }
                }
                if (i >= 500) {
                    if (dp[i] > dp[i - 500] + 1) {
                        dp[i] = dp[i - 500] + 1;
                        choice[i] = choice[i - 500].clone();
                        choice[i][2]++;
                    }
                }
                if (i >= 1000) {
                    if (dp[i] > dp[i - 1000] + 1) {
                        dp[i] = dp[i - 1000] + 1;
                        choice[i] = choice[i - 1000].clone();
                        choice[i][1]++;
                    }
                }
                if (i >= 5000) {
                    if (dp[i] > dp[i - 5000] + 1) {
                        dp[i] = dp[i - 5000] + 1;
                        choice[i] = choice[i - 5000].clone();
                        choice[i][0]++;
                    }
                }
            }

            System.out.println("#" + tc);
            for (int a : choice[N]) System.out.print(a + " ");
            System.out.println();
        }
    }
}
