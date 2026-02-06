package backtracking;

import java.util.Scanner;

public class P15652 {
    static int N;
    static int M;
    static int[] A;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[M];
        roop(1, 0);
        System.out.println(sb.toString());
    }
    private static void roop(int s, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(A[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = s; i < N+1; i++) {
            A[depth] = i;
            roop(i,depth+1);
        }
    }
}