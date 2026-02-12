package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2817 {
    static int N;
    static int K;
    static int[] A;
    static long ans;
    private static void dfs(int idx, long sum) {
        if (sum == K) ans++;
        if (idx >= N || sum >= K) return;
        dfs(idx+1, sum + A[idx]);
        dfs(idx+1, sum); // 넘기기
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < T + 1; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            A = new int[N];
            ans = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
            dfs(0, 0);
            System.out.println("#" + tc + " " + ans);
        }
    }
}
