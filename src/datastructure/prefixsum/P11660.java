package datastructure.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1,1을 구하려면 (0,0+0,1) + (0,0+1,0) - (0,0) + (1,1)
// -> D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j]
public class P11660 {
    public static void main(String[] args) throws IOException {
        /*
        * N(행렬크기) M(테스트 횟수) 저장
        * for(N크기만큼){
        *   for(N크기만큼){
        *       원본 배열 저장
        *   }
        * }
         * for(N크기만큼){
         *   for(N크기만큼){
         *       합배열 저장
         *       D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
         *   }
         * }
         * for(M만큼){
         *  결과 반환(D[x2][y2] - D[x1-1][y2] -D[x2][y1-1] + D[x1-1][y1-1];)
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N+1][N+1];
        int[][] D = new int[N+1][N+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                D[i][j] = D[i-1][j] + D[i][j-1] - D[i-1][j-1] + A[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1]);
        }
    }
}