package dp;

import java.util.Arrays;
import java.util.Scanner;

public class P11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N+1];
        for (int i = 1; i < A.length; i++) {
            A[i] = sc.nextInt();
        }

        int[] dp = new int[N+1];
        dp[1] = 1;
        for (int i = 2; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
