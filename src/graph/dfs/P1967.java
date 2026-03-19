package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1967 {
    static List<Node>[] A;
    static int endNode;
    static long ans = 0;

    private static class Node {
        int V;
        int E;

        public Node(int v, int e) {
            V = v;
            E = e;
        }
    }

    private static void dfs(int node, long sum, boolean[] v) {
        v[node] = true;
        if (ans < sum) {
            endNode = node;
            ans = sum;
        }
        for (Node n : A[node])  {
            if (v[n.V]) continue;
            dfs(n.V, sum + n.E, v);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new List[N+1];
        for (int i = 0 ; i < A.length; i++) A[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            A[s].add(new Node(e, edge));
            A[e].add(new Node(s, edge));
        }

        // 말단 노드 찾기
        dfs(1, 0, new boolean[N+1]);
        // 최장 노드 찾기
        ans = 0;
        dfs(endNode, 0, new boolean[N+1]);

        System.out.print(ans);
    }
}
