package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class im1868 {
    static int N;
    static char[][] A;
    static boolean[][] visited;
    static long ans;

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    static char countBomb(int i , int j) {
        int bombSum = 0;
        for (int k = 0; k < 8; k++) {
            int nx = j + dx[k];
            int ny = i + dy[k];
            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                if (A[ny][nx] == '*') bombSum++;
            }
        }

        return (char) (bombSum + '0');
    }

    static void bfs(int i, int j) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        ans++;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[1];
            int y = now[0];

            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (visited[ny][nx]) continue;
                    visited[ny][nx] = true;

                    if (A[ny][nx] == '0') {
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            A = new char[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                A[i] = br.readLine().toCharArray();
            }

            // 폭탄 수 세기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (A[i][j] == '*') {
                        visited[i][j] = true;
                        continue;
                    }
                    A[i][j] = countBomb(i, j);
                }
            }

            ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (A[i][j] == '0' && !visited[i][j]) {
                        visited[i][j] = true;
                        bfs(i, j);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        ans++;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
