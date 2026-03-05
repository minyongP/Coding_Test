package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1247 {
    static int N;
    static int[][] A;
    static boolean[] v;
    static long min;

    static void dfs (int[] now, int cnt, long distSum) {
        // 거리 합이 최소보다 크면 롤백
        if (min <= distSum) return;

        // 마지막 손님까지 방문 했으면 집으로
        if (cnt == N - 2) {
            distSum += Math.abs(now[0] - A[1][0]) + Math.abs(now[1] - A[1][1]);
            if (min > distSum) min = distSum;
            return;
        }

        // 2~N까지 손님 랜덤 방문
        for (int i = 2; i < N; i++) {
            if (v[i]) continue;
            v[i] = true;
            // 거리계산
            distSum += Math.abs(now[0] - A[i][0]) + Math.abs(now[1] - A[i][1]);
            dfs(A[i], cnt+1, distSum);

            // 롤백
            v[i] = false;
            distSum -= Math.abs(now[0] - A[i][0]) + Math.abs(now[1] - A[i][1]);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            min = Integer.MAX_VALUE;
            sb.append("#").append(tc).append(" ");
            N = Integer.parseInt(br.readLine().trim());
            N += 2;
            A = new int[N][2];
            v = new boolean[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                    A[i][0] = Integer.parseInt(st.nextToken());
                    A[i][1] = Integer.parseInt(st.nextToken());
            }

            dfs(A[0], 0, 0L);
            sb.append(min).append("\n");
        }
        System.out.print(sb.toString());
    }
}
