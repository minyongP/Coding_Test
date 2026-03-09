package backtracking;

import java.util.Scanner;

public class P9663 {
    static int N;
    static long ans = 0;
    private static void dfs(int row, int[] col) {
        if (row == N) {
            ans++; return;
        }

        for (int c = 0; c < N; c++) {
            boolean isConflict = false;

            for (int i = 0; i < row; i++) {
                if (col[i] == c)  {
                    isConflict = true;
                    break;
                }
            }
            for (int i = 1; i <= row; i++) {
                if (i == Math.abs(c - col[row - i])) {
                    isConflict = true;
                    break;
                }
            }

            if (isConflict) continue;
            col[row] = c;
            dfs(row+1, col);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dfs(0, new int[N]);

        System.out.println(ans);
    }
}
