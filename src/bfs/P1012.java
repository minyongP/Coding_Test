package bfs;

import java.util.*;

public class P1012 {
    static Scanner scanner;
    static int[][] A;
    static boolean[][] v;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int M;
    static int N;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            Test();
        }
    }
    static void Test() {
        int result = 0;
        M = scanner.nextInt();
        N = scanner.nextInt();
        int K = scanner.nextInt();
        A = new int[M][N];
        v = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = 0;
            }
        }
        for (int i = 0; i < K; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            A[x][y] = 1;
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 1 && !v[i][j]) {
                    BFS(i, j);
                    result++;
                }
            }
        }
        System.out.println(result);
    }
    static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        v[i][j] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && x < M && y >= 0 && y < N) {
                    if (!v[x][y] && A[x][y] == 1) {
                        q.offer(new int[]{x, y});
                        v[x][y] = true;
                    }
                }
            }
        }
    }
}
/*
T(테스트 개수) M(가로 길이) N(세로 길이) K(배추 개숫)
A(맵 배열) v(방문 배열)
 for(T){
     Test();
 }
Test {
        A를 맵 크기만큼 0으로 초기화
        for(K) { A[x][y]=1 }
            for(N){
                for(M){
                    if(A[i][j] == 1 && !v[i][j]){
                        BFS(i, j);
                        result++;
                    }
                }
             }
        result출력
        }
}
BFS{
     큐에 저장
        방문배열 저장
        while(큐가 빌때까지){
            for(4){
            x += dx;
            y += dy;
                if(맵 안이고 미방문시){
                큐,방문 저장
                }
            }
        }
}
*/
