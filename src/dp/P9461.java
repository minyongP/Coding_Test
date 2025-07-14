package dp;

import java.util.Scanner;

public class P9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long[] P = new long[101];   // overflow
        P[1] = 1; P[2] = 1; P[3] = 1; P[4] = 2;

        for (int n = 5; n < P.length; n++) {
            P[n] = P[n - 1] + P[n - 5];
        }

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            System.out.println(P[N]);
        }
    }
}
