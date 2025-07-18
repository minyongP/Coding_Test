package dp;

import java.util.Arrays;
import java.util.Scanner;

public class P1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        dp[0] = A[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(A[i], dp[i-1] + A[i]);
        }

        System.out.println(Arrays.stream(dp).max().orElse(0));
    }
}
