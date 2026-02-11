package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1248 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc < T + 1; tc++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int[] parent = new int[V + 1];
            int[] child1 = new int[V + 1];
            int[] child2 = new int[V + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                parent[c] = p;
                if (child1[p] == 0) child1[p] = c;
                else child2[p] = c;
            }

            boolean[] visited = new boolean[V + 1];
            int x = A;
            while (x != 0) {
                visited[x] = true;
                x = parent[x];
            }

            int y = B;
            while (!visited[y]) {
                y = parent[y];
            }
            int lca = y;

            int[] stack = new int[V + 1];
            int top = 0;
            stack[top++] = lca;

            int size = 0;
            while (top > 0) {
                int node = stack[--top];
                size++;

                int c1 = child1[node];
                int c2 = child2[node];
                if (c1 != 0) stack[top++] = c1;
                if (c2 != 0) stack[top++] = c2;
            }

            sb.append('#').append(tc).append(' ')
                    .append(lca).append(' ')
                    .append(size).append('\n');
        }

        System.out.print(sb.toString());
    }
}
