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
*       result에 저장 bfs(i, j, 0);
* }
* bfs(x, y, cnt){
*   큐에 저장
*   방문 배열 저장
*   while(큐가 빌때까지)
*       큐 뽑기
*       방문 배열 저장
*       상하좌우 체크하고 1이면 큐 저장
*       cnt++
* }
* */
public class P2667 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] A;
    static boolean[][] visited;
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < N; j++) {
                A[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                BFS(i, j);
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (int r : result) System.out.println(r);
    }

    static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
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
                if (!visited[x][y] && A[x][y] == 1) {
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        if (cnt != 0) result.add(cnt);
    }
}