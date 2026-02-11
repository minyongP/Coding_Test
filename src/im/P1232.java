package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1232 {
    static String[] nodes;
    static int[] leftNode;
    static int[] rightNode;
    static StringBuilder sb = new StringBuilder();

    static void add(int i, String s, int left, int right) {
        nodes[i] = s;
        leftNode[i] = left;
        rightNode[i] = right;
    }

    static int dfs(int idx) {
        if (idx == 0) return 0;
        String s = nodes[idx];
        int x = dfs(leftNode[idx]);
        int y = dfs(rightNode[idx]);

        switch (s) {
            case "+": return x + y;
            case "-": return x - y;
            case "*": return x * y;
            case "/": return x / y;
        }

        return Integer.parseInt(s);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = 10;
        for (int tc = 1; tc < T + 1; tc++) {
            sb.append("#" + tc + " ");
            int N = Integer.parseInt(br.readLine());
            nodes = new String[N+1];
            leftNode = new int[N+1];
            rightNode = new int[N+1];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                String s = st.nextToken();
                int left = 0;
                int right = 0;
                if (st.hasMoreTokens()) left = Integer.parseInt(st.nextToken());
                if (st.hasMoreTokens()) right = Integer.parseInt(st.nextToken());
                add(idx, s, left, right);
            }

            sb.append(dfs(1)).append("\n");
        }
        System.out.print(sb.toString());
    }
}
