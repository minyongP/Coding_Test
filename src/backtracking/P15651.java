package backtracking;

import java.util.Scanner;

public class P15651 {
    static int N;
    static int M;
    static int[] A;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[M];
        roop(0);
        System.out.println(sb.toString());
    }
    private static void roop(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(A[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i < N+1; i++) {
            A[depth] = i;
            roop(depth+1);
        }
    }
}
