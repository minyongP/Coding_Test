package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* N(정사각형 크기) A(배열) visited(방문 배열) result(결과 리스트)
* dx,dy(상하좌우)
* {
* for(N)
*   for(N)
*       배열 초기화
* for(N)
*   for(N)
*       if(집이고, 미방문시) bfs(i, j);
* }
* bfs(x, y){
*   큐에 저장
*   방문 배열 저장
*   cnt+1
*   while(큐가 빌때까지)
*       큐 뽑기
*       방문 배열 저장
*       상하좌우 체크하고 1이면 큐 저장
* }
* */
public class P2667 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] A;
    static boolean[][] visited;
    static List<Integer> result = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                A[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 1 && !visited[i][j]) bfs(i, j);
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int r : result) System.out.println(r);
    }

    static void bfs(int i, int j) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            int[] now = queue.poll();
            // 상하좌우 탐색
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if ((x >= 0 && x < N && y < N && y >= 0) && !visited[x][y] && A[x][y] == 1) {
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        result.add(cnt);
    }
}