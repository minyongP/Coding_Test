package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class im8275 {
    static int N;
    static int X;
    static int M;
    static int[][] A;
    static int[] ans;
    static long maxHam;

    static void dfs(int[] temp, int depth) {
        if (depth > N) {
            int[] S = new int[N+1];
            S[0] = 0;
            for (int i = 1; i <= N; i++) {
                S[i] = temp[i] + S[i-1];
            }

            boolean check = true;
            for (int[] a : A) {
                int l = a[0];
                int r = a[1];
                int s = a[2];

                if (S[r] - S[l-1] != s) {
                    check = false;
                }
            }
            if (check && S[N] > maxHam) {
                for (int i = 1; i <= N; i++) {
                    ans[i] = temp[i];
                }
                maxHam = S[N];
            }
            return;
        }

        for (int i = 0; i <= X; i++) {
            temp[depth] = i;
            dfs(temp ,depth+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new int[M][3];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                A[i] = new int[]{l, r, s};
            }

            ans = new int[N+1];
            maxHam = -1;
            dfs(new int[N+1], 1);

            sb.append("#").append(tc);
            if (maxHam != -1) {
                for (int i = 1; i <= N; i++) {
                    sb.append(" ").append(ans[i]);
                }
            }
            else sb.append(" -1");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
