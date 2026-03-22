package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class P15666 {
    static int N, M;
    static int[] A;
    static boolean[] v;

    private static void dfs(int idx, int depth, int[] selected) {
        if (depth == M) {
            for (int i : selected) System.out.print(i + " ");
            System.out.println();
            return;
        }
        int prev = 0;
        for (int i = idx; i < N; i++) {
            if (prev == A[i]) continue;
            selected[depth] = A[i];
            prev = A[i];
            dfs(i, depth+1, selected);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N];
        v = new boolean[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        dfs(0,0, new int[M]);
    }
}
