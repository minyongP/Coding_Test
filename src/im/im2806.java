package im;

import java.util.Scanner;

public class im2806 {
    static int N;
    static int[][] A;
    static int ans;
    static void dfs(int x, int y) {
        // 방문 배열 x
        // 세로축이 n이면 ans++ return;
        if (y == N) {
            ans++;
            return;
        }
        // 위에 체크

        // 좌상 체크

        // 우상 체크
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            A = new int[N][N];
            ans = 0;
            dfs(0, 0);
            System.out.println("#" + tc + " " + ans);
        }
    }
}
