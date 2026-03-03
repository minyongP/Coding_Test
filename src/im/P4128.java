package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4128 {
    static int N;
    static int[][] A;
    static boolean[] selected;
    static long best;

    static void dfs(int start, int cnt) {
        if (cnt == N / 2) {
            best = Math.min(best, diff());
            return;
        }
        if (cnt + (N - start) < N / 2) return;

        for (int i = start; i < N; i++) {
            selected[i] = true;
            dfs(i + 1, cnt + 1);
            selected[i] = false;
        }
    }

    static long diff() {
        long sumA = 0, sumB = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                long pair = (long) A[i][j] + A[j][i];
                if (selected[i] && selected[j]) sumA += pair;
                else if (!selected[i] && !selected[j]) sumB += pair;
            }
        }
        return Math.abs(sumA - sumB);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());

            A = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) A[i][j] = Integer.parseInt(st.nextToken());
            }

            selected = new boolean[N];
            best = Long.MAX_VALUE;

            selected[0] = true;
            dfs(1, 1);

            sb.append('#').append(tc).append(' ').append(best).append('\n');
        }

        System.out.print(sb.toString());
    }
}
