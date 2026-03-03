package backtracking;

import java.util.Scanner;

public class P9663 {
    static int N;
    boolean[][] v = new boolean[N][N];
    static long ans = 0;
    private static void dfs(int row) {

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            dfs(0);  // 첫행 모든 시행
        }

        System.out.println(ans);
    }
}
