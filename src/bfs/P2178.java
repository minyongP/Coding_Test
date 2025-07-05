package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean visited[][];
    static int[][] A;
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        BFS(0, 0);
        System.out.println(A[N-1][M-1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            for (int K = 0; K < 4; K++) {
                int x = now[0] + dx[K];
                int y = now[1] + dy[K];

                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (A[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1;
                        queue.offer(new int[] {x,y});
                    }
                }
            }
        }
    }
}
/*
* N,M(세로 가로), dx,dy(상하좌우)
* A(미로배열)
* visited(방문배열)
* 미로와 방문배열 초기화
* for(N){
*   for(M){
*       미로 저장
*   }
* }
* BFS실행(0)
* A[N-1][M-1] 값 출력
*
* BFS {
*   큐에 시작노드 삽입
*   방문배열에 현재 노드 저장
*   while(큐가 빌때까지){
*       큐에서 현재 노드 가져오기
*       for(상하좌우){
*            if(유효한 좌표){
*               if(이동 가능하고 방문하지 않은 노드){
*                   방문배열에 저장
*                   A에 깊이를 현재노드+1로 저장
*                   큐에 데이터 삽입
*}}}}}}*/