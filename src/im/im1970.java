package im;

import java.util.Scanner;

public class im1970 {
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
            int N = sc.nextInt();
            int[] A = new int[8];
            for (int i = 0; i < A.length; i++) {
                A[i] = N / change[i];
                N %= change[i];
            }

            System.out.println("#" + tc);
            for (int a : A) System.out.print(a + " ");
            System.out.println();
        }
    }
}
