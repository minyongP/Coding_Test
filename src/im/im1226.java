package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class im1226 {
    static int N = 16;
    static int[][] A;
    static int ans;
    static boolean[][] v;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void dfs(int i, int j) {
        if (A[i][j] == 3) {
            ans = 1;
            return;
        }

        for (int k = 0; k < 4; k++) {
            int x = j + dx[k];
            int y = i + dy[k];
            if (0 <= x && x < N && 0 <= y && y < N) {
                if (v[y][x]) continue;
                if (A[y][x] != 1) {
                    v[y][x] = true;
                    dfs(y, x);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int T = Integer.parseInt(br.readLine().trim());
            A = new int[N][N];
            v= new boolean[N][N];
            int[] s = new int[2];

            for (int i = 0; i < N; i++) {
                char[] c = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    int input = c[j] - '0';
                    if (input == 2) s = new int[]{i, j};
                    A[i][j] = input;
                }
            }

            ans = 0;
            v[s[0]][s[1]] = true;
            dfs(s[0], s[1]);

            sb.append("#").append(T).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
