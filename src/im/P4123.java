package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4123 {
    static int N;
    static int[] A;
    static int[] op;
    static long max;
    static long min;

    static void dfs(int[] ops, int depth) {
        if (depth == N-1) {
            long ans = calc(ops);
            if (max < ans) max = ans;
            if (min > ans) min = ans;
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] <= 0) continue;
            op[i]--;
            ops[depth] = i;
            dfs(ops, depth+1);
            // 롤백
            op[i]++;
        }
    }

    static long calc(int[] ops) {
        long acc = A[0];

        for (int i = 0; i < N-1; i++) {
            if (ops[i] == 0) acc += A[i+1];
            if (ops[i] == 1) acc -= A[i+1];
            if (ops[i] == 2) acc *= A[i+1];
            if (ops[i] == 3) {
                acc /= A[i+1];
            }
        }
        return acc;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            N = Integer.parseInt(br.readLine().trim());
            A = new int[N];
            op = new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                op[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            max = Long.MIN_VALUE;
            min = Long.MAX_VALUE;

            dfs(new int[N-1], 0);

            sb.append(max - min).append("\n");
        }
        System.out.print(sb.toString());
    }
}
