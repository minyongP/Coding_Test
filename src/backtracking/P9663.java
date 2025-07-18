package backtracking;

import java.util.Scanner;

// 같은 행, 열에 있는가 | 행+열이 같은가 (/대각) | 행 - 열이 같은가 (\대각)
public class P9663 {
    static int N;
    static int ans;
    static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];
        ans = 0;

        play(0);

        System.out.println(ans);
    }

    private static void play(int row) {
        if (row == N) {
            ans++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isPlay(row, col)) {
                // 퀸을 배치하고 다음 행으로 이동해서 반복
                board[row][col] = 1;
                play(row + 1);

                // 백트래킹: 퀸을 다시 빼고 다른 열에 검사
                board[row][col] = 0;
            }
        }
    }

    private static boolean isPlay(int row, int col) {
        // 같은 열에 퀸이 있는지 검사
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        // 왼쪽 위 대각에 퀸이 있는지 검사
        int r = row - 1;
        int c = col - 1;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 1) {
                return false;
            }
            r--;
            c--;
        }

        // 오른쪽 위 대각에 퀸이 있는지 검사
        r = row - 1;
        c = col + 1;
        while (r >= 0 && c < N) {
            if (board[r][c] == 1) {
                return false;
            }
            r--;
            c++;
        }

        return true;
    }
}
