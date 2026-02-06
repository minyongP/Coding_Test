package backtracking;

import java.util.Scanner;

public class P15650 {
    static int N;
    static int M;
    static int[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[M];
        dfs(1, 0);

    }
    private static void dfs(int i, int depth) {
        if (depth == M) {
            for (int j = 0; j < M; j++) {
                System.out.print(A[j] + " ");
            }
            System.out.println();
            return;
        }
        for (int j = i; j < N+1; j++) {
            A[depth] = j;
            dfs(j+1, depth+1);
        }
    }
}
