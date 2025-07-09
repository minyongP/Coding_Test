package dp;

import java.util.Scanner;

public class P2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stairCnt = sc.nextInt();
        int[] stairScore = new int[stairCnt+1];
        for (int i = 1; i <= stairCnt; i++) {
            stairScore[i] = sc.nextInt();
        }

        int[][] dp = new int[stairCnt+1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = stairScore[1];
        dp[1][1] = stairScore[1];

        // 0은 두칸 넘은 것, 1은 한칸 넘어온 것
        for (int i = 2; i <= stairCnt; i++) {
            dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + stairScore[i];
            dp[i][1] = dp[i-1][0] + stairScore[i];
        }

        System.out.println(Math.max(dp[stairCnt][0], dp[stairCnt][1]));
    }
}
