package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1231 {
    static char[] nodes;
    static int[] leftNode;
    static int[] rightNode;
    static StringBuilder sb = new StringBuilder();

    static void add(int i, char c, int left, int right) {
        nodes[i] = c;
        leftNode[i] = left;
        rightNode[i] = right;
    }

    static void dfs(int idx) {
        if (idx == 0) return;
        dfs(leftNode[idx]);
        sb.append(nodes[idx]);
        dfs(rightNode[idx]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = 10;
        for (int tc = 1; tc < T + 1; tc++) {
            sb.append("#" + tc + " ");
            int N = Integer.parseInt(br.readLine());
            nodes = new char[N+1];
            leftNode = new int[N+1];
            rightNode = new int[N+1];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                char c = st.nextToken().charAt(0);
                int left = 0;
                int right = 0;
                if (st.hasMoreTokens()) left = Integer.parseInt(st.nextToken());
                if (st.hasMoreTokens()) right = Integer.parseInt(st.nextToken());
                add(idx, c, left, right);
            }
            dfs(1);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
