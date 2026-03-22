package backtracking;

import java.util.*;

public class P15663 {
    static int N, M;
    static int[] A;


    static void dfs(int depth, int[] selected, boolean[] v) {
        if (depth == M) {
            for (int i : selected) System.out.print(i + " ");
            System.out.println();
            return;
        }

        boolean[] check = new boolean[10_001];
        for (int i = 1; i <= N; i++) {
            if (v[i]) continue;
            if (check[A[i]]) continue;
            check[A[i]] = true;
            v[i] = true;
            selected[depth] = A[i];
            dfs(depth+1, selected, v);
            v[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N+1];
        for (int i = 1; i <= N; i++) A[i] = sc.nextInt();
        Arrays.sort(A);

        dfs(0, new int[M], new boolean[N+1]);
    }
}
