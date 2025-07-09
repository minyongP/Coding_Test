package dp;

import java.util.Scanner;

public class P1003 {
    static  int zero = 0;
    static  int one = 0;
    public static void main(String[] args) {
        int[] zeroCnt = new int[41];
        int[] oneCnt = new int[41];

        zeroCnt[0] = 1;
        oneCnt[0] = 0;
        zeroCnt[1] = 0;
        oneCnt[1] = 1;

        for (int i = 2; i <= 40; i++) {
            zeroCnt[i] = zeroCnt[i-1] + zeroCnt[i-2];
            oneCnt[i] = oneCnt[i-1] + oneCnt[i-2];
        }

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            System.out.println(zeroCnt[N] + " " + oneCnt[N]);
        }
    }
}
