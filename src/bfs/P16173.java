package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16173 {
    static int N;
    static int[][] A;
    static boolean[][] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        v = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(BFS(0,0));
    }
    private static String BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{ i, j });
        v[i][j] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int nowCnt = A[x][y];
            if (nowCnt == -1) return "HaruHaru";
            if(y + nowCnt < N && !v[x][y + nowCnt]) {
                q.offer(new int[]{ x, y + nowCnt });
                v[x][y + nowCnt] = true;
            }
            if(x + nowCnt < N && !v[x + nowCnt][y]) {
                q.offer(new int[]{ x + nowCnt, y });
                v[x + nowCnt][y] = true;
            }
        }
        return "Hing";
    }
}
/*
* N(맵 크기) A[][](맵) v[][](방문배열)
* 맵, 방문배열 초기화
* for(N){
*   for(N) {
*       맵 저장
*   }
* }
* BFS(0, 0) 출력
* BFS {
*   큐에 시작점 저장
*   방문배열 저장
*   while(큐가 빌때까지) {
*       큐에서 꺼내기
*       if(A 값 == -1) return haruharu
*       if(A 값*오른쪽 < N &&미방문시) { 큐, 방문배열 저장 }
*       if(A 값*아래쪽 < N && 미방문시) { 큐, 방문배열 저장 }
*   }
*   return hing
* }*/