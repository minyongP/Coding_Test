package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class im2105 {
    static int N;
    static int[][] A;
    static boolean[][] visited;
    static boolean[] kindOfDesert;
    static long ans;
    static int x, y;
    static int[] dx = {-1, 1, 1, -1};
    static int[] dy = {1, 1, -1, -1};

    static void dfs(int i, int j, int depth, int status) {

        for (int k = 0; k < 2; k++) {   // 방향 유지 or 시계방향 90도 턴
            int nextStatus = (status + k);
            if (nextStatus >= 4) break;
            int nx = j + dx[nextStatus];
            int ny = i + dy[nextStatus];

            // 바운더리 안쪽
            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                if (nx == x && ny == y) {
                    ans = Math.max(ans, depth);
                    return;
                }
                // 방문 및 중복 디저트 검증
                if (!visited[ny][nx] && !kindOfDesert[A[ny][nx]]) {
                    visited[ny][nx] = true;
                    kindOfDesert[A[ny][nx]] = true;
                    dfs(ny, nx, depth + 1, nextStatus);
                    visited[ny][nx] = false;
                    kindOfDesert[A[ny][nx]] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            A = new int[N][N];
            visited = new boolean[N][N];
            kindOfDesert = new boolean[101];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    x = j;
                    y = i;
                    visited[i][j] = true;
                    kindOfDesert[A[i][j]] = true;
                    dfs(i, j, 1, 0);
                    visited[i][j] = false;
                    kindOfDesert[A[i][j]] = false;
                }
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
