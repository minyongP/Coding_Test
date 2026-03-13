package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class im7733 {
    static int N;
    static int[][] A;
    static boolean[][] v;
    static long ans;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void bfs(int x, int y, int day) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int j = now[0];
            int i = now[1];

            for (int k = 0; k < 4; k++) {
                int nx = j + dx[k];
                int ny = i + dy[k];

                if (0 <= nx && nx < N && 0 <= ny && ny <N) {
                    if (v[ny][nx]) continue;

                    if (A[ny][nx] > day) {
                        queue.add(new int[]{nx, ny});
                        v[ny][nx] = true;
                    }
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

            int M = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    A[i][j] = input;
                    M = Math.max(M, input);
                }
            }

            ans = 1;
            for (int day = 1; day <= M; day++) {
                v = new boolean[N][N];
                long piece = 0;
                for (int y = 0; y < N; y++) {
                    for (int x = 0; x < N; x++) {
                        if (!v[y][x] && A[y][x] > day) {
                            v[y][x] = true;
                            bfs(x, y, day);
                            piece++;
                        }
                    }
                }
                ans = Math.max(ans, piece);
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
