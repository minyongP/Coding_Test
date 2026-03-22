package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P11725 {
    static List<Integer>[] A;
    static boolean[] v;
    static int[] ans;

    static void dfs(int node) {
        v[node] = true;
        for (int i : A[node]) {
            if (v[i]) continue;
            ans[i] = node;
            dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new List[N+1];
        v = new boolean[N+1];
        ans = new int[N+1];

        for (int i = 0; i < A.length; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        dfs(1);

        for (int i = 2; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
