package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P14502 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int N;
    static int M;
    static int[][] A;
    static List<int[]> list = new ArrayList<>();
    static List<int[]> virusList = new ArrayList<>();
    static long maxSafeArea;

    static void dfs(int[][] wall, int depth, int idx) {
        if (depth == 3) {
            bfs(wall);
            return;
        }
        if (idx == list.size()) return;

        wall[depth] = list.get(idx);
        dfs(wall, depth+1, idx+1);

        dfs(wall, depth, idx+1);
    }

    static void bfs(int[][] wall) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[N][M];

        // 추가한 벽을 1로 두지 않고 방문배열로 체크한다
        for (int i = 0; i < wall.length; i++) {
            int y = wall[i][0];
            int x = wall[i][1];
            v[y][x] = true;
        }

        // 바이러스 시작점 큐에 넣기
        for (int i = 0; i < virusList.size(); i++) {
            int[] virus = virusList.get(i);
            int y = virus[0];
            int x = virus[1];
            v[y][x] = true;
            q.add(virusList.get(i));
        }

        while (!q.isEmpty()) {
            int[] virus = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = virus[1] + dx[i];
                int y = virus[0] + dy[i];
                if (0 <= x && x < M && 0 <= y && y < N) {
                    if (v[y][x] || A[y][x] == 1) continue;
                    v[y][x] = true;
                    q.add(new int[] {y, x});
                }
            }
        }

        // 안전구역 체킹
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!v[i][j] && A[i][j] == 0) safeArea++;
            }
        }
        maxSafeArea = Math.max(maxSafeArea, safeArea);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 0)list.add(new int[]{i, j});
                if (input == 2) virusList.add(new int[]{i, j});
                A[i][j] = input;
            }
        }

        maxSafeArea = 0;
        // 벽 3개 정하기
        dfs(new int[3][2], 0, 0);

        System.out.print(maxSafeArea);
    }
}
