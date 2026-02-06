package im;

import java.util.Scanner;

public class P1217 {
    static int N;
    static int M;
    static int T;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            T = sc.nextInt();
            N = sc.nextInt();
            M = sc.nextInt();
            pow(N, 1);
        }
    }
    private static void pow(int i, int depth) {
        if (depth == M)  {
            System.out.println("#" + T + " " + i);
            return;
        }
        pow(i*N, depth+1);
    }
}
