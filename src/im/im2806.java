package im;

import java.util.Scanner;

public class im2806 {
    static int N;
    static int ans;

    static void dfs(int depth, int[] row) {
        // 세로축이 n이면 ans++ return;
        if (depth == N+1) {
            ans++;
            return;
        }

        for (int col = 1; col <= N; col++) {
            boolean canPlace = false;
            // 상단 체크
            for (int i = 1; i < depth; i++) {
                if (row[i] == col) canPlace = true;
            }
            // 대각선 체크
            for (int i = 1; i < depth; i++) {
                if (Math.abs(depth - i) == Math.abs(col - row[i])) canPlace = true;
            }

            if (canPlace) continue;
            row[depth] = col;
            dfs(depth+1, row);
        }




    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            ans = 0;
            dfs(1, new int[N+1]);
            System.out.println("#" + tc + " " + ans);
        }
    }
}
