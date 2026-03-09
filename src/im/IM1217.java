package im;

import java.util.Scanner;

public class IM1217 {
    static int N;
    static int M;
    static long ans;
    static void dfs(long v, int depth) {
        if (depth == M - 1) {
            ans = v;
            return;
        }
        dfs(v*N, depth+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int T = sc.nextInt();
            N = sc.nextInt();
            M = sc.nextInt();

            dfs(N, 0);
            System.out.println("#" + T + " " + ans);
        }
    }
}
