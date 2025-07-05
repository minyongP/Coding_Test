package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4963 {
    static int w;
    static int h;
    static int[][] A;
    static boolean[][] v;
    static int[] dx = { 0, 1, 0, -1, -1, 1, 1, -1};
    static int[] dy = { 1, 0, -1, 0, 1, 1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            if (h == 0) break;
            w = Integer.parseInt(st.nextToken());
            A = new int[w][h];
            v = new boolean[w][h];
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < h; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = 0;
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (A[i][j] == 1 && !v[i][j]) {
                        DFS(i, j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
    private static void DFS(int i, int j) {
        v[i][j] = true;
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < w && y >= 0 && y < h) {
                if (A[x][y] == 1 && !v[x][y]) {
                    DFS(x, y);
                }
            }
        }
    }
}
/*
* w(너비) h(높이)
* A(맵 배열) v(방문배열)
* dx,dy(이동 배열)
* while(true){
*   if(w == 0) break;
*   Solve(w, h)
* }
* Solve(){
*   맵, 방문배열 초기화
*   for(w){
*       for(h){
*           if(A[][] == 1 && !v[][]) {
*               DFS(i,j)
*               result++;
*           }
*       }
*   }
*   result출력
* }
* DFS(){
*   v[][] = true;
*   for(8) {
*       8방향 이동
*       if(A[x][y] == 1 && !v[x][y]) {
*           DFS(x,y);
*       }
*   }
* }
*   */
