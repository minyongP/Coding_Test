package dp;

import java.util.Scanner;

public class P1003 {
    static  int zero = 0;
    static  int one = 0;
    public static void main(String[] args) {
        int[][] cnt = new int[41][41];
        for (int i = 0; i < cnt.length; i++) {
            fibo(i);
            cnt[i][0] = zero;
            cnt[i][1] = one;
            zero = 0;
            one = 0;
        }

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            System.out.println(cnt[N][0] + " " + cnt[N][1]);
        }
    }

    private static int fibo(int n) {
        if (n == 0) {
            zero++;
            return 0;
        } else if (n == 1) {
            one++;
            return 1;
        } else {
            return fibo(n-1) + fibo(n-2);
        }
    }
}
