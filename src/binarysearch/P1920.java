package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int result = 0;
            int t = Integer.parseInt(st.nextToken());
            int s = 0;
            int e = A.length-1;
            while (s <= e) {
                int m = (e+s)/2;
                if (A[m] > t) {
                    e = m - 1;
                }
                else if (A[m] < t) {
                    s = m + 1;
                }
                else {
                    result = 1;
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
/*
* N(데이터 개수) M(찾을 개수)
* A(데이터 배열)
* A초기화 및 정렬
* for(M) {
*   while(s <= e) {
*       if(중앙값 > 찾는 수) { e = 중앙값 - 1 }
*       else if(중앙값 < 찾는 수) { s = 중앙 값 + 1}
*       else break;
*   }
* if(찾음) 1;
* else 0;
* */