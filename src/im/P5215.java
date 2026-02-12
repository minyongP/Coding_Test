package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5215 {
    static int N;
    static int L;
    static int[][] A;
    static int ans;
    private static void dfs(int idx, int sum, int cal) {
        if (ans < sum && cal <= L) ans = sum;
        if (idx == N) return;
        dfs(idx+1, sum + A[idx][0], cal + A[idx][1]);
        dfs(idx+1, sum, cal); // pass
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < T + 1; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            A = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                A[i][0] = Integer.parseInt(st.nextToken());
                A[i][1] = Integer.parseInt(st.nextToken());
            }
            ans = 0;
            dfs(0, 0, 0);
            sb.append("#" + tc + " ");
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
